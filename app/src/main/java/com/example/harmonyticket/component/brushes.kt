package com.example.harmonyticket.component

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val dl = Brush.linearGradient(
    0.0f to Color(0xFF000000),
    0.5f to Color(0xFFAD91D3),
    1.0f to Color(0xFFFFFFFF),
    start = Offset.Zero,
    end = Offset.Infinite
)