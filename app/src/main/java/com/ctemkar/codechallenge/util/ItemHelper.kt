package com.ctemkar.codechallenge.util

import androidx.compose.ui.graphics.Color
import com.ctemkar.codechallenge.data.Component
import com.ctemkar.codechallenge.data.Component1
import com.ctemkar.codechallenge.data.Component2
import com.ctemkar.codechallenge.data.Component3
import com.ctemkar.codechallenge.model.ItemDTO
import java.lang.IllegalArgumentException

/*
This method converts the different component types to a uniform datatype ItemDTO
to avoid boilerplate code and uniform data structure inside the app and also view
 */
fun processComponentType(component: Component): ItemDTO {
    val item = ItemDTO("", Color.Transparent, Color.Transparent, "")
    when (component) {
/*
Setting the data to item object according to the component type, currently there are 3
component types possible to be received
 */
        is Component1 -> {
            item.apply {
                textColor = Color.Cyan
                title = component.text
                circleColor = Color.Cyan
            }
        }
        is Component2 -> {
            item.apply {
                textColor = Color.Black
                circleColor = Color.Gray
            }

           if (component.imageUrl.isNullOrBlank()) { item.title =  "No image to display"} else { item.title =  component.imageUrl.toString() }

        }
        is Component3 -> {
            item.apply {
                title = component.timestamp.toString()
                textColor = Color.Cyan
                circleColor = Color.Yellow
            }
        }
        //Throw an error if any other component is received
        else->throw IllegalArgumentException("Invalid Component Type")
    }

    return item

}