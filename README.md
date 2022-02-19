# Infi

A Kotlin `List` implementation to iterate around elements infinitely.

# Add to your project:

In your root `build.gradle` file:
```groovy
allprojects {
  repositories {
    ...
    maven { url 'jitpack.io' }
  }
}
```

and in your module `build.gradle` file: Latest version: **`1.1.0`**
```groovy
dependencies {
  implementation 'com.github.alraj-dev:infi:latest-version'
}
```

# Demo:

Consider the following list:
```kotlin
val list = listOf(1, 2, 3, 4, 5)
```
In a normal case to loop around elements infinitely you do:

```kotlin
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
```
use `infiOf` instead of `listOf`

```kotlin
//Backward by single element
list.previous()
//Forward by single element
list.next()

// go beyond single element
list.next(3)     // go to 3rd next element
list.previous(4) // go to 4th previous element
```

`next(n: Int)` - goes to the nth next element and returns it. (default n value is 1)

`previous(n: Int)` - goes to the nth previous element and returns it. (default n value is 1)

since this is a infinite loop list, increment or decrement beyond the element size, loops back just like a normal `next` or `previous` function.

```kotlin
list.next(17)      // Gets 2, loops around with the increment
list.previous(198) // Gets 3
```

The default element is the 0th element, to change the default element use `with()`.  You can start looping from a specific index or element:
```kotlin
val list = infiOf(1, 2, 3, 4, 5).with(index = 2)

// By Index, use named parameter when Elements are Int
// Because both index parameter and element parameter will be Int
list.with(index = 3).next() // Gets 5
// By Element
list.with(4).next()         // Gets 5
```
`with(index)` - set the current index to the given index, so changes the current element and position to traverse from

`with(element)` - set the current index to the index of given element, so changes the current element and position to traverse from

other functions:
-
`element()` - returns the current element

`index()` - returns the current element's index

and all `List` functions available in Kotlin, since `Infi` extends `List`

```kotlin
open class Infi<E> : List<E>
```

# MutableInfi:
```kotlin
class MutableInfi<E> : Infi<E>,MutableList<E>
```
Same as `Infi` but with Mutable property, you can use all `MutableList` functions available in Kotlin.

# Exception
You get **`IndexOutOfBoundException()`** doing the following:

- calling `next()` or `previous()`, when there is no element present.
- calling `index()`  or `element()` when there is no element.
- calling `with(index)` when index is smaller than Zero or index is greater than elements size
- calling `with(element)` when element is not present