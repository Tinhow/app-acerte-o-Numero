package filho.walter.acerteonumero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Lose_screen : AppCompatActivity() {

    lateinit var new_game_bt: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lose_screen)

        new_game_bt = findViewById(R.id.new_game_bt)

        new_game_bt.setOnClickListener {
            new_game()
        }
    }

    private fun new_game(){
        val novoJogo = Intent(this, MainActivity::class.java)
        startActivity(novoJogo)
    }
}