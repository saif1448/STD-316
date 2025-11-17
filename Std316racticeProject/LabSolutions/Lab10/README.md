# Lab 10 – Step-by-step Guide

Theme: Collections (lists, dictionaries, sets), debugging, algorithms, and memory management concepts.

---

## lab10_task1.py – Merging sorted lists
- Goal: Combine two already-sorted lists into one sorted list efficiently.
- Inputs: Two sorted lists of integers
- Output: One merged sorted list
- Ideas: Two-pointer technique, helper function validation, list slicing

How it works:
1) **is_sorted()** helper validates that inputs are sorted (precondition check).
2) Use two pointers (i, j) to track position in each list.
3) Compare elements at current positions, add smaller one to result.
4) Move pointer forward in the list whose element was added.
5) When one list is exhausted, append remaining elements from the other.

Step-by-step for merge_lists([0,1,3,5], [0,1,2,4,6]):
- i=0, j=0: Compare 0 vs 0 → add 0 (from list_2), j=1
- i=0, j=1: Compare 0 vs 1 → add 0 (from list_1), i=1
- i=1, j=1: Compare 1 vs 1 → add 1 (from list_2), j=2
- Continue until one list exhausted...

Try: merge_lists([1,3], [2,4]) → [1,2,3,4]

---

## lab10_task2.py – contains_duplicates(nums)
- Goal: Return True if any number appears more than once in the list.
- Input: List of integers
- Output: bool (True = has duplicates, False = all unique)
- Ideas: Set membership test (O(1) lookup), early exit optimization

How it works:
1) Create an empty set to track seen numbers.
2) Loop through each number in the list.
3) If number already in set → duplicate found, return True immediately.
4) Otherwise, add number to set and continue.
5) If loop completes without finding duplicates → return False.

Why sets? Sets only store unique elements, so checking "if num in set" is very fast.

Try: contains_duplicates([1,2,3,1]) → True (1 appears twice)
Try: contains_duplicates([5,6,7,8]) → False (all unique)

---

## lab10_task3.py – majority_element(nums)
- Goal: Find element(s) that appear most frequently. If tie, return all in sorted order.
- Input: List of integers
- Output: List of most frequent elements (sorted)
- Ideas: Dictionary counting, finding maximum, filtering, sorting

How it works:
1) Validate input is list and contains only integers.
2) Handle edge case: empty list → return [].
3) Count frequency of each element using dictionary.
4) Find the maximum count among all frequencies.
5) Collect all elements that have this maximum count.
6) Sort and return the result.

Step-by-step for [2,2,2,3,1,2,2,3,3]:
- Count: {2:5, 3:3, 1:1}
- Max count: 5
- Elements with max count: [2]

Try: majority_element([3,3,1,1]) → [1,3] (both appear 2 times)

---

## lab10_task4-1.py – update_subject_grade() (In-place modification)
- Goal: Update a grade in the original dictionary (modifies the input).
- Function: update_subject_grade(dict, subject, new_grade) → None
- Ideas: Mutable objects, pass-by-reference, in-place modification, assertions

How it works:
1) Validate new_grade is an integer.
2) Validate subject exists in the dictionary.
3) Directly update: dict[subject] = new_grade.
4) Return nothing (None) because we modified the original.

**Key concept**: Dictionaries are mutable. When you pass a dict to a function, you're passing a reference to the same object. Changes inside the function affect the original dict.

Example:
```python
grades = {"Math": 90, "English": 75}
update_subject_grade(grades, "Math", 85)
print(grades)  # {"Math": 85, "English": 75} - original changed!
```

---

## lab10_task4-2.py – return_subject_grade() (Copy and modify)
- Goal: Update a grade in a copy of the dictionary (preserves the original).
- Function: return_subject_grade(dict, subject, new_grade) → dict
- Ideas: Shallow copy, immutable approach, functional programming style

How it works:
1) Same validation as task 4-1.
2) Create copy: new_dict = original_dict.copy().
3) Update the copy: new_dict[subject] = new_grade.
4) Return the updated copy.

**Key concept**: .copy() creates a new dictionary object with the same key-value pairs. Changes to the copy don't affect the original.

Example:
```python
original = {"Math": 90, "English": 75}
updated = return_subject_grade(original, "Math", 85)
print(original)  # {"Math": 90, "English": 75} - unchanged
print(updated)   # {"Math": 85, "English": 75} - new dict
```

---

## Key Concepts Summary

**Memory and References:**
- **Mutable objects** (lists, dicts): Changes inside functions affect the original
- **Immutable approach**: Create copies to preserve original data

**Collections:**
- **Lists**: Ordered, allow duplicates, indexed access
- **Sets**: Unordered, no duplicates, fast membership testing
- **Dictionaries**: Key-value pairs, fast lookup by key

**Algorithms:**
- **Two-pointer technique**: Efficient for merging sorted data
- **Frequency counting**: Use dicts to count occurrences
- **Early exit**: Stop as soon as you find what you need

**When to modify vs copy:**
- **Modify original**: When you want changes to persist (like updating a database record)
- **Create copy**: When you need to preserve history, enable undo, or avoid side effects

Try thinking of real examples:
- Bank account balance (modify original)
- Document editing with undo (create copies)
- Shopping cart (modify) vs order history (preserve copies)