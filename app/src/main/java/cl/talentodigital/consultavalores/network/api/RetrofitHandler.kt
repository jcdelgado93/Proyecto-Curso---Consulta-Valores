package cl.talentodigital.consultavalores.network.api

import cl.talentodigital.consultavalores.detalleMoneda.data.remote.ApiHistorialDeValores
import cl.talentodigital.consultavalores.menuListado.data.remote.ApiValores
import com.google.gson.GsonBuilder
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitHandler {

    companion object {

        fun getRetrofit(): Retrofit {

            val interceptor = HttpLoggingInterceptor()
            interceptor.apply { interceptor.level = HttpLoggingInterceptor.Level.BODY }
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

            val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

            return Retrofit.Builder()
                .baseUrl("https://mindicador.cl/")
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
        }

        fun getValoresApi(): ApiValores {
            return getRetrofit().create(ApiValores::class.java)
        }

        fun getHistorialApi(): ApiHistorialDeValores {
            return getRetrofit().create(ApiHistorialDeValores::class.java)
        }
    }
}