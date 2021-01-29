package kg.nurik.errorhandling.di

import kg.nurik.errorhandling.data.iteractor.SamboInteractor
import kg.nurik.errorhandling.data.iteractor.SamboInteractorImpl
import kg.nurik.errorhandling.data.remote.CoursesService
import kg.nurik.errorhandling.data.remote.RetrofitBuilder
import kg.nurik.errorhandling.data.repository.SamboRepository
import kg.nurik.errorhandling.data.repository.SamboRepositoryImpl
import kg.nurik.errorhandling.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModule: Module = module {
    viewModel { MainViewModel(get()) }
}

val repositoryModule: Module = module {
    single<SamboRepository> { SamboRepositoryImpl(get()) }
}

val apiModule: Module = module {
    single<CoursesService> { RetrofitBuilder.buildRetrofit() }
    single<SamboInteractor> { SamboInteractorImpl(get()) }
}

val appModules =
    listOf(viewModelModule, apiModule, repositoryModule)