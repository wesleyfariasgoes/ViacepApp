package com.wfghc.viacepapp.di

import com.wfghc.viacepapp.data.local.repository.AddressLocalRepositoryImpl
import com.wfghc.viacepapp.data.repository.AddressRepositoryImpl
import com.wfghc.viacepapp.domain.api.repository.AddressRepository
import com.wfghc.viacepapp.domain.local.repository.AddressLocalRepository
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

    @Binds
    abstract fun bindsAddressLocalRepositoryImpl(
        addressLocalRepositoryImpl: AddressLocalRepositoryImpl
    ) : AddressLocalRepository

}