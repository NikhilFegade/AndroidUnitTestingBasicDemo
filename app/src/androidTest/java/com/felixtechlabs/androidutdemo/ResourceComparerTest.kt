package com.felixtechlabs.androidutdemo

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class ResourceComparerTest {

    /**
     * Bad Approach:All test cases depend on single instance of class
     *  private val resourceComparer = ResourceComparer()*/
    private lateinit var resourceComparer: ResourceComparer


    /**
     * Suggested Approach
     *
     * */
    @Before
    fun setUp(){
        resourceComparer = ResourceComparer()
    }

    @Test
    fun stringResourceSameAsGivenString_returnsTrue() {
        /**Bad Approach :Every time new Instace of a class created in JVM
        resourceComparer = ResourceComparer()*/
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context, R.string.app_name, "AndroidUTDemo")
        assertThat(result).isTrue()

    }

    @Test
    fun stringResourceDifferentAsGivenString_returnsFalse() {
        /**     resourceComparer = ResourceComparer()*/
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context, R.string.app_name, "DemoApp")
        assertThat(result).isFalse()

    }
}