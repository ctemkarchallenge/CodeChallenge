package com.ctemkar.codechallenge

import com.ctemkar.codechallenge.data.*
import org.junit.Test

import org.junit.Assert.*

class FeedListItemTesting {


    @Test
    fun checkIsDataReceiving() {
        val feedRepo  = FeedRepository(feedDao = MockClient)
        assertNotEquals(feedRepo.getAllFeeds().size,0)
    }

    @Test
    fun checkDifferentComponents() {
        val feedRepo  = FeedRepository(feedDao = MockClient)
        var component1 = false
        var component2 = false
        var component3 = false
        feedRepo.getAllFeeds().forEach {
            if(it is Component1) component1 = true
            if(it is Component2) component2 = true
            if(it is Component3) component3 = true
        }
        assert(component1)
        assert(component2)
        assert(component3)
    }

    @Test
    fun checkValidDataReceiving() {
        val feedRepo  = FeedRepository(feedDao = MockClient)
        val list1 = feedRepo.getAllFeeds()
        val list2 = feedRepo.getAllFeeds()
        assertNotEquals(list1,list2)
    }


}