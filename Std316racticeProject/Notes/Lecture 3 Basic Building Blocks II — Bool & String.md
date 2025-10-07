# Lecture 3: Basic Building Blocks II — Bool & String

---

## 🧩 Puzzles: Think Like a Python Interpreter

### Q1. `a = b` — Why doesn’t Python complain about `a`?

```python
a = b
```

➡️ **Explanation:**  
Python complains **about `b`**, not `a`, because `b` is **unbound** (it has not been assigned any value yet). Python executes the right-hand side first.

If `b` is not defined, you’ll get:

```
NameError: name 'b' is not defined
```

---

### Q2. `2x = 10` — Why is there a syntax error?

```python
2x = 10
```

➡️ **Explanation:**  
Python reads this as a **number (`2`) multiplied by a variable (`x`)**, but assignment can only happen to **variables**, not expressions.  
✅ Variable names **cannot start with digits**.

Correct examples:

```python
x2 = 10
_x = 10
```

---

### Q3. Swapping values incorrectly

```python
x = 5000
y = 3000
x = y
y = x
```

➡️ **Explanation:**  
After `x = y`, both variables point to **the same value** (`3000`).  
When you then do `y = x`, nothing changes — both remain 3000.

💡 **Correct way:** use a temporary variable

```python
x = 5000
y = 3000
z = x
x = y
y = z
print(x, y)  # 3000, 5000
```

Or use Python shorthand:

```python
x, y = y, x
```

---

### Q4. Memory Diagram Concept

When we assign:

```python
x = 3000
y = 7000
x = x + y
y = x
```

**Step-by-step:**

1. `x = 3000`, `y = 7000`
    
2. `x = x + y` → `x = 10000`
    
3. `y = x` → `y = 10000`
    

✅ Final: `x = 10000`, `y = 10000`

---

### Q5. Built-in Function Overview (Practice Q6)

Get familiar with the following:

|Function|Description|Example|Output|
|---|---|---|---|
|`min()`|Returns the smallest value|`min(3, 5)`|`3`|
|`max()`|Returns the largest value|`max(3, 5)`|`5`|
|`abs()`|Returns the absolute value|`abs(-4)`|`4`|
|`pow()`|Exponentiation (x to the power y)|`pow(2, 3)`|`8`|
|`id()`|Returns the memory address of an object|`id(1000)`|(some integer)|
|`input()`|Takes input from user|`name = input("Enter name: ")`|(user enters data)|
|`print()`|Displays output|`print("Hello")`|`Hello`|
|`type()`|Returns data type|`type(5)`|`<class 'int'>`|

📘 _Note:_ `type` is actually a **class**, not a function — but behaves like one.

---

### Activity Examples

```python
# Activity 1
a = pow(2, 11)  # 2^11 = 2048
print(a)

# Activity 2
var_1 = 35.7
print(var_1)

# Activity 3
name = input("Enter your name: ")
print("Hello", name)

# Activity 4
x = 1000
print(id(x))
print(type(x))  # <class 'int'>
```

---

## 🧮 Boolean Type (bool)

### Definition

A **Boolean** represents one of two logical values:

```python
True
False
```

These are used in comparisons and logical expressions.

### Comparison Operators

|Operator|Meaning|Example|Output|
|---|---|---|---|
|`==`|Equal to|`3 == 3`|True|
|`!=`|Not equal to|`3 != 2`|True|
|`>`|Greater than|`5 > 2`|True|
|`<`|Less than|`3 < 1`|False|
|`>=`|Greater than or equal|`3 >= 3`|True|
|`<=`|Less than or equal|`2 <= 4`|True|

Python allows comparisons between strings too (lexicographically):

```python
'a' < 'b'  # True
'Z' < 'a'  # True because uppercase < lowercase
```

---

### Logical Operators

|Operator|Description|Example|Output|
|---|---|---|---|
|`not`|Negates a condition|`not True`|False|
|`and`|True only if both are True|`True and False`|False|
|`or`|True if at least one is True|`True or False`|True|



```python
x = 5
y = 10
print(x > 3 and y < 20)  # True
print(not(x > 3))        # False
```

💡 **Lazy Computation:**

- `and`: if the first is False, Python skips the rest.
    
- `or`: if the first is True, Python skips the rest.
    

```python
x = 0
x and print("Skipped")  # no output
x or print("Printed")    # prints "Printed"
```

---

### Operator Precedence (Order Matters)

Highest → lowest:

```
not → and → or
```

Example:

```python
True and False or not True
# Step 1: not True → False
# Step 2: True and False → False
# Step 3: False or False → False
```

Use parentheses to make it clear:

```python
(True and False) or (not True)
```

---

### Boolean Conversion

Python automatically converts values to Boolean when needed:

|Value|Bool Result|
|---|---|
|`0`, `0.0`, `None`, `''`, `[]`, `{}`|False|
|Any other value|True|

