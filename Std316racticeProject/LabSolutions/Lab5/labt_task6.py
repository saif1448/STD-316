import doctest

def is_even(n: int) -> bool:
    """
    Returns True if the input integer is even, False otherwise.

    Preconditions:
    - n must be an integer (no floats, strings, or other types)

    >>> is_even(4)
    True
    >>> is_even(-5)
    False
    >>> is_even(0)
    True
    >>> is_even(-2)
    True
    >>> is_even(1)
    False
    >>> is_even(99999998)
    True
    >>> is_even(-99999999)
    False
    """
    assert type(n) == int, "Input must be an integer."
    return n % 2 == 0


doctest.testmod()