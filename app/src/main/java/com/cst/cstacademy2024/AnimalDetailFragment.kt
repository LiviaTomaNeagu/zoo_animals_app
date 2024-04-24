package com.cst.cstacademy2024

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.cst.cstacademy2024.models.ContinentType

class AnimalDetailFragment : Fragment() {

    private val args: AnimalDetailFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_animal_detail, container, false)

        // Assuming args.color is a valid color code passed from the previous fragment
        try {
            val color = Color.parseColor(args.color)
            view.setBackgroundColor(color)
        } catch (e: IllegalArgumentException) {
            Log.e("AnimalDetailFragment", "Invalid color format", e)
            // Optionally set a default color if the format is wrong
            view.setBackgroundColor(Color.parseColor("#FFFFFF")) // Default white
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Display the animal name
        view.findViewById<TextView>(R.id.tv_animal_name).apply {
            text = args.animalName
            setTextColor(ContextCompat.getColor(context, getTextColorResId(args.continent)))
        }

        // Display the continent
        view.findViewById<TextView>(R.id.tv_animal_continent).apply {
            text = args.continent
            setTextColor(ContextCompat.getColor(context, getTextColorResId(args.continent)))
        }

    }

    private fun getTextColorResId(continentType: String): Int {
        return when (continentType) {
            "Europe" -> R.color.white
            "Africa" -> R.color.black
            "Asia" -> R.color.white
            "North America" -> R.color.white
            "South America" -> R.color.black
            "Australia" -> R.color.white
            "Antarctica" -> R.color.white
            else -> R.color.black // Default color if needed
        }
    }
}
