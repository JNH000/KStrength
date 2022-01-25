package system

class KPasswordManager {

    companion object{
        internal var MIN_LENGTH = 7
        internal var MAX_LENGTH = 16
        internal var REQ_SYMBOLS = true
        internal var REQ_NUMBERs = true
        internal var REQ_LOWERCASE = true
        internal var REQ_UPPERCASE = true
    }

    fun checkPassword(password: String) : Int{
        var curScore = 0
        var checkSymbols = false
        var checkNumbers = false
        var checkLowercase = false
        var checkUppercase = false

        for(i in 0 until password.length){
            val c = password[i]

            //If the character is not a letter or a digit, we found a special char / symbol
            if(!checkSymbols && !Character.isLetterOrDigit(c)){
                curScore += 1
                checkSymbols = true
            }
            else{
                //If the character is a number / digit
                if(!checkNumbers && Character.isDigit(c)){
                    curScore += 1
                    checkNumbers = true
                }
                else{
                    //If the character is a Uppercase or a Lowercase Letter
                    if(!checkUppercase || !checkLowercase){
                        if(Character.isUpperCase(c))
                            checkUppercase = true
                        else
                            checkLowercase = true
                        if(checkUppercase && checkLowercase)
                            curScore += 1
                    }
                }
            }
        }

        //Conditions for medium strength are met
        if(password.length > MIN_LENGTH){
            if(REQ_SYMBOLS && !checkSymbols || REQ_UPPERCASE && !checkUppercase
                || REQ_LOWERCASE && !checkLowercase || REQ_NUMBERs && !checkNumbers){
                curScore = 1
            }
            //Conditions for Strong & Extreme are met
            else{
                curScore = 2
                if(password.length > MAX_LENGTH){
                    curScore = 3
                }
            }
        }
        //Conditions for Weak are met
        else{
            curScore = 0
        }
        return curScore
    }


}