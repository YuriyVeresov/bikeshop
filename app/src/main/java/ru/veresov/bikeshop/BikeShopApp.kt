package ru.veresov.bikeshop

import android.app.Application
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import ru.veresov.bikeshop.data.network.BikeShopApi
import ru.veresov.bikeshop.data.storage.CatalogItemStorageImpl
import ru.veresov.bikeshop.domain.CatalogItemStorage
import ru.veresov.bikeshop.domain.LoadCatalogResult
import ru.veresov.bikeshop.ui.mapper.CatalogUiMapper
import ru.veresov.bikeshop.ui.screen.CatalogScreenViewModel
import ru.veresov.bikeshop.ui.screen.ViewModelProvider
import ru.veresov.bikeshop.ui.screen.state.CatalogUiState

private const val BASE_URL = "http://10.0.2.2:3000/"

class BikeShopApp : Application(), ViewModelProvider {

    private lateinit var mainActivityViewModel: CatalogScreenViewModel

    override fun onCreate() {
        super.onCreate()
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val catalogItemStorage: CatalogItemStorage = CatalogItemStorageImpl(
            api = Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi)).build()
                .create(BikeShopApi::class.java),
        )
        val mapper: LoadCatalogResult.CatalogMapper<CatalogUiState> = CatalogUiMapper()
        mainActivityViewModel = CatalogScreenViewModel(catalogItemStorage, mapper)
    }

    override fun provideCatalogViewModel(): CatalogScreenViewModel {
        return mainActivityViewModel
    }

}