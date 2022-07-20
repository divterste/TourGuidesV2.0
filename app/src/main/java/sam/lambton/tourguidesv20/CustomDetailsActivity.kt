package sam.lambton.tourguidesv20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class CustomDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_details)

        Toast.makeText(this, intent.getStringExtra("packageName"), Toast.LENGTH_LONG).show()

        val packageName : TextView = findViewById(R.id.etPackageName)
        val packageDesc : TextView = findViewById(R.id.etPackageDescription)
        val source : TextView = findViewById(R.id.sourceType)
        val destination : TextView = findViewById(R.id.destinationType)
        val airlines : TextView = findViewById(R.id.spinnerAirlines)
        val hotels : TextView = findViewById(R.id.spinnerHotels)
        val startDate : TextView = findViewById(R.id.etStartDate)
        val endDate : TextView = findViewById(R.id.etEndDate)

        packageName.text = intent.getStringExtra("packageName")
        packageDesc.text = intent.getStringExtra("packageDescription")
        source.text = intent.getStringExtra("source")
        destination.text = intent.getStringExtra("destination")
        airlines.text = intent.getStringExtra("airlines")
        hotels.text = intent.getStringExtra("hotels")
        startDate.text = intent.getStringExtra("startDate")
        endDate.text = intent.getStringExtra("endDate")
    }
}