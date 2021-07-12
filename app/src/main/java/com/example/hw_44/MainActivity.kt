package com.example.hw_44

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw_44.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), TodoListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAdapter()
        onButtonAdd()
    }

    private fun setupAdapter() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        todoAdapter = TodoAdapter(this)
        binding.recyclerView.adapter = todoAdapter
    }

    private fun onButtonAdd() {
        binding.btnAdd.setOnClickListener {
            val text = binding.etTodo.text.toString()

            if (text == "") {
                Toast.makeText(this, getString(R.string.empty_et_toast), Toast.LENGTH_LONG).show()
            } else {
                val item = Todo(text)
                todoAdapter.setItems(item)
            }
        }
    }

    override fun onButtonDelete(position: Int) {
        todoAdapter.delete(position)
    }
}