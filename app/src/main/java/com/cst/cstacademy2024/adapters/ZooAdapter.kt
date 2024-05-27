package com.cst.cstacademy2024.adapters

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.cst.cstacademy2024.R
import com.cst.cstacademy2024.models.ZooAnimalModel
import com.cst.cstacademy2024.models.ContinentType

class ZooAdapter(private val items: List<ZooAnimalModel>) : RecyclerView.Adapter<ZooAdapter.ZooViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ZooViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_zoo_animal, parent, false)
        return ZooViewHolder(view)
    }

    override fun onBindViewHolder(holder: ZooViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.deleteButton.setOnClickListener {
            onDeleteClickListener?.invoke(position)
        }
    }

    override fun getItemCount(): Int = items.size

    inner class ZooViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val deleteButton: ImageView = itemView.findViewById(R.id.delete_animal)

        fun bind(item: ZooAnimalModel) {
            itemView.apply {
                // Set the text views
                findViewById<TextView>(R.id.animalName).apply {
                    text = item.animalName
                    gravity = Gravity.CENTER
                    setLineSpacing(0f, 1.0f)
                    setTextColor(ContextCompat.getColor(context, R.color.white))
                    val layoutParams = layoutParams as? LinearLayout.LayoutParams
                    layoutParams?.apply {
                        width = LinearLayout.LayoutParams.MATCH_PARENT // or any default value
                        height = LinearLayout.LayoutParams.WRAP_CONTENT  // or any default value
                        weight = 0f  // typically 0 for default
                    }

                }

                findViewById<TextView>(R.id.animalContinent).apply {
                    text = item.continent
                    gravity = Gravity.CENTER
                    setLineSpacing(0f, 1.0f)
                    setTextColor(ContextCompat.getColor(context, R.color.white))
                    val layoutParams = layoutParams as? LinearLayout.LayoutParams
                    layoutParams?.apply {
                        width = LinearLayout.LayoutParams.MATCH_PARENT // or any default value
                        height = LinearLayout.LayoutParams.WRAP_CONTENT  // or any default value
                        weight = 0f  // typically 0 for default
                    }

                }

            }


        }

    }
    // Define a function type for the delete button click listener
    private var onDeleteClickListener: ((Int) -> Unit)? = null

    // Public function to set the delete button click listener
    fun setOnDeleteClickListener(listener: (Int) -> Unit) {
        onDeleteClickListener = listener
    }
}
