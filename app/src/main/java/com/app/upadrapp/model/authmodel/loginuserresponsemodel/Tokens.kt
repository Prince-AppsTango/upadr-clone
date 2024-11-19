package com.app.upadrapp.model.authmodel.loginuserresponsemodel

data class Tokens(
    val accessToken: String,
    val idToken: String,
    val refreshToken: String,
    val secretHash: String
)