package com.example.todo.screens

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Destination
fun AddTaskScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp)
            .scrollable(
                state = rememberScrollState(),
                orientation = Orientation.Vertical
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Add New Task+",
            style = MaterialTheme.typography.displayMedium,
            fontWeight = FontWeight.Bold
        )

        Divider(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(vertical = 6.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        var title by remember {
            mutableStateOf("")
        }
        var caption by remember {
            mutableStateOf("")
        }
        var description by remember {
            mutableStateOf("")
        }
        val datePickerState = rememberDatePickerState()

        TextField(
            modifier = Modifier.clip(shape = RoundedCornerShape(10.dp)),
            value = title,
            label = { Text("Title") },
            onValueChange = { title = it }
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            modifier = Modifier.clip(shape = RoundedCornerShape(10.dp)),
            value = caption,
            label = { Text("Caption") },
            onValueChange = { caption = it }
        )

        Spacer(modifier = Modifier.height(26.dp))

        TextField(
            modifier = Modifier
                .fillMaxHeight(0.4f)
                .clip(shape = RoundedCornerShape(16.dp)),
            value = description,
            label = { Text("Description") },
            onValueChange = { description = it }
        )

        Spacer(modifier = Modifier.height(40.dp))

        var expanded by remember {
            mutableStateOf(false)
        }
        var selectedOptionText by remember {
            mutableStateOf("")
        }
//        ExposedDropdownMenuBox(
//            expanded = expanded,
//            onExpandedChange = {
//                expanded = it
//            },
//        ) {
//            for (selectionOption in listOf("Low", "Medium", "High")) {
//                Expos(
//                    text = { Text(selectionOption) },
//                    onClick = {
//                        selectedOptionText = selectionOption
//                        expanded = false
//                    }
//                )
//            }
//        }
    }
}