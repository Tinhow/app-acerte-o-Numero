package filho.walter.acerteonumero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Win_screen : AppCompatActivity() {

    private lateinit var button_new_game: Button
    private lateinit var input_win_player_name: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_win_screen)

        this.button_new_game = findViewById(R.id.button_new_game)
        this.input_win_player_name = findViewById(R.id.input_win_player_name)

        this.button_new_game.setOnClickListener {
            new_game()
        }
    }

    private fun new_game() {
        val player_name = this.input_win_player_name.text.toString()
        val novoJogo = Intent(this, MainActivity::class.java)
        novoJogo.putExtra("player_name", player_name) // Adicione o valor como um extra
        startActivity(novoJogo)
    }


}


