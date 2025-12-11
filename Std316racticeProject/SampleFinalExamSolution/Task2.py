from typing import List, Tuple

def analyze_strings(data: List[List[str]]) -> Tuple[List[int], List[int],
int]:
    # hi cat ---> 5
    # a tool ---> 5
    # [5,5]
    # [3,7]
    #  5

    """
    Analyzes a nested list of strings and returns:
    1. A list with the total number of characters in each row.
    2. A list with the total number of characters in each column.
    3. A single integer: total number of vowels (a, e, i, o, u), case
    insensitive.
    Requirements: - Input must be a rectangular matrix (all rows same length). - Input must be a nested list containing only strings. - Empty matrix should return ([], [], 0).
    >>> analyze_strings([["hi", "cat"], ["a", "tool"]])
    ([5, 5], [3, 7], 5)
    >>> analyze_strings([])   # empty case
    ([], [], 0)
    >>> analyze_strings([["abc"]])   # single element
    ([3], [3], 1)
    >>> analyze_strings([["bbb", "ccc"], ["ddd", "fff"]])   # no vowels
    ([6, 6], [6, 6], 0)
    """

    # Validate type: must be list of lists
    assert isinstance(data, list), "Input must be a list."
    if data == []:
        return ([], [], 0)
    # All rows must be lists and non-empty
    for row in data:
        assert isinstance(row, list), "Each row must be a list."
        assert len(row) > 0, "Rows cannot be empty."

    # Validate rectangular structure
    col_count = len(data[0])
    for row in data:
        assert len(row) == col_count, "Matrix must be rectangular."
    # Validate elements are strings
    for row in data:
        for item in row:
            assert isinstance(item, str), "All elements must be strings."
    # 1. Row character counts
    # row_counts = [sum(len(s) for s in row) for row in data]
    row_counts = []
    # [hi, cat]
    for row in data:
        row_sum = 0
        #  hi
        #  cat
        for item in row:
            row_sum += len(item) # 2 + 3 = 5
        row_counts.append(row_sum)
    # 2. Column character counts
    #  0  1
    #0 hi cat
    #1 a tool

    # hi + a = 3 ---> 0 0 + 1 0
    # cat + tool = 7 ---> 0 1 + 1 1
    column_counts = []
    # for c in range(col_count):
    #     col_sum = sum(len(data[r][c]) for r in range(len(data)))
    for c in range(col_count):
        col_sum = 0
        for r in range(len(data)):
            col_sum += len(data[r][c])
        column_counts.append(col_sum)
    # 3. Total vowels
    vowels = set("aeiouAEIOU")
    # vowel_count = sum(ch in vowels for row in data for cell in row for ch in
    #                   cell)

    # hi cat
    vowel_count = 0
    for row in data:
        for col in row:
            for ch in col:
                if ch in vowels:
                    vowel_count += 1

    return (row_counts, column_counts, vowel_count)