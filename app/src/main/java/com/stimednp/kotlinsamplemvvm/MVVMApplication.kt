package com.stimednp.kotlinsamplemvvm

import android.app.Application
import com.stimednp.kotlinsamplemvvm.network.ApiClient
import com.stimednp.kotlinsamplemvvm.repository.MovieRepository
import com.stimednp.kotlinsamplemvvm.ui.MovieViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

/**
 * Created by rivaldy on Sep/26/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

class MVVMApplication: Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@MVVMApplication))
        bind() from singleton { ApiClient() }
        bind() from singleton { MovieRepository(instance()) }
        bind() from singleton { MovieViewModelFactory(instance()) }
    }
}