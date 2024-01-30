package com.example.new_year_resolutions

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.MutableState

data class Resolution (
    var name:String,
    var editedName: MutableState<String> = mutableStateOf(name)
)
