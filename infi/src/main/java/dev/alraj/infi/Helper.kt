package dev.alraj.infi

import java.lang.Exception

fun <T> infiOf(vararg elements: T): Infi<T> = Infi(elements.toList())
fun <T> infoOf(elements: List<T>): Infi<T> = Infi(elements)

fun <T> mutableInfiOf(vararg elements: T): MutableInfi<T> = MutableInfi(elements.toMutableList())
fun <T> mutableInfiOf(elements: List<T>): MutableInfi<T> = MutableInfi(elements.toMutableList())

class TooFewElementsException : Exception {
    constructor(size: Int) : super("Too few elements to infi $size")
    constructor(msg: String) : super(msg)
}
