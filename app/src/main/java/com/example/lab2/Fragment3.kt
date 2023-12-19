package com.example.lab2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding
import com.example.lab2.databinding.Fragment3Binding

class Fragment3 : Fragment(), MyView {
    private lateinit var presenter: PresenterImp
    private var _binding : Fragment3Binding? = null
    private val binding : Fragment3Binding get() = _binding!!
    var name:String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        name = arguments?.getString("name")
        _binding = Fragment3Binding.inflate(inflater, container, false)
        val model = ModelImp()
        presenter = PresenterImp(model, this)
        presenter.onFragment3Created()

        return binding.root
    }

    override fun setCarInfo(){
        val car = presenter.getCarByName(name)
        binding.name.setText(car.name)
        binding.drive.setText(car.drive)
        binding.power.setText(car.power)
        binding.engineType.setText(car.engineType)
        binding.transmitionType.setText(car.transmitionType)
    }

    override fun getCarInfo(): Data.AdvancedCar {
        name = binding.name.text.toString()
        return Data.AdvancedCar(
            binding.name.text.toString(),
            R.drawable.default_car,
            binding.drive.text.toString(),
            binding.engineType.text.toString(),
            binding.transmitionType.text.toString(),
            binding.power.text.toString())
    }

    override fun onCreate() {
        binding.backButton.setOnClickListener{
            val fragment = Fragment2()
            presenter.openFragment(fragment, name)
        }

        binding.save.setOnClickListener{
            presenter.setNewData(name)
        }
    }

    override fun getRequireActivity(): FragmentActivity {
        return requireActivity()
    }

    override fun getBinding(): ViewBinding {
        return binding
    }

    override fun onItemClick(name: String) {}

    companion object {
        @JvmStatic
        fun newInstance() = Fragment3()
    }
}