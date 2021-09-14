package com.nagwa.downloaderdemo.utils

import com.nagwa.downloaderdemo.BuildConfig

object Constants {

 fun getBaseUrl() : String{
    return BuildConfig.BASE_URL
}
}