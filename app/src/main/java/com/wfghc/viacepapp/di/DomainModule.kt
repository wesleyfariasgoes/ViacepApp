package com.wfghc.viacepapp.di

import com.wfghc.viacepapp.data.repository.AddressRepositoryImpl
import com.wfghc.viacepapp.domain.repository.AddressRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindsAddressRepositoryImpl(
        addressRepositoryImpl: AddressRepositoryImpl
    ) : AddressRepository

}