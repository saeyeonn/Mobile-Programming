package com.saeyeon.portfolio

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.saeyeon.portfolio.ui.components.dialog.ContactDialog
import com.saeyeon.portfolio.ui.theme.PortfolioTheme

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark Mode"
)
@Composable
fun PortfolioAppPreview() {
    PortfolioTheme {
        PortfolioApp()
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark Mode"
)
@Composable
fun ContactDialogPreview() {
    PortfolioTheme {
        ContactDialog(onDismiss = {})
    }
}

@Preview(name = "Light Mode", widthDp = 320)
@Preview(
    name = "Dark Mode",
    widthDp = 320,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun NavigationDrawerPreview() {
    PortfolioTheme {
        ModalNavigationDrawer(
            drawerContent = {
                ModalDrawerSheet {
                    Text(
                        "Profile",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.titleLarge
                    )
                    Divider()
                    NavigationDrawerItem(
                        label = { Text("About Me") },
                        selected = false,
                        onClick = { },
                        icon = { Icon(Icons.Default.Person, contentDescription = null) }
                    )
                }
            },
            drawerState = rememberDrawerState(DrawerValue.Open)
        ) {
            // Content
            Box(modifier = Modifier.fillMaxSize()) {
                Text("Main Content")
            }
        }
    }
}

// TopAppBar Preview
@OptIn(ExperimentalMaterial3Api::class)
@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark Mode"
)
@Composable
fun TopAppBarPreview() {
    PortfolioTheme {
        TopAppBar(
            title = { Text("My Portfolio") },
            navigationIcon = {
                IconButton(onClick = { }) {
                    Icon(Icons.Default.Menu, contentDescription = "Menu")
                }
            },
            actions = {
                IconButton(onClick = { }) {
                    Icon(
                        Icons.Default.Home,
                        contentDescription = "Home",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = MaterialTheme.colorScheme.onPrimary,
                navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
            )
        )
    }
}