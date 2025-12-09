package app.vercel.danfelogarporfolios.nav3_adaptivelayout.navigation

import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.layout.calculatePaneScaffoldDirective
import androidx.compose.material3.adaptive.navigation3.ListDetailSceneStrategy
import androidx.compose.material3.adaptive.navigation3.rememberListDetailSceneStrategy
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import app.vercel.danfelogarporfolios.nav3_adaptivelayout.screen.DetailsScreen
import app.vercel.danfelogarporfolios.nav3_adaptivelayout.screen.DetailsScreenPlaceholder
import app.vercel.danfelogarporfolios.nav3_adaptivelayout.screen.HomeScreen
import app.vercel.danfelogarporfolios.nav3_adaptivelayout.screen.SettingsScreen
import org.koin.compose.koinInject

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun NavGraph(modifier: Modifier = Modifier) {
    val navigator = koinInject<Navigator>()

    val windowAdaptiveInfo = currentWindowAdaptiveInfo()
    val directive = remember(windowAdaptiveInfo) {
        calculatePaneScaffoldDirective(windowAdaptiveInfo)
            .copy(horizontalPartitionSpacerSize = 0.dp)
    }
    val listDetailStrategy = rememberListDetailSceneStrategy<Any>(directive = directive)

    NavDisplay(
        modifier = modifier,
        backStack = navigator.backStack,
        onBack = { navigator.goBack() },
        sceneStrategy =  listDetailStrategy,
        entryProvider = entryProvider {
            entry<Screen.Home>(
                metadata = ListDetailSceneStrategy.listPane(
                    detailPlaceholder = { DetailsScreenPlaceholder() }
                )
            ) {
                HomeScreen(
                    navigateToDetails = { userId -> navigator.navigateToDetails(userId)},
                    navigateToSettings = { navigator.navigateTo(destination = Screen.Settings) }
                )
            }
            entry<Screen.Details>(
                metadata = ListDetailSceneStrategy.detailPane()
            ) {
                DetailsScreen(
                    id = it.id,
                    navigateBack = { navigator.goBack() }
                )
            }
            entry<Screen.Settings>(
                metadata = ListDetailSceneStrategy.extraPane()
            ) {
                SettingsScreen(
                    navigateBack = { navigator.goBack() }
                )
            }
        },
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        )
    )
}