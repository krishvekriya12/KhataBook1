package com.example.khatabook

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.khatabook.Model.TransModal

class Database(
    context: Context?

) : SQLiteOpenHelper(context,"Dharm.db",null,5){
    var TABLE_NAME = "trans"
    var ID = "id"
    var AMT = "amt"
    var CATEGORY = "category"
    var NOTE = "note"
    var EXTRA = "extra"
    var IS_EXPENSES = "isExpenses"

    override fun onCreate(p0: SQLiteDatabase?) {
        var sql = "CREATE TABLE $TABLE_NAME ($ID INTEGER PRIMARY KEY AUTOINCREMENT, $AMT INTEGER, $CATEGORY TEXT, $NOTE TEXT, $EXTRA TEXT, $IS_EXPENSES INTEGER)"

        p0?.execSQL(sql)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
    fun addTrans(transModal: TransModal){
        var db = writableDatabase
        var values = ContentValues().apply {
            transModal.apply {
                put(AMT,amt)
                put(CATEGORY,category)
                put(NOTE,note)
                put(EXTRA,extra)
                put(IS_EXPENSES,isExpenses)

            }
        }

        db.insert(TABLE_NAME,null,values)
    }
}