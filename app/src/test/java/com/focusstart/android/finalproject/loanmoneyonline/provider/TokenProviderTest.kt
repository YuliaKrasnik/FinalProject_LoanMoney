package com.focusstart.android.finalproject.loanmoneyonline.provider

import android.content.SharedPreferences
import com.focusstart.android.finalproject.loanmoneyonline.core.data.provider.TokenProviderImpl
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants
import com.nhaarman.mockito_kotlin.*
import org.junit.Assert
import org.junit.Test

class TokenProviderTest {
    private val preferences: SharedPreferences = mock()
    private val tokenProvider: TokenProviderImpl = TokenProviderImpl(preferences)
    private val editor: SharedPreferences.Editor = mock()

    @Test
    fun `save bearer token EXPECT one putString and one apply`() {
        val inOrderOnType = InOrderOnType(editor)
        whenever(preferences.edit()).thenReturn(editor)
        whenever(editor.putString(any(), any())).thenReturn(editor)
        val token = "Bearer token"

        tokenProvider.saveBearerToken(token)

        inOrderOnType.verify(editor, times(1)).putString(any(), any())
        inOrderOnType.verify(editor, times(1)).apply()
    }

    @Test
    fun `get bearer token EXPECT string`() {
        val token = "Bearer token"
        whenever(preferences.contains(Constants.APP_PREFERENCES_TOKEN)).thenReturn(true)
        whenever(preferences.getString(Constants.APP_PREFERENCES_TOKEN, null)).thenReturn(token)

        val actual = tokenProvider.getBearerToken()

        Assert.assertEquals(token, actual)
    }

    @Test
    fun `get bearer token EXPECT null`() {
        whenever(preferences.contains(Constants.APP_PREFERENCES_TOKEN)).thenReturn(false)

        val actual = tokenProvider.getBearerToken()

        val expected = null
        Assert.assertEquals(expected, actual)
    }

}