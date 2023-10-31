package com.wfghc.viacepapp.domain.local.repository

import com.wfghc.viacepapp.data.local.entity.AddressEntity
import kotlinx.coroutines.flow.Flow

interface AddressLocalRepository {
    fun getAllAddress(): Flow<List<AddressEntity>>
    suspend fun getAddressByIds(id: Long): AddressEntity?
    suspend fun insertAddress(addressEntity: AddressEntity): Long
    suspend fun updateAddress(addressEntity: AddressEntity)
    suspend fun deleteAddress(addressEntity: AddressEntity)
}