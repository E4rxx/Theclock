package rgtec.rgtec
import java.time.LocalDateTime


class mainclock {
    val clockdata = ClockData()
    fun setClock() {
        clockdata.seconds = setSeconds()
        clockdata.minutes = setMinutes()
        clockdata.hours = setHours()
        displayClock()
        //Establecer hora
    }
    fun resetClock() {
        clockdata.seconds = -1
        clockdata.minutes = -1
        clockdata.hours = -1
        println("Reloj restablecido")
        //Reestablecer hora
    }
    fun setAlarm() {
        if (clockdata.seconds == -1 || clockdata.minutes == -1 || clockdata.hours == -1) {
            println("Primero establece la hora")
        } else {
            clockdata.secondsAlarm = setSecondsAlarm()
            clockdata.minutesAlarm = setMinutesAlarm()
            clockdata.hoursAlarm = setHoursAlarm()
            displayAlarmClock()
        }
        //Establecer alarma
    }
    fun clockAdvance () {
        while (clockdata.hours != 24 && clockdata.seconds != -1 && clockdata.minutes != -1 && clockdata.hours != -1) {
            if (clockdata.seconds == -1 || clockdata.minutes == -1 || clockdata.hours == -1) {
                println("Debes establecer la hora antes")
                break
            }
            clockdata.seconds++
            Thread.sleep(1000)
            if (clockdata.seconds == 60) {
                clockdata.minutes++
                clockdata.seconds = 0
            }
            if (clockdata.minutes == 60) {
                clockdata.hours++
                clockdata.minutes = 0
            }
            if (clockdata.seconds == clockdata.secondsAlarm && clockdata.minutes == clockdata.minutesAlarm && clockdata.hours == clockdata.hoursAlarm) {
                alarmSetOff()
                break
            }
            if (clockdata.minutes == clockdata.timeLimitAdvance) {
                break
            }
            clearConsole()
            displayClockSimple()
        }
        //Avanzar reloj
    }
    fun clockReversee() {
        while (clockdata.seconds > 0 || clockdata.minutes > 0 || clockdata.hours > 0) {
            clockdata.seconds--
            Thread.sleep(1000)
            if (clockdata.seconds < 0 && clockdata.minutes > 0) {
                clockdata.minutes--
                clockdata.seconds = 59
            }
            if (clockdata.minutes < 0 && clockdata.hours > 0) {
                clockdata.hours--
                clockdata.minutes = 59
            }
            clearConsole()
            displayClockSimple()
        }
        //Retroceder reloj
    }
    fun displayClockReal() {
        val CurrentTime = LocalDateTime.now()
        clockdata.seconds = CurrentTime.second
        clockdata.minutes = CurrentTime.minute
        clockdata.hours = CurrentTime.hour
        var timelimitclockreal = CurrentTime.minute + clockdata.timeLimitAdvance
        while (clockdata.hours != 24) {
            clockdata.seconds++
            Thread.sleep(1000)
            if (clockdata.seconds == 60) {
                clockdata.minutes++
                clockdata.seconds = 0
            }
            if (clockdata.minutes == 60) {
                clockdata.hours++
                clockdata.minutes = 0
            }
            if (clockdata.minutes == timelimitclockreal) {
                break
            }
            clearConsole()
            displayClockSimple()
        }
        //Reloj en tiempo real
    }
    fun alarmSetOff() {
        return repeat(3) {
            println("RING!")
            println("     RING!")
            println("          RING!")
            Thread.sleep(800)
        }
        //Alarma
    }
    fun clockTimer () {
        var exittimer = false
        clockReversee()
        if (clockdata.seconds == 0 && clockdata.minutes == 0 && clockdata.hours == 0) {
            alarmSetOff()
            exittimer = true
        }
        //Temporizador
    }
    fun displayClockSimple() {
        val secondsdisplay = String.format("%02d", clockdata.seconds)
        val minutesdisplay = String.format("%02d", clockdata.minutes)
        val hoursdisplay = String.format("%02d", clockdata.hours)
        println("$hoursdisplay:$minutesdisplay:$secondsdisplay")
        //Mostrar reloj simple
    }
    fun displayClock() {
        val secondsdisplay = String.format("%02d", clockdata.seconds)
        val minutesdisplay = String.format("%02d", clockdata.minutes)
        val hoursdisplay = String.format("%02d", clockdata.hours)
        var message = ""
        if (clockdata.seconds == -1 || clockdata.minutes == -1 || clockdata.hours == -1) {
                message = "El reloj aún no se ha establecido"
            } else {
                message = "El reloj esta establecido en $hoursdisplay:$minutesdisplay:$secondsdisplay"
        }
        return println("$message")
        //Mostrar reloj
    }
    fun displayAlarmClock() {
        val secondsdisplay = String.format("%02d", clockdata.secondsAlarm)
        val minutesdisplay = String.format("%02d", clockdata.minutesAlarm)
        val hoursdisplay = String.format("%02d", clockdata.hoursAlarm)
        return println("La alarma esta establecida en $hoursdisplay:$minutesdisplay:$secondsdisplay")
        //Mostrar alarma
    }
    private fun inputIntClock(x:Int): Int {
        var numtypin: Int?
        do {
            numtypin = readln().toIntOrNull()
            if (numtypin == null) {
                println("Solo se adminten números enteros")
            }
        } while (numtypin == null)
        return numtypin
        //Introducir número
    }
    private fun setSeconds(): Int {
        println("Introduce la cantidad de segundos")
        do {
            clockdata.seconds = inputIntClock(1)
            if (clockdata.seconds < 0 || clockdata.seconds > 59) {
                println("Segundos no correctos")
            }
        } while (clockdata.seconds < 0 || clockdata.seconds > 59)
        println("Segundos introducidos: ${clockdata.seconds}")
        return clockdata.seconds
        //Establecer segundos
    }
    fun setSecondsAlarm(): Int {
        println("Introduce la cantidad de segundos")
        do {
            clockdata.secondsAlarm = clockdata.seconds + inputIntClock(1)
            if (clockdata.secondsAlarm < 0 || clockdata.secondsAlarm > 59) {
                println("Segundos no correctos")
            }
        } while (clockdata.secondsAlarm < 0 || clockdata.secondsAlarm > 59)
        println("Segundos introducidos: ${clockdata.secondsAlarm}")
        return clockdata.secondsAlarm
        //Establecer segundos de alarma
    }
    private fun setMinutes(): Int {
        println("Introduce la cantidad de minutos")
        do {
            clockdata.minutes = inputIntClock(2)
            if (clockdata.minutes < 0 || clockdata.minutes > 59) {
                println("Segundos no correctos")
            }
        } while (clockdata.minutes < 0 || clockdata.minutes > 59)
        println("Segundos introducidos: ${clockdata.minutes}")
        return clockdata.minutes
        //Establecer minutos
    }
    fun setMinutesAlarm(): Int {
        println("Introduce la cantidad de minutos")
        do {
            clockdata.minutesAlarm = clockdata.minutes + inputIntClock(2)
            if (clockdata.minutesAlarm < 0 || clockdata.minutesAlarm > 59) {
                println("Segundos no correctos")
            }
        } while (clockdata.minutesAlarm < 0 || clockdata.minutesAlarm > 59)
        println("Segundos introducidos: ${clockdata.minutesAlarm}")
        return clockdata.minutesAlarm
        //Establecer minutos de alarma
    }
    fun setTimeLimitAdvance(): Int {
        do {
            clockdata.timeLimitAdvance = clockdata.minutes + inputIntClock(2)
            if (clockdata.timeLimitAdvance < 0 || clockdata.timeLimitAdvance > 59) {
                println("")
            }
        } while (clockdata.timeLimitAdvance < 0 || clockdata.timeLimitAdvance > 59)
        return clockdata.timeLimitAdvance
        //Establecer limite de avance
    }
    private fun setHours(): Int {
        println("Introduce la cantidad de horas")
        do {
            clockdata.hours = inputIntClock(2)
            if (clockdata.hours < 0 || clockdata.hours > 23) {
                println("Segundos no correctos")
            }
        } while (clockdata.hours < 0 || clockdata.hours > 23)
        println("Segundos introducidos: ${clockdata.hours}")
        return clockdata.hours
        //Establecer horas
    }
    fun setHoursAlarm(): Int {
        println("Introduce la cantidad de horas")
        do {
            clockdata.hoursAlarm = inputIntClock(2)
            if (clockdata.hoursAlarm < 0 || clockdata.hoursAlarm > 23) {
                println("Segundos no correctos")
            }
        } while (clockdata.hoursAlarm < 0 || clockdata.hoursAlarm > 23)
        println("Segundos introducidos: ${clockdata.hoursAlarm}")
        return clockdata.hoursAlarm
        //Establecer horas de alarma
    }
}
fun clearConsole() {
    repeat(100) {
        println() }
    //Limpiar consola
}
