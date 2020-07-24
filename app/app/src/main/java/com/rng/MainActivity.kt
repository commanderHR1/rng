package com.rng

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // Gets random number between lower and upper bound (inclusive_
    private fun randNum(lowBound : Int, upBound : Int): Int = (lowBound..upBound).random()

    // Main
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val goButton : Button = findViewById(R.id.btnGo)    // Grabs goButton
        var message : Toast

        // When goButton clicked
        goButton.setOnClickListener {
            // Gets elements
            val resultTextView : TextView = findViewById(R.id.lblResult)
            val lowBoundInput : EditText = findViewById(R.id.txtLow)
            val highBoundInput : EditText = findViewById(R.id.txtHigh)

            // Gets bounds
            val lowBoundStr : String = lowBoundInput.text.toString().trim()
            val highBoundStr : String = highBoundInput.text.toString().trim()

            // Tests errors
            if (lowBoundStr.isEmpty() || highBoundStr.isEmpty()){
                // Empty input field(s)
                resultTextView.text = getString(R.string.resultError)
                message = Toast.makeText(this, "Error! Please input lower and upper bounds.", Toast.LENGTH_SHORT)
                message.show()
                //throw NumberFormatException("Empty high or low bound input")
            }
            else if (lowBoundStr.toInt() > Int.MAX_VALUE) {
                // Low bound overflow
                resultTextView.text = getString(R.string.resultError)
                message = Toast.makeText(this, "Error! Lower bound is too large.", Toast.LENGTH_SHORT)
                message.show()
                //throw NumberFormatException("Low bound overflow")
            }
            else if (lowBoundStr.toInt() < Int.MIN_VALUE) {
                // Low bound underflow
                resultTextView.text = getString(R.string.resultError)
                message = Toast.makeText(this, "Error! Lower bound is too small.", Toast.LENGTH_SHORT)
                message.show()
                //throw NumberFormatException("Low bound underflow")
            }
            else if (highBoundStr.toInt() > Int.MAX_VALUE) {
                // High bound overflow
                resultTextView.text = getString(R.string.resultError)
                message = Toast.makeText(this, "Error! Upper bound is too large.", Toast.LENGTH_SHORT)
                message.show()
                //throw NumberFormatException("High bound overflow")
            }
            else if (highBoundStr.toInt() < Int.MIN_VALUE) {
                // High bound underflow
                resultTextView.text = getString(R.string.resultError)
                message = Toast.makeText(this, "Error! Upper bound is too small.", Toast.LENGTH_SHORT)
                message.show()
                //throw NumberFormatException("High bound underflow")
            }
            else  {
                val lowBound = lowBoundInput.text.toString().toInt()
                val highBound = highBoundInput.text.toString().toInt()

                // Outputs
                resultTextView.text = "Result: ${randNum(lowBound, highBound)}"
                message = Toast.makeText(this, "Generated!", Toast.LENGTH_SHORT)
                message.show()
            }
        }
    }
}
