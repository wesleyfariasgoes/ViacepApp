package com.wfghc.viacepapp.domain.local.usecase

import com.wfghc.viacepapp.data.local.entity.AddressEntity
import com.wfghc.viacepapp.domain.local.repository.AddressLocalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllAddressUseCase @Inject constructor(
    private val repository: AddressLocalRepository
){
    operator fun invoke(): Flow<List<AddressEntity>> {
        return repository.getAllAddress()
    }
}