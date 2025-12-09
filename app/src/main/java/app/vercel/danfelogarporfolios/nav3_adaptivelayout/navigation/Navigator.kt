package app.vercel.danfelogarporfolios.nav3_adaptivelayout.navigation

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList

class Navigator() {
    val backStack : SnapshotStateList<Any> = mutableStateListOf(Screen.Home)

    fun navigateTo(destination: Any) {
        backStack.add(destination)
    }

    fun navigateToDetails(userId: Int) {
        // If the current screen is also Details, replace it instead of stacking
        if(backStack.lastOrNull() is Screen.Details) {
            backStack[backStack.lastIndex] = Screen.Details(id = userId)
        }else{
            backStack.add(Screen.Details(id = userId))
        }
    }

    fun goBack() {
        backStack.removeLastOrNull()
    }
}