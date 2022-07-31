package sam.lambton.tourguidesv20

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.core.view.allViews
import com.google.android.material.button.MaterialButton
import org.w3c.dom.Text
import java.util.concurrent.Executors

class WinterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_winter)

        val Banffbutton : Button = findViewById(R.id.BtnBanff)
        val Louisebutton : Button = findViewById(R.id.BtnLouise)
        val Edmontonbutton : Button = findViewById(R.id.BtnEdmonton)

        Banffbutton.setOnClickListener {
            //Toast.makeText(this, "Summer clicked", Toast.LENGTH_LONG).show()
            val intent = Intent(applicationContext, BanffActivity::class.java)
            startActivity(intent)
        }

        Louisebutton.setOnClickListener {
            //Toast.makeText(this, "Summer clicked", Toast.LENGTH_LONG).show()
            val intent = Intent(applicationContext, LouiseActivity::class.java)
            startActivity(intent)
        }

        Edmontonbutton.setOnClickListener {
            //Toast.makeText(this, "Summer clicked", Toast.LENGTH_LONG).show()
            val intent = Intent(applicationContext, EdmontonActivity::class.java)
            startActivity(intent)
        }

        /* Multiple CardView Loop | .addView customized View */

        var cardView : View = LayoutInflater.from(this).inflate(R.layout.cardview, null)
        var llWinterCards: LinearLayout = findViewById(R.id.llWinterCards)
        var tvChange : TextView

        /*for (i in 1..3) {
            cardView = LayoutInflater.from(this).inflate(R.layout.cardview, null)
            tvChange = cardView.findViewById(R.id.tvCustomCardTitle)

            tvChange.text = "Custom package $i"

            llWinterCards.addView(cardView)
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

        // Find how many images there are and iterate the process

        val imageURLS = arrayOf("https://i.postimg.cc/G2ZNhnvp/banff.png",
            "https://i.postimg.cc/W1F7gfLr/image.png",
            "https://i.postimg.cc/P54YfQYf/edmonton.png")


        // Setting up the imageview with the background from url

        // Declaring and initializing the ImageView
        val imageView = findViewById<ImageView>(R.id.ivBanff)
        val imageView_LakeLouise = findViewById<ImageView>(R.id.ivLakeLouise)
        val imageView_Edmonton = findViewById<ImageView>(R.id.ivEdmonton)

        val imageViewURLS = arrayOf (imageView, imageView_LakeLouise,
        imageView_Edmonton)

        // Declaring executor to parse the URL
        val executor = Executors.newSingleThreadExecutor()

        // Once the executor parses the URL
        // and receives the image, handler will load it
        // in the ImageView
        val handler = Handler(Looper.getMainLooper())

        // Initializing the image
        var image: Bitmap? = null

        // Only for Background process (can take time depending on the Internet speed)
        executor.execute {

            // Tries to get the image and post it in the ImageView
            // with the help of Handler

            for (item in imageURLS.indices) {

                try {
                    val `in` = java.net.URL(imageURLS[item]).openStream()
                    image = BitmapFactory.decodeStream(`in`)

                    // Only for making changes in UI
                    handler.post {
                        imageViewURLS[item].setImageBitmap(image)
                    }
                }

                // If the URL doesnot point to
                // image or any other kind of failure
                catch (e: Exception) {
                    e.printStackTrace()
                }

            }
        }
    }
}