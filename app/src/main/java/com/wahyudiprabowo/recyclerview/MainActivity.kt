package com.wahyudiprabowo.recyclerview

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.wahyudiprabowo.recyclerview.adapter.AdapterTeamBola
import com.wahyudiprabowo.recyclerview.databinding.ActivityMainBinding
import com.wahyudiprabowo.recyclerview.model.Pemain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listPemain = ArrayList<Pemain>()
        listPemain.add(Pemain("Lionel Messi",R.drawable.messi, "Penyerang", "1.68 m","Rosario(Argentina)","24 Juni 1987"))
        listPemain.add(Pemain("Keylor Navas",R.drawable.navas, "Penjaga Gawang", "1.85 m","Perez Zeledon (Costa Rica)","15 Desember 1986"))
        listPemain.add(Pemain("Neymar",R.drawable.neymar, "Penyerang", "1.75 m","Mogi das Cruzes (Brazil)","5 Februari 1992"))
        listPemain.add(Pemain("Mauricio Pochettino",R.drawable.pochettino, "Pelatih", "1.82 m","Murphy (Agentina)","2 Maret 1972"))
        listPemain.add(Pemain("Sergio Ramos",R.drawable.ramos, "Belakang", "1.84 m","Camas (Spanyol)","30 Maret 1986"))

        binding.list.adapter = AdapterTeamBola( this,listPemain, object  : AdapterTeamBola.OnClickListener {
            override fun detailData(item: Pemain?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_pemain)

                    val image = this.findViewById<ImageView>(R.id.image_pemain)
                    val nama = this.findViewById<TextView>(R.id.txt_namapemain)
                    val posisi = this.findViewById<TextView>(R.id.txt_posisi)
                    val tinggi = this.findViewById<TextView>(R.id.txt_tinggibadan)
                    val tempatlahir = this.findViewById<TextView>(R.id.txt_tempatlahir)
                    val tgllahir = this.findViewById<TextView>(R.id.txt_tanggallahir)
                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"
                    posisi.text = "${item?.posisi}"
                    tinggi.text = "${item?.tinggi}"
                    tempatlahir.text = "${item?.tempatlahir}"
                    tgllahir.text = "${item?.tgllahir}"

                    btn.setOnClickListener{
                        this.dismiss()
                    }
                }.show()
            }


        })


        }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode : Int) {
        when (selectedMode) {
            R.id.myprofile -> {
                val intent = Intent(this,Profile::class.java)
                startActivity(intent)
            }
        }
    }

    }
