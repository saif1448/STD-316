from typing import Tuple


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


val = find_the_biggest_number(10, 20, 30)
print(val)

# you can return multiple value
def area_perimeter(length:int, width:int) -> Tuple[int, int]:
    """
    This function calculates the area and perimiter of a rectangle
    """
    area = length * width
    perimeter = 2* (length + width)
    return area, perimeter

a, p = area_perimeter(100, 100)
print(f'Area: {a}, Perimeter: {p}')