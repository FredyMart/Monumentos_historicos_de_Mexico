package com.example.monumentos_historicos_de_mexico.data

import com.example.monumentos_historicos_de_mexico.R
import com.example.monumentos_historicos_de_mexico.model.Monumentos

class Datasource {
    fun cargaMonumentos(): List<Monumentos>{
        return listOf<Monumentos>(
            Monumentos(R.string.monumento1, R.drawable.angel_independencia),
            Monumentos(R.string.monumento2, R.drawable.castillo_chapultepec_4),
            Monumentos(R.string.monumento3, R.drawable.catedral_metropolitana),
            Monumentos(R.string.monumento4, R.drawable.chichen_itza),
            Monumentos(R.string.monumento5, R.drawable.basilica_virgen_guadalupe),
            Monumentos(R.string.monumento6, R.drawable.ninos_heroes02),
            Monumentos(R.string.monumento7, R.drawable.mayor),
            Monumentos(R.string.monumento8, R.drawable.bellas_artes),
            Monumentos(R.string.monumento9, R.drawable.frida),
            Monumentos(R.string.monumento10, R.drawable.zocalo)

        )
    }
}