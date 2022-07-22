package sam.lambton.tourguidesv20

import android.app.DatePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*


class CustomCreateActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private var spinnerItem: String? = null
    private var tvSelectedDate : EditText? = null
    private var etStartDate: EditText? = null
    private var etEndDate: EditText? = null

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_create)

        tvSelectedDate = findViewById(R.id.etStartDate)

        // Date Picker variables
        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)

        etStartDate = findViewById(R.id.etStartDate)
        etStartDate?.setOnClickListener {
            clickDatePicker(etStartDate)
        }

        etEndDate = findViewById(R.id.etEndDate)
        etEndDate?.setOnClickListener {
            clickDatePicker(etEndDate)
        }

        val spinnerSource: Spinner = findViewById(R.id.sourceType)
        spinnerSource.onItemSelectedListener = this
        ArrayAdapter.createFromResource(
            this,
            R.array.source_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerSource.adapter = adapter
        }

        val spinnerDestination: Spinner = findViewById(R.id.destinationType)
        spinnerDestination.onItemSelectedListener = this
        ArrayAdapter.createFromResource(
            this,
            R.array.destination_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerDestination.adapter = adapter
        }

        val spinnerAirlines: Spinner = findViewById(R.id.spinnerAirlines)
        spinnerAirlines.onItemSelectedListener = this
        ArrayAdapter.createFromResource(
            this,
            R.array.airlines_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerAirlines.adapter = adapter
        }

        val spinnerHotels: Spinner = findViewById(R.id.spinnerHotels)
        spinnerHotels.onItemSelectedListener = this
        ArrayAdapter.createFromResource(
            this,
            R.array.hotels_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerHotels.adapter = adapter
        }

        val btnCreatePackage : Button = findViewById(R.id.BtnCreatePackage)
        btnCreatePackage.setOnClickListener {

            // Create intent to See all custom packages

            val intent = Intent(this, CustomSeeAllPackagesActivity::class.java)
            val etPackageName : String = (findViewById<EditText>(R.id.etPackageName).text).toString()
            val etPackageDescription: String = (findViewById<EditText>(R.id.etPackageDescription).text).toString()
            val source : String = (spinnerSource.selectedItem).toString()
            val destination : String = (spinnerDestination.selectedItem).toString()
            val airline : String = (spinnerAirlines.selectedItem).toString()
            val hotel : String = (spinnerHotels.selectedItem).toString()
            val startDate : String = (etStartDate?.text).toString()
            val endDate : String = (etEndDate?.text).toString()

            intent.putExtra("activity", "CustomCreateActivity")
            intent.putExtra("packageName", etPackageName)
            intent.putExtra("packageDescription", etPackageDescription)
            intent.putExtra("source", source)
            intent.putExtra("destination", destination)
            intent.putExtra("airlines", airline)
            intent.putExtra("hotels", hotel)
            intent.putExtra("startDate", startDate)
            intent.putExtra("endDate", endDate)

            /* Persist to database */
            val databaseHelper: DatabaseHelper = DatabaseHelper(this)

            val packageModel: PackageModel = PackageModel(-1, etPackageName, etPackageDescription, source, destination, airline, hotel, startDate, endDate)

            if(databaseHelper.addPackage(packageModel)){
                Toast.makeText(this, "Data Insertion successful", Toast.LENGTH_LONG).show()
                Toast.makeText(this, "Total rows is ${databaseHelper.howManyPackages()}", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Data Insertion failed", Toast.LENGTH_LONG).show()
                Toast.makeText(this, "Total rows is ${databaseHelper.howManyPackages()}", Toast.LENGTH_LONG).show()
            }

            intent.putExtra("ROWS", databaseHelper.howManyPackages())
            startActivity(intent)

        }

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        spinnerItem = parent!!.getItemAtPosition(position).toString()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun clickDatePicker(etDate: EditText?){

        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(this,
            { _, selectedYear, selectedMonth, selectedDayOfMonth ->

                val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/${selectedYear}"

                //tvSelectedDate?.text = selectedDate

                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                val theDate = sdf.parse(selectedDate)

                theDate?.let {

                    val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

                    currentDate?.let {
                        //Toast.makeText(this, sdf.format(SimpleDateFormat("dd/MM/yyyy").parse(selectedDate)).toString() , Toast.LENGTH_SHORT).show()
                        etDate?.setText(sdf.format(SimpleDateFormat("dd/MM/yyyy").parse(selectedDate)).toString(), TextView.BufferType.EDITABLE);
                    }
                }

            },
            year,
            month,
            day
        )
        dpd.datePicker.minDate = System.currentTimeMillis()
        dpd.show()
    }
}

/* Code that generates a view iteratively and fixes in into a layout using layout inflation *//*
            var cardView : View
            var llCustomCards: LinearLayout = findViewById(R.id.llCustomCreate)
            var tvChange : TextView

            for (i in 1..3) {
                cardView = LayoutInflater.from(this).inflate(R.layout.cardview, null)
                tvChange = cardView.findViewById(R.id.tvCustomCardTitle)

                tvChange.text = "Custom package $i"

                llCustomCards.addView(cardView)
            }*/

