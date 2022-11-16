package com.example.mycar.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.mycar.BaseApplication
import com.example.mycar.ui.adapter.CarListAdapter
import com.example.mycar.ui.viewmodel.CarViewModel
import com.example.mycar.ui.viewmodel.CarViewModelFactory

/**
 * A simple [Fragment] subclass.
 * Use the [CarListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CarListFragment : Fragment() {

    private val viewModel: CarViewModel by activityViewModels {
        CarViewModelFactory(
            (activity?.application as BaseApplication).database.myCarDao()
        )
    }

    //to review
    private var _binding: CarListFragment? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = CarListFragment.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CarListAdapter { car ->
            val action = CarListFragmentDirections.action
            findNavController().navigate(action)
        }

        viewModel.allCar.observe(this.viewLifecycleOwner) { cars ->
            cars.let {
                adapter.submitList(it)
            }
        }

        binding.apply {

        }
    }

}