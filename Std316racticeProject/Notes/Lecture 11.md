# Lecture 11: Collections Part 3 Summary

This document provides a comprehensive summary of Lecture 11, focusing on **Nested Collections** (lists within lists, dictionaries within dictionaries) and **Nested Loops**.

---

## 1. Nested Data Types

A nested data type is a collection that contains other collections as elements.

### 1.1 Nested Lists
A list where elements are other lists. This is often used to represent matrices or grids.

```python
# A 3x3 matrix (list of 3 lists)
matrix = [
    [1, 2, 3], 
    [4, 5], 
    [6, 7, 8, 9]
]
```

**Accessing Elements:**
Use multiple indices. The first index selects the inner list, the second index selects the element within that inner list.
```python
val = matrix[0][1] # Accesses the first list ([1, 2, 3]), then the second element (2)
print(val) # Output: 2
```

### 1.2 Nested Dictionaries
A dictionary where values are other dictionaries (or lists, tuples, etc.).

```python
grades = {
    'Sam': {'Labs': [90, 95], 'Exams': [78, 99]},
    'Snorlax': {'Labs': [0, 0], 'Exams': [0, 0]}
}
```

**Accessing Elements:**
```python
sam_lab_1 = grades['Sam']['Labs'][0]
print(sam_lab_1) # Output: 90
```

---

## 2. Nested Loops

Nested loops are loops inside other loops. They are essential for iterating through nested data structures.

### 2.1 Looping Through Nested Lists (By Element)
```python
matrix = [
    [1, 2, 3], 
    [4, 5], 
    [6, 7, 8, 9]
]

for row in matrix:       # Outer loop: iterates through each inner list
    for item in row:     # Inner loop: iterates through elements of the inner list
        print(item)
```

### 2.2 Looping Through Nested Lists (By Index)
Using indices allows you to modify the elements if needed.

```python
for i in range(len(matrix)):          # i is the index of the row
    for j in range(len(matrix[i])):   # j is the index of the column
        print(matrix[i][j])
```

**Trace:**
1.  `i=0`: `matrix[0]` is `[1, 2, 3]`.
    *   `j=0`: prints `1`
    *   `j=1`: prints `2`
    *   `j=2`: prints `3`
2.  `i=1`: `matrix[1]` is `[4, 5]`.
    *   `j=0`: prints `4`
    *   `j=1`: prints `5`
...and so on.

---

## 3. Coding Style for Nested Data

*   **Formatting**: Use indentation to make the structure clear. Don't put a massive nested structure on a single line.
    *   *Bad*: `a = [[1,2,3],[4,5,6],[7,8,9]]`
    *   *Good*:
        ```python
        a = [
            [1, 2, 3],
            [4, 5, 6],
            [7, 8, 9]
        ]
        ```
*   **Readability**: If nesting gets too deep (e.g., list of dicts of lists of tuples), consider redesigning your data structure or using classes.

---

## 4. Summary

*   **Nested Collections**: Allow for complex data modeling (grids, tables, hierarchical data).
*   **Access**: Use multiple brackets `[][]` to drill down into the structure.
*   **Iteration**: Use nested loops (`for` inside `for`) to process every element.
