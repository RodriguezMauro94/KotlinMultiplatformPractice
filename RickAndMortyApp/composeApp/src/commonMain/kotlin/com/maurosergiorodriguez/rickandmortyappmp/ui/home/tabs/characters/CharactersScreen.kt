package com.maurosergiorodriguez.rickandmortyappmp.ui.home.tabs.characters

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import app.cash.paging.compose.LazyPagingItems
import app.cash.paging.compose.collectAsLazyPagingItems
import coil3.compose.AsyncImage
import com.maurosergiorodriguez.rickandmortyappmp.domain.model.CharacterModel
import com.maurosergiorodriguez.rickandmortyappmp.ui.core.BackgroundPrimaryColor
import com.maurosergiorodriguez.rickandmortyappmp.ui.core.DefaultTextColor
import com.maurosergiorodriguez.rickandmortyappmp.ui.core.Green
import com.maurosergiorodriguez.rickandmortyappmp.ui.core.components.PagingLoadingState
import com.maurosergiorodriguez.rickandmortyappmp.ui.core.components.PagingType
import com.maurosergiorodriguez.rickandmortyappmp.ui.core.components.PagingWrapper
import com.maurosergiorodriguez.rickandmortyappmp.ui.core.ex.vertical
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import rickandmortyapp.composeapp.generated.resources.Res
import rickandmortyapp.composeapp.generated.resources.rickface

@Composable
@OptIn(KoinExperimentalAPI::class)
fun CharactersScreen(navigateToDetail: (characterModel: CharacterModel) -> Unit) {
    val charactersViewModel = koinViewModel<CharactersViewModel>()
    val state by charactersViewModel.state.collectAsState()
    val characters = state.characters.collectAsLazyPagingItems()
    CharactersGridListWrapper(state, characters, navigateToDetail)
}

@Composable
fun CharactersGridListWrapper(
    state: CharactersState,
    characters: LazyPagingItems<CharacterModel>,
    navigateToDetail: (characterModel: CharacterModel) -> Unit
) {
    PagingWrapper(
        pagingType = PagingType.VERTICAL_GRID,
        pagingItems = characters,
        initialView = {
            PagingLoadingState()
        },
        itemView = {
            CharacterItemList(it) { characterModel ->
                navigateToDetail(characterModel)
            }
        },
        headerView = {
            Column {
                Text("Characters", color = DefaultTextColor, fontSize = 24.sp, fontWeight = FontWeight.SemiBold)
                Spacer(Modifier.height(6.dp))
                CharacterOfTheDay(state.characterOfTheDay) {
                    navigateToDetail(it)
                }
            }
        }
    )
}

@Composable
fun CharacterItemList(characterModel: CharacterModel, onItemSelect: (characterModel: CharacterModel) -> Unit) {
    Box(modifier = Modifier.clip(RoundedCornerShape(24))
        .border(
            2.dp,
            Green,
            shape = RoundedCornerShape(0, 24, 0, 2)
        )
        .fillMaxWidth()
        .height(175.dp)
        .clickable {
            onItemSelect(characterModel)
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
fun CharacterOfTheDay(characterOfTheDay: CharacterModel? = null, onItemSelect: (characterModel: CharacterModel) -> Unit) {
    Card(modifier = Modifier.fillMaxWidth().height(400.dp).clickable {
        characterOfTheDay?.let {
            onItemSelect(it)
        }
    }, shape = RoundedCornerShape(percent = 12)) {
        if (characterOfTheDay == null) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(color = Green)
            }
        } else {
            Box(contentAlignment = Alignment.BottomStart) {
                Box(modifier = Modifier.fillMaxSize().background(Green.copy(alpha = 0.5f)))

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