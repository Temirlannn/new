package com.itacademy.new23042022.view.mainActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.itacademy.new23042022.AddActivity.AddActivity
import com.itacademy.new23042022.R
import com.itacademy.new23042022.adapter.ItemAdapter
import com.itacademy.new23042022.databinding.ActivityMainBinding
import com.itacademy.new23042022.models.inventory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), IMainView {

    private var binding: ActivityMainBinding? = null
    private val presenter by lazy { MainPresenter(this) }
    private val adapter by lazy { ItemAdapter() }
    private var list: MutableList<inventory>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        clickListener()
        getAllItems()
        delete()
    }

    private fun clickListener(){
        binding?.floatAdd?.setOnClickListener {
            startActivity(Intent(this, AddActivity::class.java))
        }
    }

    private fun getAllItems() = CoroutineScope(Dispatchers.IO).launch {
        Log.e("Size", presenter.getAllItems()?.size.toString())
        list = presenter.getAllItems()?.toMutableList()
        adapter.differ.submitList(MutableList())
        binding?.Recyler?.adapter = adapter
        binding?.Recyler?.layoutManager = LinearLayoutManager(this@MainActivity)
    }

    private fun delete(){
        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        )
    }

    override fun onResume(){
        super.onResume()
        adapter.notifyDataSetChanged()
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder.
    )

    override fun showTextDeleted() {
        Toast.makeText(this,"SSSFSGASEAE", Toast.LENGTH_SHORT).show()
    }
}