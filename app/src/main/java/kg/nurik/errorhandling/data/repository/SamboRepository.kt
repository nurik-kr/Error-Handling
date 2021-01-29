package kg.nurik.errorhandling.data.repository

import kg.nurik.errorhandling.data.iteractor.SamboInteractor
import kg.nurik.errorhandling.data.model.ProfileModel

interface SamboRepository {
    suspend fun loadUserProfile(): ProfileModel?
}

class SamboRepositoryImpl(private val network : SamboInteractor) : SamboRepository {
    override suspend fun loadUserProfile(): ProfileModel? {
        return network.loadUserProfile()
    }
}