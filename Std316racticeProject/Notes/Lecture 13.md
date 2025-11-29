# Lecture 13: Classes and Objects Part 2 & Complexity Summary

This document provides a comprehensive summary of Lecture 13, delving deeper into **Object-Oriented Programming (OOP)** concepts like using objects as attributes and parameters, and introducing **Complexity Analysis** (Big O notation).

---

## 1. Advanced Classes and Objects

### 1.1 Objects as Instance Variables
Instance variables are not limited to simple types (int, str). They can be other objects or collections of objects.

```python
class Minion:
    def __init__(self, name):
        self.name = name
        self.backpack = [] # A list (object) as an instance variable

    def add_item(self, item):
        self.backpack.append(item)
```

### 1.2 Objects as Function Parameters
You can pass objects to functions.
*   **Mutable Objects**: If the function modifies the object (e.g., changes an attribute), the change persists outside the function.

```python
def feed_minion(minion):
    minion.weight += 1 # Modifies the object directly

kevin = Minion("Kevin")
feed_minion(kevin)
print(kevin.weight) # Weight has increased
```

### 1.3 Objects in Collections
You can store objects in lists, dictionaries, etc.

```python
minions = [Minion("Kevin"), Minion("Stuart")]
for m in minions:
    print(m.name)
```

### 1.4 The `self` Variable
*   Refers to the **current instance** of the class.
*   Must be the first parameter of any instance method.
*   Allows access to attributes (`self.name`) and other methods (`self.eat()`) within the class.

### 1.5 Class Variables vs. Instance Variables
*   **Instance Variables**: Unique to each object (defined with `self.var`).
*   **Class Variables**: Shared by **all** instances of the class (defined inside class, outside methods).
    ```python
    class Dice:
        num_of_rolls = 0 # Class variable

        def roll(self):
            Dice.num_of_rolls += 1 # Access using ClassName
    ```

### 1.6 Why Use Classes?
*   **Encapsulation**: Bundles data and behavior together.
*   **Modularity**: Separates code into logical units.
*   **Consistency**: Ensures all objects of a type have the same structure.
*   **Code Reuse**: Enables inheritance and polymorphism (advanced OOP concepts).

---

## 2. Complexity Analysis

Complexity analysis evaluates how efficient a program is in terms of **Time** (speed) and **Space** (memory) as the input size ($n$) grows.

### 2.1 Big O Notation ($O$)
Describes the **worst-case** scenario for how the runtime scales with input size $n$.

| Notation | Name | Description | Example |
| :--- | :--- | :--- | :--- |
| $O(1)$ | Constant | Time does not change with $n$. | Accessing Dict by key, List index lookup. |
| $O(\log n)$ | Logarithmic | Time grows slowly. | Binary Search. |
| $O(n)$ | Linear | Time grows directly with $n$. | Finding item in unsorted List (Linear Search). |
| $O(n \log n)$ | Linearithmic | Faster than quadratic. | Merge Sort. |
| $O(n^2)$ | Quadratic | Time grows with square of $n$. | Nested loops, Insertion Sort. |

### 2.2 Data Structure Efficiency
Choosing the right data structure affects complexity.

*   **Finding an item**:
    *   **List**: $O(n)$ - Must check every item (Linear Search).
    *   **Dictionary**: $O(1)$ - Uses a hash function to jump directly to the location.

**Key Takeaway**: Dictionaries are much faster for lookups than lists when $n$ is large.

### 2.3 Algorithms
Different algorithms for the same problem can have different complexities.
*   **Sorting**:
    *   **Insertion Sort**: $O(n^2)$ (Slow for large lists).
    *   **Merge Sort**: $O(n \log n)$ (Much faster for large lists).

---

## 3. Summary
*   **OOP**: Objects can contain other objects and be passed around, allowing for complex data modeling.
*   **Complexity**: "Big O" measures scalability.
    *   $O(1)$ is ideal.
    *   $O(n)$ is okay.
    *   $O(n^2)$ should be avoided for large datasets.
*   **Optimization**: Use Dictionaries for fast lookups ($O(1)$) instead of Lists ($O(n)$).
