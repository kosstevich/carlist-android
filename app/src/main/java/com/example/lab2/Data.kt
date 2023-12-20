package com.example.lab2

object Data {
    data class Car(val name:String, val imageID:Int, val power:String)
    data class AdvancedCar(
        var name:String, var imageID:Int, var power:String, var transmitionType:String,
        var engineType:String, var drive:String){
        fun toCar(): Car {
            return Car(this.name, this.imageID, this.power)
        }
    }
    var index:Int = 0

    var advanced_cars = mutableListOf<AdvancedCar>(
        AdvancedCar("BMW 525 E34", R.drawable.e34,"191hp", "МКПП","Атмосферный","Задний"),
        AdvancedCar("Lada Granta",R.drawable.granta,"106hp","МКПП","Атмосферный","Передний"),
        AdvancedCar("Lada Vesta",R.drawable.vesta,"116hp","МКПП/Робот","Атмосферный","Передний")
    )

    var cars = mutableListOf<Car>(
        Car("BMW 525 E34", R.drawable.e34, "191hp"),
        Car("Lada Granta", R.drawable.granta, "106hp"),
        Car("Lada Vesta", R.drawable.vesta, "116hp"))

    var cars_recycler : MutableList<Car> = cars
}
