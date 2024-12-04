package rgtec.rgtec

data class ClockData(
    var seconds: Int = -1,
    var minutes: Int = -1,
    var hours: Int = -1,
    var secondsAlarm: Int = 0,
    var minutesAlarm: Int = 0,
    var hoursAlarm: Int = 0,
    var timeLimitAdvance: Int = 1
    //Clase de datos del reloj
)