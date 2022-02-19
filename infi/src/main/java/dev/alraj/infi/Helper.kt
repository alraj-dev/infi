package dev.alraj.infi

import java.lang.Exception

fun <T> infiOf(vararg elements: T): Infi<T> = Infi(elements.toList())
fun <T> infiOf(elements: List<T>): Infi<T> = Infi(elements)

fun <T> mutableInfiOf(vararg elements: T): MutableInfi<T> = MutableInfi(elements.toMutableList())
fun <T> mutableInfiOf(elements: List<T>): MutableInfi<T> = MutableInfi(elements.toMutableList())

fun <T> Array<T>.toInfi(): Infi<T> = infiOf(*this)
fun <T> Collection<T>.toInfi(): Infi<T> = infiOf(this.toList())
fun <T> List<T>.toInfi(): Infi<T> = infiOf(this)
fun <T> Sequence<T>.toInfi(): Infi<T> = infiOf(this.toList())

fun <T> Array<T>.toMutableInfi(): MutableInfi<T> = mutableInfiOf(*this)
fun <T> Collection<T>.toMutableInfi(): MutableInfi<T> = mutableInfiOf(this.toMutableList())
fun <T> List<T>.toMutableInfi(): MutableInfi<T> = mutableInfiOf(this.toMutableList())
fun <T> Sequence<T>.toMutableInfi(): MutableInfi<T> = mutableInfiOf(this.toMutableList())
