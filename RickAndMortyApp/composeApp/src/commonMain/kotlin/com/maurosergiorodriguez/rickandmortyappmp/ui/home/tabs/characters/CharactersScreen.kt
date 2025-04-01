package com.maurosergiorodriguez.rickandmortyappmp.ui.home.tabs.characters

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import app.cash.paging.compose.LazyPagingItems
import app.cash.paging.compose.collectAsLazyPagingItems
import coil3.compose.AsyncImage
import com.maurosergiorodriguez.rickandmortyappmp.domain.model.CharacterModel
import com.maurosergiorodriguez.rickandmortyappmp.ui.core.ex.vertical
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import rickandmortyapp.composeapp.generated.resources.Res
import rickandmortyapp.composeapp.generated.resources.rickface

@Composable
@OptIn(KoinExperimentalAPI::class)
fun CharactersScreen() {
    val charactersViewModel = koinViewModel<CharactersViewModel>()
    val state by charactersViewModel.state.collectAsState()
    val characters = state.characters.collectAsLazyPagingItems()

    Column(modifier = Modifier.fillMaxSize()) {
        CharactersGridList(state, characters)
    }
}

@Composable
fun CharactersGridList(state: CharactersState, characters: LazyPagingItems<CharacterModel>) {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item(span = { GridItemSpan(2) }) {
            CharacterOfTheDay(state.characterOfTheDay)
        }

        when {
            characters.loadState.refresh is LoadState.Loading && characters.itemCount == 0 -> {
                // Initial load
                item(span = { GridItemSpan(2) }) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator(Modifier.size(64.dp), color = Color.Red)
                    }
                }
            }
            characters.loadState.refresh is LoadState.NotLoading && characters.itemCount == 0 -> {
                // Empty response
                item(span = { GridItemSpan(2) }) {
                    Text("No hay personajes :(")
                }
            }
            else -> {
                // Fetch items
                if (characters.loadState.refresh is LoadState.Loading) {
                    item(span = { GridItemSpan(2) }) {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            CircularProgressIndicator(Modifier.size(64.dp), color = Color.Red)
                        }
                    }
                } else {
                    items(characters.itemCount) { pos ->
                        characters[pos]?.let { characterModel ->
                            CharacterItemList(characterModel)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CharacterItemList(characterModel: CharacterModel) {
    Box(modifier = Modifier.clip(RoundedCornerShape(24))
        .border(
            2.dp,
            Color.Green,
            shape = RoundedCornerShape(0, 24, 0, 2)
        )
        .fillMaxWidth()
        .height(175.dp)
        .clickable {
        },
        contentAlignment = Alignment.BottomCenter
    ) {
        AsyncImage(
            model = characterModel.image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
            placeholder = painterResource(Res.drawable.rickface)
        )

        Box(
            modifier = Modifier.fillMaxSize().height(60.dp).background(
                brush = Brush.verticalGradient(
                    listOf(
                        Color.Black.copy(0f),
                        Color.Black.copy(0.6f),
                        Color.Black.copy(1f)
                    )
                )
            ),
            contentAlignment = Alignment.Center
        ) {
            Text(characterModel.name, color = Color.White, fontSize = 18.sp)
        }
    }
}

@Composable
fun CharacterOfTheDay(characterOfTheDay: CharacterModel? = null) {
    Card(modifier = Modifier.fillMaxWidth().height(400.dp), shape = RoundedCornerShape(percent = 12)) {
        if (characterOfTheDay == null) {
            Box(contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else {
            Box(contentAlignment = Alignment.BottomStart) {
                Box(modifier = Modifier.fillMaxSize().background(Color.Green.copy(alpha = 0.5f)))

                AsyncImage(
                    model = characterOfTheDay.image,
                    contentDescription =  characterOfTheDay.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )


                Box(modifier = Modifier.fillMaxSize().background(
                    Brush.horizontalGradient(
                        0f to Color.Black.copy(alpha = 0.9f),
                        0.4f to Color.White.copy(alpha = 0f)
                    )
                ))
                Text(
                    characterOfTheDay.name,
                    fontSize = 40.sp,
                    maxLines = 1,
                    minLines = 1,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(horizontal = 24.dp, vertical = 16.dp)
                        .fillMaxHeight()
                        .vertical()
                        .rotate(-90f)
                )
            }
        }
    }
}