package com.maurosergiorodriguez.rickandmortyappmp.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.maurosergiorodriguez.rickandmortyappmp.data.database.RickAndMortyDatabase
import com.maurosergiorodriguez.rickandmortyappmp.data.remote.ApiService
import com.maurosergiorodriguez.rickandmortyappmp.data.remote.paging.CharactersPagingSource
import com.maurosergiorodriguez.rickandmortyappmp.data.remote.paging.EpisodesPagingSource
import com.maurosergiorodriguez.rickandmortyappmp.data.remote.response.EpisodeResponse
import com.maurosergiorodriguez.rickandmortyappmp.domain.Repository
import com.maurosergiorodriguez.rickandmortyappmp.domain.model.CharacterModel
import com.maurosergiorodriguez.rickandmortyappmp.domain.model.CharacterOfTheDayModel
import com.maurosergiorodriguez.rickandmortyappmp.domain.model.EpisodeModel
import kotlinx.coroutines.flow.Flow

class RepositoryImpl(
    private val apiService: ApiService,
    private val charactersPagingSource: CharactersPagingSource,
    private val episodesPagingSource: EpisodesPagingSource,
    private val rickAndMortyDatabase: RickAndMortyDatabase
): Repository {
    companion object {
        const val MAX_ITEMS = 20
        const val PREFETCH_ITEMS = 5
    }

    override suspend fun getSingleCharacter(id: String): CharacterModel {
        return apiService.getSingleCharacter(id).toDomain()
    }

    override fun getAllCharacters(): Flow<PagingData<CharacterModel>> {
        return Pager(
            config = PagingConfig(pageSize = MAX_ITEMS, prefetchDistance = PREFETCH_ITEMS),
            pagingSourceFactory = { charactersPagingSource }
        ).flow
    }

    override fun getAllEpisodes(): Flow<PagingData<EpisodeModel>> {
        return Pager(
            config = PagingConfig(pageSize = MAX_ITEMS, prefetchDistance = PREFETCH_ITEMS),
            pagingSourceFactory = { episodesPagingSource }
        ).flow
    }

    override suspend fun getCharacterDB(): CharacterOfTheDayModel? {
        return rickAndMortyDatabase.getPreferencesDao().getCharacterOfTheDayDB()?.toDomain()
    }

    override suspend fun saveCharacterDB(characterOfTheDay: CharacterOfTheDayModel) {
        rickAndMortyDatabase.getPreferencesDao().saveCharacter(characterOfTheDay.toEntity())
    }

    override suspend fun getEpisodesForCharacter(episodes: List<String>): List<EpisodeModel> {
        return if(episodes.isEmpty()){
            emptyList()
        } else if (episodes.size == 1) {
            listOf(apiService.getEpisode(episodes.first()).toDomain())
        } else {
            apiService.getEpisodes(episodes.joinToString(",")).map { episodeResponse ->
                episodeResponse.toDomain()
            }
        }
    }
}