package sam.lambton.tourguidesv20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class AboutUsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)

        val facebook : ImageButton = findViewById(R.id.facebook)
        val twitter : ImageButton = findViewById(R.id.twitter)
        val instagram : ImageButton = findViewById(R.id.instagram)
    }
}