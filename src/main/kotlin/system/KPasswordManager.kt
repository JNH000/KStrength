package system

class KPasswordManager {

    val lowercase : String = "abcdefghijklmnopqrstuvwxyz"
    val uppercase : String = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val number : String = "1234567890"
    val symbols : String = "@!#=£%$&?+"
    val maxPLength : Float = 50f
    val maxPStrength : Float = 20.5F

    fun checkPassword(password: String) : Float{
        var pStrength = 0
        var pLength = password.length

        if(password.matches(Regex(".*["+this.lowercase+"].*")))
            pStrength += 2
        if(password.matches(Regex(".*["+this.uppercase+"].*")))
            pStrength += 2
        if(password.matches(Regex(".*["+this.number+"].*")))
            pStrength += 1
        if(password.matches(Regex(".*["+this.symbols+"].*")))
            pStrength += 5

        return(pStrength * pLength) / (maxPStrength * maxPLength)
    }

}