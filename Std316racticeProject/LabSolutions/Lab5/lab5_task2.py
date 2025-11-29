import doctest
x = 0.0
y = 0.0
def function1(value: float) -> None:
    global x
    x = value + y
    return

def function2(value: float) -> None:
    global y
    y = value
    return


# SUBMIT ONLY THIS FUNCTION
def problematic_function(x_value: float, y_value: float) -> float:
    """
    Fix the scope issue and correctly compute the sum of x_value and y_value using global variables

    >>> problematic_function(10.0, 5.0)
    20.0
    >>> problematic_function(10.0, -5.0)
    0.0
    >>> problematic_function(5.9, 2.1)
    10.1
    >>> problematic_function(67, 8.5)
    Traceback (most recent call last):
    ...
    AssertionError: invalid argument
    """
    assert type(x_value) == float, "invalid argument"
    assert type(y_value) == float, "invalid argument"
    #
    # global x, y
    # y = 0.0  # Initialize y first since function1 depends on it
    # x = 0.0

    function2(y_value)
    function1(x_value)

    # Do not modifiy anything below this line
    return x + y 


doctest.testmod()