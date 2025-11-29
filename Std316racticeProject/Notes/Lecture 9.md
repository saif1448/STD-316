# Lecture 9: Collections Part 1 Summary

This document provides a comprehensive summary of Lecture 9, covering Python's built-in collection types: **Tuples**, **Lists**, **Sets**, and **Dictionaries**. It also touches on function docstrings with collections.

---

## 1. Tuples `()`

Tuples are **ordered** and **immutable** collections of data.

### 1.1 Declaration
*   **Syntax**: `(item1, item2, ...)`
*   **Empty Tuple**: `()`
*   **Single Element**: `(1,)` (Note the comma!)
    *   `x = (1)` is just the integer 1.
*   **Mixed Types**: Allowed but not recommended for good style. `(1, "hello", 3.14)`

```python
t = (1, 2, 3)
single = (5,) 
```

### 1.2 Operations
*   **Access**: Indexing `t[0]`, Slicing `t[1:3]`
*   **Immutable**: You **cannot** change elements after declaration. `t[0] = 5` raises an error.
*   **Unpacking**: Assigning tuple elements to variables.
    ```python
    data = (180, 70)
    weight, height = data
    ```
*   **Methods**:
    *   `count(value)`: Returns number of occurrences.
    *   `index(value)`: Returns index of first occurrence.

---

## 2. Lists `[]`

Lists are **ordered** and **mutable** collections.

### 2.1 Declaration
*   **Syntax**: `[item1, item2, ...]`
*   **Empty List**: `[]`

```python
my_list = [1, 2, 3]
```

### 2.2 Operations
*   **Access**: Indexing `my_list[0]`, Negative Indexing `my_list[-1]` (last item), Slicing `my_list[1:3]`
*   **Mutable**: You **can** change elements. `my_list[0] = 5` works.
*   **Deleting**: `del my_list[0]` removes the item at index 0.
*   **Aliasing**: Be careful! `b = a` makes `b` point to the same list as `a`. Changing `b` changes `a`.
    *   Use `b = a.copy()` or `b = a[:]` to create a separate copy.

### 2.3 Methods
*   **Adding**:
    *   `append(item)`: Adds to the end.
    *   `extend(iterable)`: Adds all items from iterable to the end.
    *   `insert(index, item)`: Inserts at specific index.
*   **Removing**:
    *   `remove(value)`: Removes first occurrence of value.
    *   `pop(index)`: Removes and returns item at index (default last).
    *   `clear()`: Removes all items.
*   **Other**:
    *   `sort()`: Sorts in place.
    *   `reverse()`: Reverses in place.
    *   `count(value)`, `index(value)`, `copy()`.

### 2.4 String Methods Related to Lists
*   `split()`: Splits a string into a list. `"a b c".split()` -> `['a', 'b', 'c']`
*   `join()`: Joins a list of strings. `"-".join(['a', 'b', 'c'])` -> `"a-b-c"`

### 2.5 Mutable vs. Immutable in Functions
*   **Immutable Types** (int, float, bool, str, tuple): Passed by **value** (copy). Changing the parameter inside the function *does not* affect the original variable.
*   **Mutable Types** (list, set, dict): Passed by **reference**. Changing the parameter inside the function (e.g., `list.append()`) **does** affect the original object.
    *   *Side Effect*: Unintended modification of data.
    *   *Solution*: Pass a copy if you don't want side effects: `my_func(my_list.copy())`.

---

## 3. Sets `{}`

Sets are **unordered** collections of **unique** elements.

### 3.1 Declaration
*   **Syntax**: `{item1, item2, ...}`
*   **Empty Set**: `set()` (Note: `{}` creates an empty dictionary!)

```python
my_set = {1, 2, 3}
```

### 3.2 Characteristics
*   **No Duplicates**: `{1, 2, 2, 3}` becomes `{1, 2, 3}`.
*   **Unordered**: You cannot access by index `my_set[0]` (Error).
*   **Operations**:
    *   `add(item)`: Adds an element.
    *   `remove(item)`: Removes an element (Error if missing).
    *   `discard(item)`: Removes an element (No error if missing).
    *   `pop()`: Removes and returns a random element.
    *   `issubset()`, `difference()`, etc.

---

## 4. Dictionaries `{key: value}`

Dictionaries store data in **key-value pairs**. Keys must be unique and immutable (e.g., strings, numbers, tuples).

### 4.1 Declaration
*   **Syntax**: `{key1: value1, key2: value2}`
*   **Empty Dict**: `{}`

```python
scores = {"Sam": 78, "Eeyore": 97}
```

### 4.2 Operations
*   **Access**: `scores["Sam"]` returns `78`.
*   **Adding/Updating**: `scores["Snorlax"] = 20` adds a new pair or updates existing.
*   **Methods**:
    *   `get(key, default)`: Returns value if key exists, else default (safe access).
    *   `keys()`, `values()`, `items()`: Return views of keys, values, and pairs.
    *   `pop(key)`: Removes key and returns value.
    *   `update(other_dict)`: Merges another dictionary.

---

## 5. Type Hinting in Docstrings

When writing functions that take collections, it's good practice to specify the type of elements.

```python
from typing import List

def get_total(nums: List[float]) -> float:
    """Return the sum of numbers in a list.
    
    >>> get_total([1.0, 2.0])
    3.0
    """
    return sum(nums)
```

---

## 6. Summary Table

| Type | Syntax | Ordered? | Mutable? | Duplicates? | Access |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **Tuple** | `(1, 2)` | Yes | No | Yes | Index/Slice |
| **List** | `[1, 2]` | Yes | Yes | Yes | Index/Slice |
| **Set** | `{1, 2}` | No | Yes | No | None |
| **Dict** | `{'k': 'v'}` | No* | Yes | Keys: No | Key |

*\*Python 3.7+ preserves insertion order for Dictionaries, but they are conceptually unordered mappings.*
