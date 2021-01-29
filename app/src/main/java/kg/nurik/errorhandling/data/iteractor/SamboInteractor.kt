package kg.nurik.errorhandling.data.iteractor

import kg.nurik.errorhandling.data.model.ProfileModel
import kg.nurik.errorhandling.data.remote.CoursesService

interface SamboInteractor {
    suspend fun loadUserProfile(): ProfileModel?
}

class SamboInteractorImpl(private val service: CoursesService) : SamboInteractor {
    override suspend fun loadUserProfile(): ProfileModel?{
        return service.loadUserProfile()
    }
}