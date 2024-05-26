package com.example.todoapp.categories

sealed class TaskCategory {
    data object Business : TaskCategory()
    data object Others : TaskCategory()
    data object Personal : TaskCategory()


}

