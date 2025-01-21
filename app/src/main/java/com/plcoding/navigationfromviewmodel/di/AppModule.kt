package com.plcoding.navigationfromviewmodel.di

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.plcoding.navigationfromviewmodel.DefaultNavigator
import com.plcoding.navigationfromviewmodel.Destination
import com.plcoding.navigationfromviewmodel.Navigator
import dagger.Module
import dagger.Provides
import dagger.hilt.EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NavigationModule {

    @Provides
    @Singleton
    fun providesNavigator(): Navigator {
        return DefaultNavigator(
            startDestination = Destination.AuthGraph
        )
    }
}

private lateinit var navigatorEntryPoint: NavigatorEntryPoint

@EntryPoint
@InstallIn(SingletonComponent::class)
interface NavigatorEntryPoint {
    val navigator: Navigator
}

@Composable
fun requireNavigatorEntryPoint(): NavigatorEntryPoint {
    if (!::navigatorEntryPoint.isInitialized) {
        navigatorEntryPoint = EntryPoints.get(
            LocalContext.current.applicationContext,
            NavigatorEntryPoint::class.java
        )
    }
    return navigatorEntryPoint
}

