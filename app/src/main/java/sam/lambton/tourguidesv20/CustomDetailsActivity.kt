package sam.lambton.tourguidesv20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import com.google.android.material.button.MaterialButton
import org.w3c.dom.Text

class CustomDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_details)

        Toast.makeText(this, intent.getStringExtra("packageName"), Toast.LENGTH_LONG).show()

        val packageName : TextView = findViewById(R.id.etPackageName)
        val packageDesc : TextView = findViewById(R.id.etPackageDescription)

        /*val source : TextView = findViewById(R.id.source)
        val destination : TextView = findViewById(R.id.destination)
        val airlines : TextView = findViewById(R.id.airlines)
        val hotels : TextView = findViewById(R.id.hotels)
        val startDate : TextView = findViewById(R.id.startDate)
        val endDate : TextView = findViewById(R.id.endDate)

        packageName.text = intent.getStringExtra("packageName")
        packageDesc.text = intent.getStringExtra("packageDescription")

        source.text = intent.getStringExtra("source")
        destination.text = intent.getStringExtra("destination")
        airlines.text = intent.getStringExtra("airlines")
        hotels.text = intent.getStringExtra("hotels")
        startDate.text = intent.getStringExtra("startDate")
        endDate.text = intent.getStringExtra("endDate")*/

        val btnCustomKnowMore : Button = findViewById(R.id.BtnCustomKnowMore)
        var cardView : View
        var llCustomCards: LinearLayout = findViewById(R.id.llCustomDetails)
        var knowMoreShowing: Boolean = false

        btnCustomKnowMore.setOnClickListener {

            cardView = LayoutInflater.from(this).inflate(R.layout.custom_know_more, null)

            if(knowMoreShowing) {
                llCustomCards.removeView(llCustomCards.findViewById(R.id.llCustomKnowMoreFull))
                knowMoreShowing = false
            }
            else {
                llCustomCards.addView(cardView)

                cardView.findViewById<TextView>(R.id.source).text = intent.getStringExtra("source")
                cardView.findViewById<TextView>(R.id.destination).text = intent.getStringExtra("destination")
                cardView.findViewById<TextView>(R.id.airlines).text = intent.getStringExtra("airlines")
                cardView.findViewById<TextView>(R.id.hotels).text = intent.getStringExtra("hotels")
                cardView.findViewById<TextView>(R.id.startDate).text = intent.getStringExtra("startDate")
                cardView.findViewById<TextView>(R.id.endDate).text = intent.getStringExtra("endDate")

                knowMoreShowing = true
            }

        }

        val mBtnSummer: MaterialButton = findViewById(R.id.mBtnSummer)
        mBtnSummer.setOnClickListener {
            val intent = Intent(applicationContext, SummerActivity::class.java)
            startActivity(intent)
        }

        val mBtnWinter: MaterialButton = findViewById(R.id.mBtnWinter)
        mBtnWinter.setOnClickListener {
            val intent = Intent(applicationContext, WinterActivity::class.java)
            startActivity(intent)
        }

        val mBtnCustom: MaterialButton = findViewById(R.id.mBtnCustom)
        mBtnCustom.setOnClickListener {
            val intent = Intent(applicationContext, CustomActivity::class.java)
            startActivity(intent)
        }
    }
}