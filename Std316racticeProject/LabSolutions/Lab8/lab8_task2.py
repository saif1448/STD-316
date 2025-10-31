################################### TASK 2 ###################################
import doctest
### Starting code ###
def repeat_sum(num:int) -> int:
    """ 
    Repeatedly sums up terms up to and including num
        * if num is even, sum up all even numbers
        * if num is odd, sum up all odd numbers
    
    >>> repeat_sum(10)
    30
    >>> repeat_sum(9)
    25
    >>> repeat_sum(20)
    110
    >>> repeat_sum(33)
    289
    >>> repeat_sum(15)
    64
    >>> repeat_sum(24)
    156
    """
    
    assert type(num) == int and num >= 0, "num must be a non-negative int"
    
    if num % 2 == 0:
        start = 2
    else:
        start = 1
        
    total = 0

    for i in range(start, num+1, 2):
        total += i

    return total


doctest.testmod()