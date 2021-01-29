package kg.nurik.errorhandling.ui

import androidx.lifecycle.MutableLiveData
import kg.nurik.errorhandling.common.BaseViewModel
import kg.nurik.errorhandling.data.model.ProfileModel
import kg.nurik.errorhandling.data.repository.SamboRepository

class MainViewModel(private val repository: SamboRepository) : BaseViewModel() {

    val user = MutableLiveData<ProfileModel>()

    fun loadUser() {
        handleRequest {
            val result = repository.loadUserProfile()
            user.postValue(result)
        }


//        viewModelScope.launch(Dispatchers.IO) {
//            kotlin.runCatching {
//                val result = repository.loadUserProfile()
//                if (result.isSuccessful) {
//                    user.postValue(result.body())
//                } else {
//                    Log.d("error is ", result.message())
//                }
//            }.onFailure {
//                if (it is HttpException) {
//                    Log.d("error is ", it.toString()) //code
//                } else {
//                    Log.d("error is ", it.toString())  //message
//                }
//            }
//            try {
//                val result = repository.loadUserProfile()
//                user.postValue(result.body())
//            } catch (e: Exception) {
//                Log.d("error is ", e.toString())
//            }
    }
}
