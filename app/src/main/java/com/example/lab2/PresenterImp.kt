package com.example.lab2

import android.os.Bundle
import androidx.fragment.app.Fragment
class PresenterImp(private val model: Model, private val view: MyView):Presenter {
    private var adapter: CarAdapter = CarAdapter(model.getData().cars_recycler, this)
    override fun onFragmentCreated(name: String?) {
        view.drawCarInfo(name)
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

    override fun setNewData(name: String?, oldname: String?, car: Data.AdvancedCar) {
        if(model.isCarExist(oldname)){
            val ind = model.findCar(oldname)
            car.imageID = model.getData().advanced_cars[ind].imageID
            model.getData().advanced_cars[ind] = car
        }else{
            model.getData().advanced_cars.add(car)
            model.getData().cars.add(car.toCar())
        }

        model.updateInfo()
    }

    override fun onCarClick(car: Data.Car) {
        view.onItemClick(car.name)
    }

    override fun addCar(car: Data.AdvancedCar?) {
        if(car!=null){
            adapter.addCar(car.toCar())
        }else{
            if(model.getData().index>model.getData().cars.size-1) model.getData().index = 0
            adapter.addCar(model.getData().cars[model.getData().index])
            model.getData().index++
        }
    }

    override fun getAdapter(): CarAdapter {
        return adapter
    }

    override fun getCarByName(name: String?): Data.AdvancedCar {
        return model.getData().advanced_cars[model.findCar(name)]
    }
}