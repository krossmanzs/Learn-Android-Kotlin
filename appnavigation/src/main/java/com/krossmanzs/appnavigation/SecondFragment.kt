package com.krossmanzs.appnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation

class SecondFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        val tv2 : TextView = view.findViewById(R.id.textView2)

        tv2.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_secondFragment_to_firstFragment)
        }

        return view
    }
}