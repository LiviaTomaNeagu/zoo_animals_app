package com.cst.cstacademy2024

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cst.cstacademy2024.adapters.ZooAdapter
import com.cst.cstacademy2024.helpers.extensions.SpacesItemDecoration
import com.cst.cstacademy2024.helpers.extensions.logErrorMessage
import com.cst.cstacademy2024.models.ContinentType
import com.cst.cstacademy2024.models.ZooAnimalModel


class ZooAnimalListFragment : Fragment() {

//    private val arguments: ZooAnimalListFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_zoo_animal_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val token = arguments.token
//        token.logErrorMessage()
        fetchZooAnimals()

    }

    private fun fetchZooAnimals() {
        // Placeholder for an API call to get zoo animals
        val zooAnimals = getAnimals()  // Simulated data fetch
        setupZooAnimalList(zooAnimals)
    }

    companion object {
        var animals_list: List<ZooAnimalModel>? = null
    }

    fun getAnimals(): List<ZooAnimalModel> {
        if (animals_list == null) {
            animals_list = createAnimalList().shuffled()
        }
        return animals_list!!
    }

    fun createAnimalList(): MutableList<ZooAnimalModel> {
        val animals = mutableListOf<ZooAnimalModel>()

// Africa
        animals.add(ZooAnimalModel(1, "Lion", "Africa", ContinentType.AFRICA))
        animals.add(ZooAnimalModel(2, "Elephant", "Africa", ContinentType.AFRICA))
        animals.add(ZooAnimalModel(3, "Giraffe", "Africa", ContinentType.AFRICA))
        animals.add(ZooAnimalModel(4, "Zebra", "Africa", ContinentType.AFRICA))
        animals.add(ZooAnimalModel(5, "Hippo", "Africa", ContinentType.AFRICA))
        animals.add(ZooAnimalModel(6, "Cheetah", "Africa", ContinentType.AFRICA))
        animals.add(ZooAnimalModel(7, "Rhinoceros", "Africa", ContinentType.AFRICA))

// Asia
        animals.add(ZooAnimalModel(8, "Panda", "Asia", ContinentType.ASIA))
        animals.add(ZooAnimalModel(9, "Tiger", "Asia", ContinentType.ASIA))
        animals.add(ZooAnimalModel(10, "Monkey", "Asia", ContinentType.ASIA))
        animals.add(ZooAnimalModel(11, "Snake", "Asia", ContinentType.ASIA))
        animals.add(ZooAnimalModel(12, "Bear", "Asia", ContinentType.ASIA))
        animals.add(ZooAnimalModel(13, "Camel", "Asia", ContinentType.ASIA))

// Australia
        animals.add(ZooAnimalModel(14, "Kangaroo", "Australia", ContinentType.AUSTRALIA))
        animals.add(ZooAnimalModel(15, "Koala", "Australia", ContinentType.AUSTRALIA))
        animals.add(ZooAnimalModel(16, "Emu", "Australia", ContinentType.AUSTRALIA))
        animals.add(ZooAnimalModel(17, "Platypus", "Australia", ContinentType.AUSTRALIA))
        animals.add(ZooAnimalModel(18, "Wallaby", "Australia", ContinentType.AUSTRALIA))

// Antarctica
        animals.add(ZooAnimalModel(19, "Penguin", "Antarctica", ContinentType.ANTARCTICA))
        animals.add(ZooAnimalModel(20, "Seal", "Antarctica", ContinentType.ANTARCTICA))
        animals.add(ZooAnimalModel(21, "Whale", "Antarctica", ContinentType.ANTARCTICA))
        animals.add(ZooAnimalModel(22, "Albatross", "Antarctica", ContinentType.ANTARCTICA))
        animals.add(ZooAnimalModel(23, "Orca", "Antarctica", ContinentType.ANTARCTICA))

// North America
        animals.add(ZooAnimalModel(24, "Grizzly Bear", "North America", ContinentType.NORTH_AMERICA))
        animals.add(ZooAnimalModel(25, "Bald Eagle", "North America", ContinentType.NORTH_AMERICA))
        animals.add(ZooAnimalModel(26, "Bison", "North America", ContinentType.NORTH_AMERICA))
        animals.add(ZooAnimalModel(27, "Raccoon", "North America", ContinentType.NORTH_AMERICA))
        animals.add(ZooAnimalModel(28, "Cougar", "North America", ContinentType.NORTH_AMERICA))

// South America
        animals.add(ZooAnimalModel(29, "Jaguar", "South America", ContinentType.SOUTH_AMERICA))
        animals.add(ZooAnimalModel(30, "Llama", "South America", ContinentType.SOUTH_AMERICA))
        animals.add(ZooAnimalModel(31, "Sloth", "South America", ContinentType.SOUTH_AMERICA))
        animals.add(ZooAnimalModel(32, "Anaconda", "South America", ContinentType.SOUTH_AMERICA))
        animals.add(ZooAnimalModel(33, "Toucan", "South America", ContinentType.SOUTH_AMERICA))

// Europe
        animals.add(ZooAnimalModel(34, "Wolf", "Europe", ContinentType.EUROPE))
        animals.add(ZooAnimalModel(35, "Brown Bear", "Europe", ContinentType.EUROPE))
        animals.add(ZooAnimalModel(36, "Red Fox", "Europe", ContinentType.EUROPE))
        animals.add(ZooAnimalModel(37, "European Bison", "Europe", ContinentType.EUROPE))
        animals.add(ZooAnimalModel(38, "Chamois", "Europe", ContinentType.EUROPE))
        animals.add(ZooAnimalModel(39, "Iberian Lynx", "Europe", ContinentType.EUROPE))
        animals.add(ZooAnimalModel(40, "Moose", "Europe", ContinentType.EUROPE))

// Additional Animals to Reach 50
        animals.add(ZooAnimalModel(41, "Reindeer", "Europe", ContinentType.EUROPE))
        animals.add(ZooAnimalModel(42, "White Stork", "Europe", ContinentType.EUROPE))
        animals.add(ZooAnimalModel(43, "Griffon Vulture", "Europe", ContinentType.EUROPE))
        animals.add(ZooAnimalModel(44, "Elk", "North America", ContinentType.NORTH_AMERICA))
        animals.add(ZooAnimalModel(45, "Bobcat", "North America", ContinentType.NORTH_AMERICA))
        animals.add(ZooAnimalModel(46, "Arctic Fox", "Antarctica", ContinentType.ANTARCTICA))
        animals.add(ZooAnimalModel(47, "Leopard Seal", "Antarctica", ContinentType.ANTARCTICA))
        animals.add(ZooAnimalModel(48, "Dingo", "Australia", ContinentType.AUSTRALIA))
        animals.add(ZooAnimalModel(49, "Cassowary", "Australia", ContinentType.AUSTRALIA))
        animals.add(ZooAnimalModel(50, "Snow Leopard", "Asia", ContinentType.ASIA))

        return animals
    }


    private fun setupZooAnimalList(zooAnimals: List<ZooAnimalModel>) {
        val layoutManager = LinearLayoutManager(context)
//        val adapter = ZooAdapter(zooAnimals)
        val adapter = ZooAdapter(zooAnimals) { animalName, continent, color ->
            val action = ZooAnimalListFragmentDirections
                .actionZooAnimalListFragmentToAnimalDetailFragment(animalName, continent, color)
            findNavController().navigate(action)
        }
        view?.findViewById<RecyclerView>(R.id.rv_zoo_animal_list)?.apply {
            this.layoutManager = layoutManager
            this.adapter = adapter
            // Adaugă ItemDecoration pentru spațiere
            val decoration = SpacesItemDecoration(spaceSize = resources.getDimensionPixelSize(R.dimen.recycler_view_item_spacing))
            addItemDecoration(decoration)
        }
    }
}
