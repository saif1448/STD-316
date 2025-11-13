# Lab 5 – Step-by-step Guide

Theme: Functions with math formulas, scope, composing functions, input validation, and string parsing.

---

## lab5_task1.py – Circle calculations
- Functions: circle_area(radius: float), circle_circumference(radius: float)
- Inputs: radius (float, 0.0 to 1000.0)
- Outputs: float
- Ideas: Using a PI constant, asserts to validate type/range, formulas

How it works:
1) Assert radius is float and within range.
2) Area = PI * r^2; Circumference = 2 * PI * r.

Try: radius=2.0 → area 12.56636; circumference 12.56636

---

## lab5_task2.py – Fixing scope via helper functions
- Function: problematic_function(x_value: float, y_value: float) -> float
- Goal: Correctly use global x and y via helper functions function1 and function2.
- Idea: In the judge environment, function1 and function2 exist and use globals. We set y then x, call helpers, then return x + y.
- Inputs: floats only; asserts reject non-floats.

How it works:
1) Assert both inputs are floats.
2) Initialize globals x and y to 0.0 (y first because function1 uses y).
3) Call function2(y_value) (sets global y), then function1(x_value) (sets global x),
4) Return x + y.

Try: problematic_function(5.9, 2.1) → 10.1

---

## lab5_task3.py – Total revenue from two stores
- Functions: get_store1_revenue, get_store2_revenue, get_total_revenue
- Inputs: two monthly sales (float, non-negative)
- Output: total revenue (float)
- Ideas: Decompose into small functions, validate inputs, reuse helpers

How it works:
1) Validate that both inputs are float and ≥ 0.
2) Store 1 revenue: sales/5; Store 2 revenue: sales/8.
3) Sum to get total.

Try: get_total_revenue(800.0, 600.0) → 235.0

---

## lab5_task4.py – Food credit calculator (two roles)
- Functions: my_food_credit(food_ate, opp_food_ate), opponent_food_credit(opp_food_ate, food_ate)
- Rules:
  - Mine: raw = food*10
  - Opponent: raw = food*15
  - Final = raw - 0.2*(other_raw), but not less than 0
- Inputs: non-negative floats (validated)
- Output: float final credit
- Ideas: Small validator function, one calculator function, reuse for both roles

How it works:
1) input_validation(...) checks type and non-negativity.
2) Compute raw credits (10x or 15x).
3) calculate_final_credit applies the 20% deduction and clamps to 0.

Try: my_food_credit(20.0, 10.0) → 170.0; opponent_food_credit(10.0, 20.0) → 110.0

---

## lab5_task5.py – Absolute value from a string like "|-3.5|"
- Function: absolute_value(number_str: str)
- Input: string that starts and ends with '|', content is a number (e.g., "|2.3|", "|-3|")
- Output: float absolute value
- Ideas: Strip spaces, check first/last char, verify digits/optional '-' and single '.', then abs(float(...))

How it works:
1) Trim spaces; ensure length ≥ 3 and borders are '|'.
2) Extract inner content, remove inner spaces.
3) Handle optional leading '-', at most one '.'; remaining chars must be digits.
4) Convert to float and return abs(...).

Try: absolute_value("| - 2.3|") → 2.3

---

## labt_task6.py – is_even(n: int)
- Note: Filename has a small typo (labt_task6.py). Function still works.
- Input: int n
- Output: bool – True if n % 2 == 0
- Idea: Assert n is int; modulo to test evenness

Try: is_even(4) → True; is_even(-5) → False
