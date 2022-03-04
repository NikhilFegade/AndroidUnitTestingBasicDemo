package com.felixtechlabs.androidutdemo

object RegistrationUtils {

    /**
     *After write below function, On right click on class->generate->test
     * we should select test folder to create test class file because below tests are not
     * required any android component to work
     * */
    private val existingUsers = listOf("Nikhil", "Chetan")

    /**
     * the input is not valid if ->
     * 1->the username/password is empty
     * 2->the username is already taken
     * 3->the confirmed password is not the same as the real password
     * 4->the password contains less than 2 digits
     */
    fun validateRegistrationInput(
        username: String,
        password: String,
        confirmedPassword: String
    ): Boolean {
        if (username.isEmpty() || password.isEmpty()) {
            return false
        }
        if (username in existingUsers) {
            return false
        }
        if (password != confirmedPassword) {
            return false
        }
        if (password.count { it.isDigit() } < 2) {
            return false
        }
        return true
    }
}