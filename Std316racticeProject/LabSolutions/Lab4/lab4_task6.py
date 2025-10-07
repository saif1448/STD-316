import doctest

def pound(expression: str) -> int:
    """
    Return the result of the pound operation defined as "x # y" = x^2 - y^2.

    Handles extra spaces and raises AssertionError for invalid formats.

    Good test cases (from task 2):
    >>> pound("2 # 3")
    -5
    >>> pound("0 # 0")
    0
    >>> pound("6 # 1")
    35
    >>> pound("10 # 2")
    96
    >>> pound("5 # 5")
    0
    >>> pound("100 # 99")
    199
    >>> pound("2#3")
    -5
    >>> pound(" 2 # 3")
    -5
    >>> pound("2 # 3 ")
    -5
    >>> pound("2 ##### 3")
    Traceback (most recent call last):
    ...
    AssertionError: invalid pound operator format
    >>> pound("2 # ")
    Traceback (most recent call last):
    ...
    AssertionError: missing operand
    >>> pound("a # 3")
    Traceback (most recent call last):
    ...
    AssertionError: operands must be integers
    >>> pound(5)
    Traceback (most recent call last):
    ...
    AssertionError: invalid argument type
    """

    assert type(expression) == str, "invalid argument type"
    expr = expression.strip()
    pound_index = expr.find('#')
   
    assert pound_index != -1 and expr.count('#') == 1, "invalid pound operator format"
    x_str = expr[:pound_index].strip()
    y_str = expr[pound_index+1:].strip()
    assert x_str and y_str, "missing operand"
    assert x_str.isdigit() and y_str.isdigit(), "operands must be integers"
    x = int(x_str)
    y = int(y_str)
    return x**2 - y**2

doctest.testmod()