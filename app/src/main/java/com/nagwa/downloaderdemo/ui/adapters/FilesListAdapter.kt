package com.nagwa.downloaderdemo.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.nagwa.downloaderdemo.R
import com.nagwa.downloaderdemo.databinding.FileLayoutItemBinding
import com.nagwa.downloaderdemo.model.FilesData
import com.nagwa.downloaderdemo.model.type
import java.util.*

class FilesListAdapter (var filesDataList: List<FilesData>) :
    RecyclerView.Adapter<FilesListAdapter.ViewHolder>() {
    lateinit var context : Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: FileLayoutItemBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.file_layout_item,parent,false)
        context = parent.context
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(filesDataList[position])

    }

    override fun getItemCount(): Int {
        return filesDataList.size
    }

    inner class ViewHolder(var binding : FileLayoutItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(fileData: FilesData){
            binding.fileNameTxtView.text = fileData.name
            binding.fileTypeTxtView.text = fileData.type
            switchBetweenTypes(fileData)
        }
        fun switchBetweenTypes(fileData: FilesData){
            when(fileData.type.lowercase()){
                type.pdf.name -> binding.fileTypeImgView.setImageResource(R.drawable.ic_pdf)
                type.video.name -> binding.fileTypeImgView.setImageResource(R.drawable.ic_mp4)
            }
        }

    }
}
