package sam.lambton.tourguidesv20

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "TGuidesDatabase2"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE SIGNUP(ID INTEGER PRIMARY KEY AUTOINCREMENT, EMAIL TEXT, USER_TYPE TEXT, PASSWORD TEXT)")
        db?.execSQL("CREATE TABLE PACKAGE(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, DESCRIPTION TEXT, SOURCE TEXT, DESTINATION TEXT, AIRLINE TEXT, HOTEL TEXT, START_DATE TEXT, END_DATE TEXT)")
    }

    fun addPackage(packageModel: PackageModel): Boolean {
        val dbWrite : SQLiteDatabase = this.writableDatabase
        val cv = ContentValues()

        cv.put("NAME", packageModel.packageName)
        cv.put("DESCRIPTION", packageModel.packageDescription)
        cv.put("SOURCE", packageModel.source)
        cv.put("DESTINATION", packageModel.destination)
        cv.put("AIRLINE", packageModel.airline)
        cv.put("HOTEL", packageModel.hotel)
        cv.put("START_DATE", packageModel.startDate)
        cv.put("END_DATE", packageModel.endDate)

        val insert: Long = dbWrite.insert("PACKAGE", null, cv)
        return insert != -1L
    }

    fun getPackageWithTag(tagGiven: String): String {
        val dbRead : SQLiteDatabase = this.readableDatabase
        val cursor : Cursor = dbRead.rawQuery("SELECT * FROM PACKAGE WHERE NAME=?",
            arrayOf(tagGiven)
        )

        return if(cursor.moveToFirst()) {
            cursor.getString(3)
        } else {
            "Error"
        }

    }

    fun howManyPackages(): Int {

        val dbRead : SQLiteDatabase = this.readableDatabase
        val cursor : Cursor = dbRead.rawQuery("SELECT * FROM PACKAGE", null)
        var count : Int = 0

        if(cursor.moveToFirst()) {
            do {
                count++
            } while (cursor.moveToNext())
        }

        return count
    }

    fun getAllPackages(): List<PackageModel> {
        val dbRead : SQLiteDatabase = this.readableDatabase
        val cursor : Cursor = dbRead.rawQuery("SELECT * FROM PACKAGE", null)

        val packageModelList = mutableListOf<PackageModel>()

        if(cursor.moveToFirst()) {
            do {
                // Insert all the package objects to an arraylist and then iterate through the arraylist
                val packageModel : PackageModel = PackageModel(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                cursor.getString(3), cursor.getString(4), cursor.getString(5),
                cursor.getString(6), cursor.getString(7), cursor.getString(8))

                packageModelList.add(packageModel)
            } while(cursor.moveToNext())
        }

        return packageModelList
    }

    fun addSignUp(signUpModel: SignUpModel): Boolean {
        // Check if user exists already
        val dbRead : SQLiteDatabase = this.readableDatabase
        val cursor: Cursor = dbRead.rawQuery("SELECT * FROM SIGNUP", null)

        if(cursor.moveToFirst()) {
            do {
                val email: String = cursor.getString(1)

                if(email == signUpModel.email)
                {
                    cursor.close()
                    return false
                }
            } while (cursor.moveToNext())
        }

        val dbWrite : SQLiteDatabase = this.writableDatabase
        val cv = ContentValues()

        cv.put("EMAIL", signUpModel.email)
        cv.put("USER_TYPE", signUpModel.userType)
        cv.put("PASSWORD", signUpModel.password)

        val insert: Long = dbWrite.insert("SIGNUP", null, cv)
        return insert != -1L
    }

    fun loginValidation(signUpModel: SignUpModel): Boolean{
        val dbRead : SQLiteDatabase = this.readableDatabase
        val cursor: Cursor = dbRead.rawQuery("SELECT * FROM SIGNUP", null)

        if(cursor.moveToFirst()) {
            do {
                val email: String = cursor.getString(1)
                val password: String = cursor.getString(3)

                if((email == signUpModel.email) and (password == signUpModel.password))
                {
                    cursor.close()
                    return true
                }
            } while (cursor.moveToNext())
        }
        return false
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}