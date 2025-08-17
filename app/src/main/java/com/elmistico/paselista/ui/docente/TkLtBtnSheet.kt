package com.elmistico.paselista.ui.docente

import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.view.PreviewView
import androidx.core.content.ContextCompat
import com.elmistico.paselista.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import androidx.camera.lifecycle.ProcessCameraProvider


class TkLtBtnSheet : BottomSheetDialogFragment() {
    private lateinit var previewView: PreviewView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_tk_lits, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val btnCamera = view.findViewById<Button>(R.id.btnCamara)
        previewView = view.findViewById(R.id.cameraPreview)

        btnCamera.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    requireContext(),
                    android.Manifest.permission.CAMERA
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                previewView.visibility = View.VISIBLE
                iniciarCamara()
            } else {
                requestPermissions(arrayOf(android.Manifest.permission.CAMERA), 1001)
            }
        }
    }

    private fun iniciarCamara() {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(requireContext())
        cameraProviderFuture.addListener({
            try {
                val cameraProvider = cameraProviderFuture.get()
                val preview = Preview.Builder().build().also {
                    it.setSurfaceProvider(previewView.surfaceProvider)
                }
                val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
                cameraProvider.unbindAll()
                cameraProvider.bindToLifecycle(viewLifecycleOwner, cameraSelector, preview)
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(requireContext(), "Error al abrir cámara", Toast.LENGTH_SHORT).show()
            }
        }, ContextCompat.getMainExecutor(requireContext()))
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1001 && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            previewView.visibility = View.VISIBLE
            iniciarCamara()
        } else {
            Toast.makeText(requireContext(), "Permiso denegado", Toast.LENGTH_SHORT).show()
            dismiss()
        }
    }
}
