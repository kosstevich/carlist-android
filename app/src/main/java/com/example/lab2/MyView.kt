package com.example.lab2

import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding

interface MyView {
    fun getRequireActivity(): FragmentActivity
    fun getBinding(): ViewBinding
    fun onItemClick(name:String)
    fun setCarInfo()
    fun getCarInfo():Data.AdvancedCar
    fun onCreate()
}