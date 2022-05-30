package com.krossmanzs.appnavigation.dialogfragment

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment

/**
 * Similiar to how onCreateView() should create a root View in an ordinary fragment,
 * onCreateDialog() should create a Dialog to display as part of DialogFragment. The DialogFragment
 * handles displaying the Dialog at appropriate states in the fragment's lifecycle.
 */

class DownloadConfirmationDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setMessage("Apakah anda yakin ingin mendownload file ini?")
            .setPositiveButton("YES") { _, _ ->
                Toast.makeText(requireContext(), "Mendownload file...", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("NO") { _, _ ->
                Toast.makeText(requireContext(), "Dowload file dibatalkan...", Toast.LENGTH_SHORT)
                    .show()
            }
            .create()
    }

    override fun onDismiss(dialog: DialogInterface) {
        Toast.makeText(requireContext(), "Dialog cancelled...", Toast.LENGTH_SHORT)
            .show()
    }

    companion object {
        const val TAG = "DownloadConfirmationDialog"
    }
}