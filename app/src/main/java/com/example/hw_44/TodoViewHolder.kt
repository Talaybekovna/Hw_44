package com.example.hw_44

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_44.databinding.ItemTodoViewholderBinding

class TodoViewHolder(val binding: ItemTodoViewholderBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Todo) {
        binding.tvTodo.text = item.todo
    }

    companion object {
        fun create(parent: ViewGroup, listener: TodoListener): TodoViewHolder {
            val view = ItemTodoViewholderBinding
                .inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            val holder = TodoViewHolder(view)

            holder.binding.btnDelete.setOnClickListener {
                val position: Int = holder.absoluteAdapterPosition
                listener.onButtonDelete(position)
            }
            return holder
        }
    }
}