package com.wfghc.viacepapp.di

import com.wfghc.viacepapp.data.api.CepApi
import com.wfghc.viacepapp.network.CepProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun providesCepApi(
        cepProvides: CepProvider
    ) : CepApi {
        return cepProvides.createService(CepApi::class.java)
    }
}