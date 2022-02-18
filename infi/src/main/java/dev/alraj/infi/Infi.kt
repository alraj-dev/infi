package dev.alraj.infi

import java.lang.IndexOutOfBoundsException
import kotlin.jvm.Throws

open class Infi<E>(private val _elements: List<E>) : List<E> {
    private var currentElementIndex: Int = 0
    private val currentElement: E = _elements[currentElementIndex]

    override val size: Int = _elements.size

    @Throws(TooFewElementsException::class)
    fun index(): Int {
        if(size < 1) throw TooFewElementsException("Cannot get Index, there are no elements")

        return currentElementIndex
    }

    fun element(): E {
        if(size < 1) throw TooFewElementsException("Cannot get Element, there are no elements")

        return currentElement
    }

    @Throws(TooFewElementsException::class)
    fun previous(): E {
        if(size < 2) throw TooFewElementsException(size)

        if(currentElementIndex == 0)
            currentElementIndex = _elements.lastIndex
        else currentElementIndex--

        return currentElement
    }

    @Throws(TooFewElementsException::class)
    fun next(): E {
        if(size < 2) throw TooFewElementsException(size)

        if(currentElementIndex == _elements.lastIndex)
            currentElementIndex = 0
        else currentElementIndex++

        return currentElement
    }

    @Throws(IndexOutOfBoundsException::class)
    fun with(element: E): Infi<E> {
        val index = indexOf(element)
        if(index < 0)
            throw IndexOutOfBoundsException("Element not present in this Infi")

        currentElementIndex = index
        return this
    }

    @Throws(IndexOutOfBoundsException::class)
    fun with(index: Int): Infi<E> {
        if(index > _elements.lastIndex)
            throw IndexOutOfBoundsException("Trying to access element at $index, but size is $size")
        else if(index < 0)
            throw IndexOutOfBoundsException("Trying to access element at -1, not possible")

        currentElementIndex = index
        return this
    }

    override fun get(index: Int): E = _elements[index]

    override fun indexOf(element: E): Int = _elements.indexOf(element)

    override fun lastIndexOf(element: E): Int = _elements.lastIndexOf(element)

    override fun contains(element: E): Boolean = _elements.contains(element)

    override fun containsAll(elements: Collection<E>): Boolean = _elements.containsAll(elements)

    override fun isEmpty(): Boolean = _elements.isEmpty()

    override fun iterator(): Iterator<E> = _elements.iterator()

    override fun listIterator(): ListIterator<E> = _elements.listIterator()

    override fun listIterator(index: Int): ListIterator<E> = _elements.listIterator(index)

    override fun subList(fromIndex: Int, toIndex: Int): List<E> = _elements.subList(fromIndex, toIndex)

    fun toMutableInfi(): MutableInfi<E> = MutableInfi(_elements.toMutableList())
}