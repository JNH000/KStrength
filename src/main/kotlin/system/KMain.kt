package system

import ui.JInterface

fun main(args: Array<String>) {
    var pasMan = KPasswordManager()
    val ui = JInterface()
    ui.setText(pasMan.checkPassword("Test3094_W").toFloat());
}