package com.example.todoapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.categories.CategoriesAdapters
import com.example.todoapp.categories.TaskCategory


class HomeActivity : AppCompatActivity() {
private val categories= listOf(

    TaskCategory.Personal,
    TaskCategory.Business,
    TaskCategory.Others,


)
    private lateinit var rvCategories:RecyclerView
    private lateinit var  categoriesAdapters:CategoriesAdapters
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        initComponent()
        initUI()


    }


    private fun initComponent() {
        rvCategories=findViewById(R.id.rvCategories)
    }

    private fun initUI() {
       categoriesAdapters=CategoriesAdapters(categories)
        rvCategories.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rvCategories.adapter=categoriesAdapters
    }
}