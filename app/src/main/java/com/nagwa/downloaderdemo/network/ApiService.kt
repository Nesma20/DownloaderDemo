package com.nagwa.downloaderdemo.network

import com.nagwa.downloaderdemo.model.FilesData
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("movies")
    fun getDownloadFilesList() : Single<Response<List<FilesData>>>

}