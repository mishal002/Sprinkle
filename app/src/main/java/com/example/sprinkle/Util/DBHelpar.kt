package com.example.sprinkle.Util

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf

class DBHelpar(
    context: Context,) :
    SQLiteOpenHelper(context,"Cake",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val query ="CREATE TABLE Student(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT)"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
    fun insertData(c1:String)
    {

        val db=writableDatabase
        val cv= contentValuesOf()
        cv.put("name",c1)
        val res =db.insert("student",null,cv)

        println(res)
    }
    @SuppressLint("Range")
    fun readData(): ArrayList<ModelData> {

        val list = arrayListOf<ModelData>()
        val db=readableDatabase
        val query = "SELECT * FROM student"

        val cursor = db.rawQuery(query,null,)

        if(cursor.moveToFirst())
        {

            do{
              val id = cursor.getString(cursor.getColumnIndex("id"))
                val name = cursor.getColumnName(cursor.getColumnIndex("name"))

                val m1= ModelData(id,name)
                list.add(m1)

            }while (cursor.moveToNext())
        }
        return list
    }
}