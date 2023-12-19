package com.example.lab2

import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding

interface MyView {
    //fun setButtonClickListener(listener: View.OnClickListener)
    fun getRequireActivity(): FragmentActivity
    fun getBinding(): ViewBinding
    fun onItemClick(name:String)
    fun setCarInfo()
    fun getCarInfo():Data.AdvancedCar
    fun onCreate()
    //fun getName(): String?
    //fun openFragment(fragment: Fragment, name: String?)
}