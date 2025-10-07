# Lecture 4: String Methods & Function Basics

---

## 🧩 Overview

**Main Topics:**

- String Review (from previous lecture)
    
- String Methods (built-in functions within strings)
    
- String Formatting (4 ways)
    
- Function Basics (definition, parameters, return)
    
- Type Hints and Assertions
    
- Pre-conditions & Post-conditions
    

---

## 🔁 Review: Boolean & String Basics

Before continuing, recall:

- Boolean has two values: `True`, `False`
    
- Logical order of precedence: `not` → `and` → `or`
    
- String representation supports quotes, escape sequences, and slicing
    

**Example:**

```python
True and False or not True
# not True → False → overall result = False
```

Use parentheses `()` for clarity:

```python
(True and False) or (not True)
```

---

## 🔤 String Review & Advanced Slicing

### Example Recap

```python
text = "Python"
print(text[0:3])   # 'Pyt'
print(text[:4])    # 'Pyth'
print(text[::2])   # 'Pto'
print(text[::-1])  # 'nohtyP' (reversed)
```

Remember:

- Strings are **immutable** (cannot be changed in-place)
    
- Slicing creates **new strings**
    

---

## ✨ String Methods

Strings have **built-in methods** for modification and inspection.  
They are **functions inside objects** — called with dot syntax:

```python
string.method()
```

### Common Categories

|Category|Methods|Description|
|---|---|---|
|Case handling|`capitalize()`, `lower()`, `upper()`, `swapcase()`, `title()`, `casefold()`|Change character case|
|Searching/counting|`count()`, `find()`, `index()`, `startswith()`, `endswith()`|Search substrings|
|Character tests|`isalnum()`, `isalpha()`, `islower()`, `isupper()`, `isnumeric()`|Check property of string|
|Replacing/cleaning|`replace()`, `strip()`|Modify or clean strings|

🧠 _Important:_ These methods **do not change** the original string — they return a **new string**.

---

### Example 1 — Case methods

```python
a = "hello world"
print(a.capitalize())  # Hello world
print(a.upper())       # HELLO WORLD
print(a.title())       # Hello World
print(a.swapcase())    # HELLO WORLD → hello world or vice versa
```

---

### Example 2 — Find, Count, Index

```python
a = "Pika Pika Chu!"
print(a.find('C'))      # 10 (index of first 'C')
print(a.count('Pika'))  # 2 (occurrence count)
```

💡 `find()` returns `-1` if substring not found; `index()` raises an error instead.

---

### Example 3 — Character Tests

```python
a = "1234"
print(a.isnumeric())   # True
print(a.isalpha())     # False
print(a.isalnum())     # True (letters or digits)
print(a.islower())     # False (not lowercase)
```

---

### Example 4 — Replace & Strip

```python
a = "    Pika Pika Chu!     "
print(a.strip())                # 'Pika Pika Chu!'
print(a.replace('i', '1'))      # 'P1ka P1ka Chu!'
print(a.replace('i', ''))       # 'Pka Pka Chu!'
```

---

### Example 5 — Call Multiple Methods

Methods can be chained:

```python
msg = "      Hello World!      "
msg = msg.strip().upper().replace("LL", "XX")
print(msg)  # 'HEXXO WORLD!'
```

**Step-by-step execution:**

1. `strip()` → removes spaces → `'Hello World!'`
    
2. `upper()` → `'HELLO WORLD!'`
    
3. `replace()` → `'HEXXO WORLD!'`
    

---

### Example 6 — Chaining with Slice

```python
msg = "      Hello World!      "
part = msg.strip().lower()[6:11]
print(part)  # 'world'
```

---

### Key Takeaways

- String methods **don’t modify** the original string.
    
- Always **store the result** in a variable if you need it.
    
- Use chaining for compact operations.
    

---

## 🧵 String Formatting

**Goal:** combine text and variables neatly.

Given:

```python
name = "Meiying"
year = 1
```

Desired output:

```
Meiying teaches a course in year 1.
```

There are **4 ways** to format strings:

---

### 1️⃣ Concatenation using `+`

```python
msg = name + " teaches a course in year " + str(year) + "."
print(msg)
```

⚠️ Be careful with **spaces** and **type conversion** (must convert non-strings).

---

### 2️⃣ Using `%` placeholders

```python
msg = "%s teaches a course in year %d." % (name, year)
print(msg)
```

|Placeholder|Meaning|
|---|---|
|`%s`|string|
|`%d`|integer|
|`%f`|float|
|`%r`|boolean|

---

### 3️⃣ Using `.format()` method

```python
msg = "{} teaches a course in year {}.".format(name, year)
print(msg)
```

Simpler, more readable, and supports reordering.

---

### 4️⃣ f-String (modern & best)

Introduced in Python 3.6+

```python
msg = f"{name} teaches a course in year {year}."
print(msg)
```

You can even put **expressions** inside:

```python
print(f"Next year will be {year + 1}.")
```

✅ **Best Practice:** Use **f-strings** — clear, modern, readable.

---

## ⚙️ Functions — The Building Blocks of Reusable Code

### Why Functions?

Avoid repetition and make code organized.

