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

        // Asia
        animals.add(ZooAnimalModel(6, "Panda", "Asia", ContinentType.ASIA))
        animals.add(ZooAnimalModel(7, "Tiger", "Asia", ContinentType.ASIA))
        animals.add(ZooAnimalModel(8, "Monkey", "Asia", ContinentType.ASIA))
        animals.add(ZooAnimalModel(9, "Snake", "Asia", ContinentType.ASIA))
        animals.add(ZooAnimalModel(10, "Bear", "Asia", ContinentType.ASIA))

        // Australia
        animals.add(ZooAnimalModel(11, "Kangaroo", "Australia", ContinentType.AUSTRALIA))
        animals.add(ZooAnimalModel(12, "Koala", "Australia", ContinentType.AUSTRALIA))
        animals.add(ZooAnimalModel(13, "Emu", "Australia", ContinentType.AUSTRALIA))
        animals.add(ZooAnimalModel(14, "Platypus", "Australia", ContinentType.AUSTRALIA))
        animals.add(ZooAnimalModel(15, "Wallaby", "Australia", ContinentType.AUSTRALIA))

        // Antarctica
        animals.add(ZooAnimalModel(16, "Penguin", "Antarctica", ContinentType.ANTARCTICA))
        animals.add(ZooAnimalModel(17, "Seal", "Antarctica", ContinentType.ANTARCTICA))
        animals.add(ZooAnimalModel(18, "Whale", "Antarctica", ContinentType.ANTARCTICA))
        animals.add(ZooAnimalModel(19, "Albatross", "Antarctica", ContinentType.ANTARCTICA))
        animals.add(ZooAnimalModel(20, "Orca", "Antarctica", ContinentType.ANTARCTICA))

        // North America
        animals.add(ZooAnimalModel(21, "Grizzly Bear", "North America", ContinentType.NORTH_AMERICA))
        animals.add(ZooAnimalModel(22, "Bald Eagle", "North America", ContinentType.NORTH_AMERICA))
        animals.add(ZooAnimalModel(23, "Bison", "North America", ContinentType.NORTH_AMERICA))
        animals.add(ZooAnimalModel(24, "Raccoon", "North America", ContinentType.NORTH_AMERICA))
        animals.add(ZooAnimalModel(25, "Cougar", "North America", ContinentType.NORTH_AMERICA))

        // South America
        animals.add(ZooAnimalModel(26, "Jaguar", "South America", ContinentType.SOUTH_AMERICA))
        animals.add(ZooAnimalModel(27, "Llama", "South America", ContinentType.SOUTH_AMERICA))
        animals.add(ZooAnimalModel(28, "Sloth", "South America", ContinentType.SOUTH_AMERICA))
        animals.add(ZooAnimalModel(29, "Anaconda", "South America", ContinentType.SOUTH_AMERICA))
        animals.add(ZooAnimalModel(30, "Toucan", "South America", ContinentType.SOUTH_AMERICA))

        return animals
    }




//    private fun createSampleZooAnimalList(): List<ZooAnimalModel> {
////        return listOf(
////            ZooAnimalModel(1, "Lion", "Africa", ContinentType.AFRICA),
////            ZooAnimalModel(2, "Panda", "Asia", ContinentType.ASIA),
////            ZooAnimalModel(3, "Kangaroo", "Australia", ContinentType.AUSTRALIA),
////            ZooAnimalModel(4, "Polar Bear", "Antarctica", ContinentType.ANTARCTICA),
////            ZooAnimalModel(5, "Elephant", "Africa", ContinentType.AFRICA),
////            ZooAnimalModel(6, "Grizzly Bear", "North America", ContinentType.NORTH_AMERICA),
////            ZooAnimalModel(7, "Koala", "Australia", ContinentType.AUSTRALIA),
////            ZooAnimalModel(8, "Giraffe", "Africa", ContinentType.AFRICA),
////            ZooAnimalModel(9, "Penguin", "Antarctica", ContinentType.ANTARCTICA),
////            ZooAnimalModel(10, "Zebra", "Africa", ContinentType.AFRICA),
////            ZooAnimalModel(11, "Koala", "Australia", ContinentType.AUSTRALIA),
////            ZooAnimalModel(12, "Polar Bear", "Antarctica", ContinentType.ANTARCTICA),
////            ZooAnimalModel(13, "Elephant", "Africa", ContinentType.AFRICA),
////            ZooAnimalModel(14, "Grizzly Bear", "North America", ContinentType.NORTH_AMERICA),
////            ZooAnimalModel(15, "Koala", "Australia", ContinentType.AUSTRALIA),
////            ZooAnimalModel(16, "Giraffe", "Africa", ContinentType.AFRICA),
////            ZooAnimalModel(17, "Penguin", "Antarctica", ContinentType.ANTARCTICA),
////            ZooAnimalModel(18, "Zebra", "Africa", ContinentType.AFRICA),
////            ZooAnimalModel(19, "Koala", "Australia", ContinentType.AUSTRALIA),
////            ZooAnimalModel(20, "Polar Bear", "Antarctica", ContinentType.ANTARCTICA),
////            ZooAnimalModel(21, "Elephant", "Africa", ContinentType.AFRICA),
////            ZooAnimalModel(22, "Grizzly Bear", "North America", ContinentType.NORTH_AMERICA),
////            ZooAnimalModel(23, "Koala", "Australia", ContinentType.AUSTRALIA),
////            ZooAnimalModel(24, "Giraffe", "Africa", ContinentType.AFRICA),
////            ZooAnimalModel(25, "Penguin", "Antarctica", ContinentType.ANTARCTICA),
////            ZooAnimalModel(26, "Zebra", "Africa", ContinentType.AFRICA),
////            ZooAnimalModel(27, "Koala", "Australia", ContinentType.AUSTRALIA),
////
////        )
//
//        val animals = mutableListOf<ZooAnimalModel>()
//
//
//        return animals
//    }

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
