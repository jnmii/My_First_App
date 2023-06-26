package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val TAG: String = "MainActivity"

    /*
    * Creating the references of resources (to be used)
    * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main)

        Log.d(TAG, "OnCreate: Creating the references of resources (to be used)")

        val emailEditText: EditText = findViewById(R.id.etUserInput)
        val passwordEditText: EditText = findViewById(R.id.etPassword)
        val loginButton: Button = findViewById(R.id.btnFirst)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            Log.d("MainActivity", email+ "  "+ password)

            if (isEmailValid(email) && isPasswordValid(password)) {

                startActivity(Intent(this@MainActivity, SecondActivity::class.java))
            } else {
                // Invalid email or password
                Toast.makeText(
                    this@MainActivity,
                    "Invalid email or password",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    // Email validation function
    private fun isEmailValid(email: String): Boolean {
        // Add your email validation logic here
        // For example, you can use regular expressions to validate the email format
        val emailRegex = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        val value : Boolean = email.matches(emailRegex.toRegex())
        Log.d("MainActivity is email valid", ""+ value)

        return value

    }

    // Password validation function
    private fun isPasswordValid(password: String): Boolean {
        return password.length >= 8
    }

    /*
    * Make sure all the resources are allocated (memory/resources)
    * */
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: Make sure all the resources are allocated (memory/resources)")
    }

    /*
    * User gets to see and interact with the Activity (UI)
    * */
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: User gets to see and interact with the Activity (UI)")
    }

    /*
    * Stops the user interaction and holds activity temporary (paused)
    * */
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: Stops the user interaction and holds activity temporary (paused)")
    }

    /*
    * Removes all the memory allocations (remove memory/resources)
    * */
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: Removes all the memory allocations (remove memory/resources)")
    }

    /*
    * Removes the activity reference (remove it ever existed)
    * */
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: Removes the activity reference (remove it ever existed)")
    }
}