Without functions:

```python
# Making three sandwiches
print("Making peanut butter and jelly sandwich...")
print("Making Nutella and strawberry jelly sandwich...")
print("Making hummus and mayo sandwich...")
```

With functions:

```python
def make_sandwich(spread_1, spread_2):
    print(f"Making {spread_1} and {spread_2} sandwich...")

make_sandwich("peanut butter", "jelly")
make_sandwich("Nutella", "strawberry jelly")
make_sandwich("hummus", "mayo")
```

✅ Output is cleaner and easier to modify.

---

## 🧱 Function Definition Syntax

```python
def function_name(param1, param2, ...):
    """Docstring (description of the function)"""
    statement
    return result
```

### Components

|Part|Description|
|---|---|
|`def`|Keyword for defining a function|
|`function_name`|Must be meaningful (PEP-8: lowercase_with_underscores)|
|`()`|Parameters (optional)|
|`:`|Indicates start of function block|
|Docstring|Description of what the function does|
|`return`|Sends value(s) back to caller (optional)|

Example:

```python
def add(a, b):
    """Return the sum of two numbers."""
    return a + b

result = add(5, 3)
print(result)  # 8
```

---

## 🧩 Example: `make_sandwich()`

```python
def make_sandwich(spread_1, spread_2):
    """Prints a message for making a sandwich."""
    print(f"Making sandwich with {spread_1} and {spread_2}!")

make_sandwich("peanut butter", "jelly")
make_sandwich("Nutella", "strawberry jelly")
```

Output:

```
Making sandwich with peanut butter and jelly!
Making sandwich with Nutella and strawberry jelly!
```

---

## 🎯 Function Return Values

A function may or may not return data.

```python
def multiply(x, y):
    return x * y

result = multiply(3, 4)
print(result)  # 12
```

If no `return` is used, the function returns `None` by default.

---

### Multiple Return Values

```python
def area_perimeter(length, width):
    area = length * width
    perimeter = 2 * (length + width)
    return area, perimeter

area, peri = area_perimeter(5, 3)
print(area, peri)  # 15 16
```

---

## 🧠 Function Design Recipe

A **design recipe** ensures clarity and documentation for each function.

Example:

```python
def get_larger(num_1: float, num_2: float) -> float:
    """Return the larger of the two numbers.

    >>> get_larger(1.0, 2.0)
    2.0
    >>> get_larger(3.5, 1.5)
    3.5
    >>> get_larger(2.2, 2.2)
    2.2
    """
    if num_1 >= num_2:
        return num_1
    else:
        return num_2
```

✔️ **Include design recipes** in labs and assignments.

---

## 💡 Type Hints in Python

Python supports **type hints** for readability and static checking.

```python
num: int = 15
name: str = "Donald"
amount: float = 300.5
```

If you mismatch types, IDEs like PyCharm will warn you — but Python still runs.

---

### Function Type Hints

```python
def add_numbers(x: int, y: int) -> int:
    return x + y

result = add_numbers(10, 5)
print(result)  # 15
```

Compare with static languages (e.g., Java):

```java
int addNumbers(int x, int y) {
    return x + y;
}
```

---

### Type Hint with No Return

```python
def greet(name: str) -> None:
    print(f"Hello, {name}!")
```

---

## 🧮 Preconditions, Postconditions & `assert`

### Garbage In → Garbage Out (GIGO)

To prevent errors, define **rules** for valid input/output.

- **Pre-condition:** what must be true _before_ function runs
    
- **Post-condition:** what must be true _after_ function runs
    

Example:

```python
def average_age(age_list: list[int]) -> float:
    total = 0
    n = len(age_list)

    # Preconditions
    assert n != 0, "List cannot be empty."
    for age in age_list:
        assert age >= 0, f"Age {age} must be positive."

    total = sum(age_list)
    result = total / n

    # Post-condition
    assert result >= 0, "Average cannot be negative."
    return result
```

If an invalid condition occurs, Python raises an `AssertionError`.

---

### Example: Avoid Divide by Zero

```python
x = int(input("Enter numerator: "))
y = int(input("Enter denominator: "))
assert y != 0, "Cannot divide by zero!"
print(x / y)
```

If `y = 0`, program stops with:

```
AssertionError: Cannot divide by zero!
```

---

### When to Use `assert`

- Use for **debugging and enforcing constraints**
    
- Typically used for **pre-condition checks**
    
- Helps detect bugs early
    

---

## 🧭 Summary Table

|Concept|Example|Output|
|---|---|---|
|String Method|`'hi'.upper()`|'HI'|
|Formatting|`f"Name: {name}"`|'Name: Meiying'|
|Function Definition|`def add(x, y): return x+y`|—|
|Type Hint|`x: int = 5`|—|
|Assertion|`assert y>0, 'Must be >0'`|raises error if false|

---

## ✅ Key Takeaways for Exam

- Understand **string immutability** and common methods.
    
- Know **4 formatting techniques**, especially f-strings.
    
- Be able to **define, call, and document** functions.
    
- Practice **type hints** and **assertions** to improve code robustness.
    
- Always include **pre-conditions and post-conditions** for clarity.
    

---

