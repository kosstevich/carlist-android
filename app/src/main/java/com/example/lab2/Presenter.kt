package com.example.lab2

import androidx.fragment.app.Fragment

interface Presenter {
    fun onFragment1Created()
    fun onFragment2Created()
    fun onFragment3Created()
    fun openFragment(fragment: Fragment, name: String?)
    fun setNewData(name:String?)
    fun onCarClick(car:Data.Car)
    fun addCar()
    fun getAdapter():CarAdapter
    fun getCarByName(name: String?):Data.AdvancedCar
}