package com.example.courseapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.courseapp.ui.theme.CourseAppTheme
import androidx.compose.ui.tooling.preview.Preview as Preview1

data class Event(
    val title: String,
    val location: String,
    val imageRes: Int
)

class DiscoverStudentGuideActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CourseAppTheme {
                DiscoverStudentGuideScreen()
            }
        }
    }
}

@Composable
fun DiscoverStudentGuideScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.college),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Light Blue Overlay
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.7f))
        )

        // Content Layer
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Add a colored background above the TopHeader
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(Color(0xFF3A84F3)) // Blue background above the header
            )

            TopHeader()
            DiscoverSection()
            LearningSection()
        }
    }
}

@Composable
fun TopHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .background(Color(0xFF3A84F3)), // Blue background for the header
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "BOW COLLEGE",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                text = "Bow College Student Guides",
                fontSize = 14.sp,
                color = Color.White
            )
        }
    }
}

@Composable
fun DiscoverSection() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Discover",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        val events = listOf(
            Event("2025 Spring Welcome Week", "Calgary, AB", android.R.drawable.ic_menu_gallery),
            Event("Bow College Open House 2025", "Calgary, AB", android.R.drawable.ic_menu_gallery),
            Event("Bow College, Puppy Room, 2025", "Calgary, AB", android.R.drawable.ic_menu_gallery)
        )
        LazyRow(modifier = Modifier.padding(top = 8.dp)) {
            items(events) { event ->
                DiscoverCard(event)
            }
        }
    }
}

@Composable
fun DiscoverCard(event: Event) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .width(200.dp)
            .padding(end = 12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = event.imageRes),
                contentDescription = event.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = event.title,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Text(
                text = event.location,
                fontSize = 12.sp,
                color = Color.Gray,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun LearningSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Learning",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                imageVector = Icons.Default.ArrowForward, // Use built-in ArrowForward icon
                contentDescription = "Forward arrow",
                modifier = Modifier.size(16.dp)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "You have no courses",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Add a course now",
                    fontSize = 14.sp,
                    color = Color.Red,
                    modifier = Modifier
                        .clickable { }
                        .padding(top = 4.dp)
                )
            }
        }
    }
}

// Update the Preview to reflect the latest changes
@Preview1(showBackground = true)
@Composable
fun DiscoverStudentGuideScreenPreview() {
    CourseAppTheme {
        DiscoverStudentGuideScreen()
    }
}
