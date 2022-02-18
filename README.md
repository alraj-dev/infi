

# Infi

```kotlin
open class Infi<E> : List<E>
```
A Kotlin/Java `List` implementation to iterate around elements infinitely.

In a normal List to loop around elements infinitely you do:


```kotlin
val list = listOf(1, 2, 3, 4, 5)

//Backwards
if(currentIndex == 0)
    currentIndex = list.lastIndex
else
    currentIndex--
	
//Forwards
if(currentIndex == list.lastIndex)
    currentIndex = 0
else
    currentIndex++
```

But with Infi, it is simple:
```kotlin
val list = infiOf(1, 2, 3, 4, 5)

//Backwards
list.previous()

//Forwards
list.next()
```
internally it is the same `if` condition, but this is easy right? :)

You can also start looping from a specific index or element:
```kotlin
val list = infiOf(1, 2, 3, 4, 5)

// well both index and element is Int, so use named parameter
list.with(index = 3).next() // Index
list.with(4).next()         // Element
```

`next()` - goes to the next element and returns it

`previous()` - goes to the previous element and returns it

`element()` - returns the current element

`index()` - returns the current element's index

`with(index)` - set the current index to the given index, so changes the current element and position to traverse from

`with(element)` - set the current index to the index of given element, so changes the current element and position to traverse from

By default 0'th element is the current element. To change the default element, use with()
```kotlin
val list = infiOf(1, 2, 3, 4, 5).with(index = 2)
```

# MutableInfi:
```kotlin
class MutableInfi<E> : Infi<E>,MutableCollection<E>
```
Same as Infi but with Mutable property.

# Exception

You get **`TooFewElementsException()`** doing the following:

- calling `next()` or `previous()`, when there is no or 1 element present.
- calling `index()`  or `element()` when there is no element.

You get **`IndexOutOfBoundException()`** doing the following:

- calling `with(index)` when index is smaller than Zero or index is greater than elements size
- calling `with(element)` when element is not present
