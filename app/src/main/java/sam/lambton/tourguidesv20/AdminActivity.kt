package sam.lambton.tourguidesv20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class AdminActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)


        val summerbtn : TextView = findViewById(R.id.btnsummer)
        summerbtn.setOnClickListener {
            val intent = Intent(applicationContext, AddpackagesActivity::class.java)
            startActivity(intent)

        }

        val winterbtn : TextView = findViewById(R.id.btnwinter)
        winterbtn.setOnClickListener {
            val intent = Intent(applicationContext, AddpackagesActivity::class.java)
            startActivity(intent)

        }

    }
}