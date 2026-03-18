package com.example.laboratorio1

import org.junit.Test

class ejerciciosLaboratorio(){

    class Computadora(var OS: String,
                      var ram: Int,
                      var memoria: Int,
                      var procesador: String){
        val encendida: Boolean = true
        var programasInstalados = mutableListOf<String>()
        fun encender(){
            if (encendida == true){
                println("Computadora encendiendo")
            }else{
                println("computadora apagada")
            }

        }

        fun updateRam(actualizarRam:Int){
            ram = actualizarRam
            println("Ahora tenes $actualizarRam gb de Ram")
        }

        fun updateMemoria(nuevaMemoria:Int){
            memoria = nuevaMemoria
            println("Cambiaste $nuevaMemoria ahora sos mas pro")
        }

        fun updateOS(nuevoOs: String){
            OS = nuevoOs
            println("Cambiaste tu sistema por $nuevoOs ahora sos mas pro")
        }

        fun updateProcesador(procesadorPro:String){
            procesador = procesadorPro
            println("Cambiaste tu procesador por $procesadorPro ahora sos mas pro")
        }

        fun instalarPrograma(nombrePrograma: String) {
            programasInstalados.add(nombrePrograma)
            println("Instalado: $nombrePrograma")
        }

        fun obtenerProgramas(): MutableList<String> {
            val programasEncontrados = mutableListOf<String>()
            val anioBuscado = "2026"

            for (programa in programasInstalados) {
                if (programa.contains(anioBuscado)) {
                    programasEncontrados.add(programa)
                }
            }
            return programasEncontrados
        }
        fun mostrarEspecificaciones() {
            println("Su computadora actual tiene:")
            println("Procesador: $procesador")
            println("RAM: $ram GB")
            println("Almacenamiento: $memoria GB")
            println("Sistema Operativo: $OS")
        }



    }

    class Calculadora(val marca: String,
                      val yearsVida: Int,
                      val precio: Double){
        fun sumar(numero1: Double, numero2: Double): Double {
            return numero1 + numero2
        }

        fun restar(numero1: Double, numero2: Double): Double {
            return numero1 - numero2
        }

        fun multiplicar(numero1: Double, numero2: Double): Double {
            return numero1 * numero2
        }

        fun dividir(numero1: Double, numero2: Double): Double {
            if (numero2 == 0.0) {
                println("No se puede dividir entre cero.")
                return 0.0
            } else {
                return numero1 / numero2
            }
        }
        fun mostrarInformacion() {
            println("Calculadora $marca")
            println("Vida útil: $yearsVida años")
            println("Precio de venta: $$precio")

        }

    }
    class Estudiante(
        val nombre: String,
        val carnet: Int,
        val asignatura: String
    ) {
        fun mostrarDatos(){
            println("El nombre del estudiante es: $nombre")
            println("El carnet del estudiante es: $carnet")
        }
    }
    fun buscarPorMateria(listaEstudiantes: List<Estudiante>, materiaBuscada: String) {
        println("Buscando inscritos en: $materiaBuscada")
        var encontrados = 0

        for (estudiante in listaEstudiantes) {
            if (estudiante.asignatura == materiaBuscada) {
                estudiante.mostrarDatos()
                encontrados++
            }
        }
        println("Total de estudiantes encontrados: $encontrados\n")
    }



    @Test
    fun probarCompu(){
        val miPC = Computadora("Ryzen 5", 8, 256, "Windows 11")


        miPC.encender()
        miPC.mostrarEspecificaciones()
        miPC.updateRam(16)
        miPC.instalarPrograma("Word 2026")
        miPC.instalarPrograma("JuegoViejito 2015")
        miPC.instalarPrograma("Excel 2026")
        miPC.instalarPrograma("explorer 1543")

        val resultado = miPC.obtenerProgramas()
        for (programa in resultado) {
            println("- $programa")
        }
    }

    @Test
    fun probarCalcu(){
        val miCalculadora = Calculadora("Casio", 10, 15.99)
        miCalculadora.mostrarInformacion()

        val resultadoSuma = miCalculadora.sumar(10.5, 5.0)
        println("El resultado de la suma es: $resultadoSuma")

        val resultadoMultiplicacion = miCalculadora.multiplicar(3.0, 4.0)
        println("El resultado de la multiplicación es: $resultadoMultiplicacion")

        val resultadoDivision = miCalculadora.dividir(15.0, 3.0)
        println("El resultado de la división es: $resultadoDivision")

    }

    @Test
    fun pasarLista(){
        val est1 = Estudiante("Mariano López", 202601, "Programación de Dispositivos Móviles")
        val est2 = Estudiante("Marian López", 202602, "Programación de Dispositivos Móviles")
        val est3 = Estudiante("Marito López", 202603, "Programación de Dispositivos Móviles")
        val est4 = Estudiante("María López", 202604, "Análisis Numérico")
        val est5 = Estudiante("Marío López", 202605, "Análisis Numérico")
        val est6 = Estudiante("Don López", 202606, "Análisis Numérico")
        val est7 = Estudiante("Dona López", 202607, "Análisis Numérico")

        val ciclo01 = listOf(est1, est2, est3, est4,est5, est6,est7)

        buscarPorMateria(ciclo01, "Programación de Dispositivos Móviles")

    }
}