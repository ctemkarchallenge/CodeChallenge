package com.ctemkar.codechallenge.ui.list

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ctemkar.codechallenge.data.Component
import com.ctemkar.codechallenge.data.Component1
import com.ctemkar.codechallenge.util.processComponentType

@Composable
fun FeedListItem(
    feedComponent: Component
) {
    //Converting the component to uniform data for views
    val itemDTO = processComponentType(feedComponent)

    //View Definition
    Surface(
        //Setting the background color from item
        modifier = Modifier.fillMaxWidth(),
        color = itemDTO.circleColor,
        shape = RectangleShape,
        elevation = 2.dp
    ) {
        Column(
            modifier = Modifier
                .padding(all = 24.dp)
                .fillMaxWidth()
        ) {



            Row {
                Text(
                    //Setting the Title from item
                    modifier = Modifier.weight(8f),
                    text = itemDTO.title,
                    color =Color.DarkGray,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
            }

        }
    }

}

@Composable
@Preview
fun FeedListItemPreview() {
    val feedComponent = Component1(text = "")
    FeedListItem(feedComponent = feedComponent)

}