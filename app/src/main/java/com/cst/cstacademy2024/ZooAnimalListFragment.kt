package com.cst.cstacademy2024

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cst.cstacademy2024.adapters.ZooAdapter
import com.cst.cstacademy2024.helpers.extensions.SpacesItemDecoration
import com.cst.cstacademy2024.helpers.extensions.logErrorMessage
import com.cst.cstacademy2024.models.ContinentType
import com.cst.cstacademy2024.models.ZooAnimalModel
import np.com.bimalkafle.todoapp.ZooAnimalViewModel


class ZooAnimalListFragment : Fragment() {

    private val id = 0
    private lateinit var viewModel: ZooAnimalViewModel

    //private val zooAnimals: LiveData<List<ZooAnimalModel>> = viewModel.allAnimals
    private var currentAnimals: List<ZooAnimalModel> = listOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_zoo_animal_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            viewModel = ViewModelProvider(this).get(ZooAnimalViewModel::class.java)

            val recyclerView: RecyclerView = view.findViewById(R.id.rv_zoo_animal_list)
            val adapter = ZooAdapter()
            recyclerView.apply {
                layoutManager = LinearLayoutManager(context)
                this.adapter = adapter
                addItemDecoration(SpacesItemDecoration(spaceSize = resources.getDimensionPixelSize(R.dimen.recycler_view_item_spacing)))
            }

            // Observe the LiveData from ViewModel
            viewModel.allAnimals.observe(viewLifecycleOwner) { animals ->
                adapter.submitList(animals)
                currentAnimals = animals
            }

            setupAddButton(view)
            adapter.setOnDeleteClickListener { position ->
                    // Remove the item from the list at the specified position
                    viewModel.deleteAnimal(viewModel.allAnimals.value?.get(position)?.id ?: 0)
                    //zooAnimals.removeAt(position)
                    // Notify the adapter that the item has been removed
                    adapter.notifyItemRemoved(position)
                }
        }

    private fun setupAddButton(view: View) {
        val addButton = view.findViewById<Button>(R.id.btn_add_animal)
        addButton.setOnClickListener {
            val nameEdit = view.findViewById<EditText>(R.id.edit_name)
            val continentEdit = view.findViewById<EditText>(R.id.edit_continent)
            val name = nameEdit.text.toString().trim()
            val continent = continentEdit.text.toString().trim()

            if (name.isNotEmpty() && continent.isNotEmpty()) {
                if(!doesContinentExit(continent)) {
                    Toast.makeText(context, "The continent is not valid!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                val newAnimal = ZooAnimalModel(animalName = getStringCapitalized(name), continent = getStringCapitalized(continent))
                if (currentAnimals.any { it.animalName.equals(newAnimal.animalName, ignoreCase = true) && it.continent == newAnimal.continent }) {
                    Toast.makeText(context, "The animal is already on the list!", Toast.LENGTH_SHORT).show()
                } else {
                    viewModel.addAnimal(newAnimal.animalName, newAnimal.continent)
                    Toast.makeText(context, "The animal has been added to the list!", Toast.LENGTH_SHORT).show()
                    nameEdit.text.clear()
                    continentEdit.text.clear()
                }
            } else {
                if (name.isEmpty()) nameEdit.error = "Please enter a name"
                if (continent.isEmpty()) continentEdit.error = "Please enter a continent"
            }
        }
    }

    private fun getStringCapitalized(animalName: String): String {
        // Transformă numele animalului în litere mici
        val lowercaseName = animalName.toLowerCase()
        // Capitalizează prima literă
        return lowercaseName.capitalize()
    }

    private fun doesContinentExit(continent: String): Boolean {
        if(continent.lowercase() != "europe" && continent.lowercase() != "africa" && continent.lowercase() != "asia" && continent.lowercase() != "north america" && continent.lowercase() != "south america" && continent.lowercase() != "australia" && continent.lowercase() != "antarctica") {
            return false
        }
        return true;
    }


}
