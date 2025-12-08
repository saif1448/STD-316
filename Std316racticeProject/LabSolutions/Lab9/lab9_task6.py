from typing import List
import doctest


def remove_item(name_list: List[str], index: int) -> List[str]:
    """
    Remove an item at a specific index from a list of product names.

    This function creates a new list containing all items except the one at the
    specified index. If the index is out of range, raises an AssertionError.

    Args:
        name_list (List[str]): A list of product names
        index (int): The index position of the product to remove (0-based)

    Returns:
        List[str]: A new list with the item at the specified index removed

    Raises:
        AssertionError: If the index is out of valid range

    >>> remove_item(["cellphone", "laptop", "microphone"], 1)
    ['cellphone', 'microphone']
    >>> remove_item(["cellphone", "laptop", "microphone"], 4)
    Traceback (most recent call last):
        ...
    AssertionError: Index out of range
    >>> remove_item([], 0)
    Traceback (most recent call last):
        ...
    AssertionError: Index out of range
    >>> remove_item(["laptop"], 0)
    []
    >>> remove_item(["a", "b", "c", "d"], 0)
    ['b', 'c', 'd']
    >>> remove_item(["a", "b", "c", "d"], 3)
    ['a', 'b', 'c']
    """

    assert 0 <= index < len(name_list), "Index out of range"

    result = name_list.copy()
    result.pop(index)

    return result


doctest.testmod()