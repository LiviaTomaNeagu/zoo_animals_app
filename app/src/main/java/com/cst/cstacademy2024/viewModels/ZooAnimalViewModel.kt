package np.com.bimalkafle.todoapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cst.cstacademy2024.MainApplication
import com.cst.cstacademy2024.models.ZooAnimalModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.Date

class ZooAnimalViewModel : ViewModel() {

    // Assuming MainApplication has a singleton access to the database similar to the Todo app
    private val zooAnimalDao = MainApplication.zooDatabase.animalDao()

    // LiveData holding the list of all animals
    val allAnimals: LiveData<List<ZooAnimalModel>> = zooAnimalDao.getAllAnimals()

    // Function to add a new animal to the database
    fun addAnimal(animalName: String, continent: String) {
        viewModelScope.launch(Dispatchers.IO) {
            zooAnimalDao.addAnimal(ZooAnimalModel(animalName = animalName, continent = continent))
        }
    }

    // Function to delete an animal by ID
    fun deleteAnimal(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            zooAnimalDao.deleteAnimal(id)
        }
    }

}
