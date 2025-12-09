package app.vercel.danfelogarporfolios.nav3_adaptivelayout.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.vercel.danfelogarporfolios.nav3_adaptivelayout.domain.userList

@Composable
fun HomeScreen(
    navigateToDetails: (Int) -> Unit,
    navigateToSettings: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
    ) {
        Button(
            onClick = navigateToSettings,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Settings")
        }

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(items = userList) { user ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .clickable {
                            navigateToDetails(user.id)
                        }
                ) {
                    Text(
                        text = user.name,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}