package by.maxluxs.polyc.di

import android.content.Context
import by.maxluxs.polyc.data.local.preferences.AuthPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideAuthPreferences(@ApplicationContext context: Context) = AuthPreferences(context)

}