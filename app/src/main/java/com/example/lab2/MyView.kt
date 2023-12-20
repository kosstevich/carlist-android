package com.example.lab2

import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding

interface MyView {
    fun getRequireActivity(): FragmentActivity
    fun onItemClick(name:String)
    fun drawCarInfo(name:String?)
    fun onCreate()
}