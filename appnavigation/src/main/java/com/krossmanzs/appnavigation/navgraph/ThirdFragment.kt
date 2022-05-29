package com.krossmanzs.appnavigation.navgraph

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.krossmanzs.appnavigation.R

class ThirdFragment : Fragment() {
    companion object {
        const val EXTRA_BUNDLE = "extra_bundle"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_third, container, false)

        val tv3 : TextView = view.findViewById(R.id.textView3)

        tv3.text = arguments?.getString(EXTRA_BUNDLE)

        tv3.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_thirdFragment_to_firstFragment)
        }

        return view
    }
}