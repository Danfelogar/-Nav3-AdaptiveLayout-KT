package app.vercel.danfelogarporfolios.nav3_adaptivelayout.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed class Screen : NavKey {
    @Serializable
    object  Home : Screen()

    @Serializable
    data class Details(val id: Int) : Screen()

    @Serializable
    object Settings: Screen()
}