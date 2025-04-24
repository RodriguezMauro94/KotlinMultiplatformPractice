package com.maurosergiorodriguez.rickandmortyappmp

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.maurosergiorodriguez.rickandmortyappmp.domain.model.CharacterModel
import com.maurosergiorodriguez.rickandmortyappmp.ui.detail.CharacterDetailScreen
import com.maurosergiorodriguez.rickandmortyappmp.ui.detail.MainHeader

@Composable
@Preview(showBackground = true)
fun Preview() {
    MainHeader(
        CharacterModel(
            1,
            true,
            "image",
            "Rick",
            "Humano"
        )
    )
}