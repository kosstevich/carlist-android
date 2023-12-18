package com.example.lab2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.lab2.databinding.Fragment3Binding
import com.example.lab2.databinding.FragmentEditItemBinding

class Fragment3 : Fragment() {

    private var _binding : Fragment3Binding? = null
    private val binding : Fragment3Binding get() = _binding!!

    var index: Int = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = Fragment3Binding.inflate(inflater, container, false)

        val name = arguments?.getString("name")
        setCarInfo(name)

        binding.backButton.setOnClickListener{
            val fragment = Fragment2()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            val bundle = Bundle()

            bundle.putString("name", name)
            fragment.arguments = bundle

            transaction.replace(R.id.place_holder, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        binding.save.setOnClickListener{
            Data.advanced_cars[index].name = binding.name.text.toString()
            Data.advanced_cars[index].drive = binding.drive.text.toString()
            Data.advanced_cars[index].engineType = binding.engineType.text.toString()
            Data.advanced_cars[index].transmitionType = binding.transmitionType.text.toString()
            Data.advanced_cars[index].power = binding.power.text.toString()
            Data.updateInfo()
        }

        return binding.root
    }

    fun setCarInfo(name:String?){
        for(i in 0..<Data.advanced_cars.size){
            if(Data.advanced_cars[i].name.equals(name)){
                index = i
                val car: Data.AdvancedCar = Data.advanced_cars[i]
                binding.name.setText(car.name)
                binding.drive.setText(car.drive)
                binding.power.setText(car.power)
                binding.engineType.setText(car.engineType)
                binding.transmitionType.setText(car.transmitionType)
            }
        }
    }


    companion object {
        @JvmStatic
        fun newInstance() = Fragment3()
    }
}