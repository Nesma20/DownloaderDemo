package com.nagwa.downloaderdemo.model

data class FilesData (
    var id: Int,
    var type : String,
    var name : String,
    var url : String
        )
enum class type {
    pdf, video
}