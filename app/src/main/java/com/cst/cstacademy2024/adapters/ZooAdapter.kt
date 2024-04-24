package com.cst.cstacademy2024.adapters

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.cst.cstacademy2024.R
import com.cst.cstacademy2024.models.ZooAnimalModel
import com.cst.cstacademy2024.models.ContinentType

class ZooAdapter(private val items: List<ZooAnimalModel>,
                 private val onItemClicked: (String, String, String) -> Unit) : RecyclerView.Adapter<ZooAdapter.ZooViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ZooViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_zoo_animal, parent, false)
        return ZooViewHolder(view)
    }

    override fun onBindViewHolder(holder: ZooViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item, onItemClicked)
    }

    override fun getItemCount(): Int = items.size

    class ZooViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: ZooAnimalModel, onItemClicked: (String,String, String) -> Unit) {
            itemView.apply {
                // Set the text views
                findViewById<TextView>(R.id.animalName).apply {
                    text = item.animalName
                    // Set custom alignment based on continent
                    gravity = when (item.continent) {
                        "Europe" -> Gravity.LEFT
                        "Asia" -> Gravity.CENTER
                        "Africa" -> Gravity.LEFT
                        "North America" -> Gravity.RIGHT
                        "South America" -> Gravity.RIGHT
                        "Australia" -> Gravity.CENTER
                        "Antarctica" -> Gravity.CENTER
                        else -> Gravity.START
                    }
                    // Set custom line spacing based on continent
                    setLineSpacing(0f, when (item.continent) {
                        "Europe" -> 1.0f
                        "Asia" -> 1.0f
                        "Africa" -> 1.9f
                        "North America" -> 1.0f
                        "South America" -> 1.9f
                        "Australia" -> 1.0f
                        "Antarctica" -> 1.9f
                        else -> 1.0f
                    })
                    setTextColor(ContextCompat.getColor(context, getTextColorResId(item.type)))

                    // Change layout params for Asia
                    if (item.continent == "Asia") {
                        val layoutParams = layoutParams as? LinearLayout.LayoutParams
                        layoutParams?.apply {
                            // Modify layout params here
                            width = 0
                            height = LinearLayout.LayoutParams.MATCH_PARENT
                            weight = 1f
                            // Add any other modifications as needed
                        }
                    }
                }

                findViewById<TextView>(R.id.animalContinent).apply {
                    text = item.continent
                    // Set custom alignment for animalContinent
                    gravity = when (item.continent) {
                        "Europe" -> Gravity.LEFT
                        "Asia" -> Gravity.CENTER
                        "Africa" -> Gravity.LEFT
                        "North America" -> Gravity.RIGHT
                        "South America" -> Gravity.LEFT
                        "Australia" -> Gravity.CENTER
                        "Antarctica" -> Gravity.CENTER
                        else -> Gravity.END
                    }

                    setLineSpacing(0f, when (item.continent) {
                        "Europe" -> 1.0f
                        "Asia" -> 1.0f
                        "Africa" -> 1.9f
                        "North America" -> 1.0f
                        "South America" -> 1.9f
                        "Australia" -> 1.0f
                        "Antarctica" -> 1.9f
                        else -> 1.0f
                    })
                    setTextColor(ContextCompat.getColor(context, getTextColorResId(item.type)))

                    // Change layout params for Asia
                    if (item.continent == "Asia") {
                        val layoutParams = layoutParams as? LinearLayout.LayoutParams
                        layoutParams?.apply {
                            // Modify layout params here
                            width =0
                            height = LinearLayout.LayoutParams.MATCH_PARENT
                            weight = 1f
                        }
                    }
                }

                val background = ContextCompat.getDrawable(itemView.context, R.drawable.rounded_corners) as GradientDrawable
                background.setColor(getBackgroundColor(item.continent))
                itemView.background = background

//                // Set background color based on the continent type
//                background = ContextCompat.getDrawable(context, getBackgroundResId(item.type))

                // Set custom background drawable for the divider based on continent
                val divider = findViewById<View>(R.id.divider)
                val dividerDrawableId = when (item.continent) {
                    "Asia" -> R.drawable.vertical_divider
                    "Africa", "South America", "Antarctica" -> R.drawable.horizontal_divider
                    else -> 0 // No specific divider for other continents
                }
                divider.background = if (dividerDrawableId != 0) {
                    ContextCompat.getDrawable(context, dividerDrawableId)
                } else {
                    null // Set background to null if no specific divider
                }
                divider.visibility = if (dividerDrawableId != 0) {
                    View.VISIBLE // Show divider for Asia, Africa, South America, and Antarctica
                } else {
                    View.GONE // Hide divider for other continents
                }

                if (item.continent == "Asia") {
                    val layoutParams = divider.layoutParams as? LinearLayout.LayoutParams
                    layoutParams?.apply {
                        width = 0
                        weight = 0.02f
                        height = LinearLayout.LayoutParams.MATCH_PARENT
                    }
                }

                // Set orientation of LinearLayout based on continent
                val layout = findViewById<LinearLayout>(R.id.animalItemLayout)
                layout.orientation = when (item.continent) {
                    "Asia" -> LinearLayout.HORIZONTAL // Change orientation for Asia
                    else -> LinearLayout.VERTICAL // Default orientation for other continents
                }
                layout.gravity = when (item.continent) {
                    "Asia" -> Gravity.CENTER_VERTICAL // Center items for Asia
                    else -> Gravity.START // Default gravity for other continents
                }

                setOnClickListener {
                    val colorResId = when (item.continent) {
                        "Europe" -> ContextCompat.getColor(itemView.context, R.color.green)
                        "Africa" -> ContextCompat.getColor(itemView.context, R.color.yellow)
                        "Asia" -> ContextCompat.getColor(itemView.context, R.color.red)
                        "North America" -> ContextCompat.getColor(itemView.context, R.color.brown)
                        "South America" -> ContextCompat.getColor(itemView.context, R.color.orange)
                        "Australia" -> ContextCompat.getColor(itemView.context, R.color.purple)
                        "Antarctica" -> ContextCompat.getColor(itemView.context, R.color.blue)
                        else -> ContextCompat.getColor(itemView.context, R.color.white)
                    }
                    val color = colorResId
                    onItemClicked(item.animalName, item.continent, String.format("#%06X", 0xFFFFFF and color))
                }

            }
        }

        private fun getBackgroundColor(continent: String): Int {
            return when (continent) {
                "Europe" -> ContextCompat.getColor(itemView.context, R.color.green)
                "Africa" -> ContextCompat.getColor(itemView.context, R.color.yellow)
                "Asia" -> ContextCompat.getColor(itemView.context, R.color.red)
                "North America" -> ContextCompat.getColor(itemView.context, R.color.brown)
                "South America" -> ContextCompat.getColor(itemView.context, R.color.orange)
                "Australia" -> ContextCompat.getColor(itemView.context, R.color.purple)
                "Antarctica" -> ContextCompat.getColor(itemView.context, R.color.blue)
                else -> ContextCompat.getColor(itemView.context, R.color.white)
            }
        }

        private fun getTextColorResId(continentType: ContinentType): Int {
            return when (continentType) {
                ContinentType.EUROPE -> R.color.white
                ContinentType.AFRICA -> R.color.black
                ContinentType.ASIA -> R.color.white
                ContinentType.NORTH_AMERICA -> R.color.white
                ContinentType.SOUTH_AMERICA -> R.color.black
                ContinentType.AUSTRALIA -> R.color.white
                ContinentType.ANTARCTICA -> R.color.white
                else -> R.color.black // Default color if needed
            }
        }
    }
}
