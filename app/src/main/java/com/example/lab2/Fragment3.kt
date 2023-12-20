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
    private lateinit var binding:Fragment3Binding
    var name:String? = null
    var isFrag1: Boolean = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        name = arguments?.getString("name")
        if(name != null) isFrag1 = false
        binding = Fragment3Binding.inflate(inflater, container, false)
        val model = ModelImp()
        presenter = PresenterImp(model, this)
        presenter.onFragmentCreated(name)

        return binding.root
    }

    override fun drawCarInfo(name:String?){
        if(name != null){
            val car = presenter.getCarByName(name)
            binding.name.setText(car.name)
            binding.drive.setText(car.drive)
            binding.power.setText(car.power)
            binding.engineType.setText(car.engineType)
            binding.transmitionType.setText(car.transmitionType)
        }
    }
    override fun onCreate() {
        binding.backButton.setOnClickListener{
            val fragment2 = Fragment2()
            val fragment1 = Fragment1()
            if(isFrag1){
                presenter.openFragment(fragment1, name)
            }else{
                presenter.openFragment(fragment2, name)
            }
        }

        binding.save.setOnClickListener{
            val oldname:String? = name
            name = binding.name.text.toString()
            val car = Data.AdvancedCar(
                binding.name.text.toString(),
                R.drawable.default_car,
                binding.drive.text.toString(),
                binding.engineType.text.toString(),
                binding.transmitionType.text.toString(),
                binding.power.text.toString())
            presenter.setNewData(name,oldname, car)
        }
    }

    override fun getRequireActivity(): FragmentActivity {
        return requireActivity()
    }

    override fun onItemClick(name: String) {}

    companion object {
        @JvmStatic
        fun newInstance() = Fragment3()
    }
}