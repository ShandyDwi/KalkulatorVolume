package com.example.volumemodul

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*

class Biodata : AppCompatActivity(), View.OnClickListener{
    lateinit var etTanggal: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biodata)

        val btnSimpan:Button = findViewById(R.id.btn_submit)
        btnSimpan.setOnClickListener(this)

        etTanggal = findViewById(R.id.edt_date)
        etTanggal.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val DatePickerDialog = DatePickerDialog(

                this,
                {view, year, monthOfYear, dayOfMonth ->

                    val dat = (dayOfMonth.toString() + "-" +
                            (monthOfYear + 1) + "-" + year)
                    etTanggal.setText(dat)
                },

                year,
                month,
                day
            )

            DatePickerDialog.show()
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_submit ->{
                val etNamaDepan : EditText = findViewById(R.id.edt_namaDepan)
                val etNamaBelakang : EditText = findViewById(R.id.edt_namaBelakang)
                val etTanggal : EditText = findViewById(R.id.edt_date)
                val etAlamat: EditText = findViewById(R.id.edt_alamat)
                val etNomor : EditText = findViewById(R.id.edt_phone)
                val result: TextView = findViewById(R.id.tv_result)

                var textOut = ("""Result
                    |Nama Lengkap : ${etNamaDepan.getText()} ${etNamaBelakang.getText()} 
                    |Tanggal Lahir : ${etTanggal.getText()} 
                    |Alamat : ${etAlamat.getText()} 
                    |Telepon : ${etNomor.getText()}""".trimMargin())
                result.text = textOut
            }
        }

    }
}