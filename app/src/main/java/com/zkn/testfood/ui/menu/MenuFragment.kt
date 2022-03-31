package com.zkn.testfood.ui.menu

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zkn.testfood.R
import com.zkn.testfood.databinding.FragmentMenuBinding



class MenuFragment : Fragment(), AdapterView.OnItemSelectedListener{


    private var _binding: FragmentMenuBinding? = null


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(MenuViewModel::class.java)

        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerview = binding.salesCategory

        // this creates a horizontal layout Manager

        recyclerview.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()


        // This loop will create 5 Views containing
        // the image with the count of view
        for (i in 1..4) {
            data.add(ItemsViewModel(R.layout.sale_category_first))
        }




        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter


        val spinner: Spinner = binding.spinnerCities
        ArrayAdapter.createFromResource(
            requireActivity(),
            R.array.cities_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // App ly the adapter to the spinner
            spinner.adapter = adapter

        }
        homeViewModel.text.observe(viewLifecycleOwner) {
            arrayOf(spinner)
        }

        val recyclerViewBlock = binding.blockCategory
        recyclerViewBlock.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        val data2 = ArrayList<ItemsViewModel2>()
        for (i in 1..5) {
            data2.add(ItemsViewModel2(R.layout.category_block))
        }

        val adapter2 = CustomBlockAdapter(data2)
        recyclerViewBlock.adapter = adapter2

        val recyclerViewPizza = binding.pizzaScroll
        recyclerViewPizza.layoutManager = LinearLayoutManager(requireActivity())
        val data3 = ArrayList<ItemsViewModel3>()
        for (i in 1..6) {
            data3.add(ItemsViewModel3(R.layout.pizza_block))
        }

        val adapter3 = CustomPizzaAdapter(data3)
        recyclerViewPizza.adapter = adapter3



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val spinner: Spinner = binding.spinnerCities
        spinner.onItemSelectedListener = this
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }



}