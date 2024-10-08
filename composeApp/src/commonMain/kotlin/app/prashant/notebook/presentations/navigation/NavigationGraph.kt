package app.prashant.notebook.presentations.navigation

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import app.prashant.notebook.domain.model.Note
import app.prashant.notebook.presentations.home.Home
import app.prashant.notebook.presentations.note.CreateNote
import app.prashant.notebook.utils.log.Logcat

@Composable
fun NavigationGraph(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = Route.HomeScreen,
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { it }
            ) + fadeIn()
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { -it }
            ) + fadeOut()
        },
        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { -it }
            ) + fadeIn()
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { it }
            ) + fadeOut()
        },
    ) {
        composable<Route.HomeScreen> {
            Home(navHostController = navHostController)
        }
        composable<Route.NoteScreen> { backStackEntry ->
            val noteArgs: Route.NoteScreen = backStackEntry.toRoute()
            Logcat.d("NavGraph", noteArgs.toString())
            val note = if (noteArgs.title != null && noteArgs.description != null) {
                Note(title = noteArgs.title, description = noteArgs.description, id = noteArgs.id)
            } else {
                null
            }
            CreateNote(note = note, navHostController = navHostController)
        }
    }
}