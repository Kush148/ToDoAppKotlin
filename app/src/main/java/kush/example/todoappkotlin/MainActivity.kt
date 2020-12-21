package kush.example.todoappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_dailouge_layout.view.*
import kush.example.todoappkotlin.models.TODO

class MainActivity : AppCompatActivity() {
    var todoList = ArrayList<TODO>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv.adapter = TodoListAdapter(todoList)
        rv.layoutManager = LinearLayoutManager(this)
        rv.setHasFixedSize(true)
        fab.setOnClickListener(View.OnClickListener {
            val layoutBuilder =
                LayoutInflater.from(this).inflate(R.layout.custom_dailouge_layout, null)
            val dialougeBuilder = AlertDialog.Builder(this).setView(layoutBuilder)
            val alertDialog = dialougeBuilder.show()

            layoutBuilder.btnAdd.setOnClickListener(View.OnClickListener {
                val title = layoutBuilder.editText.text.toString()
                if (layoutBuilder.editText.text.isNotEmpty()) {
                    todoList.add(kush.example.todoappkotlin.models.TODO(1, title, ""))
                    alertDialog.dismiss()
                }
            })
            layoutBuilder.btnCancel.setOnClickListener(View.OnClickListener {
                alertDialog.dismiss()
            })
        })
    }
}