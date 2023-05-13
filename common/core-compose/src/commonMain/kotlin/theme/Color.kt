package theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class KarmaColors(
    val primaryAction: Color,
    val primaryColor: Color,
    val highlightTextColor: Color
)

val palette = KarmaColors(
    primaryAction = Color(red = 242, green = 146, blue = 0),
    primaryColor = Color(red = 23, green = 132, blue = 232),
    highlightTextColor = Color(red = 192, green = 196, blue = 205)
)

val LocalColorProvider = staticCompositionLocalOf<KarmaColors> { error("not find default impl") }