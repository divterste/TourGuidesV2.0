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
import com.google.android.material.button.MaterialButton

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

        var packageVariable: PackageModel? = null

        var howManyPackages: Int = databaseHelper.howManyPackages()

        /*if (howManyPackages > 0){
            packageVariable = databaseHelper.getAllPackages()!!
        }*/

        var packageModelList = listOf<PackageModel>()
        packageModelList = databaseHelper.getAllPackages()

        for (i in packageModelList) {
            cardView = LayoutInflater.from(this).inflate(R.layout.cardview,  null)

            // Make Package Name the TAG of the view
            //TODO("Make a check if a package name already exists before inserting to database")
            customKnowMore = cardView.findViewById(R.id.btnPackageDetails)
            customKnowMore?.tag = i.packageName

            // Change titles of cardViews
            cardView.findViewById<TextView>(R.id.tvCustomCardTitle).text = i.packageName

            llCustomCards.addView(cardView)

            var btnClickKnowMore = llCustomCards.findViewWithTag<Button>(i.packageName)











            btnClickKnowMore.setOnClickListener {
                val packageDetails: MutableList<String> = databaseHelper.getPackageWithTag(btnClickKnowMore.tag.toString())
                // Set values to intent

                //Toast.makeText(this, packageDetails[0], Toast.LENGTH_SHORT).show()

                val intentDetails = Intent(this, CustomDetailsActivity::class.java)
                intentDetails.putExtra("packageName", packageDetails[0])
                intentDetails.putExtra("packageDescription", packageDetails[1])
                intentDetails.putExtra("source", packageDetails[2])
                intentDetails.putExtra("destination", packageDetails[3])
                intentDetails.putExtra("airlines", packageDetails[4])
                intentDetails.putExtra("hotels", packageDetails[5])
                intentDetails.putExtra("startDate", packageDetails[6])
                intentDetails.putExtra("endDate", packageDetails[7])

                startActivity(intentDetails)
            }



























        }

        //Toast.makeText(this, arrayListPackages.toString(), Toast.LENGTH_LONG).show()

/*        customKnowMore?.setOnClickListener {
            Toast.makeText(this, llCustomCards.findViewById<Button>(customKnowMore.id).text, Toast.LENGTH_SHORT).show()
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

            Toast.makeText(this, "Button clicked with id ${customKnowMore.id}",
            Toast.LENGTH_SHORT).show()
        }*/

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