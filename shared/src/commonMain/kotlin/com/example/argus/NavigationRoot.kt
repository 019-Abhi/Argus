package com.example.argus

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.savedstate.serialization.SavedStateConfiguration
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
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
                        Routes.HomeScreen::class,
                        Routes.HomeScreen.serializer()
                    )
                    subclass(
                        Routes.EventDetails::class,
                        Routes.EventDetails.serializer()
                    )
                }
            }
        },
        Routes.HomeScreen
    )
    NavDisplay(
        backStack = backStack,
        entryProvider = { key ->
            when(key) {
                is Routes.HomeScreen -> {
                    NavEntry(key) {
                        HomeScreen(
                            onEventClick = { eventId ->
                                backStack.add(Routes.EventDetails(eventId))
                            }
                        )
                    }
                }
                is Routes.EventDetails -> {
                    NavEntry(key) {
                        EventDetails(eventId = key.eventId)
                    }
                }
                else -> error("Unknown NavKey")
            }

        }
    )
}