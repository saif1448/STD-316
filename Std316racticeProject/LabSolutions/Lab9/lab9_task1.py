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
    # allowed number = 5, range(allowed number) ---> 0 - 4, numbers[0] -> num, number[1] -> num
    # for i in range(ALLOWED_NUMBER):
    #     total += int(numbers[i].strip())

    for num_str in numbers:
        # num_str = num_str.strip()
        # num = int(num_str)
        # total += num
        total += int(num_str.strip())


    return total/ALLOWED_NUMBER

doctest.testmod()