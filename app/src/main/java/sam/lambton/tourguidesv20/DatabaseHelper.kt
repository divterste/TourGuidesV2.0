package sam.lambton.tourguidesv20

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "TGuidesDatabase1"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE SIGNUP(ID INTEGER PRIMARY KEY AUTOINCREMENT, EMAIL TEXT, USER_TYPE TEXT, PASSWORD TEXT)")
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

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}