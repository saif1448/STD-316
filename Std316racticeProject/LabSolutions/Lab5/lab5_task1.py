PI = 3.14159

def circle_area(radius: float) -> float:
    """
    Calculate the area of a circle given its radius using the formula:
    Area = PI * radius^2

    Precondition: radius must be a float between 0.0 and 1000.0

    >>> circle_area(2.0)
    12.56636
    >>> circle_area(4.0)
    50.26544
    """
    assert type(radius) == float, "radius must be a float"
    assert 0.0 <= radius <= 1000.0, "radius must be in range of 0.0 to 1000.0"

    return PI * radius ** 2


def circle_circumference(radius: float) -> float:
    """
    Calculate the circumference of a circle given its radius using the formula:
    Circumference = 2 * PI * radius

    Precondition: radius must be a float between 0.0 and 1000.0

    >>> circle_circumference(2.0)
    12.56636
    >>> circle_circumference(4.0)
    25.13272
    """
    assert type(radius) == float, "radius must be a float"
    assert 0.0 <= radius <= 1000.0, "radius must be in range of 0.0 to 1000.0"

    return 2 * PI * radius