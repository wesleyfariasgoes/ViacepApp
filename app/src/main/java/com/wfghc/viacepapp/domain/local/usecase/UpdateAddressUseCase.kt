package com.wfghc.viacepapp.domain.local.usecase

import com.wfghc.viacepapp.data.local.entity.AddressEntity
import com.wfghc.viacepapp.data.mapper.toEntity
import com.wfghc.viacepapp.domain.local.repository.AddressLocalRepository
import com.wfghc.viacepapp.domain.model.Address
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UpdateAddressUseCase @Inject constructor(
    private val repository: AddressLocalRepository
){
    suspend operator fun invoke(address: Address) {
        return repository.updateAddress(address.toEntity())
    }
}