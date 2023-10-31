package com.wfghc.viacepapp.domain.local.usecase

import com.wfghc.viacepapp.data.mapper.toEntity
import com.wfghc.viacepapp.domain.local.repository.AddressLocalRepository
import com.wfghc.viacepapp.domain.model.Address
import javax.inject.Inject

class InsertAddressUseCase @Inject constructor(
    private val repository: AddressLocalRepository
){
    suspend operator fun invoke(address: Address): Long {
        return repository.insertAddress(address.toEntity())
    }
}