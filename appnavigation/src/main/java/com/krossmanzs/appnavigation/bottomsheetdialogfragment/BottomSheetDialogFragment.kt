package com.krossmanzs.appnavigation.bottomsheetdialogfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.krossmanzs.appnavigation.R

class BottomSheetDialogFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.layout_photo_bottom_sheet, container, false)

        val btnUseCamera : TextView = view.findViewById(R.id.tv_btn_add_photo_camera)
        val btnUploadGallery : TextView = view.findViewById(R.id.tv_btn_add_photo_gallery)
        val btnRemovePhoto : TextView = view.findViewById(R.id.tv_btn_remove_photo)

        btnUseCamera.setOnClickListener {
            Toast.makeText(requireContext(), "Using camera", Toast.LENGTH_SHORT).show()
        }

        btnUploadGallery.setOnClickListener {
            Toast.makeText(requireContext(), "Upload photo from gallery", Toast.LENGTH_SHORT).show()
        }

        btnRemovePhoto.setOnClickListener {
            Toast.makeText(requireContext(), "Photo Removed!", Toast.LENGTH_SHORT).show()
        }

        return view
    }

    companion object {
        const val TAG = "BottomSheet"
    }
}