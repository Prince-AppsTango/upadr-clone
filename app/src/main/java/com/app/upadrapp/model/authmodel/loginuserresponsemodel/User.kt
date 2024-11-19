package com.app.upadrapp.model.authmodel.loginuserresponsemodel

data class User(
    val accountStatus: String,
    val emailAddress: String,
    val firstName: String,
    val lastName: String,
    val numberOfUnreadNotifications: Int,
    val numberOfUnreadSurveys: Int,
    val phoneCountryCode: Any,
    val phoneNumber: Any,
    val profileImage: Any,
    val profilePictureUrl: Any,
    val profile_image_url: Any,
    val registeredOn: String,
    val userId: String,
    val userSettings: UserSettings,
    val userType: String
)