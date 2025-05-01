package com.maurosergiorodriguez.rickandmortyappmp.ui.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import app.cash.paging.compose.LazyPagingItems
import com.maurosergiorodriguez.rickandmortyappmp.ui.core.BackgroundPrimaryColor

enum class PagingType {
    ROW,
    COLUMN,
    VERTICAL_GRID,
}

@Composable
fun <T: Any> PagingWrapper(
    pagingType: PagingType,
    pagingItems: LazyPagingItems<T>,
    initialView: @Composable () -> Unit = {},
    emptyView: @Composable () -> Unit = {},
    extraItemsView: @Composable () -> Unit = {},
    headerView: @Composable () -> Unit = {},
    itemView: @Composable (item: T) -> Unit
) {
    when {
        pagingItems.loadState.refresh is LoadState.Loading && pagingItems.itemCount == 0 -> {
            initialView()
        }
        pagingItems.loadState.refresh is LoadState.NotLoading && pagingItems.itemCount == 0 -> {
            emptyView()
        }
        else -> {
            when(pagingType) {
                PagingType.ROW -> {
                    LazyRow {
                        items(pagingItems.itemCount) { pos ->
                            pagingItems[pos]?.let { item ->
                                itemView(item)
                            }
                        }
                    }
                }
                PagingType.COLUMN -> {
                    LazyColumn {
                        items(pagingItems.itemCount) { pos ->
                            pagingItems[pos]?.let { item ->
                                itemView(item)
                            }
                        }
                    }
                }
                PagingType.VERTICAL_GRID -> {
                    LazyVerticalGrid(
                        modifier = Modifier.fillMaxSize().background(BackgroundPrimaryColor).padding(horizontal = 16.dp),
                        columns = GridCells.Fixed(2),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        state = rememberLazyGridState() // this is currently not working due a paging3 issue, so we need to use the viewModel cache
                    ) {
                        item(span = { GridItemSpan(2) }) {
                            headerView()
                        }
                        items(pagingItems.itemCount) { pos ->
                            pagingItems[pos]?.let { item ->
                                itemView(item)
                            }
                        }
                    }
                }
            }
            if (pagingItems.loadState.append is LoadState.Loading) {
                extraItemsView()
            }
        }
    }
}