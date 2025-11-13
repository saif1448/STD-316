# Lab 4 – Step-by-step Guide

Theme: Writing functions with inputs/outputs, using assertions for input validation, and reading docstring tests.

For each task below:
- What it does
- Inputs/outputs
- Key ideas
- How the code works
- A small “try this”

---

## lab4_task1.py – fruit_price(num_peaches, num_apples, num_watermelons)
- Does: Returns total fruit cost using fixed prices: peach 3.99, apple 2.94, watermelon 7.99.
- Inputs: Three non-negative integers
- Output: A float (rounded to 2 decimals)
- Ideas: constants for prices, assert checks (type and non-negative), return a value (not print)

How it works:
1) Asserts ensure inputs are ints and >= 0.
2) Computes total = 3.99*peaches + 2.94*apples + 7.99*watermelons.
3) Rounds to 2 decimals and returns it.

Try: fruit_price(2, 1, 0) → 2*3.99 + 2.94 = 10.92

---

## lab4_task2.py – pound(expression: str)
- Does: Parses a string like "2 # 3" and computes x^2 − y^2.
- Input: A string containing one '#'
- Output: An int result
- Ideas: String parsing (find('#'), slicing), str → int conversion, basic math, assert for type

How it works:
1) Make sure expression is a str.
2) Find '#', split left (x) and right (y), strip spaces.
3) Convert to int, compute x**2 - y**2.

Try: pound("6 # 1") → 36 − 1 = 35

---

## lab4_task3.py – count_wheels(bicycles, tricycles, cars, trucks)
- Does: Total wheels from counts of vehicles.
- Inputs: Four non-negative ints
- Output: Int number of wheels
- Ideas: Input validation with assert, arithmetic sum, doctest usage

How it works:
1) Assert all inputs are ints and >= 0.
2) Return 2*bicycles + 3*tricycles + 4*cars + 18*trucks.

Try: count_wheels(1, 0, 2, 1) → 2 + 0 + 8 + 18 = 28

---

## lab4_task4.py – need_to_buy_ticket(age, height)
- Does: Decides if a child must buy a ticket.
- Rules:
  - If height > 120cm → must buy regardless of age
  - Else if age ≤ 6 → no need
  - Else → must buy
- Inputs: age (float/int > 0), height (float/int > 0)
- Output: bool (True means must buy)
- Ideas: Assertions, if/elif/else logic

How it works:
1) Assert types are numbers (int or float) and positive.
2) Check height first; if >120 → True.
3) Else if age ≤ 6 → False.
4) Else → True.

Try: need_to_buy_ticket(5, 119.5) → False

---

## lab4_task5.py – xor_operator(a: bool, b: bool)
- Does: Exclusive OR (XOR): True if exactly one input is True.
- Inputs: two bools
- Output: bool
- Idea: a != b is XOR for booleans; asserts ensure both are bool

How it works: returns a != b.

Try: xor_operator(True, False) → True; xor_operator(True, True) → False

---

## lab4_task6.py – Robust pound(expression: str)
- Does: Same operation as task2, but with more checks (extra spaces, exactly one '#', both sides present, integers only).
- Inputs: expression str
- Output: int
- Ideas: strip(), count('#'), isdigit(), helpful assertion messages

How it works:
1) Strip and find '#'; assert exactly one.
2) Split into x_str and y_str, strip; both must be present.
3) Ensure both are digits, convert to int.
4) Return x**2 - y**2.

Try: pound(" 10 # 2 ") → 100 − 4 = 96
