package com.example.appsqlite

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appsqlite.db.DBHandler
import com.example.appsqlite.ui.theme.AppSQLiteTheme
import java.util.Calendar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()

        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(){

    var coursename by remember { mutableStateOf("") }
    var courseduration by remember { mutableStateOf("") }
    var coursetracks by remember { mutableStateOf("") }
    var coursedescription by remember { mutableStateOf("") }
    val context = LocalContext.current
    var dbHandler: DBHandler = DBHandler(context)

    // Defina a cor de fundo escura
    Surface(
        color = Color(24, 28, 31), // Defina a cor de fundo para escuro
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(text = "SQlite Database in Android", color = Color.White) // Defina a cor do texto para branco

            OutlinedTextField(
                value = coursename,
                onValueChange = { coursename = it },
                label = { Text("Enter your course name") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            OutlinedTextField(
                value = courseduration,
                onValueChange = { courseduration = it },
                label = { Text("Enter your course duration") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            OutlinedTextField(
                value = coursetracks,
                onValueChange = { coursetracks = it },
                label = { Text("Enter your course tracks") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            OutlinedTextField(
                value = coursedescription,
                onValueChange = { coursedescription = it },
                label = { Text("Enter your course description") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    dbHandler.addNewCourse(
                        coursename,
                        courseduration,
                        coursedescription,
                        coursetracks
                    )
                    Toast.makeText(context, "Course Added to Database", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(text = "Add Course to Database")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {

                },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(text = "Read Courses to Database")
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun AppPreview() {
    AppSQLiteTheme {
        App()
    }
}
