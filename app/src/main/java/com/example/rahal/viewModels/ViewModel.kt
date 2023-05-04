package com.example.rahal.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rahal.data.Docuemnt
import com.example.rahal.repositories.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(
    val repository: Repository
): ViewModel(){

    private val _getRecommendedMutableLiveData = MutableLiveData<List<Docuemnt>>()
    val getRecommendedLiveData: LiveData<List<Docuemnt>> = _getRecommendedMutableLiveData

    private val _getTopRatedMutableLiveData = MutableLiveData<List<Docuemnt>>()
    val getTopRatedLiveData: LiveData<List<Docuemnt>> = _getTopRatedMutableLiveData

    fun getRecommended(){
        viewModelScope.launch {
            try {
                val response = repository.getRecommended("-num_reviews")

                response.body()!!.data.docuemnts.let {
                    _getRecommendedMutableLiveData.postValue(it)
                }

            }catch (t:Throwable){
                Log.d("testApp",t.message.toString()+ " Error getRecommended")
            }
        }
    }

    fun getTopRated(){
        viewModelScope.launch {
            try {
                val response = repository.getTopRated("-rating")

                response.body()!!.data.docuemnts.let {
                    _getTopRatedMutableLiveData.postValue(it)
                }

            }catch (t:Throwable){
                Log.d("testApp",t.message.toString()+ " Error getTopRated")
            }
        }
    }

}