package dev.alraj.infi

import java.lang.IndexOutOfBoundsException
import kotlin.jvm.Throws

open class Infi<E>(private val _elements: List<E>) : List<E> {
    protected var currentElementIndex: Int = 0
    private val currentElement: E
        get() = _elements[currentElementIndex]

    override val size: Int
        get() = _elements.size

    @Throws(IndexOutOfBoundsException::class)
    fun index(): Int {
        if(size < 1) throw IndexOutOfBoundsException("Cannot get Index, there are no elements")

        return currentElementIndex
    }

    @Throws(IndexOutOfBoundsException::class)
    fun element(): E {
        if(size < 1) throw IndexOutOfBoundsException("Cannot get Element, there are no elements")

        return currentElement
    }

    @Throws(IndexOutOfBoundsException::class)
    fun previous(n: Int = 1): E {
        if(size < 1) throw IndexOutOfBoundsException("Nothing to go previous, there are no elements")

        val tempIndex = currentElementIndex - (n % size)
        currentElementIndex = if(tempIndex >= 0)
            tempIndex
        else
            size + tempIndex

        return currentElement
    }

    @Throws(IndexOutOfBoundsException::class)
    fun next(n: Int = 1): E {
        if(size < 1) throw IndexOutOfBoundsException("Nothing to go previous, there are no elements")

        val tempIndex = (currentElementIndex + (n % size)) - size
        currentElementIndex = if(tempIndex < 0)
            size + tempIndex
        else
            tempIndex

        return currentElement
    }

    @Throws(IndexOutOfBoundsException::class)
    fun with(element: E): Infi<E> {
        val index = indexOf(element)
        if(index < 0)
            throw IndexOutOfBoundsException("Given element is not present in the Infi")

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
