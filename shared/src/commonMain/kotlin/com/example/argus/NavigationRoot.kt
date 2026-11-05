package com.example.argus

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.savedstate.serialization.SavedStateConfiguration
import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.subclass
import kotlinx.serialization.modules.polymorphic

@Composable
fun NavigationRoot(modifier: Modifier = Modifier) {

    val backStack = rememberNavBackStack(
        configuration = SavedStateConfiguration {
            serializersModule = SerializersModule {
                polymorphic(NavKey::class) {
                    subclass(
                        Routes.HomeRoute::class,
                        Routes.HomeRoute.serializer()
                    )
                    subclass(
                        Routes.EventPage::class,
                        Routes.EventPage.serializer()
                    )
                }
            }
        },
        Routes.HomeRoute
    )
    NavDisplay(
        backStack = backStack,
        entr
    )
}