from typing import List, Tuple
import doctest
import math

def mean(values: List[int]) -> float:
    """
    Calculate and return the mean of a list
    
    >>> mean([2, 3, 4])
    3.0
    >>> mean([1, 2, 3, 4, 5])
    3.0
    """
    if not values:
        return 0.0
    return sum(values) / len(values)

def pearson_correlation(list_1: List[int], list_2: List[int]) -> float:
    """
    Calculate the Pearson correlation coefficient between two lists.

    Parameters:
    - list_1 (list): First list of numerical values.
    - list_2 (list): Second list of numerical values.

    Returns:
    - float: Pearson correlation coefficient.
    
    >>> pearson_correlation([2, 4, 6], [1, 3, 5])
    1.0
    
    """
    # Requirement: Check if lists have different lengths
    if len(list_1) != len(list_2):
        raise AssertionError("Lists must have the same length.")

    # Calculate the mean of each list
    mean_list_1 = mean(list_1)
    mean_list_2 = mean(list_2)

    # Calculate the numerator and denominator of the Pearson correlation formula
    numerator = 0
    for i in range(len(list_1)):
        numerator = (list_1[i] - mean_list_1) * (list_2[i] - mean_list_2)
    
    denominator_sum_list_1 = 0
    for x in list_1:
        denominator_sum_list_1 += (x - mean_list_1) ** 2
    
    denominator_sum_list_2 = 0
    for y in list_2:
        denominator_sum_list_2 += (y - mean_list_2) ** 2        
    
    denominator = (denominator_sum_list_1 * denominator_sum_list_2) ** 0.5

    if denominator == 0:
        raise AssertionError("Denominator is zero (standard deviation is zero).")

    # Calculate the correlation coefficient and handle division by zero
    correlation_coefficient = numerator / denominator
    
    return correlation_coefficient

def find_highest_correlation(reference_list: List[int], nested_list: List[List[int]]) -> (List[int], float):
    """
    Find the sublist in the nested list with the highest Pearson correlation with the reference list.

    Parameters:
    - reference_list (list): A list of numerical values representing a reference sequence.
    - nested_list (list): A nested list where each sublist contains numerical values.

    Returns:
    - Tuple: (sublist_with_highest_correlation, correlation_coefficient)
    
    >>> find_highest_correlation([1, 2, 3], [[4, 5, 6], [1, 2, 3], [7, 8, 9]])
    ([4, 5, 6], 1.0)
    """
    # Initialize variables to store the maximum correlation and corresponding sublist
    max_correlation = -float('inf')
    max_correlation_sublist = None

    # Iterate through each sublist in the nested list
    for sublist in nested_list:
        # Calculate the Pearson correlation with the reference list
        correlation = pearson_correlation(reference_list, sublist)

        # Update the maximum correlation and sublist if the current correlation is higher
        if correlation > max_correlation:
            max_correlation = correlation
            max_correlation_sublist = sublist

    # Return the sublist with the highest correlation and the corresponding correlation coefficient
    return max_correlation_sublist, round(max_correlation, 4) # please keep the round function

if __name__ == "__main__":
    # Example Usage:
    reference = [1, 2, 3]
    nested = [[4, 5, 6], [1, 2, 3], [7, 8, 9]]
    result = find_highest_correlation(reference, nested)
    print(result)
    
    # doctest.testmod()
