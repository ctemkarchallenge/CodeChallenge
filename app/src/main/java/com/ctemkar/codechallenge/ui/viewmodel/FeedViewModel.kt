package com.ctemkar.codechallenge.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ctemkar.codechallenge.data.Component
import com.ctemkar.codechallenge.data.FeedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val repository: FeedRepository
) : ViewModel() {


    /*
    The Mutable live data is only accessible inside the viewmodel
    Activity or others are only allowed to observe the data, if they
    want to change the data, then a function should be defined to change
    with the data inside this class.
    Injections :- repository
     */
    private var _feeds = MutableLiveData<List<Component>>()
    var feeds =_feeds
    init {
        /*
        Calls the getFeeds method when an instance is created
        Used to load the data initially
         */
        getFeeds()
    }

    //This method loads the data from the repository and loads it to the LiveData
    private fun getFeeds() {
        viewModelScope.launch (Dispatchers.IO){
            //Calling the suspend function to get all the feilds and set it to livedata
            //which is being observed from the activity/fragment
            _feeds.postValue(repository.getAllFeeds())
            Log.d(TAG, "getFeeds: ${repository.getAllFeeds().size}")
        }
    }

    private val TAG = "FeedViewModel"


}