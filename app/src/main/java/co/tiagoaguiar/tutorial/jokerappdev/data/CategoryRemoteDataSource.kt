package co.tiagoaguiar.tutorial.jokerappdev.data

import android.os.Handler
import android.os.Looper
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryRemoteDataSource {

    fun findAllCategories(callback: ListCategoryCallback){
      HTTPClient.retrofit()
          .create(ChuckNorrisAPI:: class.java) // vai criar a class concreta a partir desse interface
          .findAllCategories()
          .enqueue(object : Callback<List<String>> {
              override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
                if(response.isSuccessful){
                    val caregories = response.body()
                    callback.onSuccess(caregories ?: emptyList())
                }else {
                    val error = response.errorBody()?.string()
                    callback.onError(error ?: "Erro desconhecido")
                }
                callback.onComplete()
              }

              override fun onFailure(call: Call<List<String>>, t: Throwable) {
                  callback.onError(t.message ?: "Erro interno")
                  callback.onComplete()
              }

          })
    }
}