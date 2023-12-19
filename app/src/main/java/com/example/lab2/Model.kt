package com.example.lab2

interface Model {
    fun getData():Data
    fun updateInfo()
    fun findCar(name:String?):Int
    fun getIndx():Int
}