package com.example.courseapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.courseapp.ui.theme.CourseAppTheme

// Course data class
data class Course(
    val code: String,
    val title: String,
    val credits: Int,
    val description: String
)

// Main activity
class CourseSelectionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CourseAppTheme {
                CourseSelectionScreen()
            }
        }
    }
}

@Composable
fun CourseSelectionScreen() {
    val courses = listOf(
        Course("SODV1101", "Programming Fundamentals", 3, "Learn the basics of programming."),
        Course("TECH1101", "Web and Internet Fundamentals", 3, "Understand how the web works."),
        Course("TECH1102", "Internet of Things", 3, "Explore IoT applications."),
        Course("MGMT1103", "Essential Skills for Team Collaboration", 3, "Develop collaboration skills."),
        Course("MATH1901", "Math for the Computer Industry", 3, "Math concepts for computing.")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE5F0FF))
            .padding(16.dp)
    ) {
        Text(
            text = "Full Course outlines are available here.",
            fontSize = 16.sp,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Students should select their program and requirements with their academic advisor.",
            fontSize = 14.sp,
            color = Color.DarkGray
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Iterate over courses
        courses.forEach { course ->
            ExpandableCourseCard(course = course)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun ExpandableCourseCard(course: Course) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column {
                    Text(
                        text = "${course.code} - ${course.title}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Text(
                        text = "Credits: ${course.credits}",
                        fontSize = 14.sp,
                        color = Color.Red
                    )
                }

                // Expand/Collapse icon
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(
                        imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                        contentDescription = if (expanded) "Collapse" else "Expand"
                    )
                }
            }

            // Show description if expanded
            if (expanded) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = course.description,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CourseSelectionPreview() {
    CourseAppTheme {
        CourseSelectionScreen()
    }
}
