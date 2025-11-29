# Lecture 12: Classes and Objects Part 1 & File I/O Summary

This document provides a comprehensive summary of Lecture 12, introducing **Object-Oriented Programming (OOP)** with Classes and Objects, and covering **File Input/Output (I/O)** operations.

---

## 1. Classes and Objects

### 1.1 What is a Class?
A **Class** is a blueprint or template for creating objects. It defines:
*   **Properties (Attributes)**: Data describing the object (e.g., name, height, color).
*   **Actions (Methods)**: Functions describing what the object can do (e.g., eat, sleep).

**Analogy**:
*   **Class**: The design/blueprint of a Minion.
*   **Object**: A specific Minion (e.g., Kevin, Stuart) created from that blueprint.

### 1.2 Defining a Class
*   **Class Name**: Use **CamelCase** (e.g., `Minion`, `ChocolateCake`).
*   **`__init__` Method**: The constructor. It initializes the object's attributes.
*   **`self`**: The first parameter of every method. It refers to the current instance of the object.

```python
class Minion:
    def __init__(self, name, color):
        self.name = name        # Instance variable
        self.color = color      # Instance variable
        self._eyes = 2          # Private variable convention

    def eat(self, food):
        print(f"{self.name} is eating {food}")
```

### 1.3 Creating Objects (Instantiation)
```python
kevin = Minion("Kevin", "Yellow")
stuart = Minion("Stuart", "Yellow")
```

### 1.4 Accessors (Getters) and Mutators (Setters)
Directly accessing instance variables is often discouraged. Use methods to control access.
*   **Private Variables**: Prefix with `_` (e.g., `self._weight`). This is a convention in Python to indicate "do not touch directly".

```python
class Minion:
    # ... init ...
    def get_eyes(self):
        return self._eyes

    def set_eyes(self, num):
        if num >= 0:
            self._eyes = num
```

### 1.5 Special Methods
*   **`__str__(self)`**: Returns a string representation of the object (used by `print()` and `str()`).
*   **`__eq__(self, other)`**: Defines behavior for equality `==`.

```python
    def __str__(self):
        return f"Minion {self.name}"
```

---

## 2. File I/O

File I/O allows reading from and writing to files.

### 2.1 Opening a File
Use the `open()` function.
*   **Syntax**: `file_object = open(filename, mode)`
*   **Modes**:
    *   `"r"`: Read (default).
    *   `"w"`: Write (overwrites existing content).
    *   `"a"`: Append (adds to the end).

    *   `"a"`: Append (adds to the end).

### 2.2 Checking File Existence
Before opening a file for reading, it's good practice to check if it exists to avoid errors.

```python
import os
if os.path.exists("demo.txt"):
    file = open("demo.txt", "r")
else:
    print("File not found!")
```

### 2.3 Reading Files
1.  **`read()`**: Reads the entire file as one string.
2.  **`readline()`**: Reads one line at a time.
3.  **`readlines()`**: Reads all lines into a list of strings.
4.  **Looping**: Best practice for memory efficiency.

```python
file = open("demo.txt", "r")
for line in file:
    print(line.strip()) # strip() removes the newline character
file.close() # Always close the file!
```

### 2.4 Writing Files
```python
file = open("output.txt", "w")
file.write("Hello World\n")
file.close()
```

### 2.5 Best Practice: `with` statement
Automatically closes the file, even if errors occur.

```python
with open("demo.txt", "r") as file:
    content = file.read()
# File is automatically closed here
```

### 2.6 CSV Files (Comma Separated Values)
*   Text files where data is separated by commas.
*   Use `split(',')` to parse lines.
*   **Tip**: Create classes to represent rows (e.g., `Student` class) for better organization.

---

## 3. Summary
*   **Classes** encapsulate data and behavior.
*   **Objects** are instances of classes.
*   **File I/O** is essential for persistent data storage. Always close your files or use the `with` statement.
