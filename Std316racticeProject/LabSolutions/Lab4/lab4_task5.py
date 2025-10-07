import doctest

def xor_operator(a: bool, b: bool) -> bool:
    """
    Return the exclusive-or (XOR) of two boolean variables.

    Args:
        a (bool): First boolean value.
        b (bool): Second boolean value.

    Returns:
        bool: True if exactly one input is True, False otherwise.

    Examples:
        >>> xor_operator(True, False)
        True
        >>> xor_operator(False, True)
        True
        >>> xor_operator(True, True)
        False
        >>> xor_operator(False, False)
        False
        >>> xor_operator(None, True)
        Traceback (most recent call last):
        ...
        AssertionError: Both arguments must be bool
        >>> xor_operator(False, "True")
        Traceback (most recent call last):
        ...
        AssertionError: Both arguments must be bool
        >>> xor_operator([], False)
        Traceback (most recent call last):
        ...
        AssertionError: Both arguments must be bool
        >>> xor_operator(3 > 2, 2 > 3)
        True
        >>> xor_operator(True and False, False or True)
        True
    """
    assert isinstance(a, bool) and isinstance(b, bool), "Both arguments must be bool"
    return a != b

doctest.testmod()