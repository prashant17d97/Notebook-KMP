package app.prashant.notebook.domain.repositories

import app.prashant.notebook.domain.model.AppAppearance

/**
 * Represents a repository interface for managing data stored within the application, including posts,
 * application theme, and system palette preference.
 *
 * @author Prashant Singh
 */
interface DataStoreRepository {
    suspend fun saveAppAppearance(appAppearance: AppAppearance)

    suspend fun fetchAppearance(): AppAppearance
}

