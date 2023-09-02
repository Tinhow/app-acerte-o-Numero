package filho.walter.acerteonumero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.Random

class MainActivity : AppCompatActivity() {

    private lateinit var textViewMin: TextView
    private lateinit var textViewMax: TextView
    private lateinit var editTextPalpite: EditText
    private lateinit var textViewStatus: TextView
    private lateinit var buttonChute: Button
    private lateinit var intervaloNumeros: IntervaloNumeros

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.textViewMin = findViewById(R.id.textViewMin)
        this.textViewMax = findViewById(R.id.textViewMax)
        this.editTextPalpite = findViewById(R.id.editTextPalpite)
        this.textViewStatus = findViewById(R.id.textViewStatus)
        this.buttonChute = findViewById(R.id.buttonChute)
        this.intervaloNumeros = IntervaloNumeros(1, 100)
        this.updateLayoutInfo()

        this.buttonChute.setOnClickListener {
            Chute()
        }
        this.buttonChute.setOnLongClickListener(TrataClickLong())

    }

    private fun Chute(){
        val chute = this.editTextPalpite.text.toString()
        if (chute != ""){
            this.intervaloNumeros.chute(Integer.parseInt(chute))
        }
        this.updateLayoutInfo()
        Toast.makeText(this, this.intervaloNumeros.getNumeroStatus().toString(),
            Toast.LENGTH_SHORT).show()
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


    private fun updateLayoutInfo() {
        this.editTextPalpite.setText("")
        this.textViewMin.text = this.intervaloNumeros.getMin().toString()
        this.textViewMax.text = this.intervaloNumeros.getMax().toString()
        this.textViewStatus.text = this.intervaloNumeros.getStatus().toString()
    }
}