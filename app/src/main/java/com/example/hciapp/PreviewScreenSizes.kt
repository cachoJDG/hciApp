package com.example.hciapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview


@Preview(
    name = "phone",
    group = "screen size",
    device = "spec:width=411dp,height=891dp"
)

@Preview(
    name = "tablet",
    group = "screen size",
    device = "spec:width=1280dp,height=800dp,dpi=240"
)

annotation class PreviewScreenSizes ()

//@PreviewScreenSizes
//@PreviewLocales
//@Composable
//fun PreviewScreenSizes()
//{
//
//}