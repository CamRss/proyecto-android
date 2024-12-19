package com.example.sistema1151.datos

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DatosCaja (context: Context): SQLiteOpenHelper(context, "misgastos.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE movimientos(" +
                "idmovimiento INTEGER PRIMARY KEY AUTOINCREMENT," +
                "fecha DATETIME DEFAULT CURRENT_TIMESTAMP," +
                "descripcion TEXT," +
                "monto FLOAT," +
                "tipo INTEGER" +
                ")")
    }

    fun registrarMovimientos(datosCaja: DatosCaja, descripcion: String, monto: Float, tipo: Int){
        val db = datosCaja.writableDatabase
        //db.execSQL("INSERT INTO ...")
        val values = ContentValues().apply {
            put("descripcion", descripcion)
            put("monto", monto)
            put("tipo", tipo)
        }
        db.insert("movimientos", null, values)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

}