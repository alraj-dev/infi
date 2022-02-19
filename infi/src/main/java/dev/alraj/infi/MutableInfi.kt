package dev.alraj.infi

class MutableInfi<E>(private val _elements: MutableList<E>) : Infi<E>(_elements), MutableList<E> {
    override fun add(element: E): Boolean = _elements.add(element)

    override fun addAll(elements: Collection<E>): Boolean = _elements.addAll(elements)

    override fun clear() = _elements.clear()

    override fun iterator(): MutableIterator<E> = _elements.iterator()

    override fun remove(element: E): Boolean {
        val result = _elements.remove(element)

        // Reset the currentElementIndex, otherwise you may get IndexOutOfBoundException
        if(currentElementIndex > _elements.lastIndex)
            currentElementIndex = _elements.lastIndex
        return result
    }

    override fun removeAt(index: Int): E {
        val result = _elements.removeAt(index)

        // Reset the currentElementIndex, otherwise you may get IndexOutOfBoundException
        if(currentElementIndex > _elements.lastIndex)
            currentElementIndex = _elements.lastIndex
        return result
    }

    override fun removeAll(elements: Collection<E>): Boolean {
        // Reset the currentElementIndex, otherwise you may get IndexOutOfBoundException
        currentElementIndex = 0
        return _elements.removeAll(elements)
    }

    override fun retainAll(elements: Collection<E>): Boolean {
        val result = _elements.retainAll(elements)

        // Reset the currentElementIndex, otherwise you may get IndexOutOfBoundException
        if(currentElementIndex > _elements.lastIndex)
            currentElementIndex = _elements.lastIndex
        return result
    }

    override fun add(index: Int, element: E) = _elements.add(index, element)

    override fun addAll(index: Int, elements: Collection<E>): Boolean = _elements.addAll(index, elements)

    override fun listIterator(): MutableListIterator<E> = _elements.listIterator()

    override fun listIterator(index: Int): MutableListIterator<E> = _elements.listIterator(index)

    override fun set(index: Int, element: E): E = _elements.set(index, element)

    override fun subList(fromIndex: Int, toIndex: Int): MutableList<E> = _elements.subList(fromIndex, toIndex)

    fun toInfi(): Infi<E> = Infi(_elements)
}