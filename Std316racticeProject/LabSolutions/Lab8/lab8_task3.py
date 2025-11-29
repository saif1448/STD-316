################################### TASK 3 ###################################
### Starting code ###
import doctest
def approximate_pi(m):
    """
    Approximates pi using the Leibniz formula up to m terms.
    
    The Leibniz formula: π = 4 * Σ((-1)^n / (2n + 1)) for n from 0 to m
    
    >>> approximate_pi(1)
    2.6667
    >>> approximate_pi(5)
    2.976
    >>> approximate_pi(8)
    3.2524
    >>> approximate_pi(20)
    3.1892
    >>> approximate_pi(10)
    3.2323
    >>> approximate_pi(50)
    3.1612
    >>> approximate_pi(100)
    3.1515
    >>> approximate_pi(500)
    3.1436
    """
    result = 0  
    ### Your code here ###  
    for n in range(0, m+1):
        result += ((-1) ** n) / (2 * n + 1)
    
    result *= 4
    
    
    return round(result, 4)


doctest.testmod()