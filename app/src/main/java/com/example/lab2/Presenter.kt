package com.example.lab2

import androidx.fragment.app.Fragment

interface Presenter {
    fun onFragmentCreated(name: String?)
    fun openFragment(fragment: Fragment, name: String?)
    fun setNewData(name:String?,oldname:String?, car: Data.AdvancedCar)
    fun onCarClick(car:Data.Car)
    fun addCar(car: Data.AdvancedCar?)
    fun getAdapter():CarAdapter
    fun getCarByName(name: String?):Data.AdvancedCar
}