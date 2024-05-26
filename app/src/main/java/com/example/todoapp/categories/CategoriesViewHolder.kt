package com.example.todoapp.categories

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R

class CategoriesViewHolder(view:View):RecyclerView.ViewHolder(view){
    private val tvCategoryName:TextView=view.findViewById(R.id.tvCategoryName)
    private val divider:View=view.findViewById(R.id.divider)


fun render( taskCategory: TaskCategory){

    when(taskCategory){






        TaskCategory.Business -> {
            tvCategoryName.text="Business"
            divider.setBackgroundColor(
                 ContextCompat.getColor(divider.context,R.color.BusinessCategory)

            )
        }
        TaskCategory.Others -> {
            tvCategoryName.text = "Others"
            divider.setBackgroundColor(
                ContextCompat.getColor(divider.context,R.color.OtherCategory))
        }

        TaskCategory.Personal -> {
            tvCategoryName.text = "Personal"
            divider.setBackgroundColor(
                ContextCompat.getColor(divider.context,R.color.PersonalCategory))
        }
    }


}

}