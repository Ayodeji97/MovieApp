package com.engie.eea_tech_interview.business.datasource.remote.remotesource

import com.engie.eea_tech_interview.MovieApiService
import com.engie.eea_tech_interview.business.datasource.remote.model.SearchResultDto
import com.engie.eea_tech_interview.business.utils.Constants.MOVIE_API_KEY
import com.engie.eea_tech_interview.business.utils.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException

class GetMoviesRemoteSourceImpl(
    private val movieApiService: MovieApiService,
    private val ioDispatcher: CoroutineDispatcher
) : GetMoviesRemoteSource {
    override suspend fun getMovies(searchQuery: String): Result<SearchResultDto> =
        withContext(ioDispatcher) {
            return@withContext try {
                val apiResponse = movieApiService.getMovies(MOVIE_API_KEY, searchQuery)
                if (apiResponse.isSuccessful) {
                    val movies = apiResponse.body()
                    Result.Success(movies)
                } else {
                    @Suppress("BlockingMethodInNonBlockingContext")
                    val errorMessageObject = apiResponse.errorBody()?.string()
                    apiResponse.errorBody()?.close()
                    val errorMessage = errorMessageObject?.let {
                        JSONObject(it).getString("message")
                    }
                    Result.Error(errorMessage ?: "Something went wrong")
                }
            } catch (httpException: HttpException) {
                Result.Error(errorMessage = httpException.message())
            } catch (ioException: IOException) {
                Result.Error(
                    errorMessage = ioException.message ?: "Please check your network connection"
                )
            }
        }
}