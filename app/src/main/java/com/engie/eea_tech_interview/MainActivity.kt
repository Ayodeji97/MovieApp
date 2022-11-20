package com.engie.eea_tech_interview

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.engie.eea_tech_interview.business.datasource.remote.model.SearchResultDto
import com.engie.eea_tech_interview.business.utils.Constants.MOVIE_API_KEY
import org.koin.android.ext.android.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    private val retrofit: Retrofit by inject()

//    companion object {
//        const val MOVIE_API_KEY = "47304f18bd4a3b4e733196b18e68bfbc"
//        const val SEARCH_QUERY = "James Bond"
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val movieApiService = retrofit.create(MovieApiService::class.java)
        movieApiService.getMovies(MOVIE_API_KEY, SEARCH_QUERY).enqueue(object : Callback<SearchResultDto> {
            override fun onResponse(call: Call<SearchResultDto>, response: Response<SearchResultDto>) {
                val searchResult = response.body()
                Log.d("EEA TECH INTERVIEW", searchResult?.results?.joinToString(separator = ",").orEmpty())
            }

            override fun onFailure(call: Call<SearchResultDto>, t: Throwable) {
                Log.e("EEA TECH INTERVIEW", t.localizedMessage.orEmpty())
            }
        })

    }
}