package sam.lambton.tourguidesv20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView

class CustomSeeAllPackagesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_see_all)

        //createCardViewProgrammatically()
        val view : View = LayoutInflater.from(this).inflate(R.layout.cardview, null)
        val llCustomCards: LinearLayout = findViewById(R.id.llCustomCards)
        llCustomCards.addView(view)

    }

    /*private fun createCardViewProgrammatically(){

        val cardView: CardView = CardView(this)
        val layoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)

        val llCustomCards: LinearLayout = findViewById(R.id.llCustomCards)

        val cardViewFormat: CardView = findViewById(R.id.cvFormat)

        cardView.layoutParams = cardViewFormat.layoutParams

        val textView: TextView = TextView(this)
        textView.text = "Something something"

        cardView.addView(textView)
        llCustomCards.addView(cardView)
    }*/
}