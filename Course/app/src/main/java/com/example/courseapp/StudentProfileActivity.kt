package com.example.courseapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.courseapp.ui.theme.CourseAppTheme


class StudentProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CourseAppTheme {
                StudentProfileScreen()
            }
        }
    }
}

@Composable
fun StudentProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE0F2FF))
    ) {
        ProfileHeader()

        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Welcome to your profile, USER_NAME",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = "My Courses",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = "Name: USER_NAME\nStudent ID: 001122\n\nLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(
                text = "COURSES:",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            CourseInfoCard()
        }
    }
}

@Composable
fun ProfileHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color(0xFF2A78D1)),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "BOW COLLEGE",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Row {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = Color.White
                    )
                }
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Menu",
                        tint = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun CourseInfoCard() {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Course_Name",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = "Course_Section", fontSize = 14.sp, color = Color.DarkGray)

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Course_Start_Date: Jan 1, 2025")
            Text(text = "Course_End_Date: Apr 15, 2025")
            Text(text = "Course_Drop_Date: Jan 20, 2025")
            Text(text = "Course_Withdrawal: Mar 10, 2025")

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Course_Schedule, Time:",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
            Text(text = "Monday: 11AM - 12:30PM")
            Text(text = "Thursday: 11AM - 12:30PM")

            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Credits: 3")
            Text(text = "Campus: Main Campus")
            Text(text = "Delivery_Mode: In-Person")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewStudentProfileScreen() {
    CourseAppTheme {
        StudentProfileScreen()
    }
}
