package com.danp.proyecto_01

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import android.widget.Toast
import androidx.activity.viewModels
import com.danp.proyecto_01.data.ProductApplication
import com.danp.proyecto_01.data.ProductViewModel
import com.danp.proyecto_01.data.ProductViewModelFactory

import com.danp.proyecto_01.ui.theme.Proyecto_01Theme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class MainActivity : ComponentActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        val productViewModel by viewModels<ProductViewModel> {
            ProductViewModelFactory((application as ProductApplication).repository)
        }
        val currentUser = auth.currentUser

        updateUI(currentUser, productViewModel)

//        setContent {
//            Proyecto_01Theme {
//                MainScreen()
//            }
//        }
    }

//    public override fun onStart() {
//
//        super.onStart()
//        val productViewModel by viewModels<ProductViewModel> {
//            ProductViewModelFactory((application as ProductApplication).repository)
//        }
//        // Check if user is signed in (non-null) and update UI accordingly.
//        val currentUser = auth.currentUser
//
//        updateUI(currentUser, productViewModel)
//    }

    private fun createAccount(email: String, password: String, productViewModel: ProductViewModel?) {
        // [START create_user_with_email]
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser
                    if (productViewModel != null) {
                        updateUI(user, productViewModel)
                    }
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                    if (productViewModel != null) {
                        updateUI(null, productViewModel)
                    }
                }
            }
        // [END create_user_with_email]
    }

    private fun signIn(email: String, password: String, productViewModel: ProductViewModel?) {
        // [START sign_in_with_email]
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser
                    if (productViewModel != null) {
                        updateUI(user, productViewModel)
                    }
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                    if (productViewModel != null) {
                        updateUI(null, productViewModel)
                    }
                }
            }
        // [END sign_in_with_email]
    }

    private fun updateUI(user: FirebaseUser?, productViewModel: ProductViewModel) {

        val startRoute = if (user == null) {
            BottomBarScreen.Login.route
        } else {
            BottomBarScreen.Home.route
        }

        setContent {
            Proyecto_01Theme {
                MainScreen(productViewModel, startRoute, ::signIn, ::createAccount)
            }
        }

    }
}

