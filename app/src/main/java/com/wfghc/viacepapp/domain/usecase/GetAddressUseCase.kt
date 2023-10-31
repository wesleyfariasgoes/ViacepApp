package com.wfghc.viacepapp.domain.usecase

import com.wfghc.viacepapp.data.mapper.toDomain
import com.wfghc.viacepapp.domain.model.Address
import com.wfghc.viacepapp.domain.repository.AddressRepository
import javax.inject.Inject

class GetAddressUseCase @Inject constructor(
    private val repository: AddressRepository
) {
    suspend operator fun invoke(cep: String) : Address {
        return repository.getAddress(cep).toDomain()
    }
}