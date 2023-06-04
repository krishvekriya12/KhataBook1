package com.example.khatabook.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.khatabook.Adapter.TranslistAdapter
import com.example.khatabook.Database
import com.example.khatabook.Model.TransModal
import com.example.khatabook.R
import com.example.khatabook.databinding.FragmentAddBinding
import com.example.khatabook.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    var transList = ArrayList<TransModal>()
    lateinit var database: Database
    lateinit var adapter : TranslistAdapter
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

         binding = FragmentHomeBinding.inflate(layoutInflater)

        database = Database(context)
        transList = database.getTransaction()

        adapter = TranslistAdapter()
        adapter.setTrans(transList)

        binding.rcvTransList.layoutManager = LinearLayoutManager(context)
        binding.rcvTransList.adapter = adapter

        return binding.root
    }


}