package sam.lambton.tourguidesv20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CustomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom)

        val btnCreatePackage : Button = findViewById(R.id.BtnCreatePackage)

        btnCreatePackage.setOnClickListener {
            //Toast.makeText(this, "Summer clicked", Toast.LENGTH_LONG).show()
            val intent = Intent(applicationContext, CustomCreateActivity::class.java)
            startActivity(intent)
        }

        val btnSeeAllPackages : Button = findViewById(R.id.btnViewAllPackages)

        btnSeeAllPackages.setOnClickListener {
            //Toast.makeText(this, "Summer clicked", Toast.LENGTH_LONG).show()
            val intent = Intent(applicationContext, CustomSeeAllPackagesActivity::class.java)
            startActivity(intent)
        }
    }
}