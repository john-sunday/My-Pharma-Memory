package com.juandomingo.mypharmamemory.dependencyinjection

import com.google.firebase.firestore.FirebaseFirestore
import com.juandomingo.mypharmamemory.data.network.PharmaApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        //  El objeto RetrofitHelper.kt, que hacía lo mismo, se elimina:
        return Retrofit.Builder()
            .baseUrl("https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideFirestoreInstance() = FirebaseFirestore.getInstance()

    @Provides
    @Singleton
    fun providePharmaList(
        firestore: FirebaseFirestore
    ) = firestore.collection("pharmas")


    @Provides
    @Singleton
    fun providePharmaApiClient(retrofit: Retrofit): PharmaApiClient {
        return retrofit.create(PharmaApiClient::class.java)
    }
}