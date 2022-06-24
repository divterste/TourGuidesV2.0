package sam.lambton.tourguidesv20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogin : Button = findViewById(R.id.login)
        val etEmail: EditText? = findViewById(R.id.email)
        val etPassword: EditText? = findViewById(R.id.password)
        btnLogin.setOnClickListener {
            val databaseHelper: DatabaseHelper = DatabaseHelper(this)
            val signUpModel: SignUpModel =
                SignUpModel(-1, etEmail?.text.toString(), "", etPassword?.text.toString())

            if(databaseHelper.loginValidation(signUpModel)){
                val intent = Intent(applicationContext, IndexActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Username/Password Invalid", Toast.LENGTH_SHORT).show()
            }
        }
    }
}