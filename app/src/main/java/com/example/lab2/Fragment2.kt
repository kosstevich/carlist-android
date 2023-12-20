package com.example.lab2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding
import com.example.lab2.databinding.FragmentEditItemBinding

class Fragment2 : Fragment(), MyView {
    private lateinit var presenter: PresenterImp
    private lateinit var binding:FragmentEditItemBinding
    var name:String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        name = arguments?.getString("name")
        binding = FragmentEditItemBinding.inflate(inflater, container, false)
        val model = ModelImp()
        presenter = PresenterImp(model, this)
        presenter.onFragmentCreated(name)

        return binding.root
    }

    override fun getRequireActivity(): FragmentActivity {
        return requireActivity()
    }
    override fun drawCarInfo(name: String?) {
        if(name!=null){
            val car = presenter.getCarByName(name)
            binding.carImage.setImageResource(car.imageID)
            binding.carName.setText(car.name)
            binding.carDrive.setText(car.drive)
            binding.carPower.setText(car.power)
            binding.carEngineType.setText(car.engineType)
            binding.carTransmitionType.setText(car.transmitionType)
        }
    }

    override fun onCreate() {
        binding.back.setOnClickListener {
            val fragment = Fragment1()
            presenter.openFragment(fragment, name)
        }

        binding.edit.setOnClickListener{
            val fragment = Fragment3()
            presenter.openFragment(fragment, name)
        }
    }

    override fun onItemClick(name: String) {}

    companion object {
        @JvmStatic
        fun newInstance() = Fragment2()
    }
}