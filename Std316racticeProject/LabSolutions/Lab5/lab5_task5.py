import doctest

def absolute_value(number_str: str) -> float:
    """
    Convert a string representation of an absolute number to its corresponding float value.

    Input string should be in format |number| where number can be
    positive, negative, or zero. The function returns the absolute value
    as a float.

    Preconditions:
    - number_str must be a string in the format |number|
    - number_str must start and end with '|'
    - The content between the '|' characters must be convertible to a float
    - The content cannot be empty
    - The content cannot contain any non-numeric characters except for a leading '-' for negative numbers and '.'
    - The string must have at least 3 characters (e.g |0|)

    >>> absolute_value("|2.3|")
    2.3
    >>> absolute_value("|-3|")
    3.0
    >>> absolute_value("|5|")
    5.0
    >>> absolute_value("|-4.7|")
    4.7
    >>> absolute_value("|0|")
    0.0
    >>> absolute_value("|0.0|")
    0.0
    >>> absolute_value("|-0|")
    0.0
    >>> absolute_value("|10.5|")
    10.5
    >>> absolute_value("|-7|")
    7.0
    >>> absolute_value("| 2.3 |")  # Whitespace should be handled
    2.3
    >>> absolute_value("|2.3| ")   # Trailing whitespace
    2.3
    >>> absolute_value(" |2.3|")   # Leading whitespace
    2.3
    >>> absolute_value("    |- 2.3|           ") #Whitespace after - sign
    2.3
    """


    # assert isinstance(number_str, str), "invalid argument"
    assert type(number_str) == str, "invalid argument"
    number_str = number_str.strip()
    assert len(number_str) >= 3, "invalid argument"
    assert number_str[0] == '|' and number_str[-1] == '|', "invalid argument"

    content = number_str[1:-1].strip().replace(" ", "")
    assert content != "", "content cannot be empty"

    # Check for minus sign
    if content[0] == '-':
        numeric_part = content[1:]
        assert content.count('-') == 1, "invalid argument"
    else:
        numeric_part = content
        assert content.count('-') == 0, "invalid argument"

    # Check for at most one decimal point
    assert numeric_part.count('.') <= 1, 'invalid argument'
    only_digits = numeric_part.replace('.', '', 1)
    assert only_digits.isdigit(), "invalid argument"

    return abs(float(content))
