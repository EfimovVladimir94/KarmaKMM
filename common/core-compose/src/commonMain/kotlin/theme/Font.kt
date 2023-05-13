package theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.font.FontFamily
import com.azri.karma.android.core_compose.R
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight

data class KarmaFonts(
    val montserratFamily: FontFamily
)

val fonts = KarmaFonts(
    montserratFamily = FontFamily(
        Font(R.font.montserrat_light, FontWeight.Light),
        Font(R.font.montserrat_regular, FontWeight.Normal),
        Font(R.font.montserrat_medium, FontWeight.Medium),
        Font(R.font.montserrat_bold, FontWeight.Bold)
    )
)

val LocalFontProvider = staticCompositionLocalOf<KarmaFonts> { error("not find default impl") }