package com.example.emailsenderapp

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var email: EditText
    lateinit var subject: EditText
    lateinit var message: EditText
    lateinit var sendBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        email = findViewById(R.id.email)
        subject = findViewById(R.id.subject)
        message = findViewById(R.id.message)
        sendBtn = findViewById(R.id.sendBtn)

        sendBtn.setOnClickListener {

            val emailText = email.text.toString()
            val subjectText = subject.text.toString()
            val messageText = message.text.toString()

            // Check empty fields
            if (emailText.isEmpty() || subjectText.isEmpty() || messageText.isEmpty()) {
                Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validate email
            if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
                Toast.makeText(this, "Invalid Email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Send email intent
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "message/rfc822"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(emailText))
            intent.putExtra(Intent.EXTRA_SUBJECT, subjectText)
            intent.putExtra(Intent.EXTRA_TEXT, messageText)

            startActivity(Intent.createChooser(intent, "Send Email"))
        }
    }
}