
# Lecture 06 – Arrays and Methods

---

## 1. Introduction to Arrays

An **array** is a collection of _fixed-size, same-type_ elements stored **contiguously in memory**.  
Instead of using multiple variables (e.g., `mark1, mark2, mark3`), arrays simplify data storage and access.

Example:

```java
int[] marks = new int[5];
```

This creates a structure to hold **5 integers**, indexed `0–4`.

---

## 2. Why Use Arrays?

|Problem Without Arrays|Solution With Arrays|
|---|---|
|`int s1, s2, s3, s4, s5;`|`int[] s = new int[5];`|
|Hard to process all items|Can loop through easily|
|Redundant code|Compact and efficient|

---

## 3. Array Declaration and Initialization

### Separate Declaration & Initialization

```java
int[] marks = new int[5];
marks[0] = 85;
marks[1] = 90;
marks[2] = 78;
marks[3] = 88;
marks[4] = 92;
```

### Combined Declaration

```java
int[] marks = {85, 90, 78, 88, 92};
```

---

## 4. Memory Visualization

ASCII Diagram:

```
Index →   0     1     2     3     4
Value →  85    90    78    88    92
```

✅ Index starts from **0**.  
⚠️ Accessing `marks[5]` causes **ArrayIndexOutOfBoundsException**.

---

## 5. Accessing Array Elements

```java
int[] marks = {85, 90, 78, 88, 92};
for (int i = 0; i < marks.length; i++) {
    System.out.println("marks[" + i + "] = " + marks[i]);
}
```

Output:

```
marks[0] = 85
marks[1] = 90
marks[2] = 78
marks[3] = 88
marks[4] = 92
```

---

## 6. Array Length Property

The `.length` property gives the total number of elements.

```java
System.out.println("Total Students = " + marks.length);
```

Output:

```
Total Students = 5
```

---

## 7. Using Arrays in Calculations

### Example – Average Marks

```java
int[] marks = {85, 90, 78, 88, 92};
int sum = 0;
for (int i = 0; i < marks.length; i++) {
    sum += marks[i];
}
double avg = (double) sum / marks.length;
System.out.println("Average = " + avg);
```

Output:

```
Average = 86.6
```

---

## 8. Array Input from User

```java
Scanner scan = new Scanner(System.in);
int[] nums = new int[5];
for (int i = 0; i < nums.length; i++) {
    System.out.print("Enter value " + (i+1) + ": ");
    nums[i] = scan.nextInt();
}
System.out.println("Values are:");
for (int i = 0; i < nums.length; i++)
    System.out.print(nums[i] + " ");
```

---

## 9. Finding Maximum and Minimum

```java
int[] arr = {12, 45, 23, 67, 9, 34};
int max = arr[0];
int min = arr[0];

for (int i = 1; i < arr.length; i++) {
    if (arr[i] > max)
        max = arr[i];
    if (arr[i] < min)
        min = arr[i];
}
System.out.println("Max = " + max);
System.out.println("Min = " + min);
```

---

## 10. Enhanced `for-each` Loop

Used when we only need to _read_ elements (not indexes).

```java
int[] marks = {85, 90, 78, 88, 92};
for (int mark : marks) {
    System.out.println(mark);
}
```

⚠️ You **cannot modify** array elements inside `for-each` directly.

---

## 11. Two-Dimensional Arrays (2D Arrays)

A **2D array** is like a table (rows × columns).

Declaration:

```java
int[][] matrix = new int[3][4];
```

or

```java
int[][] matrix = {
    {1, 2, 3, 4},
    {5, 6, 7, 8},
    {9, 10, 11, 12}
};
```

ASCII Diagram:

```
Row\Col | 0 | 1 | 2 | 3 |
--------|---|---|---|---|
   0    | 1 | 2 | 3 | 4 |
   1    | 5 | 6 | 7 | 8 |
   2    | 9 |10 |11 |12 |
```

---

## 12. Accessing 2D Arrays

```java
for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
    }
    System.out.println();
}
```

Output:

```
1 2 3 4
5 6 7 8
9 10 11 12
```

---

## 13. Summing Rows and Columns

### Sum of Each Row

