package app.prashant.notebook.di.platform

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import app.prashant.notebook.data.local.dataStore
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module


/**
 * Declares an expect property platformModule to be implemented in platform-specific code.
 * This module provides platform-specific dependencies required for the application.
 *
 * @see Module
 *
 * @property platformModule The platform-specific Koin module.
 *
 * @constructor Creates an instance of [platformModule].
 *
 * @author Prashant Singh
 */
actual val platformModule = module {
    single(named("Platform")) { "Android" }
    single<DataStore<Preferences>> { dataStore(context = get()) }
}