package com.example.sistema1151.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.sistema1151.R

// Set of Material typography styles to start with
private val firasans = FontFamily(
        Font(R.font.firasans_black, FontWeight.Black),
        Font(R.font.firasans_bold, FontWeight.Bold),
        Font(R.font.firasans_italic, FontWeight.Normal),
        Font(R.font.firasans_light, FontWeight.Light),
)



val Typography = Typography(
        bodyLarge = TextStyle(
                fontFamily = firasans,
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp
        ),

    headlineLarge = TextStyle(
        fontFamily = firasans,
        fontWeight = FontWeight.Bold,
        fontSize = 35.sp,
        lineHeight = 45.sp,
        letterSpacing = 0.sp
    ),
        titleLarge  = TextStyle(
        fontFamily = firasans,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = 30.sp,
        letterSpacing = 0.sp
    ),
        titleMedium = TextStyle(
        fontFamily = firasans,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 45.sp,
        letterSpacing = 0.sp
    )
   /* Other default text styles to override
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)