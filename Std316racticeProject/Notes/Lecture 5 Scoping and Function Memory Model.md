# Lecture 5: Scoping and Function Memory Model

## 1. Introduction

Understanding **scoping** is essential in Python programming. It defines _where_ variables live and _how long_ they exist in memory. This lecture explores global vs local variables, how memory is managed during function calls, and best coding practices.

---

## 2. Global vs Local Variables

### Local Variable

A **local variable** is defined inside a function and can only be accessed within that function.

```python
def greet():
    message = "Hello!"  # local variable
    print(message)

greet()
print(message)  # ❌ Error: message is not defined
```

- **Scope:** Inside the function only.
    
- **Lifetime:** Exists while the function runs.
    

### Global Variable

A **global variable** is defined outside all functions and is accessible throughout the file.

```python
name = "Alice"  # global variable

def greet():
    print(f"Hello, {name}!")

greet()
print(name)
```

**Be careful:** Global variables can cause confusion if many functions modify them.

### ASCII Diagram — Variable Scope

```
+-----------------------------+
|         Global Space        |
|  name -> 'Alice'            |
|  greet -> <function>        |
+-----------------------------+
            ↓ call greet()
+-----------------------------+
|         Local Space         |
|  message -> 'Hello!'        |
+-----------------------------+
```

---

## 3. The `global` Keyword

You can use the `global` keyword to modify a global variable from inside a function.

```python
count = 0

def increment():
    global count
    count += 1

increment()
print(count)  # 1
```

However, **avoid this practice**. It makes your code harder to maintain and debug.

### Best Practice

Instead of modifying globals directly:

```python
def increment(value):
    return value + 1

count = 0
count = increment(count)
```

---

## 4. Memory Model and Function Frames

Each time a function is called, Python creates a **frame** in memory.

### Example 1: Simple Function Call

```python
def foo():
    x = 1
    print("Inside foo:", x)

foo()
```

Memory diagram:

```
Before call:
__main__:
  foo -> <function>

After call:
__main__:
  foo -> <function>
foo frame:
  x -> 1
```

When `foo()` ends, its frame is destroyed.

### Example 2: Returning Values

```python
def foo():
    x = 5
    return x

result = foo()
print(result)  # 5
```

When `foo()` returns, its local variables are deleted, and only the return value remains in `__main__`.

---

## 5. Parameter Passing

Parameters are **local** to the function. They take values from arguments when called.

```python
def square(n):
    return n * n

num = 4
print(square(num))  # 16
```

Diagram:

```
__main__:
  num -> 4
  square -> <function>

square frame:
  n -> 4
  return -> 16
```

---

## 6. Local and Global Name Conflicts

If a local variable shares the same name as a global one, Python uses the **local** variable inside the function.

```python
a = 3

def foo():
    a = 5
    print(a)

foo()       # 5 (local)
print(a)    # 3 (global)
```

Diagram:

```
__main__: a -> 3
foo():    a -> 5
```

---

## 7. Function Calls and Stack Frames

Every function call creates a new frame and stores it on the **call stack**.

### Example: Nested Calls

```python
def add(x, y):
    return x + y

def square_sum(a, b):
    result = add(a, b) ** 2
    return result

print(square_sum(2, 3))
```

Diagram:

```
Call order:
1. __main__ calls square_sum(2,3)
2. square_sum calls add(2,3)
3. add returns 5
4. square_sum returns 25
```

ASCII Representation:

```
Stack (Top → Bottom):
+------------------+
| add frame        |
|  x=2, y=3        |
+------------------+
| square_sum frame |
|  a=2, b=3        |
+------------------+
| __main__ frame   |
+------------------+
```

---

## 8. Recursion (Optional)

A **recursive** function calls itself. Each call creates a new frame.

```python
def countdown(n):
    if n == 0:
        print("Blast off!")
    else:
        print(n)
        countdown(n-1)

countdown(3)
```

Frame visualization:

```
countdown(3)
countdown(2)
countdown(1)
countdown(0)
```

Each frame finishes and is removed in reverse order.

---

## 9. Coding Style Tips

✅ Avoid unnecessary global variables.  
✅ Pass values as parameters instead.  
✅ Return new values instead of modifying globals.  
✅ Use meaningful variable names and avoid “magic numbers.”

```python
# Bad
area = radius * 3.14 * radius

# Good
PI = 3.14159
area = radius * PI * radius
```

---

## 10. Visualization Tools

- **PyCharm Debugger** – Step through code to watch frames in memory.
    
- **Python Tutor** ([https://pythontutor.com](https://pythontutor.com/)) – Visualize how variables move through memory.
    

---

## 11. Summary

- Each function call creates a new memory frame.
    
- Local variables are isolated from global ones.
    
- Use `global` keyword rarely.
    
- Return values to share results between functions.
    
- Understand the call stack to debug effectively.
    

---

