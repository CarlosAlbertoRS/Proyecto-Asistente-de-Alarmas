package com.example.proyasyst_test

class listaDatos {
    companion object{
        val ListaSuperHeroes = listOf<variables>(
            variables(
                "Paracetamol",
                "10/10/2023",
                "Periodo administrada: 7 dias",
                "Periodo total: 27 dias",
                "Activo",
                "Tipo de alarma: Básico"
            ),
            variables(
                "Desenfrailo",
                "10/10/2023",
                "Periodo administrada: 3 dias",
                "Periodo total: 27 dias",
                "Desactivada",
                "Tipo de alarma: Estricto"
            ),
            variables(
                "Diazepam",
                "10/10/2023",
                "Periodo administrada: 27 dias",
                "Periodo total: 27 dias",
                "Finalizado",
                "Tipo de alarma: Básico"
            )
        )
    }
}