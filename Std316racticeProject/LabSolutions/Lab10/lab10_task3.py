from typing import List
import doctest

def majority_element(nums: List[int]) -> List[int]:
    """
    Returns the majority element(s) in a list - elements that appear most frequently.
    If multiple elements appear equally frequently, returns all of them in ascending order.
    
    
    >>> majority_element([2, 2, 2, 3, 1, 2, 2, 3, 3])
    [2]
    >>> majority_element([3, 3, 1, 1])
    [1, 3]
    >>> majority_element([5, 5, 5, 5, 5])
    [5]
    >>> majority_element([1, 3, 2, 1, 3, 3, 3, 1, 2, 3, 2, 1, 2, 2, 1])
    [1, 2, 3]
    >>> majority_element([])
    []
    >>> majority_element(['1', '2'])
    Traceback (most recent call last):
    ...
    AssertionError: All elements must be integers
    >>> majority_element((3, 3, 4, 5))
    Traceback (most recent call last):
    ...
    AssertionError: Input must be a list
    >>> majority_element([7, 8, 9, 7, 8])
    [7, 8]
    >>> majority_element([10, 20, 30])
    [10, 20, 30]
    >>> majority_element([99, 99, 99])
    [99]
    >>> majority_element([-1, -1, 0, 0, 1])
    [-1, 0]
    """
    
    
    assert isinstance(nums, list), "Input must be a list"

    for element in nums:
        assert isinstance(element, int), "All elements must be integers"

    if len(nums) == 0:
        return []

    frequency = {}
    for num in nums:
        if num in frequency:
            frequency[num] += 1
        else:
            frequency[num] = 1
    

    max_count = max(frequency.values())
    

    result = []
    for num, count in frequency.items():
        if count == max_count:
            result.append(num)
    

    result.sort()
    
    return result

doctest.testmod()