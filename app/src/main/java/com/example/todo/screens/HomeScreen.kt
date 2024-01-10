package com.example.todo.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todo.components.TaskBox
import com.example.todo.models.Task
import com.example.todo.screens.destinations.AddTaskScreenDestination
import com.example.todo.screens.destinations.DetailsScreenDestination
import com.example.todo.viewmodel.TasksViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterial3Api::class)
@RootNavGraph(start = true)
@Destination
@Composable
fun HomeScreen(navigator: DestinationsNavigator) {
    val viewModel = viewModel<TasksViewModel>()
//    viewModel.addTask(
//        Task(
//            title = "Be Confident",
//            caption = "Speak Clearly",
//            description = "Speaking clearly can portray great confidence."
//        )
//    )

    val allTasks by viewModel.allTasksState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Todo for KeKa",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
                navigationIcon = {
                    Icon(
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .clickable {
                                // Clicked on menu
                            },
                        imageVector = Icons.Rounded.Menu,
                        contentDescription = "Menu",
                        tint = Color.Black
                    )
                }
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { navigator.navigate(AddTaskScreenDestination) },
                contentColor = MaterialTheme.colorScheme.primary
            ) {
                Text(text = "Add New task  ")

                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = "Add a Task"
                )
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Spacer(Modifier.height(20.dp))

            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = "All Tasks",
                style = MaterialTheme.typography.displayMedium,
                fontSize = 40.sp,
                fontWeight = FontWeight.SemiBold
            )

            Divider(
                modifier = Modifier.padding(
                    top = 5.dp,
                    start = 16.dp,
                    end = 16.dp
                ),
                thickness = 2.dp
            )

            Spacer(modifier = Modifier.height(10.dp))

            HomeContent(allTasks, navigator)
        }
    }


}


@Composable
fun HomeContent(allTasks: List<Task>, navigator: DestinationsNavigator) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn {
            items(items = allTasks, key = { it.id.toString() }) {
                TaskBox(
                    modifier = Modifier
                        .fillMaxWidth(0.9f),
                    task = it,
                    onBoxClick = { navigator.navigate(DetailsScreenDestination(task = it)) }
                )

                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}