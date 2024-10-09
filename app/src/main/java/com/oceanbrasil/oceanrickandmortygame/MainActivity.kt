package com.oceanbrasil.oceanrickandmortygame

import android.content.Context
import android.media.AudioManager
import android.media.ToneGenerator
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textViewName = findViewById<TextView>(R.id.tvName)
        val tvStatus = findViewById<TextView>(R.id.tvStatus)
        val ivCharacter = findViewById<ImageView>(R.id.ivCharacter)

        val randomId = Random.nextInt(1,826)
        //acesso a api
        RetrofitInstance.api.getCharacter(randomId).enqueue(object : Callback<Character> {
            override fun onResponse(call: Call<Character>, response: Response<Character>) {
                val character = response.body()
                character?.let {
                    Log.d("Resposta", it.name)
                    textViewName.text = it.name
                    tvStatus.text = it.status
                    Glide.with(this@MainActivity)
                        .load(it.image)
                        .into(ivCharacter)
                    beepErro(this@MainActivity)

                }
            }

            override fun onFailure(call: Call<Character>, t: Throwable) {
                Log.e("Erro", t.message.toString())
            }

        })

    }

    fun beepErro(context: Context) {
        val toneGen = ToneGenerator(AudioManager.STREAM_ALARM, 100) // Volume: 100%
        toneGen.startTone(ToneGenerator.TONE_CDMA_ALERT_CALL_GUARD, 200) // Tipo de som e duração em ms
    }
}