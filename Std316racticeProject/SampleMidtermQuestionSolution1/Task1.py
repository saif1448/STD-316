import doctest

def average_rating(a: int, b: int, c:int) -> float:
    '''
    This function gives the average of 3 integer numbers

    >>> average_rating(1,2,3)
    2.0
    >>> average_rating(7,10,13)
    10.0
    >>> average_rating(3,7,11)
    7.0
    >>> average_rating(9, 5, 10)
    8.0
    >>> average_rating(1, 4, 4)
    3.0
    >>> average_rating(0, 0, 0)
    Traceback (most recent call last):
    ...
    AssertionError: invalid parameter
    >>> average_rating(-3, 1, 2)
    Traceback (most recent call last):
    ...
    AssertionError: invalid parameter
    >>> average_rating(1, True, 2)
    Traceback (most recent call last):
    ...
    AssertionError: invalid parameter
    >>> average_rating(1, 4, '2')
    Traceback (most recent call last):
    ...
    AssertionError: invalid parameter
    '''

    assert type(a) == int and type(b) == int and type(c) == int, 'invalid parameter'
    assert a > 0 and b > 0 and c > 0, 'invalid parameter'

    avg = (a + b + c)/3



    return avg


doctest.testmod()


a  = 2.44444447
print(f'{a:.2f}')