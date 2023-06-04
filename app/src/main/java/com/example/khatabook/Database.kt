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

    fun getTransaction(): ArrayList<TransModal> {
        var transList = ArrayList<TransModal>()
        var db = readableDatabase
        var sql = "SELECT * FROM $TABLE_NAME"
        var cursor = db.rawQuery(sql,null)
        cursor.moveToFirst()
        for (i in 0 .. cursor.count-1){

            var id = cursor.getInt(0)
            var amt = cursor.getInt(1)
            var category = cursor.getString(2)
            var note = cursor.getString(3)
            var extra = cursor.getString(4)
            var isExpenses = cursor.getInt(5)
            var modal = TransModal(id, amt, category, note, extra, isExpenses)
            transList.add(modal)
            cursor.moveToNext()

        }
        return transList
    }
}