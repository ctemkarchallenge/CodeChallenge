package com.ctemkar.codechallenge.di

import com.ctemkar.codechallenge.data.FeedClientDaoImpl
import com.ctemkar.codechallenge.data.MockClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    /*
    Main app module that handles the beans for serving the dependencies
    All the dependencies other than Hilt components should be defined here
     */


    /*
    This method provides the the data source serving the data
    to the repository. Change the return type with the adequate to
    plug n play the new source
     */
    @Singleton
    @Provides
    fun getFeedClientDao():FeedClientDaoImpl{
        return MockClient
    }

}