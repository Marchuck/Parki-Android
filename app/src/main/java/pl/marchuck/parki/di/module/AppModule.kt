package pl.marchuck.parki.di.module

import android.arch.persistence.room.Room
import android.content.Context
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import pl.marchuck.parki.App
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

//    @Provides
//    @Singleton
//    fun provideWordDao(app: App) = Room.databaseBuilder(app,
//            AppDatabase::class.java, "recite_db").build().wordDao()
//
//    @Provides
//    @Singleton
//    fun provideWordRepo(wordDao: WordDao) = WordRepository(wordDao)
//
//
//    @Provides
//    @Singleton
//    fun provideApiService(): WordApi = Retrofit.Builder()
//            .baseUrl("http://open.iciba.com")
//            .client(OkHttpClient())
//            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .build()
//            .create(WordApi::class.java)
//
//
//    @Provides
//    @Singleton
//    fun provideMainApi(): MainApi = Retrofit.Builder()
//            .baseUrl("http://open.iciba.com")
//            .client(OkHttpClient())
//            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())
//            .build()
//            .create(MainApi::class.java)

    @Provides
    @Singleton
    fun providePreference(app: App) = app.getSharedPreferences(app.packageName, Context.MODE_PRIVATE)


}