from typing import Tuple
import doctest


def remove_item(name_list: Tuple[str], index: int) -> Tuple[str]:
    """
    Remove an item at a specific index from a tuple of product names.
    Args:
        name_list (Tuple[str]): A tuple of product names
        index (int): The index position of the product to remove (0-based)

    Returns:
        Tuple[str, ...]: A new tuple with the item at the specified index removed

    Raises:
        AssertionError: If the index is out of valid range

    >>> remove_item(("cellphone", "laptop", "microphone"), 1)
    ('cellphone', 'microphone')
    >>> remove_item(("cellphone", "laptop", "microphone"), 4)
    Traceback (most recent call last):
        ...
    AssertionError: Index out of range
    >>> remove_item((), 0)
    Traceback (most recent call last):
        ...
    AssertionError: Index out of range
    >>> remove_item(("laptop",), 0)
    ()
    >>> remove_item(("a", "b", "c", "d"), 0)
    ('b', 'c', 'd')
    >>> remove_item(("a", "b", "c", "d"), 3)
    ('a', 'b', 'c')
    >>> remove_item(("cellphone", "laptop", "microphone"), 2)
    ('cellphone', 'laptop')
    """

    assert 0 <= index < len(name_list), "Index out of range"
    # (a, b,c, d, e,f ), 3
    # (a, b, c) + (e,f)
    # ( : 3) + (3+1:)
    result = name_list[:index] + name_list[index+1:]
    return result


if __name__ == "__main__":
    doctest.testmod()