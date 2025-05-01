package com.maurosergiorodriguez.professionalfeaturesapp.data.remote.response

import com.maurosergiorodriguez.professionalfeaturesapp.domain.model.EpisodeModel
import com.maurosergiorodriguez.professionalfeaturesapp.domain.model.SeasonEpisode
import com.maurosergiorodriguez.professionalfeaturesapp.domain.model.SeasonEpisode.*
import kotlinx.serialization.Serializable

@Serializable
data class EpisodeResponse (
    val id: Int,
    val name: String,
    val episode: String,
    val characters: List<String>
) {
    fun toDomain(): EpisodeModel {
        val season = getSeasonFromEpisodeCode(episode)
        return EpisodeModel(
            id = id,
            name = name,
            characters = characters.map {
                it.substringAfterLast("/")
            },
            season = season,
            episode = episode,
            videoURL = getVideoURLFromSeason(season)
        )
    }

    private fun getSeasonFromEpisodeCode(episode: String): SeasonEpisode {
        return when {
            episode.startsWith("S01") -> SEASON_1
            episode.startsWith("S02") -> SEASON_2
            episode.startsWith("S03") -> SEASON_3
            episode.startsWith("S04") -> SEASON_4
            episode.startsWith("S05") -> SEASON_5
            episode.startsWith("S06") -> SEASON_6
            episode.startsWith("S07") -> SEASON_7
            else -> UNKNOWN
        }
    }

    private fun getVideoURLFromSeason(season: SeasonEpisode): String {
        return when(season) {
            SEASON_1 -> "https://firebasestorage.googleapis.com/v0/b/kt-mp-ex-id.firebasestorage.app/o/yt1z.net%20-%20Rick%20and%20Morty%20Theatrical%20Trailer%20HD%20(480p)%20(1).mp4?alt=media&token=4f108011-0187-4b33-969a-d635cfeaa361"
            SEASON_2 -> "https://firebasestorage.googleapis.com/v0/b/kt-mp-ex-id.firebasestorage.app/o/yt1z.net%20-%20Rick%20and%20Morty%20Theatrical%20Trailer%20HD%20(480p)%20(1).mp4?alt=media&token=4f108011-0187-4b33-969a-d635cfeaa361"
            SEASON_3 -> "https://firebasestorage.googleapis.com/v0/b/kt-mp-ex-id.firebasestorage.app/o/yt1z.net%20-%20Rick%20and%20Morty%20Theatrical%20Trailer%20HD%20(480p)%20(1).mp4?alt=media&token=4f108011-0187-4b33-969a-d635cfeaa361"
            SEASON_4 -> "https://firebasestorage.googleapis.com/v0/b/kt-mp-ex-id.firebasestorage.app/o/yt1z.net%20-%20Rick%20and%20Morty%20Theatrical%20Trailer%20HD%20(480p)%20(1).mp4?alt=media&token=4f108011-0187-4b33-969a-d635cfeaa361"
            SEASON_5 -> "https://firebasestorage.googleapis.com/v0/b/kt-mp-ex-id.firebasestorage.app/o/yt1z.net%20-%20Rick%20and%20Morty%20Theatrical%20Trailer%20HD%20(480p)%20(1).mp4?alt=media&token=4f108011-0187-4b33-969a-d635cfeaa361"
            SEASON_6 -> "https://firebasestorage.googleapis.com/v0/b/kt-mp-ex-id.firebasestorage.app/o/yt1z.net%20-%20Rick%20and%20Morty%20Theatrical%20Trailer%20HD%20(480p)%20(1).mp4?alt=media&token=4f108011-0187-4b33-969a-d635cfeaa361"
            SEASON_7 -> "https://firebasestorage.googleapis.com/v0/b/kt-mp-ex-id.firebasestorage.app/o/yt1z.net%20-%20Rick%20and%20Morty%20Theatrical%20Trailer%20HD%20(480p)%20(1).mp4?alt=media&token=4f108011-0187-4b33-969a-d635cfeaa361"
            else -> "https://firebasestorage.googleapis.com/v0/b/kt-mp-ex-id.firebasestorage.app/o/yt1z.net%20-%20Rick%20and%20Morty%20Theatrical%20Trailer%20HD%20(480p)%20(1).mp4?alt=media&token=4f108011-0187-4b33-969a-d635cfeaa361"
        }
    }
}
