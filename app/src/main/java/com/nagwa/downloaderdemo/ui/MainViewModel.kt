package com.nagwa.downloaderdemo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nagwa.downloaderdemo.model.FilesData
import com.nagwa.downloaderdemo.model.Result
import com.nagwa.downloaderdemo.network.FilesRepository
import com.nagwa.downloaderdemo.utils.NetworkHelper
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(var repository: FilesRepository) {
   private var _filesList = MutableLiveData<Result<List<FilesData>>>()
    val filesData: LiveData<Result<List<FilesData>>>
        get() = _filesList

    init {
        getFilesList()
    }

    fun getFilesList() {
//        if(networkHelper.isNetworkConnected()) {
            _filesList.value = Result.loading(null)
            repository.getFilesListData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    var data = result.body()
                    _filesList.value = Result.success(data!!)

                }, {
                    _filesList.value = Result.error("Error while getting data")
                }
                )
//        }
//        else
//       _filesList.value = Result.error("No internet connection")
    }
}