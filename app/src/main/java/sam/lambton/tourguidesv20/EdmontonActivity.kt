package sam.lambton.tourguidesv20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class EdmontonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edmonton)

        val btncall : Button = findViewById(R.id.btnCall)
        btncall.setOnClickListener{
            val intent = Intent(applicationContext, finalActivity ::class.java)
            startActivity(intent)
        }
    }
}