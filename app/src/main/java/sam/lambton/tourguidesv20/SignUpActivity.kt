package sam.lambton.tourguidesv20

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class SignUpActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    var spinnerItem: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        //supportActionBar!!.hide()
        val etEmail: EditText? = findViewById(R.id.email)
        val etPassword: EditText? = findViewById(R.id.password)

        val btnSignIn : TextView = findViewById(R.id.gotoSignIn)
        btnSignIn.setOnClickListener {
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
        }

        val spinner: Spinner = findViewById(R.id.selectType)
        spinner.onItemSelectedListener = this
        ArrayAdapter.createFromResource(
            this,
            R.array.users_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        val btnSignUp : Button = findViewById(R.id.signup)
        btnSignUp.setOnClickListener {
            val signUpModel: SignUpModel
            val databaseHelper: DatabaseHelper = DatabaseHelper(this)
            var spinnerItemDB : String = "Error" // Start off with Error value

            if(spinnerItem != null){
                spinnerItemDB = spinnerItem as String
            }

            if(!inputValidation(etEmail?.text, etPassword?.text, spinner.selectedItem.toString())) {
                Toast.makeText(this, "ERROR: Incorrect values", Toast.LENGTH_SHORT).show()
            }
            else {
                signUpModel = SignUpModel(-1, etEmail?.text.toString(), spinnerItemDB, etPassword?.text.toString())
                if(databaseHelper.addSignUp(signUpModel)){
                    Toast.makeText(this, "User added successfully", Toast.LENGTH_SHORT).show()
                }
                else {
                    Toast.makeText(this, "User already exists", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    private fun inputValidation(etEmail: Editable?, etPasswordEdit: Editable?, spinnerItem: String) : Boolean {

        // Email validation
        var emailValidation: Boolean = false
        if(etEmail?.contains('@')?.and((etEmail.contains('.'))) == true){
            if(etEmail[etEmail.length - 1].isLetter() and etEmail[0].isLetter())
                emailValidation = true
        }

        if(!emailValidation){
            //Toast.makeText(this, "Email validation failed", Toast.LENGTH_SHORT).show()
        }

        // Spinner validation
        var spinnerValidation: Boolean = true
        if(spinnerItem == "Select the user type"){
            spinnerValidation = false
            //Toast.makeText(this, "User type validation failed", Toast.LENGTH_SHORT).show()
        }

        // Password validation
        var passwordValidation: Boolean = false
        var oneUpper: Boolean = false
        var oneLower: Boolean = false
        var oneDigit: Boolean = false
        var noChars: Boolean = false

        if(etPasswordEdit != null){
            if(etPasswordEdit.length >= 8){
                noChars = true
            }
            for(i in etPasswordEdit){
                if(i.isUpperCase()){
                    oneUpper = true
                }
                if(i.isLowerCase()){
                    oneLower = true
                }
                if(i.isDigit()){
                    oneDigit = true
                }
            }
            if((oneUpper and oneLower and oneDigit and noChars) == false){
                //Toast.makeText(this, "Password validation failed", Toast.LENGTH_SHORT).show()
            } else {
                passwordValidation = true
            }
        }

        return emailValidation and spinnerValidation and passwordValidation
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        spinnerItem = parent!!.getItemAtPosition(position).toString()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }



}