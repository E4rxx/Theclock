package rgtec.rgtec

class clockmenu {
    val clockMain = mainclock()

    fun printMenu() {
        Thread.sleep(1000)
        println("Opciones disponibles:")
        println("1: Establecer hora      2:Reloj")
        println("3: Reloj (hora real)    4:Temporizador")
        println("5: Alarma               6:Mostrar reloj")
        println("7: Restablecer reloj    0: Salir")
        //Menú
    }
    fun inputIntMenu(x:Int): Int {
        var numtypin: Int?
        do {
            numtypin = readln().toIntOrNull()
            if (numtypin == null) {
                println("Solo se adminten números enteros")
            }
        } while (numtypin == null)
        return numtypin
        //Entrada de números
    }
    fun selectOption() {
        val clockMain = mainclock()
        var exitmenu = false
        do {
            printMenu()
            println("Indique la opción:")
            var menuselection = inputIntMenu(1)
            when (menuselection) {

                1 -> clockMain.setClock()
                2 -> clockMain.clockAdvance()
                3 -> clockMain.displayClockReal()
                4 -> {
                    clockMain.setClock()
                    clockMain.clockTimer()
                }
                5 -> {
                    clockMain.setAlarm()
                }
                6 -> clockMain.displayClock()
                7 -> clockMain.resetClock()
                8 -> clockMain.setTimeLimitAdvance()
                9 -> clockMain.alarmSetOff()
                0 -> {
                    exitmenu = true
                    println("A tomar por culo")
                }
                else -> println("Opción no válida")
            }
        } while (!exitmenu)
    }
    //Selección de opciones
}