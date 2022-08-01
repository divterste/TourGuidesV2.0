package sam.lambton.tourguidesv20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView


class ProfileActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val btnprofile : TextView = findViewById(R.id.btnProfile)
        btnprofile.setOnClickListener {
            val intent = Intent(applicationContext, AdminActivity::class.java)
            startActivity(intent)
        }

        val profilespinner: Spinner = findViewById(R.id.triptype)
        profilespinner.onItemSelectedListener = this
        ArrayAdapter.createFromResource(
            this,
            R.array.users_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            profilespinner.adapter = adapter
        }

        val premimumspinner: Spinner = findViewById(R.id.premimummeber)
        premimumspinner.onItemSelectedListener = this
        ArrayAdapter.createFromResource(
            this,
            R.array.premium_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            premimumspinner.adapter = adapter
        }


    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var spinnerItem = parent!!.getItemAtPosition(position).toString()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}