package com.app.upadrapp.model.authmodel.loginuserresponsemodel

data class LoginResponseModel(
    val message: String,
    val tokens: Tokens,
    val user: User
)