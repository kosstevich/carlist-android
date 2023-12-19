package com.example.lab2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.example.lab2.databinding.FragmentFragment1Binding

class Fragment1 : Fragment(), MyView{
    private lateinit var presenter: PresenterImp
    private var _binding : FragmentFragment1Binding? = null
    private val binding : FragmentFragment1Binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFragment1Binding.inflate(inflater, container, false)
        val model = ModelImp()
        presenter = PresenterImp(model, this)
        presenter.onFragment1Created()

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

    override fun onItemClick(name: String) {
        val fragment2 = Fragment2()
        presenter.openFragment(fragment2, name)
    }

    override fun setCarInfo() {
        TODO("Not yet implemented")
    }

    override fun getCarInfo(): Data.AdvancedCar {
        TODO("Not yet implemented")
    }

    override fun onCreate() {
        binding.apply {
            recycler.layoutManager = LinearLayoutManager(context)
            recycler.adapter = presenter.getAdapter()
            add.setOnClickListener(){
                presenter.addCar()
            }
        }
    }

    override fun getRequireActivity(): FragmentActivity {
        return requireActivity()
    }

    override fun getBinding(): ViewBinding {
        return binding
    }
}