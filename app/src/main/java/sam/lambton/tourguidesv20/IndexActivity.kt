package sam.lambton.tourguidesv20

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.cardview.widget.CardView

class IndexActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)


        val summerKnowMore : Button = findViewById(R.id.summerKnowMore)
        val winterKnowMore : Button = findViewById(R.id.winterKnowMore)

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
    }
}