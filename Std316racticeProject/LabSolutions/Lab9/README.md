# Lab 9 – Step-by-step Guide

Theme: Strings parsing, basic collections (list/dict), and simple data updates.

---

## lab9_task1.py – calculate_average(numbers_str)
- Input format: exactly 5 integers as a string, separated by '|', spaces allowed: e.g., '2 | 10 | 5 | 7 | 11'
- Output: average as float
- Ideas: Split by '|', strip spaces, convert to int, sum and divide by 5

How it works:
1) Assert input is str.
2) Split by '|' → a list of 5 pieces; assert length is 5.
3) Loop through pieces: strip, int(), add to total.
4) Return total/5.

Try: calculate_average('1|2|3|4|5') → 3.0

---

## lab9_task2.py – list_to_dict(input_list)
- Inputs: list of 4 non-negative ints
- Output: dict with keys 'apple','banana','grape','orange' mapped to list elements
- Ideas: Carefully assert list type, length 4, and each element’s type/value; then build a dict

How it works:
1) Validate: type(list), length==4, each element int and ≥0.
2) Create result with the 4 fruit keys pointing to the 4 values.

Try: list_to_dict([10, 15, 20, 25]) → {'apple':10,'banana':15,'grape':20,'orange':25}

---

## lab9_task3.py – add_to_inventory(inventory, product, quantity)
- Inputs:
  - inventory: dict[str,int]
  - product: str
  - quantity: int ≥ 0
- Output: the product’s new quantity (int)
- Ideas: If product exists, add; otherwise create; assert quantity is valid

How it works:
1) Assert quantity is a non-negative int.
2) If product in inventory → inventory[product] += quantity else inventory[product] = quantity.
3) Return inventory[product].

Try: add_to_inventory({'Pen':5}, 'Pen', 2) → 7; add_to_inventory({}, 'Apple', 1) → 1

---

## lab9_task4.py – intersecting_chars(my_str) (Not implemented yet)
- Likely goal (based on name): Return characters that appear in ALL words of the string, or common characters between parts.
- Beginner-friendly plan to implement:
  1) Decide the format: if my_str is a single string with spaces, split it into words: words = my_str.split().
  2) For each word, build a set of its characters: set(word).
  3) Compute the intersection of all these sets.
  4) Return the result as a sorted string (or list) so it’s predictable.
- Example approach:
  ```python
  def intersecting_chars(my_str: str) -> str:
      assert type(my_str) == str
      words = my_str.split()
      if not words:
          return ''
      common = set(words[0])
      for w in words[1:]:
          common &= set(w)
      return ''.join(sorted(common))
  ```
- Try: intersecting_chars("class glass grass") → "as"

Once requirements are clarified, adapt the intersection rule (e.g., case-insensitive, letters only, etc.).
