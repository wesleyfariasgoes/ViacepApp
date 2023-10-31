package com.wfghc.viacepapp.domain.local.usecase

import com.wfghc.viacepapp.data.local.entity.AddressEntity
import com.wfghc.viacepapp.domain.local.repository.AddressLocalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAddressByIdUseCase @Inject constructor(
    private val repository: AddressLocalRepository
){
    suspend operator fun invoke(id: Long): AddressEntity? {
        return repository.getAddressByIds(id)
    }
}