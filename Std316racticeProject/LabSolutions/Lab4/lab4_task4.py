import doctest

def need_to_buy_ticket(age: int, height: float) -> bool:
    """
    Determine if a child needs to buy a ticket to enter a park.

    Args:
        age (int): Age of the child in years
        height (float): Height of the child in cm

    Returns:
        bool: Verdict if the child needs to buy a ticket
    
    Examples:
        >>> need_to_buy_ticket(5, 119.5)
        False
        >>> need_to_buy_ticket(7, 121)
        True
        >>> need_to_buy_ticket(5, 120.1)
        True
        >>> need_to_buy_ticket(-1, 110)
        Traceback (most recent call last):
        ...
        AssertionError: Age cannot be negative
        >>> need_to_buy_ticket(5, -110)
        Traceback (most recent call last):
        ...
        AssertionError: Height cannot be negative
        >>> need_to_buy_ticket("a", 110)
        Traceback (most recent call last):
        ...
        AssertionError: Invalid argument type
        >>> need_to_buy_ticket(5, "b")
        Traceback (most recent call last):
        ...
        AssertionError: Invalid argument type
    """
    assert (type(age) == int or type(age) == float) and (type(height) == int or type(height) == float), "Invalid argument type"
    assert age >= 0, "Age cannot be negative"
    assert height >= 0, "Height cannot be negative"
    
    if height > 120:
        return True
    elif age <= 6:
        return False
    

doctest.testmod()