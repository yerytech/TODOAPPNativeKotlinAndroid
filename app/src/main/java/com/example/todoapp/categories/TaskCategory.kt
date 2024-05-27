package com.example.todoapp.categories

sealed class TaskCategory(var isSelected:Boolean=false) {
    data object Business : TaskCategory()
    data object Others : TaskCategory()
    data object Personal : TaskCategory()


}

