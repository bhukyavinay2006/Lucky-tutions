package com.example.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LuckyColorScheme = lightColorScheme(
  primary = BrandNavy,
  onPrimary = Color.White,
  primaryContainer = BrandNavyDark,
  onPrimaryContainer = BrandGoldBright,
  secondary = BrandEmerald,
  onSecondary = Color.White,
  secondaryContainer = BrandEmeraldLight,
  onSecondaryContainer = BrandEmeraldDark,
  tertiary = BrandGold,
  onTertiary = Color.White,
  tertiaryContainer = BrandGoldSoft,
  onTertiaryContainer = BrandGold,
  background = Slate100,
  onBackground = Slate900,
  surface = Color.White,
  onSurface = Slate900,
  surfaceVariant = Slate50,
  onSurfaceVariant = Slate700,
  outline = Slate200,
)

@Composable
fun MyApplicationTheme(
  content: @Composable () -> Unit,
) {
  MaterialTheme(
    colorScheme = LuckyColorScheme,
    typography = Typography,
    content = content
  )
}

