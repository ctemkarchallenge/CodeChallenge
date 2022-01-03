package com.ctemkar.codechallenge.data

interface FeedClientDaoImpl {
    /*
    This interface defines the required methods in a network source
    All the network source clients should be extending this interface
    to make sure the dependencies are loosely coupled and can be
    changed without touching the class name
     */
    suspend fun getFeed() : List<Component>
    suspend fun buildFeed() : List<Component>
}