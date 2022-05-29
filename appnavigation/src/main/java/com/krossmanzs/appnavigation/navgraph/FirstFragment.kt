package com.krossmanzs.appnavigation.navgraph

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.krossmanzs.appnavigation.R

class FirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        val tv1 : TextView= view.findViewById(R.id.textView1)

        tv1.setOnClickListener {
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(5)
            Navigation.findNavController(view)
                .navigate(action)
        }

        return view
    }
}

