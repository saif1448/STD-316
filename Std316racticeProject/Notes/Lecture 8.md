# Lecture 8: Control Flow Summary

This document provides a comprehensive summary of Lecture 8, covering Control Flow in Python. It includes detailed explanations of **If-Statements**, **Loops**, and related concepts like variable scope and common pitfalls.

---

## 1. Global vs. Local Variables

Understanding the scope of variables is crucial when working with functions and control flow.

*   **Global Variables**: Variables defined outside of any function. They are accessible throughout the program.
*   **Local Variables**: Variables defined inside a function. They are only accessible within that function.

**Example:**
```python
a = 3  # Global variable

def foo():
    b = 5 # Local variable
    print(a) # Can access global 'a'
    print(b) # Can access local 'b'

foo()
# print(b) # Error! 'b' is not defined in this scope
```

---

## 2. Boolean Logic & Relational Operators

Before diving into control flow, it's essential to understand how Python evaluates conditions.

### 2.1 Relational Operators
These operators compare two values and return a Boolean (`True` or `False`).

*   `==`: Equal to
*   `!=`: Not equal to
*   `>`: Greater than
*   `<`: Less than
*   `>=`: Greater than or equal to
*   `<=`: Less than or equal to

### 2.2 Logical Operators
Used to combine multiple boolean expressions.

*   **`not`**: Inverses the boolean value.
    *   `not True` -> `False`
*   **`and`**: Returns `True` only if **both** operands are True.
    *   `True and False` -> `False`
*   **`or`**: Returns `True` if **at least one** operand is True.
    *   `True or False` -> `True`

### 2.3 String Comparison (Lexicographical Order)
Strings are compared character by character based on their ASCII/Unicode values.
*   **Order**: Space < Digits (0-9) < Uppercase (A-Z) < Underscore (_) < Lowercase (a-z).

```python
'a' > 'A'   # True (lowercase is 'greater' than uppercase)
'abc' < 'abd' # True
```

---

## 3. If-Statements

If-statements allow your program to make decisions and execute different blocks of code based on conditions.

### 2.1 Basic Syntax
The structure relies heavily on **indentation**.

```python
if Boolean-expression:
    # Statement(s) to execute if True
    pass
```
*   **Important**: Don't forget the colon (`:`) after the condition.
*   **Indentation**: All statements inside the block must be indented equally.

### 2.2 If-Else
Use `else` to specify what happens if the condition is `False`.

```python
grade = 55
if grade >= 60:
    print("Pass")
else:
    print("Fail")
```

### 2.3 If-Elif-Else
Use `elif` (else if) to check multiple conditions sequentially.

```python
grade = 75

if grade >= 80:
    print("A")
elif grade >= 70:
    print("B")
elif grade >= 60:
    print("C")
else:
    print("Fail")
```
*   You can have multiple `elif` blocks.
*   The `else` block is optional.

### 2.4 The `pass` Keyword
The `pass` keyword is a placeholder. It does nothing but allows you to keep the syntax correct while you plan your code.

```python
if True:
    pass # Todo: implement this later
```

### 2.5 Common Mistakes
1.  **Missing Colon**: `if x > 5` (Syntax Error) -> `if x > 5:`
2.  **Indentation Errors**: Mixing tabs and spaces or inconsistent indentation.
3.  **Logic Errors**:
    *   `if (x != 3) or (x != 4):` is always True! (If x is 3, it's not 4. If x is 4, it's not 3).
    *   `if (y * x > 0) and (y == 0):` is always False! (If y is 0, y*x is 0, which is not > 0).
4.  **Variable Scope**: Defining a variable inside an `if` block that might not execute, then trying to use it afterwards.

---

## 4. Loops

Loops allow you to repeat a block of code multiple times.

### 3.1 While-Loop
Repeats as long as a condition is `True`.

```python
count = 0
while count < 5:
    print(count)
    count += 1
```

### 3.2 For-Loop
Iterates over a sequence (like a range, list, or string).

**Using `range()`:**
```python
# Prints 0, 1, 2, 3, 4
for i in range(5):
    print(i)
```

**Looping over a String:**
```python
text = "Hello"
for char in text:
    print(char)
```

### 3.3 Break and Continue
*   **`break`**: Immediately exits the loop.
*   **`continue`**: Skips the rest of the current iteration and jumps to the next one.

**Example (Break):**
```python
for i in range(10):
    if i == 5:
        break # Stops the loop when i is 5
    print(i)
```

**Example (Continue):**
```python
for i in range(5):
    if i == 2:
        continue # Skips printing 2
    print(i)
```

---

## 5. Exercises & Examples

### Exercise 1: Repetition
Print a string `n` times.

```python
text = "Python"
n = 3
for i in range(n):
    print(text)
```

### Exercise 2: Get Consonants
Print a string without vowels (a, e, i, o, u).

```python
text = "Hello World"
vowels = "aeiouAEIOU"
for char in text:
    if char not in vowels:
        print(char, end="") # end="" prevents new line
# Output: Hll Wrld
```

### Exercise 3: Reverse String
Print a string in reverse order.

```python
text = "Python"
reversed_text = ""
for char in text:
    reversed_text = char + reversed_text
print(reversed_text)
# Output: nohtyP
```

---

## 6. Key Takeaways
*   **Control Flow**: Directs the path of execution in your program.
*   **Refactoring**: Clean up your `if-else` logic to be readable. Avoid deep nesting if possible.
*   **Lazy Evaluation**: Python evaluates boolean expressions left-to-right and stops as soon as the result is determined (e.g., in `A or B`, if `A` is True, `B` is not evaluated).
