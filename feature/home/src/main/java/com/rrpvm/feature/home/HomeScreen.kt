package com.rrpvm.feature.home

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember


object HomeScreenRoute{
    const val HOME_SCREEN = "homeScreen"
}

@Composable
fun HomeScreen(){
    val checkedState : MutableState<Boolean> = remember {
        mutableStateOf(false)
    }
    SideEffect {
        Log.e("side effect","profile()")
    }
    Box() {
        Checkbox(checked = checkedState.value, onCheckedChange = {
            checkedState.value = checkedState.value.not()
        })
    }
}