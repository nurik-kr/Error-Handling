package kg.nurik.errorhandling.common

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.nurik.errorhandling.data.model.ResultWrapper
import kotlinx.coroutines.*
import retrofit2.HttpException
import java.io.IOException
import java.net.UnknownHostException

abstract class BaseViewModel : ViewModel() {

    public val errorData = MutableLiveData<ErrorTypes>()

    protected val exceptionHandler = CoroutineExceptionHandler { _, exeption ->
       run {
           when(exeption){
               is UnknownHostException -> errorData.postValue(ErrorTypes.NETWORK_FAILED)
               is IOException -> errorData.postValue(ErrorTypes.IO_ERROR)
               is HttpException -> if(exeption.code() == 401){errorData.postValue(ErrorTypes.AUTH_ERROR)}
           }
        }
    }

    protected fun handleRequest(listener: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            try {
                listener.invoke(this)
            } catch (t: Throwable) {
                exceptionHandler.handleException(Dispatchers.IO, t)
                t.printStackTrace()
            }
        }
    }
}

enum class ErrorTypes(){
   NETWORK_FAILED,
    IO_ERROR,
    AUTH_ERROR
}

suspend fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher,
    apicall: suspend () -> T
): ResultWrapper<T> {
    return withContext(dispatcher) {
        try {
            ResultWrapper.Success(apicall.invoke())
        } catch (t: Throwable) {
            when (t) {
                is HttpException -> {
                    val code = t.code()
                    val message = t.message()
                    ResultWrapper.HttpError(code, message)
                }
                is IOException -> ResultWrapper.NetworkError
                else -> ResultWrapper.HttpError(null, null)
            }
        }
    }
}