package net.denis.memebuilder.di.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import net.denis.memebuilder.common.CONST.BASE_URL_JSONPLACEHOLDER
import net.denis.memebuilder.data.remote.GenerateMemeApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    single {
        provideRetrofit(
            gson = get(),
            okHttpClient = get()
        )
    }

    factory {
        provideGson()
    }

    factory {
        provideHttpLoggingInterceptor()
    }

    factory {
        provideOkHttpClient(
            httpLoggingInterceptor = get()
        )
    }

    single {
        GenerateMemeApi
    }
}

fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL_JSONPLACEHOLDER)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
}

fun provideGson(): Gson {
    return GsonBuilder()
        .setLenient()
        .create()
}


fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
    HttpLoggingInterceptor.Level.BODY
    return HttpLoggingInterceptor()
}

fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient()
        .newBuilder()
        .addInterceptor(httpLoggingInterceptor)
        .build()
}