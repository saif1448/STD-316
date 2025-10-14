import doctest

# declaring the function with parameters
# creating the function body
# giving the type hints for parameter and return type
# create the docstring in the function at the begining
# in the docstring give the description what the function does
# outside docstring, give necessary preconditions
# before returning, if think you have to check the output nature, give necessary post conditions
# inside docstring, create necessary test cases
# give usual test cases for the correct input
# also give the test cases where the function can give error
# in the case error type "Traceback (most recent call last):"
# after that give three dots ...
# then give the AssertionError with your giving message

def add_two_numbers(a:int, b:int) -> int:
    """
    It adds two numbers and returns the result

    Test Cases:
    >>> add_two_numbers(5,7)
    12
    >>> add_two_numbers(6,4)
    10
    >>> add_two_numbers('a', 3)
    Traceback (most recent call last):
    ...
    AssertionError: invalid argument
    >>> add_two_numbers(3, 'a')
    Traceback (most recent call last):
    ...
    AssertionError: invalid argument
    """

    # we need some precondition ---> it assures you are taking the data or having the data correctly
    assert type(a) == int, "invalid argument"
    assert type(b) == int, "invalid argument"

    res = a + b

    #postcondition
    assert type(res) == int, "invalid data returned"

    return res


doctest.testmod()