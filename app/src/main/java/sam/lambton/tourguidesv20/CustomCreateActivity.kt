package sam.lambton.tourguidesv20

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.text.Editable
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

        val spinner: Spinner = findViewById(R.id.sourceType)
        spinner.onItemSelectedListener = this
        ArrayAdapter.createFromResource(
            this,
            R.array.source_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
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

