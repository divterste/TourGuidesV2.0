package sam.lambton.tourguidesv20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.widget.Toast

class SummerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summer)

        val tofinobutton : Button = findViewById(R.id.tofinoKnowMore)
        val woodbinebutton : Button =findViewById(R.id.woodbinekmore)
        val Nigarabutton : Button=findViewById(R.id.NigaraKmore)



        tofinobutton.setOnClickListener {
            //Toast.makeText(this, "Summer clicked", Toast.LENGTH_LONG).show()
            val intent = Intent(applicationContext, TofinoActivity::class.java)
            startActivity(intent)
        }

        woodbinebutton.setOnClickListener {
            //Toast.makeText(this, "Summer clicked", Toast.LENGTH_LONG).show()
            val intent = Intent(applicationContext, WoodbineActivity ::class.java)
            startActivity(intent)
        }
        Nigarabutton.setOnClickListener {
            //Toast.makeText(this, "Summer clicked", Toast.LENGTH_LONG).show()
            val intent = Intent(applicationContext, NigaraActivity::class.java)
            startActivity(intent)
        }

    }
}


