package com.example.todoapp.tasks

import com.example.todoapp.categories.TaskCategory

data class Task (val name:String,val category:TaskCategory,var isSelected:Boolean=false){
}