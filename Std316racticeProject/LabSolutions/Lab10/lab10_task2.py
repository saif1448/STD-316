import doctest

from typing import List


def contains_duplicates(nums: List[int]) -> bool:
    """
    returns whether there are duplicate elements in a given list

    >>> contains_duplicates([1, 2, 3, 4, 1])
    True
    >>> contains_duplicates([5, 6, 7, 8])
    False
    >>> contains_duplicates([2, 0, 1, 4, 5, 9, 10, 0])
    True
    >>> contains_duplicates([0])
    False
"""

    s = set()  # initialize an empty set
    result = None  # Note: None means the data has no type
    # [1,5,7,5,9]
    #  {1, 5, 7, 9 } ---> False
    for num in nums:
        if num in s:
            result = True
            break
        else:
            result = False
            s.add(num)

    return result


doctest.testmod()