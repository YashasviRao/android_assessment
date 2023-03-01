package com.rocheassessment.ui.home

import android.content.res.Configuration
import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.rocheassessment.R
import com.rocheassessment.data.Item
import com.rocheassessment.ui.auth.AuthViewModel
import com.rocheassessment.ui.item.ItemDetailsDestination
import com.rocheassessment.ui.item.ItemEntryDestination
import com.rocheassessment.ui.navigation.NavigationDestination
import com.rocheassessment.ui.theme.AppTheme
import com.rocheassessment.ui.AppViewModelProvider
import com.rocheassessment.ui.theme.spacing
import java.text.NumberFormat

object HomeDestination : NavigationDestination {
    override val route = "home"
    override val titleRes = R.string.app_name
}
@Composable
fun HomeScreen(
    viewModel: AuthViewModel,
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {

    viewModel?.currentUser?.let {
        UserInfo(navController = navController, name = it.displayName.toString(), email = it.email.toString(),)
    }
}


//@Composable
//fun HomeScreen(
//    navigateToItemEntry: () -> Unit,
//    navigateToItemUpdate: (Int) -> Unit,
//    modifier: Modifier = Modifier,
//) {
//    Scaffold(
////        topBar = {
////            InventoryTopAppBar(
////                title = stringResource(HomeDestination.titleRes),
////                canNavigateBack = false
////            )
////        },
//        floatingActionButton = {
//            FloatingActionButton(
//                onClick = navigateToItemEntry,
//                modifier = Modifier.navigationBarsPadding()
//            ) {
//                Icon(
//                    imageVector = Icons.Default.Add,
//                    contentDescription = stringResource(R.string.item_entry_title),
//                   // tint = MaterialTheme.colors.onPrimary
//                )
//            }
//        },
//    ) { innerPadding ->
//
//        // Display List header and List of Items
//        HomeBody(
//            itemList = listOf(),  // Empty list is being passed in for itemList
//            onItemClick = navigateToItemUpdate,
//            modifier = modifier.padding(innerPadding)
//        )
//    }
//}
    @Composable
    fun HomeBody(
        itemList: List<Item>,
        onItemClick: (Int) -> Unit,
        modifier: Modifier = Modifier
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            InventoryListHeader()
            Divider()
            if (itemList.isEmpty()) {
                Text(
                    text = stringResource(R.string.no_item_description),
                    //style = MaterialTheme.typography.titleMedium
                )
            } else {
                InventoryList(itemList = itemList, onItemClick = { onItemClick(it.id) })
            }
        }
    }

    @Composable
    private fun InventoryList(
        itemList: List<Item>,

        onItemClick: (Item) -> Unit,
        modifier: Modifier = Modifier
    ) {
        LazyColumn(modifier = modifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(items = itemList, key = { it.id }) { item ->
                InventoryItem(item = item, onItemClick = onItemClick)
                Divider()
            }
        }
    }
    @Composable
    fun InventoryListHeader(modifier: Modifier = Modifier) {
        Row(modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            headerList.forEach {
                Text(
                    text = stringResource(it.headerStringId),
                    modifier = Modifier.weight(it.weight),
                  //  style = MaterialTheme.typography.labelSmall
                )
            }
        }
    }

    @Composable
    private fun InventoryItem(
        item: Item,
        onItemClick: (Item) -> Unit,
        modifier: Modifier = Modifier
    ) {
        Row(modifier = modifier
            .fillMaxWidth()
            .clickable { onItemClick(item) }
            .padding(vertical = 16.dp)
        ) {
            Text(
                text = item.name,
                modifier = Modifier.weight(1.5f),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = NumberFormat.getCurrencyInstance().format(item.price),
                modifier = Modifier.weight(1.0f)
            )
            Text(text = item.quantity.toString(), modifier = Modifier.weight(1.0f))
        }
    }

    private data class InventoryHeader(@StringRes val headerStringId: Int, val weight: Float)

    private val headerList = listOf(
        InventoryHeader(headerStringId = R.string.item, weight = 1.5f),
        InventoryHeader(headerStringId = R.string.price, weight = 1.0f),
        InventoryHeader(headerStringId = R.string.quantity_in_stock, weight = 1.0f)
    )

    @Preview(showBackground = true)
    @Composable
    fun HomeScreenRoutePreview() {
        AppTheme {
            HomeBody(
                listOf(
                    Item(1, "Game", 100.0, 20),
                    Item(2, "Pen", 200.0, 30),
                    Item(3, "TV", 300.0, 50)
                ),
                onItemClick = {}
            )
        }
    }








