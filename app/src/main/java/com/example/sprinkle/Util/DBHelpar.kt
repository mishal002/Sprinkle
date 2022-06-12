package com.example.sprinkle.Util

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf

class DBHelpar(
    context: Context
) : SQLiteOpenHelper(context, "Cake", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {

        val query =
            "CREATE TABLE Student(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,mobile TEXT, pincode TEXT, kg TEXT,other1 TEXT, address TEXT,time TEXT)"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insertData(
        c1: String,
        c2: String,
        c3: String,
        c4: String,
        c5: String,
        c6: String,
        c7: String
    ) {

        val db = writableDatabase
        val cv = contentValuesOf()
        cv.put("name", c1)
        cv.put("mobile", c2)
        cv.put("pincode", c3)
        cv.put("kg", c4)
        cv.put("other1", c5)
        cv.put("address", c6)
        cv.put("time", c7)
        val res = db.insert("Student", null, cv)

        println(res)
    }

    @SuppressLint("Range", "Recycle")
    fun readData(): ArrayList<ModelData> {

        val list = arrayListOf<ModelData>()
        val db = readableDatabase
        val query = "SELECT * FROM Student"

        val cursor = db.rawQuery(query, null)

        if (cursor.moveToFirst()) {

            do {
                val id = cursor.getString(cursor.getColumnIndex("id"))
                val id1 = cursor.getString(cursor.getColumnIndex("id"))
                val name = cursor.getString(cursor.getColumnIndex("name"))
                val mobile = cursor.getString(cursor.getColumnIndex("mobile"))
                val pincode = cursor.getString(cursor.getColumnIndex("pincode"))
                val kg = cursor.getString(cursor.getColumnIndex("kg"))
                val other1 = cursor.getString(cursor.getColumnIndex("other1"))
                val address = cursor.getString(cursor.getColumnIndex("address"))
                val time = cursor.getString(cursor.getColumnIndex("time"))

                val m1 = ModelData(id, name, mobile, pincode, kg, other1, address, time)
                list.add(m1)

            } while (cursor.moveToNext())
        }
        return list
    }

    fun deleteData(id : String )
    {
        var db = writableDatabase

        db.delete("Student","id=$id",null)


    }
}