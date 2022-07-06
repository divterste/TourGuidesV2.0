package sam.lambton.tourguidesv20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class WinterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_winter)

        val Banffbutton : Button = findViewById(R.id.BtnBanff)
        val Louisebutton : Button = findViewById(R.id.BtnLouise)
        val Edmontonbutton : Button = findViewById(R.id.BtnEdmonton)

        Banffbutton.setOnClickListener {
            //Toast.makeText(this, "Summer clicked", Toast.LENGTH_LONG).show()
            val intent = Intent(applicationContext, BanffActivity::class.java)
            startActivity(intent)
        }

        Louisebutton.setOnClickListener {
            //Toast.makeText(this, "Summer clicked", Toast.LENGTH_LONG).show()
            val intent = Intent(applicationContext, LouiseActivity::class.java)
            startActivity(intent)
        }

        Edmontonbutton.setOnClickListener {
            //Toast.makeText(this, "Summer clicked", Toast.LENGTH_LONG).show()
            val intent = Intent(applicationContext, EdmontonActivity::class.java)
            startActivity(intent)
        }


    }
}