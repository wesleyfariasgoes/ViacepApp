package com.wfghc.viacepapp.di

import com.wfghc.viacepapp.network.CepProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun providesCepProvider() = CepProvider
}