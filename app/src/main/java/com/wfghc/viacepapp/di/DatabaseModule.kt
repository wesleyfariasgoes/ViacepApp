package com.wfghc.viacepapp.di
import android.content.Context
import androidx.room.Room
import com.wfghc.viacepapp.R
import com.wfghc.viacepapp.data.local.dao.AddressDao
import com.wfghc.viacepapp.data.local.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun providesDatabase(
        @ApplicationContext context: Context
    ): AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        context.getString(R.string.app_name_database)
    ).build()

    @Provides
    fun providesAddressDao(database: AppDatabase): AddressDao = database.addressDao()

}