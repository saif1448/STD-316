# Lecture 10: Collections Part 2 Summary

This document provides a comprehensive summary of Lecture 10, focusing on **Collection Operations**, **Memory Models**, **Coding Style**, and **Function Arguments** with mutable/immutable types.

---

## 1. Collection Operations & Iterables

An **iterable** is any data type that you can loop over (e.g., strings, tuples, lists, sets, dictionaries).

### 1.1 Converting Between Iterables
You can convert between different collection types using their constructor functions:
*   `tuple(iterable)`: Converts to a tuple.
*   `list(iterable)`: Converts to a list.
*   `set(iterable)`: Converts to a set (removes duplicates, order not guaranteed).

### 1.2 Looping Over Iterables
You can use `for` loops to iterate over elements or indices.

*   **Strings, Tuples, Lists**: Iterates in order.
*   **Sets**: Iterates in arbitrary order (unordered).
*   **Dictionaries**: Iterates over **keys** by default.

**Looping by Index:**
```python
my_list = [10, 20, 30]
for i in range(len(my_list)):
    print(my_list[i])
```
*   *Note*: You cannot loop by index for Sets (unordered).

### 1.3 List Concatenation
*   **`+` Operator**: Joins two lists (or tuples) into a new one.
    ```python
    a = [1, 2]
    b = [3, 4]
    c = a + b # [1, 2, 3, 4]
    ```
*   **`extend()` vs `+`**: `extend()` modifies the list in-place, `+` creates a new list.

### 1.4 Advanced Sorting & Min/Max
*   **`sort(reverse=True)`**: Sorts in descending order.
*   **`sort(key=func)`**: Sorts based on a custom function (e.g., length of string).
    ```python
    words = ["apple", "bat", "cat"]
    words.sort(key=len) # Sorts by length
    ```
*   **`min(iterable)` / `max(iterable)`**: Returns the smallest/largest item.

---

## 2. Flexible Function Arguments (Optional)

### 2.1 `*args` (Variable Positional Arguments)
Allows a function to accept any number of positional arguments. `args` becomes a **tuple**.

```python
def foo(*args):
    print(args)

foo(1, 2, 3) # Output: (1, 2, 3)
```

### 2.2 `**kwargs` (Variable Keyword Arguments)
Allows a function to accept any number of keyword arguments. `kwargs` becomes a **dictionary**.

```python
def bar(**kwargs):
    print(kwargs)

bar(a=1, b=2) # Output: {'a': 1, 'b': 2}
```

---

## 3. Coding Style

### 3.1 Homogeneous Collections
While Python allows mixed types in lists (e.g., `[1, "hello"]`), it is **bad practice**.
*   **Recommendation**: Keep elements in a collection the same type (homogeneous).
*   **Reason**: Makes processing easier (e.g., you don't need to check types before calling `len()` or performing math).

### 3.2 List Comprehension (Pythonic Way)
A concise way to create lists.

**Example**: Create a list of squares from 0 to 49.
```python
# Traditional
squares = []
for x in range(50):
    squares.append(x**2)

# List Comprehension
squares = [x**2 for x in range(50)]
```

---

## 4. Memory Model: Assign vs. Copy

Understanding how Python handles variable assignments is critical for mutable types (Lists, Sets, Dicts).

### 4.1 Assignment (`=`)
Assigning a variable to another **copies the reference (address)**, not the data. Both variables point to the *same object*.

```python
a = [1, 2, 3]
b = a        # b points to the same list as a
b[0] = 99    # Modifies the list
print(a[0])  # Output: 99 (a is also changed!)
```

### 4.2 Copying
To create a new, independent object, you must explicitly copy.

*   **Shallow Copy**: `b = a.copy()` or `b = a[:]`
    *   Creates a new container, but elements are still references.
*   **Deep Copy**: `import copy; b = copy.deepcopy(a)` (for nested lists).

```python
a = [1, 2, 3]
b = a.copy() # b is a new list with the same values
b[0] = 99
print(a[0])  # Output: 1 (a is unchanged)
```

### 4.3 Identity: `is` vs `==`
*   **`==`**: Checks if **values** are equal.
*   **`is`**: Checks if **identities** (memory addresses) are equal.
*   **`id(obj)`**: Returns the unique memory address of an object.

```python
a = [1, 2, 3]
b = [1, 2, 3]
print(a == b) # True (Values are same)
print(a is b) # False (Different objects in memory)

c = a
print(a is c) # True (Same object)
```

---

## 5. Function Arguments: Mutable vs. Immutable

When passing arguments to functions, Python passes the **object reference**.

### 5.1 Immutable Arguments (int, str, tuple)
Since the object cannot be changed, the function cannot modify the original variable in the caller's scope. Reassigning the parameter inside the function just creates a new local variable.

```python
def foo(x):
    x = x + 1 # x is now a new local integer
    return x

a = 10
foo(a)
print(a) # Output: 10 (unchanged)
```

### 5.2 Mutable Arguments (list, set, dict)
The function receives a reference to the *same object*. Modifications (like `append`, `pop`, `[i] = val`) **will affect** the original object.

```python
def add_item(lst):
    lst.append(99) # Modifies the object lst points to

my_list = [1, 2]
add_item(my_list)
print(my_list) # Output: [1, 2, 99] (Changed!)
```

**Takeaway**:
*   If you want to modify the original list, modify it in place.
*   If you *don't* want to modify it, work on a copy inside the function.
