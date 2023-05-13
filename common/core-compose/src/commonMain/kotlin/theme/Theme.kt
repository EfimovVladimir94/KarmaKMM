package theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalColorProvider provides  palette,
        LocalFontProvider provides fonts,
        content = content
    )
}

object Theme {
    val colors: KarmaColors
        @Composable
        get() = LocalColorProvider.current

    val fonts: KarmaFonts
        @Composable
        get() = LocalFontProvider.current
}