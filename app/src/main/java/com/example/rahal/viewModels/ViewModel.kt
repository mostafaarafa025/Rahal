package com.example.rahal.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rahal.data.Place
import com.example.rahal.remove2.Restaurant
import com.example.rahal.repositories.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(
    val repository: Repository
): ViewModel(){

    private val _getRecommendedMutableLiveData = MutableLiveData<List<Place>>()
    val getRecommendedLiveData: LiveData<List<Place>> = _getRecommendedMutableLiveData

    private val _getTopRatedMutableLiveData = MutableLiveData<List<Place>>()
    val getTopRatedLiveData: LiveData<List<Place>> = _getTopRatedMutableLiveData

    private val _getNewMutableLiveData = MutableLiveData<List<Restaurant>>()
    val getNewLiveData: LiveData<List<Restaurant>> = _getNewMutableLiveData

     val _getActivitiesMutableLiveData = MutableLiveData<List<String>>()
    val getActivitiesLiveData: LiveData<List<String>> = _getActivitiesMutableLiveData

    private val _getContentActivitiesMutableLiveData = MutableLiveData<List<Place>>()
    val getContentActivitiesLiveData: LiveData<List<Place>> = _getContentActivitiesMutableLiveData

    fun getRecommended(){
        viewModelScope.launch {
            try {
                val response = repository.getRecommended("10")

                response.body()!!.data.docuemnts.let {
                    _getRecommendedMutableLiveData.postValue(it)
                }

            }catch (t:Throwable){
                Log.d("testApp",t.message.toString()+ " Error getRecommended")
            }
        }
    }

    fun getContentOfActivities(cityName: String,type: String){
        viewModelScope.launch {
            try {
                val response = repository.getContentOfActivities(cityName,type)

                response.body()!!.data.attractions.let {
                    _getContentActivitiesMutableLiveData.postValue(it)
                }

            }catch (t:Throwable){
                Log.d("testApp",t.message.toString()+ " Error getContentOfActivities")
            }
        }
    }

    fun getNew(cityName:String){
        viewModelScope.launch {
            try {
                val response = repository.getNew(cityName,"10")

                response.body()!!.data.restaurants.let {
                    _getNewMutableLiveData.postValue(it)
                }

            }catch (t:Throwable){
                Log.d("testApp",t.message.toString()+ " Error getNew")
            }
        }
    }

    fun getTopRated(){
        viewModelScope.launch {
            try {
                val response = repository.getTopRated("10")

                response.body()!!.data.docuemnts.let {
                    _getTopRatedMutableLiveData.postValue(it)
                }

            }catch (t:Throwable){
                Log.d("testApp",t.message.toString()+ " Error getTopRated")
            }
        }
    }

    fun getActivities(cityName: String){
        viewModelScope.launch {
            try {
                val response = repository.getActivities(cityName)

                response.body()!!.data.activityTypes.let {
                    _getActivitiesMutableLiveData.postValue(it)
                }

            }catch (t:Throwable){

            }
        }
    }

    fun upsert(place: Place) = viewModelScope.launch {
        repository.upsert(place)
    }

    fun delete(place: Place) = viewModelScope.launch {
        repository.delete(place)
    }

    fun getFavorites() = repository.getFavoritesPlaces

}