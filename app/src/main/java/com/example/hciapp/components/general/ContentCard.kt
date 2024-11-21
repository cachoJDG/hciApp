package com.example.hciapp.components.general

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ContentCard(
    title: String = "",
    description: String = "",
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit = {}
) {
    Card(modifier = modifier) {
       // modifier.padding(32.dp).align(Alignment.Start)
        Text(text = title, fontSize = 16.sp, modifier = Modifier.padding(1.dp))
        Column(modifier = modifier.padding(32.dp))
        {
            content()
        }

    }
}


@Preview
@Composable
fun ContentCardPreview() {
    ContentCard(title = "Title", description = "Description") {
        Text("Content")
    }
}

