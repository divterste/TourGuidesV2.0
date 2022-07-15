package sam.lambton.tourguidesv20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class IndexActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)


        val summerKnowMore : Button = findViewById(R.id.summerAll)
        val winterKnowMore : Button = findViewById(R.id.winterAll)
        val custombutton : Button = findViewById(R.id.customAll)


        summerKnowMore.setOnClickListener {
            //Toast.makeText(this, "Summer clicked", Toast.LENGTH_LONG).show()
            val intent = Intent(applicationContext, SummerActivity::class.java)
            startActivity(intent)
        }

         // setting intent for winter
        winterKnowMore.setOnClickListener {
            //Toast.makeText(this, "Summer clicked", Toast.LENGTH_LONG).show()
            val intent = Intent(applicationContext, WinterActivity::class.java)
            startActivity(intent)
        }

        val aboutUsBtn : Button = findViewById(R.id.aboutUsBtn)

        aboutUsBtn.setOnClickListener {
            val intent = Intent(applicationContext, AboutUsActivity::class.java)
            startActivity(intent)
        }
        //intent for custom button

        custombutton.setOnClickListener {
            //Toast.makeText(this, "Summer clicked", Toast.LENGTH_LONG).show()
            val intent = Intent(applicationContext, CustomActivity::class.java)
            startActivity(intent)
        }
    }
}