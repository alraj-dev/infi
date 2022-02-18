package dev.alraj.infi

class MutableInfi<E>(private val _elements: MutableList<E>) : Infi<E>(_elements), MutableCollection<E> {
    override fun add(element: E): Boolean = _elements.add(element)

    override fun addAll(elements: Collection<E>): Boolean = _elements.addAll(elements)

    override fun clear() = _elements.clear()

    override fun iterator(): MutableIterator<E> = _elements.iterator()

    override fun remove(element: E): Boolean = _elements.remove(element)

    override fun removeAll(elements: Collection<E>): Boolean = _elements.removeAll(elements)

    override fun retainAll(elements: Collection<E>): Boolean = _elements.retainAll(elements)

    fun toInfi(): Infi<E> = Infi(_elements)
}