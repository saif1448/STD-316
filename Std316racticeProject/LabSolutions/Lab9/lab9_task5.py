from typing import List
import doctest

def remove_item(name_list: List[str], item_to_remove: str)-> List[str]:
    """
    Remove all occurrences of a specific item from a list of product names.

    This function creates a new list containing all items from the original list
    except for the item to be removed. If the item doesn't exist, returns a copy
    of the original list.

    Args:
        products (List[str]): A list of product names
        item_to_remove (str): The name of the product to remove

    Returns:
        List[str]: A new list with the specified item removed

    >>> remove_item(["cellphone", "laptop", "microphone"], "laptop")
    ['cellphone', 'microphone']
    >>> remove_item(["cellphone", "laptop", "microphone"], "webcam")
    ['cellphone', 'laptop', 'microphone']
    >>> remove_item([], "laptop")
    []
    >>> remove_item(["laptop"], "laptop")
    []
    >>> remove_item(["phone", "laptop", "laptop", "mouse"], "laptop")
    ['phone', 'mouse']
    >>> remove_item(["a", "b", "c"], "d")
    ['a', 'b', 'c']
    """
    result = []
    for item in name_list:
        if item != item_to_remove:
            result.append(item)
    return result


doctest.testmod()