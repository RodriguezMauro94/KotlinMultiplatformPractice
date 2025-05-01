package com.maurosergiorodriguez.professionalfeaturesapp.ui.detail

import com.maurosergiorodriguez.professionalfeaturesapp.domain.model.CharacterModel
import com.maurosergiorodriguez.professionalfeaturesapp.domain.model.EpisodeModel

data class CharacterDetailState(
    val characterModel: CharacterModel,
    val episodes: List<EpisodeModel>? = null
)
