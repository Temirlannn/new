package com.itacademy.new23042022.AddActivity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.itacademy.new23042022.databinding.ActivityAddBinding
import com.itacademy.new23042022.models.inventory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddActivity : AppCompatActivity() {
    private var binding: ActivityAddBinding? = null
    private val presenter by lazy { AddPresenter(this) }
    private var imageUri: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        openGallery()
        insert()
    }

    private fun insert() = CoroutineScope(Dispatchers.Main).launch {
        val inventory = inventory(
            0,
            binding?.title.toString(),
            binding?.quantity.toString().toInt(),
            binding?.category.toString(),
            imageUri?: ""
        )
        binding?.add?.setOnClickListener { CoroutineScope(Dispatchers.Main).launch { presenter.inserted(inventory) } }
    }

    private fun openGallery() {
        val resultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        )
        {
            result ->
            if (result.resultCode == Activity.RESULT_OK){
                val data = result.data
                imageUri = result.data.toString()
                binding?.image?.setImageURI(data?.data)
            }
        }
        binding?.image?.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            resultLauncher.launch(intent)
        }
    }
}
