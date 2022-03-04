package com.felixtechlabs.androidutdemo

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilsTest{

    @Test
    fun emptyUserNameReturnsFalse() {
        val result = RegistrationUtils.validateRegistrationInput(
            "",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun validUserNameAndCorrectlyRepeatedPasswordReturnsTrue() {
        val result = RegistrationUtils.validateRegistrationInput(
            "Abhijeet",
            "123",
            "123"
        )
        assertThat(result).isTrue()
    }

    @Test
    fun usernameAlreadyExistsReturnsFalse() {
        val result = RegistrationUtils.validateRegistrationInput(
            "Nikhil",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun incorrectlyConfirmedPasswordReturnsFalse() {
        val result = RegistrationUtils.validateRegistrationInput(
            "Philipp",
            "123456",
            "abcdefg"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun emptyPasswordReturnsFalse() {
        val result = RegistrationUtils.validateRegistrationInput(
            "Philipp",
            "",
            ""
        )
        assertThat(result).isFalse()
    }

    @Test
    fun lessThanTwoDigitPasswordReturnsFalse() {
        val result = RegistrationUtils.validateRegistrationInput(
            "Philipp",
            "abcdefg5",
            "abcdefg5"
        )
        assertThat(result).isFalse()
    }




}