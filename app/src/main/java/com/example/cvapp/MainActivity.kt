package com.example.cv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                CvPreviewScreen()
            }
        }
    }
}


@Composable
fun CvPreviewScreen() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Cột bên trái - Thông tin cá nhân
        Column(
            modifier = Modifier
                .weight(1f)
                .background(Color(0xFFEEEEEE))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Ảnh đại diện
            Image(
                painter = painterResource(id = R.drawable.f1),
                contentDescription = "Avatar",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )


            Spacer(modifier = Modifier.height(16.dp))

            // Thông tin liên hệ
            SectionTitle("Contact Details")
            ContactInfo("21522644@gm.uit.edu.vn")
            ContactInfo("(400) 589 3591")
            ContactInfo("TP.HCM, VN")

            Spacer(modifier = Modifier.height(16.dp))

            // Học vấn
            SectionTitle("Education")
            Text("B.S. Computer Science", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Text("University of Information Technology", fontSize = 14.sp)
            Text("2021 - 2025", fontSize = 14.sp)

            Spacer(modifier = Modifier.height(16.dp))

            // Kỹ năng
            SectionTitle("Skills")
            SkillItem("Java programming - Expert")
            SkillItem("Android SDK - Expert")
            SkillItem("XML Layout - Expert")
            SkillItem("Android Studio - Expert")
            SkillItem("API integration - Expert")
            SkillItem("UI/UX design - Expert")
        }

        // Cột bên phải - Nội dung CV
        Column(
            modifier = Modifier
                .weight(2f)
                .padding(16.dp)
        ) {
            Text("Nguyen Minh Thong", fontSize = 28.sp, fontWeight = FontWeight.Bold)
            Text("Android Developer", fontSize = 18.sp, color = Color.Gray)

            Spacer(modifier = Modifier.height(16.dp))

            // Mục Summary
            SectionTitle("Summary")
            Text(
                "Experienced Android Developer with 5+ years' experience. " +
                        "Capable of building apps from scratch with a focus on user experience and performance. " +
                        "Skilled in Java, Kotlin, and Firebase.",
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Mục Work Experience
            SectionTitle("Work Experience")

            WorkExperienceItem(
                company = "Android Developer, Waters, Krejci and Bernhard",
                time = "March 2023 - Present",
                details = listOf(
                    "Successfully developed and released 5 Android applications on the Google Play Store.",
                    "Developed a UI/UX design for a mobile application that was used by over 20,000 users.",
                    "Responsible for the maintenance and improvement of existing Android applications."
                )
            )

            WorkExperienceItem(
                company = "Android Developer, O'Reilly, Pacocha and Fadel",
                time = "May 2021 - March 2023",
                details = listOf(
                    "Utilized Java, XML, and Android Studio to develop Android applications.",
                    "Developed a highly functioning Android application with a clean and intuitive interface.",
                    "Collaborated with a team of developers to create a multi-platform mobile application."
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Mục References
            SectionTitle("References")
            Text("References available upon request.", fontSize = 14.sp)
        }
    }
}


@Composable
fun SectionTitle(title: String) {
    Column {
        Text(title, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        HorizontalDivider(
            color = Color.Black,
            thickness = 1.dp,
            modifier = Modifier.fillMaxWidth()
        )

    }
    Spacer(modifier = Modifier.height(8.dp))
}


@Composable
fun ContactInfo(info: String) {
    Text(info, fontSize = 14.sp)
}


@Composable
fun SkillItem(skill: String) {
    Text(skill, fontSize = 14.sp, fontWeight = FontWeight.Medium)
}


@Composable
fun WorkExperienceItem(company: String, time: String, details: List<String>) {
    Column {
        Text(company, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        Text(time, fontSize = 14.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(4.dp))
        details.forEach { detail ->
            Text("• $detail", fontSize = 14.sp)
        }
    }
    Spacer(modifier = Modifier.height(12.dp))
}
