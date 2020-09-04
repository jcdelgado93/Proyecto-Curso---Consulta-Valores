package cl.talentodigital.consultavalores.network.api

import cl.talentodigital.consultavalores.menuListado.data.remote.ApiValores
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHandler {

    companion object {
        fun getRetrofit(): Retrofit {

            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

            val gson = GsonBuilder()
                .setLenient()
                .create()

            return Retrofit.Builder()
                .baseUrl("https://mindicador.cl/api")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }

        fun getValoresApi(): ApiValores {
            return getRetrofit().create(ApiValores::class.java)
        }
    }
}