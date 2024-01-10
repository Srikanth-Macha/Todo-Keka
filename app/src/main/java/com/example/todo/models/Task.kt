package com.example.todo.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    val title: String = "Default Title",
    val caption: String = "Default Caption",
    val description: String = "Default Description",

//    val backgroundColor: Color = Color.DarkGray,

//    @ColumnInfo(name = "due_date")
//    val dueDate: Date = Date.now(),
    val priority: Priority = Priority.Medium,
    val category: Category = Category("Daily")

//     Use @ColumnInfo for camelCase variable names.
) : Parcelable

enum class Priority {
    Low,
    Medium,
    High
}

@Parcelize
data class Category(val name: String) : Parcelable
