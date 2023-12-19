package com.example.lab2

import android.os.Bundle
import androidx.fragment.app.Fragment

class PresenterImp(private val model: Model, private val view: MyView):Presenter {
    private var adapter: CarAdapter = CarAdapter(model.getData().cars_recycler, this)
    override fun onFragment1Created() {
        adapter.showCar()
        view.onCreate()
    }

    override fun onFragment2Created() {
        view.setCarInfo()
        view.onCreate()
    }

    override fun onFragment3Created() {
        view.setCarInfo()
        view.onCreate()
    }

    override fun openFragment(fragment: Fragment, name: String?) {
        val bundle = Bundle()
        bundle.putString("name", name)
        fragment.arguments = bundle

        val transaction = view.getRequireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.place_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun setNewData(name:String?) {
        val ind = model.findCar(name)
        var car = view.getCarInfo()
        car.imageID = model.getData().advanced_cars[ind].imageID
        model.getData().advanced_cars[ind] = car
        model.updateInfo()
    }

    override fun onCarClick(car: Data.Car) {
        view.onItemClick(car.name)
    }

    override fun addCar() {
        if(model.getData().index>model.getData().cars.size-1) model.getData().index = 0
        adapter.addCar(model.getData().cars[model.getData().index])
        model.getData().index++
    }

    override fun getAdapter(): CarAdapter {
        return adapter
    }

    override fun getCarByName(name: String?): Data.AdvancedCar {
        return model.getData().advanced_cars[model.findCar(name)]
    }
}