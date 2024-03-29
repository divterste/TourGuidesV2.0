package sam.lambton.tourguidesv20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val hide = supportActionBar?.hide()

        Handler().postDelayed({
            val intent = Intent(this@MainActivity,SignUpActivity::class.java)
            startActivity(intent)
            finish()
        },3000)
    }
}