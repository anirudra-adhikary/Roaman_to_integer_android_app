package com.rudra.romerome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rudra.romerome.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClear.setOnClickListener {
            binding.display.text = ""
            binding.result.text = ""
        }

        binding.btnBS.setOnClickListener {
            if(binding.display.text.isNotEmpty(+))
                binding.display.text =  binding.display.text.substring(0, binding.display.text.length - 1)
        }

        binding.btnI.setOnClickListener {
            binding.display.append("I")
        }

        binding.btnV.setOnClickListener {
            binding.display.append("V")
        }

        binding.btnX.setOnClickListener {
            binding.display.append("X")
        }

        binding.btnL.setOnClickListener {
            binding.display.append("L")
        }

        binding.btnC.setOnClickListener {
            binding.display.append("C")
        }

        binding.btnD.setOnClickListener {
            binding.display.append("D")
        }

        binding.btnM.setOnClickListener {
            binding.display.append("M")
        }

        binding.btnConvert.setOnClickListener {
            var str = binding.display.text.toString() + '0'

            var value = 0

            for (i in 0 until str.length - 1) {

                var c = str[i]
                var nextChar = str[i+1]

                if(c=='M')
                    value = value + 1000
                else if(c == 'D')
                    value += 500
                else if(c == 'C')
                {
                    if((nextChar == 'D') || (nextChar == 'M'))
                        value -= 100
                    else
                        value += 100
                }
                else if(c == 'L')
                    value += 50
                else if(c == 'X')
                {
                    if((nextChar=='L') || (nextChar == 'C'))
                        value -= 10
                    else
                        value += 10
                }
                else if(c == 'V')
                    value += 5
                else if(c == 'I')
                {
                    if(nextChar == 'V' || nextChar == 'X')
                        value--
                    else
                        value++
                }
            }

            binding.result.text = value.toString()
        }

    }
}