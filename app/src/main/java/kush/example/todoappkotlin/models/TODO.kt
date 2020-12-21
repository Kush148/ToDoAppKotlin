package kush.example.todoappkotlin.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
data class TODO(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String,
    var createdAt: String,
  //  var items: MutableList<TodoItems>
)


data class TodoItems (
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    //@ForeignKey()
    var todoId: Int,
    var itemName: String,
    var createdAt: String,
    var isCompleted: Boolean,
)