```java
for (int i = 0; i < matrix.length; i++) {
    int rowSum = 0;
    for (int j = 0; j < matrix[i].length; j++)
        rowSum += matrix[i][j];
    System.out.println("Row " + i + " Sum = " + rowSum);
}
```

---

## 14. ⚠️ Common Array Mistakes

|Mistake|Explanation|
|---|---|
|Using wrong index (`arr[arr.length]`)|Index out of bounds|
|Forgetting to initialize|Default value used (0, 0.0, null)|
|Misunderstanding `.length`|Property, not a method — no parentheses|

---

## 15. Methods (Functions)

A **method** is a reusable block of code that performs a specific task.

### General Syntax

```java
returnType methodName(parameters) {
    // body
    return value; // optional
}
```

Example:

```java
public static int square(int x) {
    return x * x;
}
```

Call:

```java
int result = square(5);
System.out.println(result);
```

Output:

```
25
```

---

## 16. Method with Multiple Parameters

```java
public static double average(int a, int b, int c) {
    return (a + b + c) / 3.0;
}

public static void main(String[] args) {
    System.out.println("Average: " + average(10, 20, 30));
}
```

---

## 17. Returning Arrays from Methods

```java
public static int[] generateSquares(int n) {
    int[] squares = new int[n];
    for (int i = 0; i < n; i++)
        squares[i] = (i + 1) * (i + 1);
    return squares;
}

public static void main(String[] args) {
    int[] sq = generateSquares(5);
    for (int val : sq)
        System.out.print(val + " ");
}
```

Output:

```
1 4 9 16 25
```

---

## 18. Passing Arrays to Methods

Arrays are passed **by reference** (not by value).  
If the method modifies the array, the original array changes too.

```java
public static void increment(int[] arr) {
    for (int i = 0; i < arr.length; i++)
        arr[i]++;
}

public static void main(String[] args) {
    int[] numbers = {1, 2, 3};
    increment(numbers);
    System.out.println(Arrays.toString(numbers));
}
```

Output:

```
[2, 3, 4]
```

---

## 19. Overloaded Methods

Multiple methods can have the same name but different parameter lists.

```java
public static int add(int a, int b) {
    return a + b;
}

public static double add(double a, double b) {
    return a + b;
}
```

---

## 20. ⚠️ Common Method Mistakes

|Mistake|Result|
|---|---|
|Forgetting `return` in non-void method|Compilation error|
|Wrong parameter type in call|Type mismatch|
|Declaring method inside another|Illegal in Java|
|Not using `static` when calling from `main`|Compilation error|

---

## 21. Practice Problems

### 1️⃣ Basic Array Tasks

1. Write a program to find the **sum** and **average** of N numbers.

2. Find the **maximum** and **minimum** in an integer array.

3. Reverse an array and print the result.


---

### 2️⃣ 2D Array Tasks

1. Input a 3×3 matrix and display the **sum of each column**.

2. Display the **diagonal elements** of a square matrix.

3. Multiply two matrices (3×3).


---

### 3️⃣ Method Practice

1. Write a method `int factorial(int n)` using a loop.

2. Write a method `boolean isPrime(int n)` that returns `true` if `n` is prime.

3. Write a method `double average(int[] arr)` that returns the average of an array.


---

### 4️⃣ Moderate-Challenge Problems

**(a) Highest Scoring Student**

```java
Input: {85, 90, 78, 95, 88}
Output: Max = 95
```

**(b) Second Largest Element**

```java
Input: {4, 1, 7, 3, 9, 2}
Output: 7
```

**(c) Count Even and Odd Numbers**

```java
Input: {12, 5, 8, 3, 7}
Output: Even = 2, Odd = 3
```

**(d) Find Transpose of a Matrix**

```
Input:
1 2 3
4 5 6

Output:
1 4
2 5
3 6
```

---

### 5️⃣ Conceptual Questions

1. What is the difference between 1D and 2D arrays?

2. What happens if you access an index that doesn’t exist?

3. What is the advantage of passing arrays to methods?

4. Explain how Java handles parameters (call-by-value vs. reference).

5. Write a method that returns the **sum of even numbers** from an array.


---
