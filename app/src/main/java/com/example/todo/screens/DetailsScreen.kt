package com.example.todo.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todo.models.Task
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination
fun DetailsScreen(
    task: Task,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    navigator: DestinationsNavigator
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .scrollable(state = rememberScrollState(), orientation = Orientation.Vertical)
    ) {
        // Back button and edit button
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(imageVector = Icons.Rounded.KeyboardArrowDown, contentDescription = "Back")

            Icon(imageVector = Icons.Rounded.Edit, contentDescription = "Edit task")
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Category and Priority
        Row {
            OutlinedCard(shape = RoundedCornerShape(50.dp)) {
                Text(
                    modifier = Modifier.padding(10.dp),
                    text = task.category.name,
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            OutlinedCard(shape = RoundedCornerShape(50.dp)) {
                Text(
                    modifier = Modifier.padding(10.dp),
                    text = task.priority.toString(),
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        Text(
            text = task.title,
            style = MaterialTheme.typography.displayMedium,
            fontWeight = FontWeight.SemiBold,
            overflow = TextOverflow.Ellipsis,
            maxLines = 3
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            modifier = Modifier.padding(start = 4.dp),
            text = task.caption,
            style = MaterialTheme.typography.labelLarge,
            fontSize = 24.sp,
            overflow = TextOverflow.Ellipsis,
            maxLines = 5
        )

        Spacer(modifier = Modifier.height(80.dp))

        Text(
            modifier = Modifier.padding(start = 5.dp),
            text = task.description,
            style = MaterialTheme.typography.bodyLarge,
        )

        // Due-date, delete and complete buttons at bottom
    }
}