package sam.lambton.tourguidesv20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView

class CustomSeeAllPackagesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_see_all)

        /* Multiple CardView Loop | .addView customized View */

        var cardView : View
        var llCustomCards: LinearLayout = findViewById(R.id.llCustomCards)
        var tvChange : TextView

        for (i in 1..3) {
            cardView = LayoutInflater.from(this).inflate(R.layout.cardview, null)
            tvChange = cardView.findViewById(R.id.tvCustomCardTitle)

            tvChange.text = "Custom package $i"

            llCustomCards.addView(cardView)
        }
    }
}