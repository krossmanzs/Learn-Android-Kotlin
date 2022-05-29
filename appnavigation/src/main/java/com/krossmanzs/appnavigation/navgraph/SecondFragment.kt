package com.krossmanzs.appnavigation.navgraph

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.krossmanzs.appnavigation.R

class SecondFragment : Fragment() {

    private val args: SecondFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        val tv2 : TextView = view.findViewById(R.id.textView2)

        val myNumber = args.number
        tv2.text = "$myNumber"

        tv2.setOnClickListener {
            val bundle = bundleOf(ThirdFragment.EXTRA_BUNDLE to "data bundle")

            Navigation.findNavController(view)
                .navigate(R.id.action_secondFragment_to_thirdFragment, bundle)
        }

        return view
    }
}