| **Category**       | **Falsy Values**                                                      | **Truthy Examples**            |
| ------------------ | --------------------------------------------------------------------- | ------------------------------ |
| **Boolean**        | `False`                                                               | `True`                         |
| **NoneType**       | `None`                                                                | *(N/A)*                        |
| **Numbers**        | `0`, `0.0`, `0j`                                                      | `1`, `-1`, `3.14`              |
| **Strings**        | `""` *(empty)*                                                        | `"Hello"`, `"0"`, `"False"`    |
| **Lists**          | `[]` *(empty)*                                                        | `[1, 2, 3]`                    |
| **Tuples**         | `()` *(empty)*                                                        | `(0,)`, `(1, 2)`               |
| **Sets**           | `set()` *(empty)*                                                     | `{1, 2}`, `{0}`                |
| **Dictionaries**   | `{}` *(empty)*                                                        | `{"a": 1}`                     |
| **Range**          | `range(0)`                                                            | `range(1, 5)`                  |
| **Custom Objects** | Objects where `__bool__()` returns `False` or `__len__()` returns `0` | All other user-defined objects |


Example:

```python
bool(0)       # False
bool('hi')    # True
bool([])      # False
```

---

## 🔤 Strings

### Representation

A **string** is a sequence of characters enclosed in quotes.

```python
'Hello'
"World"
```

Both are valid — single or double quotes can be used.

Common style:

- `'a'` (single character → single quote)
    
- `"Hello world!"` (sentence → double quote)
    

### Triple Quotes

For multiline text:

```python
msg = '''This is
multiple lines.'''
```

### Including Quotes Inside Strings

```python
# Wrong → causes syntax error
# 'I'm Meiying' ❌

# Correct
"I'm Meiying"
'He said "stop"'
```

Or use **escape characters**:

```python
print('I\'m Meiying')
print("The sign says \"stop\".")
```

---

### Escape Sequences

|Escape|Meaning|
|---|---|
|`\'`|Single quote|
|`\"`|Double quote|
|`\n`|New line|
|`\t`|Tab|
|`\\`|Backslash|

Example:

```python
print('Line1\nLine2')
# Output:
# Line1
# Line2
```

---

### Raw Strings

Prefix with `r` to **ignore escape sequences**:

```python
print(r'C:\new_folder\data.txt')
# Output: C:\new_folder\data.txt
```

---

### Empty String

```python
s = ''
print(len(s))  # 0
```

---

## 🔁 String Operations

### Concatenation (`+`)

```python
"Hello" + " " + "World"  # 'Hello World'
```

### Repetition (`*`)

```python
'a' * 3       # 'aaa'
'Hi' * 2      # 'HiHi'
```

### Comparison

Lexicographical order (like a dictionary):

```python
'a' < 'b'        # True
'aa' < 'ab'      # True
'A' < 'a'        # True (uppercase before lowercase)
```

### Membership Operator (`in`)

```python
'bc' in 'abcde'  # True
'bd' in 'abcde'  # False
```

### Length Function

```python
len('Hello World')  # 11
len('\n')           # 1
len(r'\n')          # 2
```

---

## 🔢 Indexing and Slicing

### Indexing

Each character in a string has an index starting from 0.

```python
msg = 'Hello'
print(msg[0])  # 'H'
print(msg[-1]) # 'o'
```

### Slicing

```python
msg = 'Python'
print(msg[0:2])   # 'Py'
print(msg[:4])    # 'Pyth'
print(msg[2:])    # 'thon'
print(msg[::2])   # 'Pto'
```

### Strings are Immutable

You **cannot modify** characters in place:

```python
msg = 'Hi'
msg[0] = 'h'  # ❌ TypeError
```

To change it:

```python
msg = 'h' + msg[1:]
```

---

## 🔄 Type Conversion: int(), float(), str()

Although not recommended in style, conversion is sometimes needed:

|Conversion|Example|Output|
|---|---|---|
|`int(3.2)`|`int(3.2)`|3|
|`float('2.3')`|`float('2.3')`|2.3|
|`str(2.6)`|`str(2.6)`|'2.6'|
|`int('-5')`|`int('-5')`|-5|
|`int('6.8')`|❌ Error||

```python
# Demo
x = float('2.5')
y = int(5.7)
z = str(100)
print(x, y, z)
```

---

## 🧭 Boolean Conversion Rules Recap

- **True:** Any non-zero or non-empty value
    
- **False:** `0`, `''`, `None`, empty list/set/dict
    

```python
bool(0)       # False
bool('hi')    # True
bool([])      # False
```

---

## 🧩 Final Summary

|Concept|Example|Output|
|---|---|---|
|Boolean|`x = True`|True|
|Comparison|`3 < 5`|True|
|Logical|`True and False`|False|
|String Concatenation|`'A' + 'B'`|'AB'|
|Repetition|`'Hi' * 3`|'HiHiHi'|
|Membership|`'a' in 'cat'`|True|
|Slicing|`'Python'[1:4]`|'yth'|
|Conversion|`int('5')`|5|
|Raw String|`r'\n'`|'\n'|

---

✅ **Key Takeaways for Exam:**

- Understand memory behavior in variable assignment.
    
- Be comfortable with Boolean logic and precedence.
    
- Know common string operations and escape sequences.
    
- Strings are immutable — slicing creates new strings.
    
- Practice built-in functions like `min`, `max`, `id`, `type`, and `print`.
    