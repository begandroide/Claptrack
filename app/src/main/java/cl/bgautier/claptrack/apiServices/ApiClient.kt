package cl.bgautier.claptrack.apiServices

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private val BASE_URL = "https://api-endpoint.igdb.com/"
    private var retrofit: Retrofit? = null

    val client: Retrofit?
        get() {
            if(retrofit == null){
                retrofit = Retrofit.Builder()
                                    .baseUrl(BASE_URL)
                                    .addConverterFactory(GsonConverterFactory.create())
                                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                                    .build()
            }
            return retrofit
        }
}