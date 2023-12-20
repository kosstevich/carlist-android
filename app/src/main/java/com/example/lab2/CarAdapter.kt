package com.example.lab2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lab2.databinding.CarItemBinding

class CarAdapter(private var cars_recycler: MutableList<Data.Car>,
                 private val listener: Presenter): RecyclerView.Adapter<CarAdapter.CarHolder>(){

    class CarHolder(item: View):RecyclerView.ViewHolder(item) {
        val binding = CarItemBinding.bind(item)
        fun bind(car: Data.Car, del: CarAdapter) = with(binding){
            imageView.setImageResource(car.imageID)
            textView2.setText(car.name)
            textView3.setText(car.power)
            delete.setOnClickListener{
                del.delCar(car)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.car_item, parent, false)
        val carHolder = CarHolder(view)
        view.setOnClickListener{
            val position = carHolder.adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                val car = cars_recycler[position]
                listener.onCarClick(car)
            }
        }
        return carHolder
    }

    override fun getItemCount(): Int {
        return cars_recycler.size
    }

    override fun onBindViewHolder(holder: CarHolder, position: Int) {
        holder.bind(cars_recycler[position], this)
    }

    fun addCar(car: Data.Car) {
        cars_recycler.add(car)
        notifyDataSetChanged()
    }

    fun delCar(car:Data.Car){
        cars_recycler.remove(car)
        notifyDataSetChanged()
    }
}