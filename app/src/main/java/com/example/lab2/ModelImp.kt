package com.example.lab2

class ModelImp: Model{
    private var data = Data
    private var index: Int = 0
    override fun getData(): Data {
        return data
    }

    override fun updateInfo() {
        for(i in 0..<data.cars_recycler.size){
            data.cars.set(i, data.advanced_cars[i].toCar())
            data.cars_recycler.set(i, data.advanced_cars[i].toCar())
        }
    }

    override fun findCar(name: String?): Int {
        var ind: Int = -1
        for(i in 0..<data.advanced_cars.size){
            if(data.advanced_cars[i].name.equals(name)){
                ind = i
            }
        }
        return ind
    }

    override fun getIndx(): Int {
        return index
    }

}