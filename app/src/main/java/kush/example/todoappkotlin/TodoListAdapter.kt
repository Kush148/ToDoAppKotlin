package kush.example.todoappkotlin

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.todo_list_item.view.*
import kush.example.todoappkotlin.models.TODO

class TodoListAdapter(private var todoList: List<TODO>) : RecyclerView.Adapter<ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.todo_list_item, parent, false)
        return ViewHolder(view);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val currentItem = todoList[position]

        holder.title.text=currentItem.title
    }

    override fun getItemCount() = todoList.size
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val title: TextView = itemView.tvTitle
}
