from typing import Dict, List
import doctest

def invert_dict(input_dictionary: Dict[str, int]) -> Dict[int, List[str]]:
    """
    Inverts a dictionary of key grades by making grades the keys and key names the values.
    
    This function takes a dictionary where key names are keys and grades are values,
    and returns a new dictionary where grades are keys and lists of key names are values.
    The values are lists because multiple students can have the same value.
    
    Args:
        input_dictionary (Dict[str, int]): Dictionary with key names as keys and grades as values
        
    Returns:
        Dict[int, List[str]]: Dictionary with grades as keys and lists of key names as values
        
    Raises:
        AssertionError: If input is not a dictionary
    
    >>> invert_dict({"Alice": 85, "Bob": 92})
    {85: ['Alice'], 92: ['Bob']}
    >>> invert_dict({"Charlie": 78, "Diana": 95, "Eve": 78})
    {78: ['Charlie', 'Eve'], 95: ['Diana']}
    >>> invert_dict({"Frank": 100})
    {100: ['Frank']}
    >>> invert_dict({})
    {}
    >>> invert_dict({"Pikachu": 99, "Snorlex": 30})
    {99: ['Pikachu'], 30: ['Snorlex']}
    >>> invert_dict({"Pikachu": 99, "Snorlex": 30, "Bulbasaur": 30})
    {99: ['Pikachu'], 30: ['Snorlex', 'Bulbasaur']}
    >>> invert_dict([30, 20])
    Traceback (most recent call last):
    ...
    AssertionError: Input must be a dictionary
    """


    # Precondition: input must be a dictionary
    assert isinstance(input_dictionary, dict), "Input must be a dictionary"
    
    # Initialize the inverted dictionary
    inverted = {}
    #    key     val   key    val  key   val
    #{"Charlie": 78, "Diana": 95, "Bob": 78}
    # {78 : [Charlie, Bob], 95 : [Diana]}

    # Iterate through each key and value
    for key, value in input_dictionary.items():
        # If this value is already a key in inverted dict, add key to the list
        if value in inverted:
            inverted[value].append(key)
        else:
            # If this value is not yet a key, create a new list with this key
            inverted[value] = []
            inverted[value].append(key)
    
    return inverted

doctest.testmod()