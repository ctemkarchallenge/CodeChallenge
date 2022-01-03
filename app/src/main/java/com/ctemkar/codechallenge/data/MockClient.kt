package com.ctemkar.codechallenge.data

import kotlin.random.Random

object MockClient : FeedClientDaoImpl{

    /*
    This class acts as a mock data source for a real network request
    the methods are overridden from the interface and the data is
    given back through suspend function to the repository
     */
    override suspend fun getFeed() = buildFeed()
    override suspend fun buildFeed(): List<Component> {

        val items = mutableListOf<Component>()

        ComponentTypes.values().forEach { type ->
            val max = Random.nextInt(1, 11)
            for (i in 0..max) {
                items.add(generateComponent(type, i))
            }
        }
        return items.shuffled()

    }

    private fun generateComponent(type: ComponentTypes, i: Int) = when (type) {
        ComponentTypes.ONE -> Component1("Text #${i + 1} for $type")
        ComponentTypes.TWO -> Component2(if (i >= 2) "Image #${i + 1} for $type" else null)
        ComponentTypes.THREE -> Component3(i * 1000L)
    }

    private enum class ComponentTypes {
        ONE,
        TWO,
        THREE
    }
}

interface Component
data class Component1(val text: String) : Component
data class Component2(var imageUrl: String?) : Component
data class Component3(val timestamp: Long) : Component

