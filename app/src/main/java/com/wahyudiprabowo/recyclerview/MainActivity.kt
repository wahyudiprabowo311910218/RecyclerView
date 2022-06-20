package com.wahyudiprabowo.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
                TODO("Not yet implemented")
            }


        })


        }
    }
