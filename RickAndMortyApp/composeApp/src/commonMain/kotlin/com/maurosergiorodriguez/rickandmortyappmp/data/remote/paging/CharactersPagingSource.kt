package com.maurosergiorodriguez.rickandmortyappmp.data.remote.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.maurosergiorodriguez.rickandmortyappmp.data.remote.ApiService
import com.maurosergiorodriguez.rickandmortyappmp.domain.model.CharacterModel

class CharactersPagingSource(
    private val apiService: ApiService
): PagingSource<Int, CharacterModel>() {
    override fun getRefreshKey(state: PagingState<Int, CharacterModel>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterModel> {
        return try {
            val page  = params.key ?: 1
            val response = apiService.getAllCharacters(page)
            val characters = response.results

            val prev = if (page > 0 ) page - 1 else null
            val next = if (response.info.next != null) page + 1 else null

            LoadResult.Page(
                data = characters.map { characterResponse -> characterResponse.toDomain() },
                prevKey =  prev,
                nextKey = next
            )
        } catch (ex: Exception) {
            LoadResult.Error(ex)
        }
    }

}