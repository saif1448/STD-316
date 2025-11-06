import doctest

ALLOWED_NUMBER = 5

def calculate_average(numbers_str: str) -> float:
    """
    Calculates the average of the numbers in the specified string format.

    Parameters:
        numbers_str (str): A string containing 5 numbers separated by '|',
                           with possible spaces.

    Returns:
        float: The average of the numbers.

    >>> calculate_average('1|2|3|4|5')
    3.0
    >>> calculate_average('2 | 10 | 5 | 7 | 11')
    7.0
    """
    assert type(numbers_str) == str, "The input must be a string"

    numbers = numbers_str.split('|')

    assert len(numbers) == ALLOWED_NUMBER, "Input string must contain exactly 5 numbers."

    total = 0
    for i in range(ALLOWED_NUMBER):
        total += int(numbers[i].strip())

    return total/ALLOWED_NUMBER

doctest.testmod()