package com.example.lab2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab2.databinding.FragmentFragment1Binding

class Fragment1 : Fragment(), MyView{
    private lateinit var presenter: PresenterImp
    private lateinit var binding: FragmentFragment1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFragment1Binding.inflate(inflater, container, false)
        val model = ModelImp()
        presenter = PresenterImp(model, this)
        presenter.onFragmentCreated(null)

        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
    }

    companion object {
        @JvmStatic
        fun newInstance() = Fragment1()
    }

    override fun onItemClick(name: String) {
        val fragment = Fragment2()
        presenter.openFragment(fragment, name)
    }

    override fun drawCarInfo(name: String?) {

    }

    override fun onCreate() {
        binding.apply {
            recycler.layoutManager = LinearLayoutManager(context)
            recycler.adapter = presenter.getAdapter()
            add.setOnClickListener(){
                //presenter.addCar()
                val fragment = Fragment3()
                presenter.openFragment(fragment, null)
            }
        }
    }

    override fun getRequireActivity(): FragmentActivity {
        return requireActivity()
    }

}