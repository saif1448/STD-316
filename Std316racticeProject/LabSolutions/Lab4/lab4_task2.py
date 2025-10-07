import doctest

def pound(expression: str) -> int:
    """
    Return the result of the pound operation defined as "x # y" = x^2 - y^2.

    >>> pound("2 # 3")
    -5
    >>> pound("0 # 0")
    0
    >>> pound("6 # 1")
    35
    >>> pound(5)
    Traceback (most recent call last):
    ...
    AssertionError: invalid argument type
    """

    assert type(expression) == str, "invalid argument type"

    pound_index = expression.find('#')
    x_str = expression[:pound_index]
    x = int(x_str)

    y_str = expression[pound_index+1:].strip()
    y = int(y_str)

    return x**2 - y**2


# doctest.testmod()
