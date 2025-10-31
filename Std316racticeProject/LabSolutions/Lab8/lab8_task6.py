import doctest

def remove_vowels(s : str) -> str:
    """
    Removes all vowels (a, e, i, o, u) from the input string, both uppercase and lowercase.
    
    The function accepts strings containing only letters and spaces.
    Raises AssertionError if the string contains digits or other special characters.
    
    >>> remove_vowels("Python Programming")
    'Pythn Prgrmmng'
    >>> remove_vowels("abc")
    'bc'
    >>> remove_vowels("moving")
    'mvng'
    >>> remove_vowels("hello world")
    'hll wrld'
    >>> remove_vowels("AEIOU")
    ''
    >>> remove_vowels("bcdfg")
    'bcdfg'
    >>> remove_vowels("a")
    ''
    >>> remove_vowels("")
    ''
    >>> remove_vowels("APple")
    'Ppl'
    >>> remove_vowels(" ch erry")
    ' ch rry'
    >>> remove_vowels("XYZ xyz")
    'XYZ xyz'
    >>> remove_vowels(" number 1 ")
    Traceback (most recent call last):
    ...
    AssertionError: String must contain only letters and spaces
    >>> remove_vowels("test123")
    Traceback (most recent call last):
    ...
    AssertionError: String must contain only letters and spaces
    >>> remove_vowels("hello@world")
    Traceback (most recent call last):
    ...
    AssertionError: String must contain only letters and spaces
    """
    
    assert type(s) == str, "Input must be a string"
    for char in s:
        assert char.isalpha() or char.isspace(), "String must contain only letters and spaces"

    vowels = "aeiouAEIOU"
    
    result = ''
    
    for char in s:
        if char not in vowels:
            result += char

    return result

doctest.testmod()