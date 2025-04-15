package com.maurosergiorodriguez.rickandmortyappmp.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.maurosergiorodriguez.rickandmortyappmp.data.database.RickAndMortyDatabase
import com.maurosergiorodriguez.rickandmortyappmp.data.remote.ApiService
import com.maurosergiorodriguez.rickandmortyappmp.data.remote.paging.CharactersPagingSource
import com.maurosergiorodriguez.rickandmortyappmp.domain.Repository
import com.maurosergiorodriguez.rickandmortyappmp.domain.model.CharacterModel
import kotlinx.coroutines.flow.Flow

class RepositoryImpl(
    private val apiService: ApiService,
    private val charactersPagingSource: CharactersPagingSource,
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
        return Pager(config = PagingConfig(pageSize = MAX_ITEMS, prefetchDistance = PREFETCH_ITEMS),
            pagingSourceFactory = { charactersPagingSource }).flow
    }

    override suspend fun getCharacterDB() {
        rickAndMortyDatabase.getPreferencesDao().getCharacterOfTheDayDB()
    }
}