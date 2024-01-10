package com.example.todo.components

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todo.models.Task
import com.example.todo.ui.theme.taskBoxColors

@Composable
fun TaskBox(
    modifier: Modifier = Modifier,
    task: Task, onBoxClick: () -> Unit
) {
    val cornerRadius = 30.dp
    val context = LocalContext.current

    Box(
        modifier = modifier
            .border(
                width = Dp.Hairline,
                color = if (isSystemInDarkTheme()) Color(0xFFA5A5A5) else Color.Black,
                shape = RoundedCornerShape(cornerRadius)
            )
            .background(
                color = taskBoxColors.random(),
                shape = RoundedCornerShape(cornerRadius)
            )
            .padding(vertical = 24.dp, horizontal = 24.dp)
            .clickable(onClick = onBoxClick)
    ) {
        // Top-Start Section
        Column(modifier = Modifier.align(Alignment.TopStart)) {
            Text(
                modifier = Modifier.fillMaxWidth(0.8f),
                text = task.title,
                style = MaterialTheme.typography.titleLarge,
                fontSize = 28.sp,
                fontWeight = FontWeight.SemiBold,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .padding(start = 4.dp),
                text = task.caption,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .padding(start = 6.dp),
                text = "Due Date: 12th Dec, 2024",
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.SemiBold,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Center-End Section
        Row(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 4.dp)
        ) {
            Icon(
                modifier = Modifier
                    .size(30.dp)
                    .clickable {
                        Toast
                            .makeText(
                                context,
                                "The task is deleted",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    },
                imageVector = Icons.Rounded.Delete,
                contentDescription = "Delete task"
            )

            Spacer(modifier = Modifier.width(16.dp))

            Icon(
                modifier = Modifier
                    .size(30.dp)
                    .clickable {
                        Toast
                            .makeText(
                                context,
                                "The task is marked complete",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    },
                imageVector = Icons.Rounded.Done,
                contentDescription = "Complete task"
            )
        }

        // Bottom Section
        Row(
            modifier = Modifier
                .fillMaxWidth(0.92f)
                .align(Alignment.BottomCenter)
                .padding(top = 120.dp, bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val categoryText = buildAnnotatedString {
                withStyle(
                    style = MaterialTheme.typography.labelLarge.toSpanStyle(),
                ) {
                    append("Category: ")
                }

                withStyle(
                    style = MaterialTheme.typography.titleMedium.toSpanStyle()
                        .copy(fontWeight = FontWeight.Bold)
                ) {
                    append(task.category.name)
                }
            }

            val priorityText = buildAnnotatedString {
                withStyle(
                    style = MaterialTheme.typography.labelLarge.toSpanStyle(),
                ) {
                    append("Priority: ")
                }

                withStyle(
                    style = MaterialTheme.typography.titleMedium.toSpanStyle()
                        .copy(fontWeight = FontWeight.Bold)
                ) {
                    append(task.priority.toString())
                }
            }

            Text(text = categoryText)

            Text(text = priorityText)
        }
    }
}