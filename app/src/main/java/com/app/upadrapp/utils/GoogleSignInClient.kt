package com.app.upadrapp.utils

import android.content.Context
import androidx.credentials.ClearCredentialStateRequest
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.credentials.GetCredentialResponse
import com.app.upadrapp.store.saveToDataStore
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.tasks.await
import java.util.concurrent.CancellationException

// learn from here https://www.youtube.com/watch?v=WFTsyOKMUKU&list=LL&index=1
//https://medium.com/@TonyGnk/streamlining-authentication-using-android-credential-manager-with-firebase-for-google-sign-in-e4e75b6bd97d
class GoogleSignInClient(private val context: Context) {
    //using for the manage credential
    private val credentialManager = CredentialManager.create(context)
    //using for the manage auth
    private val firebaseAuth = FirebaseAuth.getInstance()

    fun isSignedIn():Boolean {
        if (firebaseAuth.currentUser != null) {
            println("already signed in")
            return true
        } else {
            return false
        }
    }

    suspend fun signIn(): Any {
        if(isSignedIn()){
            return true
        }
        try {
            val result = buildCredentialRequest()
            return handleSignIn(result)
        }catch(e:Exception) {
            e.printStackTrace()
            if(e is CancellationException) throw e
            println("GoogleSignInClient $e")
            return false
        }
    }

    private suspend fun  handleSignIn(result: GetCredentialResponse):Boolean{
        val credential = result.credential
        if(credential is CustomCredential && credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL){
           try {
               val tokenCredential= GoogleIdTokenCredential.createFrom(credential.data)
               println("GoogleSignInClient" + "id" + {tokenCredential.id})
               println("GoogleSignInClient" + "name" + {tokenCredential.displayName})
               println("GoogleSignInClient" + "phoneNumber" + {tokenCredential.phoneNumber})
               println("GoogleSignInClient" + "profilePictureUri" + {tokenCredential.profilePictureUri})
               val authCredential = GoogleAuthProvider.getCredential(tokenCredential.idToken,null)
               saveToDataStore(context = context,tokenCredential.idToken,tokenCredential.idToken)
               val authResult = firebaseAuth.signInWithCredential(authCredential).await()
               return  authResult.user != null
           }catch (e:GoogleIdTokenParsingException){
               println("GoogleIdTokenParsingException ${e.message}")
               return false
           }
        }else{
            println("credential is not GoogleIdTokenCredential")
            return false
        }
    }
    private suspend fun buildCredentialRequest(): GetCredentialResponse {
        // Build the Google ID option
        val googleIdOption = GetGoogleIdOption.Builder()
            .setFilterByAuthorizedAccounts(false)
            .setServerClientId("797400984314-dvlf6is9s15mea09brnf9m1jo91uam5v.apps.googleusercontent.com")
            .setAutoSelectEnabled(false)
            .build()

        // Build the credential request
        val request = GetCredentialRequest.Builder()
            .addCredentialOption(googleIdOption)
            .build()

        // Use the credential manager to retrieve the credential
        return credentialManager.getCredential(request = request, context=context)
    }
   suspend fun signOut(){
          credentialManager.clearCredentialState(
              ClearCredentialStateRequest()
          )
       firebaseAuth.signOut()
    }

}