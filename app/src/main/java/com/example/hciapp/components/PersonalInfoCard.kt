package com.example.hciapp.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UserProfileConfig(
    name: String,
    surname: String,
    email: String,
    age: Int,
    alias: String,
    language: String,
    cvu: String,
    modifier: Modifier = Modifier
) {
    var isEditable by remember { mutableStateOf(false) }
    var editableName by remember { mutableStateOf(name) }
    var editableSurname by remember { mutableStateOf(surname) }
    var editableEmail by remember { mutableStateOf(email) }
    var editableAge by remember { mutableStateOf(age.toString()) }
    var editableAlias by remember { mutableStateOf(alias) }
    var editableLanguage by remember { mutableStateOf(language) }
    var editableCvu by remember { mutableStateOf(cvu) }

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Personal Information", style = MaterialTheme.typography.headlineLarge, fontSize = 24.sp)
            Spacer(modifier = Modifier.height(16.dp))
            if (isEditable) {
                TextField(value = editableName, onValueChange = { editableName = it }, label = { Text("Name") })
                Spacer(modifier = Modifier.height(8.dp))
                TextField(value = editableSurname, onValueChange = { editableSurname = it }, label = { Text("Surname") })
                Spacer(modifier = Modifier.height(8.dp))
                TextField(value = editableEmail, onValueChange = { editableEmail = it }, label = { Text("Email") })
                Spacer(modifier = Modifier.height(8.dp))
                TextField(value = editableAge, onValueChange = { editableAge = it }, label = { Text("Age") })
                Spacer(modifier = Modifier.height(8.dp))
                TextField(value = editableAlias, onValueChange = { editableAlias = it }, label = { Text("Alias") })
                Spacer(modifier = Modifier.height(8.dp))
                TextField(value = editableLanguage, onValueChange = { editableLanguage = it }, label = { Text("Language") })
                Spacer(modifier = Modifier.height(8.dp))
                TextField(value = editableCvu, onValueChange = { editableCvu = it }, label = { Text("CVU") })
            } else {
                Text(text = "Name: $editableName")
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Surname: $editableSurname")
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Email: $editableEmail")
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Age: $editableAge")
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Alias: $editableAlias")
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Language: $editableLanguage")
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "CVU: $editableCvu")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { isEditable = !isEditable }) {
                Text(text = if (isEditable) "Save" else "Edit")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserProfileConfigPreview() {
    UserProfileConfig(
        name = "John",
        surname = "Doe",
        email = "john.doe@example.com",
        age = 30,
        alias = "johnd",
        language = "English",
        cvu = "1234567890"
    )
}