package com.wfghc.viacepapp.data.local.repository

import com.wfghc.viacepapp.data.local.dao.AddressDao
import com.wfghc.viacepapp.data.local.entity.AddressEntity
import com.wfghc.viacepapp.domain.local.repository.AddressLocalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AddressLocalRepositoryImpl @Inject constructor(
    private val addressDao: AddressDao
): AddressLocalRepository {
    override fun getAllAddress(): Flow<List<AddressEntity>> {
        return addressDao.getAllAddress()
    }

    override suspend fun getAddressByIds(id: Long): AddressEntity? {
        return addressDao.getAddressByIds(id = id)
    }

    override suspend fun insertAddress(addressEntity: AddressEntity): Long {
        return addressDao.insertAddress(addressEntity)
    }

    override suspend fun updateAddress(addressEntity: AddressEntity) {
        addressDao.updateAddress(addressEntity = addressEntity)
    }

    override suspend fun deleteAddress(addressEntity: AddressEntity) {
        addressDao.deleteAddress(addressEntity = addressEntity)
    }
}