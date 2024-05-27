package com.example.todoapp

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.categories.CategoriesAdapters
import com.example.todoapp.categories.TaskCategory
import com.example.todoapp.tasks.Task
import com.example.todoapp.tasks.TaskAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton


class HomeActivity : AppCompatActivity() {
    private val categories = listOf(

        TaskCategory.Personal,
        TaskCategory.Business,
        TaskCategory.Others,

        )

    private val tasks = mutableListOf(
        Task("Prueba b", TaskCategory.Business),
        Task("Prueba p", TaskCategory.Personal),
        Task("Prueba O", TaskCategory.Others),

        )
    private lateinit var rvCategories: RecyclerView
    private lateinit var rvtasks: RecyclerView
    private lateinit var categoriesAdapters: CategoriesAdapters
    private lateinit var taskAdapter: TaskAdapter
    private lateinit var fabAddTask: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        initComponent()
        initUI()
        initListeners()


    }

    private fun initListeners() {
        fabAddTask.setOnClickListener { showDialog() }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)
        val btnAddTask: Button = dialog.findViewById(R.id.btAddTask)
        val etTask: EditText = dialog.findViewById(R.id.etTask)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)
        btnAddTask.setOnClickListener {
            val currentTask = etTask.text.toString()
            if (currentTask.isNotEmpty()) {
                val selectedId = rgCategories.checkedRadioButtonId
                val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedId)
                val currentCategory: TaskCategory = when (selectedRadioButton.text) {
                    getString(R.string.Business) -> TaskCategory.Business
                    getString(R.string.Personal) -> TaskCategory.Personal
                    getString(R.string.Others) -> TaskCategory.Others
                    else -> TaskCategory.Others
                }
                tasks.add(Task(currentTask, currentCategory))
                updateTask()
                dialog.hide()

            }

        }
        dialog.show()
    }

    private fun initComponent() {
        rvCategories = findViewById(R.id.rvCategories)
        rvtasks = findViewById(R.id.rvTasks)
        fabAddTask = findViewById(R.id.fabAddTask)
    }

    private fun initUI() {
        categoriesAdapters = CategoriesAdapters(categories)
        rvCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapters
        taskAdapter = TaskAdapter(tasks, ){ onItemSelected(it) }
        rvtasks.layoutManager = LinearLayoutManager(this)
        rvtasks.adapter = taskAdapter
    }

    private fun onItemSelected(position: Int) {
        tasks[position].isSelected = !tasks[position].isSelected
        updateTask()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun updateTask() {
        taskAdapter.notifyDataSetChanged()
    }
}