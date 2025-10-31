import doctest

def need_to_buy_ticket(age: float, height: float) -> bool:
    """
    Determining whether a child should buy a ticket to enter a park given conditions

    #Args:
    age <= 6, no need to buy ticket
    height > 120cm, the child should buy the ticket regardless of age

    Returning True if a child needs to buy a ticket
    Returning False if a child does not need to buy a ticket

    >>> need_to_buy_ticket(5, 119.5)
    False
    >>> need_to_buy_ticket(7,121)
    True
    >>> need_to_buy_ticket(5,120.1)
    True
    >>> need_to_buy_ticket(-1,110)
    Traceback (most recent call last):
    ...
    AssertionError: age must be positive
    >>> need_to_buy_ticket(5,-110)
    Traceback (most recent call last):
    ...
    AssertionError: height must be positive
    >>> need_to_buy_ticket('a', 110)
    Traceback (most recent call last):
    ...
    AssertionError: invalid argument type
    >>> need_to_buy_ticket(5, 'b')
    Traceback (most recent call last):
    ...
    AssertionError: invalid argument type
    >>> need_to_buy_ticket(8.4, 101.2)
    True
    """

    assert type(age) == float or type(age) == int, "invalid argument type"
    assert type(height) == float or type(height) == int, "invalid argument type"

    assert age > 0, "age must be positive"
    assert height > 0, "height must be positive"

    if height > 120:
        return True
    elif age <= 6:
        return False
    else:
        return True

doctest.testmod()