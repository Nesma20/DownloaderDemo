package com.nagwa.downloaderdemo.network

import com.nagwa.downloaderdemo.model.FilesData
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import javax.inject.Inject

class FilesRepository @Inject constructor( val apiService: ApiService) {
    fun getFilesListData(): Single<Response<List<FilesData>>> {
        return apiService.getDownloadFilesList()

    }
}