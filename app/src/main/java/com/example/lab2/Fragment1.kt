package com.example.lab2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab2.databinding.FragmentFragment1Binding

class Fragment1 : Fragment(), ItemClick{

    private var _binding : FragmentFragment1Binding? = null
    private val binding : FragmentFragment1Binding get() = _binding!!
    private val adapter = CarAdapter(Data.cars_recycler, this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFragment1Binding.inflate(inflater, container, false)

        binding.apply {
            recycler.layoutManager = LinearLayoutManager(context)
            recycler.adapter = adapter
            adapter.showCar()
            add.setOnClickListener(){
                if(Data.index>Data.cars.size-1) Data.index = 0
                adapter.addCar(Data.cars[Data.index])
                Data.index++
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object {
        @JvmStatic
        fun newInstance() = Fragment1()
    }

    override fun onItemClick(car: Data.Car) {
        val fragment2 = Fragment2()
        val bundle = Bundle()
        bundle.putString("name", car.name)
        fragment2.arguments = bundle

        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.place_holder, fragment2)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}