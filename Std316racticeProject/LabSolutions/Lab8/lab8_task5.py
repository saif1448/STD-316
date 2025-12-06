import doctest

def reverse_str(s: str) -> str:
    """
    Returns the reversed version of the input string.
    
    The function takes a string and returns it with characters in reverse order.
    Only accepts string input, raises AssertionError for other types.
    
    >>> reverse_str("abcde")
    'edcba'
    >>> reverse_str("a")
    'a'
    >>> reverse_str("hello world")
    'dlrow olleh'
    >>> reverse_str("Python123")
    '321nohtyP'
    >>> reverse_str("!@#$%")
    '%$#@!'
    >>> reverse_str("")
    ''
    >>> reverse_str("racecar")
    'racecar'
    >>> reverse_str("A1B2C3")
    '3C2B1A'
    >>> reverse_str(123)
    Traceback (most recent call last):
    ...
    AssertionError: Input must be a string
    >>> reverse_str(True)
    Traceback (most recent call last):
    ...
    AssertionError: Input must be a string
    >>> reverse_str(None)
    Traceback (most recent call last):
    ...
    AssertionError: Input must be a string
    """
    assert type(s) == str, "Input must be a string"
    
    reversed_str = ''
    
    str_len = len(s)

    for i in range(str_len - 1, -1, -1):
        reversed_str += s[i]
        
    return reversed_str


doctest.testmod()