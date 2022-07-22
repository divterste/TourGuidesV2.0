package sam.lambton.tourguidesv20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.ViewCompat

class CustomSeeAllPackagesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_see_all)

        /* Add new CardView to See All Packages when Create Package is clicked */

        var cardView : View
        var llCustomCards: LinearLayout = findViewById(R.id.llCustomCards)
        var tvChange : TextView
        var customKnowMore : Button? = null
        val databaseHelper: DatabaseHelper = DatabaseHelper(this)
        val arrayListPackages: ArrayList<PackageModel>? = databaseHelper.getAllPackages()

        var howManyPackages: Int = 0

        if(intent.getStringExtra("activity") == "CustomCreateActivity")
        {
            howManyPackages = databaseHelper.howManyPackages()

            for (i in 0..howManyPackages) {
                cardView = LayoutInflater.from(this).inflate(R.layout.cardview, null)
                tvChange = cardView.findViewById(R.id.tvCustomCardTitle)

                // Change id of the View
                customKnowMore = cardView.findViewById(R.id.btnPackageDetails)
                customKnowMore.id = ViewCompat.generateViewId()

                // Change attributes
                //tvChange.text = intent.getStringExtra("packageName")
                tvChange.text = arrayListPackages?.get(i)?.packageName
                llCustomCards.addView(cardView)
            }
        }

        customKnowMore?.setOnClickListener {
            //Toast.makeText(this, llCustomCards.findViewById<Button>(customKnowMore.id).text, Toast.LENGTH_SHORT).show()
            val intentDetails = Intent(this, CustomDetailsActivity::class.java)
            intentDetails.putExtra("packageName", intent.getStringExtra("packageName"))
            intentDetails.putExtra("packageDescription", intent.getStringExtra("packageDescription"))
            intentDetails.putExtra("source", intent.getStringExtra("source"))
            intentDetails.putExtra("destination", intent.getStringExtra("destination"))
            intentDetails.putExtra("airlines", intent.getStringExtra("airlines"))
            intentDetails.putExtra("hotels", intent.getStringExtra("hotels"))
            intentDetails.putExtra("startDate", intent.getStringExtra("startDate"))
            intentDetails.putExtra("endDate", intent.getStringExtra("endDate"))

            startActivity(intentDetails)
        }
    }
}