# Lab 2 – Step-by-step Guide

This guide explains each task in Lab 2 in simple steps. For every task you’ll see:
- What the program does
- Inputs and outputs (what you type, what it prints)
- Key Python ideas used
- Step-by-step walkthrough of the code
- A tiny “try it yourself” exercise

Tip: In this lab you’ll see input(), numbers, arithmetic, and basic built-in functions like max(), min(), round().

---

## Task1.py – Grocery total price
- Goal: Ask how many apples, peaches, and watermelons you want, multiply by their prices, and print the total cost.
- Inputs: Three integers from the keyboard
  - How many apples? → int
  - How many peaches? → int
  - How many watermelons? → int
- Output: One number (float) – the total price.
- Concepts:
  - input() to read text from the user, int(...) to convert to an integer
  - Using variables for unit prices (like 2.94)
  - Arithmetic: multiply-then-add

Step-by-step:
1) Read three quantities with input(), convert them to int.
2) Store prices in variables (2.94, 3.99, 7.99).
3) Compute total = apples*2.94 + peaches*3.99 + watermelons*7.99.
4) print(total_price)

Try it yourself: What happens if you buy 2 apples, 1 peach, 0 watermelons?

---

## Task2.py – Count vehicle wheels
- Goal: Compute the total number of wheels given counts of bicycles, tricycles, cars, and trucks.
- Inputs: The code uses set numbers (2 bikes, 3 trikes, 4 cars, 18 trucks) – you can change them.
- Output: A number (int) – total wheels. (In this file, the result is stored in total_wheels. Add print(total_wheels) to see it.)
- Concepts:
  - Multiplication by constant wheels per vehicle (2, 3, 4, 6 or 18 depending on assumption)
  - Summation of parts into a total

Step-by-step:
1) Set counts for each vehicle type.
2) Compute each vehicle’s wheel total: bicycles*2, tricycles*3, cars*4, trucks*6 or 18.
3) Add them up into total_wheels.

Try it yourself: Change numbers and add print(total_wheels) at the end to display the result.

---

## Task3.py – Donuts you can buy
- Goal: With some money and a donut price, calculate how many whole donuts you can afford.
- Inputs: money is preset to 5; donut price is 2.3.
- Output: Integer number of donuts.
- Concepts:
  - Floor division // to get “how many whole items fit”
  - int(...) around // is redundant here but also gives an integer

Step-by-step:
1) money = 5
2) num_donuts = int(money // 2.3) → 5 // 2.3 is 2.0, so result is 2

Try it yourself: Change money to 6.9. How many donuts now?

---

## Task4.py – Weighted course score
- Goal: Read marks and compute a weighted score. Keep the higher of lab1 and lab2.
- Inputs: 5 integers via input(): lab1, lab2, assignment, midterm, final.
- Output: One number (float) – course_score.
- Concepts:
  - max(a, b) picks the larger lab mark
  - Weighted sum: lab*0.05 + assignment*0.2 + midterm*0.25 + final*0.5

Step-by-step:
1) Read the five marks with input(), convert to int.
2) lab = max(lab1, lab2)
3) Compute the weighted score using the given weights.
4) print(course_score)

Try it yourself: Use lab1=60, lab2=75, assignment=80, midterm=70, final=85. What do you get?

---

## Task5.py – BMI calculator
- Goal: Compute Body Mass Index: BMI = weight_kg / (height_m^2)
- Inputs: weight in kg (float), height in cm (float)
- Output: BMI rounded to 2 decimals.
- Concepts:
  - Unit conversion cm → m: height_m = height_cm / 100
  - Exponentiation: height_in_meters ** 2
  - round(value, 2)

Step-by-step:
1) Read weight and height with input(), convert to float.
2) Convert height to meters.
3) Compute BMI.
4) print(round(BMI, 2))

Try it yourself: 70kg and 170cm.

---

## Task6.py – Average of largest and smallest
- Goal: Read 4 numbers, find the largest and smallest, and print their average.
- Inputs: Four floats via input()
- Output: One number (float) – (largest + smallest)/2
- Concepts:
  - max(x1, x2, x3, x4) and min(...)

Step-by-step:
1) Read N1, N2, N3, N4 as float.
2) Largest = max(...), Smallest = min(...)
3) Average = (Largest + Smallest) / 2
4) print(Average)

Try it yourself: 3, 10, -2, 7 → largest=10, smallest=-2, average=4.0

---

Cheat-sheet of new ideas
- input() + int()/float(): read and convert user input
- // floor division vs / normal division
- max(), min(), round()
- Combining operations: multiply first, then add