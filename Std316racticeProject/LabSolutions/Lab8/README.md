# Lab 8 – Step-by-step Guide

Theme: Loops, math series, string/character operations, and simple algorithms.

---

## lab8_task1.py – is_prime and count_primes
- is_prime(num): True if num is prime, else False. Checks divisibility from 2 to num-1.
- count_primes(start, stop): counts primes in [start, stop].
- Inputs: positive ints
- Output: bool or int
- Ideas: for loops, modulo %, helper function reuse

How it works:
1) Validate integers > 0; 1 isn’t prime.
2) Try dividing by every i from 2 to num-1; if divisible, not prime.
3) count_primes loops through the range and counts where is_prime is True.

Try: count_primes(2, 12) → 5

---

## lab8_task2.py – repeat_sum(num)
- Rule: Sum up to num including:
  - if num even → sum even numbers (2 + 4 + ... + num)
  - if num odd → sum odd numbers (1 + 3 + ... + num)
- Input: non-negative int
- Output: int sum
- Idea: Choose start (2 or 1); step by 2 in range()

How it works:
1) Validate num ≥ 0.
2) start = 2 if even else 1.
3) Loop i from start to num (inclusive) with step 2, accumulate.

Try: repeat_sum(10) → 30; repeat_sum(9) → 25

---

## lab8_task3.py – approximate_pi(m)
- Approximates π using the Leibniz series up to m terms.
- Input: m (int ≥ 0)
- Output: float rounded to 4 decimals
- Ideas: Alternating signs ((-1)^n), sum of fractions, multiply by 4, round

How it works:
1) result = 0
2) For n in 0..m: add ((-1)**n)/(2n+1)
3) Multiply by 4 and round to 4 decimals.

Try: approximate_pi(100) → about 3.1515

---

## lab8_task4.py – encrypt(message, shift) (Caesar cipher)
- Shifts uppercase letters by `shift` positions; keeps digits/punctuation/spaces unchanged.
- Input: message (str), shift (int)
- Output: encrypted string
- Ideas: ord()/chr() to map letters A..Z to 0..25, add shift, wrap with % 26

How it works:
1) For each char: if char.isupper():
2) Convert to 0..25, add shift, mod 26, back to a letter.
3) Else keep char as is.

Try: encrypt("ATTACK AT DAWN", 1) → "BUUBDL BU EBXO"

---

## lab8_task5.py – reverse_str(s)
- Returns the reversed string.
- Input: str only (asserts otherwise)
- Output: str
- Ideas: Loop from end to start; build up a result string

How it works:
1) Assert type str.
2) Use for i from len(s)-1 down to 0; add s[i] to result.

Try: reverse_str("hello world") → "dlrow olleh"

---

## lab8_task6.py – remove_vowels(s)
- Removes vowels (a,e,i,o,u both cases). Only letters and spaces allowed.
- Input: str with letters/spaces
- Output: str with vowels removed
- Ideas: Validate characters, simple membership test against "aeiouAEIOU"

How it works:
1) Assert s is str; every char must be .isalpha() or .isspace().
2) For each char: if not a vowel, append to result.

Try: remove_vowels("Python Programming") → "Pythn Prgrmmng"
