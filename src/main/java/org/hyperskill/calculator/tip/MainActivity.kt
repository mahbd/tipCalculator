package org.hyperskill.calculator.tip

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.slider.Slider


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val inputField = findViewById<EditText>(R.id.edit_text)
        val sliderField = findViewById<Slider>(R.id.slider)
        inputField.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                val new = s?.toString() ?: ""
                if (new.isEmpty()) {
                    findViewById<TextView>(R.id.text_view).text = ""
                } else {
                    val totalTip = sliderField.value * 0.01 * new.toDouble()
                    val text = "Tip amount: %.2f".format(totalTip)
                    findViewById<TextView>(R.id.text_view).text = text
                }
            }
        })
        sliderField.addOnChangeListener(
                Slider.OnChangeListener { _, value, _ ->
                    val new = inputField.text.toString()
                    if (new.isNotEmpty()) {
                        val totalTip = sliderField.value * 0.01 * new.toDouble()
                        val text = "Tip amount: %.2f".format(totalTip)
                        findViewById<TextView>(R.id.text_view).text = text
                    }
                })
    }
}