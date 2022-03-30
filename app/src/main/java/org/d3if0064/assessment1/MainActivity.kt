package org.d3if0064.assessment1

import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.d3if0064.assessment1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.konvert.setOnClickListener {
            konversiSuhu()
        }

    }

    private fun konversiSuhu() {
        var hasil: Double

        val suhu = binding.celciusEditText.text.toString()

        var id: Int = binding.radioGroup.checkedRadioButtonId
        if (id != -1) {
            val radio: RadioButton = findViewById(id)

            // Kelvin
            if (radio == binding.kelvin) {
                hasil = suhu.toInt() + 273.15
                binding.suhuKonvert.text = hasil.toString()

                binding.kategoriSuhu.text = "Kelvin"
            }

            // Farenheit
            if (radio == binding.farenheit) {
                hasil = (suhu.toDouble() * 9 / 5) + 32
                binding.suhuKonvert.text = hasil.toString()

                binding.kategoriSuhu.text = "Farenheit"
            }

            // Reamur
            if (radio == binding.reamur) {
                hasil = suhu.toDouble() * 4 / 5
                binding.suhuKonvert.text = hasil.toString()

                binding.kategoriSuhu.text = "Reamur"
            }
        } else {
            Toast.makeText(applicationContext, "Anda tidak memilih konversi apapun", Toast.LENGTH_SHORT).show()
        }
    }
}

