package filho.walter.acerteonumero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var textViewMin: TextView
    private lateinit var textViewMax: TextView
    private lateinit var editTextPalpite: EditText
    private lateinit var textViewStatus: TextView
    private lateinit var buttonChute: Button
    private lateinit var intervaloNumeros: IntervaloNumeros
    private lateinit var textViewName: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.textViewMin = findViewById(R.id.textViewMin)
        this.textViewMax = findViewById(R.id.textViewMax)
        this.editTextPalpite = findViewById(R.id.editTextNome)
        this.textViewStatus = findViewById(R.id.textViewStatus)
        this.buttonChute = findViewById(R.id.buttonChute)
        this.textViewName = findViewById(R.id.textViewName)
        this.intervaloNumeros = IntervaloNumeros(1, 100)
        this.updateLayoutInfo()

        this.buttonChute.setOnClickListener {
            chute()
        }
        this.buttonChute.setOnLongClickListener(TrataClickLong())

        val playerName = intent.getStringExtra("player_name")
        setPlayerName(playerName)

    }

    private fun chute() {
        val chute = this.editTextPalpite.text.toString()
        if (chute != "") {
            val chuteInt = Integer.parseInt(chute)

            if (chuteInt < this.intervaloNumeros.getMin() || chuteInt > this.intervaloNumeros.getMax()) {
                this.intervaloNumeros.setStatus(JogoStatus.PERDEU)
                perdeu()
                Toast.makeText(this, "Chute fora do intervalo", Toast.LENGTH_SHORT).show()
            } else {
                this.intervaloNumeros.chute(chuteInt)
                this.updateLayoutInfo()
                Toast.makeText(this, this.intervaloNumeros.getNumeroStatus().toString(), Toast.LENGTH_SHORT).show()

            if (this.intervaloNumeros.getStatus() == JogoStatus.GANHOU) {
                ganhou()
               }
            }
            if (this.intervaloNumeros.getStatus() == JogoStatus.PERDEU) {
                perdeu()
            }
        }
    }



    //funcao para resetar aplicação no clicklongo do botao
    private inner class TrataClickLong : View.OnLongClickListener {
        override fun onLongClick(v: View?): Boolean {
            resetar()
            return true
        }
    }
    private fun resetar(){
        this.intervaloNumeros = IntervaloNumeros(1, 100)
        this.updateLayoutInfo()
    }

    private fun ganhou(){
        val telaWin =  Intent(this, Win_screen::class.java)
        if (this.intervaloNumeros.getStatus() == JogoStatus.GANHOU){
            startActivity(telaWin)
        }
    }
    private fun perdeu(){
        val telaLose = Intent(this, Lose_screen::class.java)
        if (this.intervaloNumeros.getStatus() == JogoStatus.PERDEU){
            startActivity(telaLose)
        }
    }


    private fun updateLayoutInfo() {
        this.editTextPalpite.setText("")
        this.textViewMin.text = this.intervaloNumeros.getMin().toString()
        this.textViewMax.text = this.intervaloNumeros.getMax().toString()
        this.textViewStatus.text = this.intervaloNumeros.getStatus().toString()
    }

    private fun setPlayerName(playerName: String?) {
        this.textViewName = findViewById(R.id.textViewName)

        if (playerName != null && playerName.isNotEmpty()) {
            this.textViewName.text = "$playerName"
        } else {
            this.textViewName.text = ""
        }
    }
}