//-----------------------------------------------------------------------------------
@Composable
//fun UserInfo(viewModel: AuthViewModel?, navController: NavController, name: String, email: String, viewModel: HomeViewModel = viewModel(factory = AppViewModelProvider.Factory)) {
fun UserInfo(navController: NavController, name: String, email: String, viewModel: HomeViewModel = viewModel(factory = AppViewModelProvider.Factory)) {
   val spacing = MaterialTheme.spacing
    val homeUiState by viewModel.homeUiState.collectAsState()
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .wrapContentHeight()
//            .padding(spacing.medium)
//            .padding(top = spacing.extraLarge),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {

//        Text(
//            text = stringResource(id = R.string.welcome_back),
//            //style = MaterialTheme.typography.headlineSmall,
//            color = MaterialTheme.colorScheme.onSurface
//        )
//
//        Text(
//            text = name,
//            style = MaterialTheme.typography.displaySmall,
//            color = MaterialTheme.colorScheme.onSurface
//        )

//        Image(
//            painter = painterResource(id = R.drawable.ic_person),
//            contentDescription = stringResource(id = R.string.empty),
//            modifier = Modifier.size(128.dp)
//        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(spacing.small)
        ) {
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .wrapContentHeight()
//            ) {
//                Text(
//                    text = stringResource(id = R.string.name),
//                    style = MaterialTheme.typography.bodyLarge,
//                    modifier = Modifier.weight(0.3f),
//                    color = MaterialTheme.colorScheme.onSurface
//                )
//
//                Text(
//                    text = name,
//                    style = MaterialTheme.typography.bodyLarge,
//                    modifier = Modifier.weight(0.7f),
//                    color = MaterialTheme.colorScheme.onSurface
//                )
//            }

//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .wrapContentHeight()
//            ) {
//                Text(
//                    text = stringResource(id = R.string.email),
//                    style = MaterialTheme.typography.bodyLarge,
//                    modifier = Modifier.weight(0.3f),
//                    color = MaterialTheme.colorScheme.onSurface
//                )
//
//                Text(
//                    text = email,
//                    style = MaterialTheme.typography.bodyLarge,
//                    modifier = Modifier.weight(0.7f),
//                    color = MaterialTheme.colorScheme.onSurface
//                )
//            }

            Scaffold(
//                topBar = {
//                    InventoryTopAppBar(
//                        title = stringResource(HomeDestination.titleRes),
//                        canNavigateBack = false
//                    )
//                },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = {
                            navController.navigate(ItemEntryDestination.route)
                                  },
                        modifier = Modifier.navigationBarsPadding()
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = stringResource(R.string.item_entry_title),
                            tint = androidx.compose.material.MaterialTheme.colors.onPrimary
                        )
                    }
                },
            ) { innerPadding ->
                HomeBody(
                    itemList =  homeUiState.itemList,
                    onItemClick = {
                        navController.navigate("${ItemDetailsDestination.route}/${it}")
                    },
                    modifier = Modifier.padding(innerPadding),
                )
            }

//            Button(
//                onClick = {
//                    viewModel?.logout()
//                    navController.navigate(ROUTE_LOGIN) {
//                        popUpTo(ROUTE_HOME) { inclusive = true }
//                    }
//                },
//                modifier = Modifier
//                    .align(Alignment.CenterHorizontally)
//                    //.padding(top = spacing.extraLarge)
//            ) {
//                Text(text = stringResource(id = R.string.logout))
//            }
        }
   // }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun HomeScreenPreviewLight() {
    AppTheme {
        UserInfo( rememberNavController(), "Belal Khan", "probelalkhan@gmail.com")
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeScreenPreviewDark() {
    AppTheme {
        UserInfo( rememberNavController(), "Belal Khan", "probelalkhan@gmail.com")
    }
}
