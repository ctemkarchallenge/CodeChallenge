package com.ctemkar.codechallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import com.ctemkar.codechallenge.data.Component
import com.ctemkar.codechallenge.ui.list.FeedListItem
import com.ctemkar.codechallenge.ui.theme.CodeChallengeTheme
import com.ctemkar.codechallenge.ui.viewmodel.FeedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    /*
    This is the entry point of the application/ HomePage
     */

    //Viewmodel is being injected by Hilt
    private val feedViewModel: FeedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodeChallengeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    //retrieving the value and passing it to views
                    //Data is observed from the view model and passing it as a state to compose
                    val observedList: List<Component> by feedViewModel.feeds.observeAsState(ArrayList<Component>())
                    ListScreen(feeds = observedList)
                }
            }
        }
    }
}

@Composable
fun ListScreen(feeds: List<Component>) {
    //Passing the data to be displayed as the list
    //FeedListItem is responsible for the views

    LazyColumn {
        items(feeds) { feed ->
            FeedListItem(feedComponent = feed)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CodeChallengeTheme {
        // add whatever
    }
}