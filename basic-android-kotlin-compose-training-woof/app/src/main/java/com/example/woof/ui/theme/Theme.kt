/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.woof.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

class WoofTheme{

    companion object{
        private val WoofDarkColorPalette = darkColors(
            background = Cyan900,
            surface = Cyan700,
            onSurface = White,
            primary = Grey900,
            onPrimary = White,
            secondary = Grey100
        )

        private val WoofLightColorPalette = lightColors(
            background = Green100,
            surface = Green50,
            onSurface = Grey900,
            primary = Grey50,
            onPrimary = Grey900,
            secondary = Grey700
        )

        @Composable
        fun GetWoofTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
            val colors = if (darkTheme) {
                WoofDarkColorPalette
            } else {
                WoofLightColorPalette
            }

            MaterialTheme(
                colors = colors,
                typography = Typography,
                shapes = Shapes,
                content = content
            )
        }
    }

}


class SuperheroTheme{

    companion object{
        private val SuperheroDarkColorPalette = darkColors(
            background = Color.Black, //background
            surface = Green1000, //element on bg button etc
            onSurface = Color.White, //text on surface
            primary = Color.Black, //topbar
//            onPrimary = Color.Blue,
//            secondary = Color.Magenta
        )

        private val SuperheroLightColorPalette = lightColors(
            background = Green100,
            surface = Green50,
            onSurface = Grey900,
            primary = Green200,
            onPrimary = Grey900,
            secondary = Grey700
        )

        @Composable
        fun GetSuperheroTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
            val colors = if (darkTheme) {
                SuperheroDarkColorPalette
            } else {
                SuperheroLightColorPalette
            }

            MaterialTheme(
                colors = colors,
                typography = Typography,
                shapes = Shapes,
                content = content
            )
        }
    }

}




