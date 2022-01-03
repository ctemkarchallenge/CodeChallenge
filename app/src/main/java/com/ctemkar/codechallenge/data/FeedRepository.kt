package com.ctemkar.codechallenge.data

import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class FeedRepository @Inject constructor(val feedDao: FeedClientDaoImpl) {

    /*
    This method retrieves all the components from the repository and
    return it to the ViewModel/Use Case
    Injections -: feedDao
     */
    suspend fun getAllFeeds(): List<Component> {
        return feedDao.getFeed()
    }
}