package com.app.co.broadcast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NetworkConnectionLD(baseContext ?: return)
            .observe(this, Observer { isConnected ->
                if (!isConnected) {
                    Toast.makeText(baseContext, "CONNECTION NETWORK OFF", Toast.LENGTH_LONG).show()
                    return@Observer
                }
                Toast.makeText(baseContext, "CONNECTION NETWORK ON", Toast.LENGTH_LONG).show()
            })
    }
}