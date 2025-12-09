package app.vercel.danfelogarporfolios.nav3_adaptivelayout.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.vercel.danfelogarporfolios.nav3_adaptivelayout.domain.userList

@Composable
fun DetailsScreen(
    id: Int,
    navigateBack: () -> Unit,
) {
    val user = userList.find { it.id == id }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        user?.let {
            Text(
                text = "ID: ${it.id}",
                fontSize = MaterialTheme.typography.titleLarge.fontSize
            )
            Spacer(modifier = Modifier.height(height = 8.dp))
            Text(
                text = "Name: ${it.name}",
                fontSize = MaterialTheme.typography.titleLarge.fontSize
            )
        } ?: Text(
            text = "User not found",
            fontSize = MaterialTheme.typography.titleLarge.fontSize
        )
        Spacer(modifier = Modifier.height(height = 24.dp))
        Button(onClick = navigateBack) {
            Text(text = "Go back")
        }
    }
}

@Composable
fun DetailsScreenPlaceholder() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Select the user.",
            fontSize = MaterialTheme.typography.titleMedium.fontSize
        )
    }
}