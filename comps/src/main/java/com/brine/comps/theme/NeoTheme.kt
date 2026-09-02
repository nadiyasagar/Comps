package com.brine.comps.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Immutable
data class NeoColors(
    val background: Color = Color(0xFFEFE9DB),      // Warm off-white / light cream
    val surface: Color = Color(0xFFF5EFDF),         // Cream surface
    val surfaceVariant: Color = Color(0xFFE5DDD0),  // Mid cream surface
    val darkSurface: Color = Color(0xFF1C1C1E),     // Dark charcoal black surface
    val border: Color = Color(0xFF1A1A1A),          // Bold dark outline
    val shadow: Color = Color(0xFF1A1A1A),          // Hard shadow offset
    val red: Color = Color(0xFFD7422F),             // Signature Neo Red / Coral
    val redLight: Color = Color(0xFFF7D5D0),        // Soft Red Chip
    val green: Color = Color(0xFF0E7C47),           // Signature Neo Green / Emerald
    val greenLight: Color = Color(0xFFD2EAD8),      // Soft Green Chip
    val yellowLight: Color = Color(0xFFF9E9B8),     // Soft Yellow Chip
    val pinkLight: Color = Color(0xFFF4D3D7),       // Soft Pink Chip
    val textPrimary: Color = Color(0xFF1A1A1A),     // Dark text
    val textSecondary: Color = Color(0xFF6B6557),   // Muted text
    val textOnDark: Color = Color(0xFFF5EFDF),      // White/Cream text on dark bg
    val textOnRed: Color = Color(0xFFFFFFFF)        // White text on red
)

@Immutable
data class NeoElevation(
    val defaultBorderWidth: Dp = 2.dp,
    val thickBorderWidth: Dp = 3.dp,
    val defaultShadowOffset: Dp = 4.dp,
    val largeShadowOffset: Dp = 6.dp,
    val smallShadowOffset: Dp = 2.dp
)

val LocalNeoColors = staticCompositionLocalOf { NeoColors() }
val LocalNeoElevation = staticCompositionLocalOf { NeoElevation() }

object NeoTheme {
    val colors: NeoColors
        @Composable
        get() = LocalNeoColors.current

    val elevation: NeoElevation
        @Composable
        get() = LocalNeoElevation.current
}

private val NeoTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Black,
        fontSize = 32.sp,
        lineHeight = 36.sp,
        color = Color(0xFF1A1A1A)
    ),
    headlineMedium = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 24.sp,
        lineHeight = 28.sp,
        color = Color(0xFF1A1A1A)
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = 22.sp,
        color = Color(0xFF1A1A1A)
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 22.sp,
        color = Color(0xFF1A1A1A)
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 18.sp,
        color = Color(0xFF1A1A1A)
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Bold,
        fontSize = 11.sp,
        lineHeight = 14.sp,
        color = Color(0xFF1A1A1A)
    )
)

/**
  Non-intrusive provider that supplies Neo-Brutalist design tokens (LocalNeoColors & LocalNeoElevation)
  into an existing application theme without overriding the app's standard MaterialTheme color scheme or typography.
 */
@Composable
fun ProvideCompsTheme(
    colors: NeoColors = NeoColors(),
    elevation: NeoElevation = NeoElevation(),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalNeoColors provides colors,
        LocalNeoElevation provides elevation,
        content = content
    )
}

/**
  Full standalone theme wrapper that supplies Neo-Brutalist tokens and configures a matching MaterialTheme.
 */
@Composable
fun CompsTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colors = NeoColors()
    val elevation = NeoElevation()

    val materialColorScheme = lightColorScheme(
        primary = colors.red,
        onPrimary = colors.textOnRed,
        secondary = colors.green,
        onSecondary = Color.White,
        background = colors.background,
        onBackground = colors.textPrimary,
        surface = colors.surface,
        onSurface = colors.textPrimary,
        surfaceVariant = colors.surfaceVariant,
        outline = colors.border
    )

    ProvideCompsTheme(colors = colors, elevation = elevation) {
        MaterialTheme(
            colorScheme = materialColorScheme,
            typography = NeoTypography,
            content = content
        )
    }
}
