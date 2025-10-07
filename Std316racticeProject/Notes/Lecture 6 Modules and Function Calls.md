# Lecture 6: Modules and Function Calls

## 1. Introduction

In this lecture, we explore how Python organizes code into **modules** and how function calls work. You’ll learn to import, define, and use modules effectively, and understand how arguments are passed in function calls.

---

## 2. Review of Previous Lecture

Before we start, recall from **Lecture 5**:

- Each function has its **own memory frame**.
    
- Variables can be **local** or **global**.
    
- Avoid modifying global variables directly.
    

---

## 3. What is a Module?

A **module** is a Python file (`.py`) that contains reusable code — functions, classes, or variables.

### Example

```python
# my_module.py
def greet(name):
    print(f"Hello, {name}!")

# main.py
import my_module
my_module.greet("Alice")
```

Output:

```
Hello, Alice!
```

### Benefits

- Organizes your code logically
    
- Avoids repetition
    
- Makes code reusable across projects
    

---

## 4. Built-in Modules

Python comes with many **built-in modules**. Examples:

|Module|Description|Example Functions|
|---|---|---|
|`math`|Mathematical operations|`sqrt`, `sin`, `log`, `pi`|
|`random`|Random number generation|`randint`, `choice`, `shuffle`|
|`datetime`|Work with dates and times|`date`, `time`, `now`|

### Using Built-in Modules

```python
import math
print(math.sqrt(16))   # 4.0
print(math.pi)         # 3.141592653589793
```

### Import Specific Functions

```python
from math import sqrt, pi
print(sqrt(9))   # 3.0
print(pi)        # 3.141592653589793
```

### Rename a Module

```python
import math as m
print(m.cos(0))   # 1.0
```

### Import Everything (❌ Not Recommended)

```python
from math import *
print(sin(pi/2))  # 1.0
```

---

## 5. Why Not Import Everything?

- Increases memory usage
    
- Makes debugging harder (function names can conflict)
    
- Python does not load all modules automatically — to save memory and improve performance.
    

---

## 6. Exploring the `math` and `random` Modules

### Math Module Example

```python
import math

print(math.ceil(4.3))   # 5
print(math.floor(4.3))  # 4
print(math.degrees(math.pi))  # 180.0
```

### Random Module Example

```python
import random

print(random.randint(1, 6))  # Random number between 1 and 6
print(random.choice(['rock', 'paper', 'scissors']))
```

---

## 7. Third-Party Modules

Python allows installing external packages using **pip**.

```bash
pip install numpy
```

Then use it like this:

```python
import numpy as np
arr = np.array([1, 2, 3])
print(np.mean(arr))
```

Terminology:

- **Module:** Python file.
    
- **Library:** A collection of modules.
    

---

## 8. Creating Your Own Module

You can define your own module for better structure and reusability.

### Example

**math_utils.py**

```python
def add(a, b):
    return a + b

def multiply(a, b):
    return a * b
```

**main.py**

```python
import math_utils
print(math_utils.add(3, 4))
print(math_utils.multiply(2, 5))
```

Output:

```
7
10
```

---

## 9. The `__name__ == "__main__"` Condition

When a Python file runs directly, Python sets `__name__` to `"__main__"`. This helps control what code runs.

### Example

```python
# my_module.py
print("This is my module")

def greet():
    print("Hello!")

if __name__ == "__main__":
    print("Running as main program")
```

**Output when run directly:**

```
This is my module
Running as main program
```

**When imported:**

```
This is my module
```

(`"Running as main program"` is skipped.)

### Why Use This?

To prevent helper code from executing when the file is imported elsewhere.

---

## 10. Function Calls

Let’s revisit **how functions are called and arguments passed**.

### 10.1 Positional Arguments

Arguments passed in order.

```python
def student_record(name, id):
    print(f"Name: {name}, ID: {id}")

student_record("Sam", 12345)
```

### 10.2 Keyword Arguments

Use parameter names to pass values.

```python
student_record(id=12345, name="Sam")
```

### 10.3 Default Arguments

Provide default values.

```python
def greet(name="Guest"):
    print(f"Hello, {name}!")

greet()           # Hello, Guest!
greet("Alice")     # Hello, Alice!
```

ASCII Diagram for Function Calls:

```
Call stack:
+------------------+
| greet("Alice")   | ← Local scope
+------------------+
| __main__         | ← Global scope
+------------------+
```

---

## 11. Common Mistakes

❌ Using mutable default arguments like lists or dicts.

```python
def add_item(item, items=[]):
    items.append(item)
    return items

print(add_item("apple"))  # ['apple']
print(add_item("banana")) # ['apple', 'banana'] ❌
```

✅ Use `None` instead:

```python
def add_item(item, items=None):
    if items is None:
        items = []
    items.append(item)
    return items
```

---

## 12. Summary

✅ Use built-in and custom modules to organize code.  
✅ Import only what you need.  
✅ Use `__main__` to separate execution and import logic.  
✅ Understand positional, keyword, and default arguments.  
✅ Avoid mutable default parameters.

---

## 13. Additional References

- [Python Math Module Docs](https://docs.python.org/3/library/math.html)
    
- [Python Random Module Docs](https://docs.python.org/3/library/random.html)
    
- [Python Tutor Visualizer](https://pythontutor.com/visualize.html)
    

---
