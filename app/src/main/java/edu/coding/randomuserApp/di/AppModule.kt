package edu.coding.randomuserApp.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.hilt.components.SingletonComponent
import edu.coding.randomuserApp.BuildConfig.BASE_URL
import edu.coding.randomuserApp.randomuser.data.local.db.RandomuserDatabase
import edu.coding.randomuserApp.randomuser.data.remote.RandomuserApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    private val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor = interceptor)
        .build()

    @Provides
    @Singleton
    fun provideRandomuserApi(): RandomuserApi {
        return Retrofit.Builder()
            .addCallAdapterFactory(CoroutineCallAdapterFactory())// experimental
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .baseUrl(BASE_URL)
            .build()
            .create(RandomuserApi::class.java)
    }

    @Provides
    @Singleton
    fun providesRandomuserDatabase(app: Application): RandomuserDatabase {
        return Room.databaseBuilder(
            app,
            RandomuserDatabase::class.java,
            "randomuser.db"
        ).build()
    }
}