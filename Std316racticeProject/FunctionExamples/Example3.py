import doctest

def find_the_biggest_number(a:int, b:int, c:int) -> int:
    '''
    This function find the biggest number among three numbers.

    >>> find_the_biggest_number(77,101,87)
    101
    >>> find_the_biggest_number(201, 301, 401)
    401
    '''
    if a > b and a > c:
        return a
    elif b > a and b > c:
        return b
    else:
        return c

doctest.testmod()