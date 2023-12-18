package com.example.lab2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lab2.databinding.FragmentEditItemBinding

class Fragment2 : Fragment() {

    private var _binding : FragmentEditItemBinding? = null
    private val binding : FragmentEditItemBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEditItemBinding.inflate(inflater, container, false)
        val name = arguments?.getString("name")

        setCarInfo(name)

        binding.back.setOnClickListener {
            val fragment1 = Fragment1()
            openFragment(fragment1, name)
        }

        binding.edit.setOnClickListener{
            val fragment3 = Fragment3()
            openFragment(fragment3, name)
        }

        return binding.root
    }

    fun setCarInfo(name:String?){
        for(i in 0..<Data.advanced_cars.size){
            if(Data.advanced_cars[i].name.equals(name)){
                val car: Data.AdvancedCar = Data.advanced_cars[i]
                binding.carImage.setImageResource(car.imageID)
                binding.carName.setText(car.name)
                binding.carDrive.setText(car.drive)
                binding.carPower.setText(car.power)
                binding.carEngineType.setText(car.engineType)
                binding.carTransmitionType.setText(car.transmitionType)
            }
        }
    }

    fun openFragment(fragment: Fragment, name: String?){
        val transaction = requireActivity().supportFragmentManager.beginTransaction()

        val bundle = Bundle()

        bundle.putString("name", name)
        fragment.arguments = bundle

        transaction.replace(R.id.place_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    companion object {
        @JvmStatic
        fun newInstance() = Fragment2()
    }
}