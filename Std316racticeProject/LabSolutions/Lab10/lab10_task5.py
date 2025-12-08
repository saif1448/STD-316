from typing import Dict, List
import doctest

def invert_dict(student_grades: Dict[str, int]) -> Dict[int, List[str]]:
    """
    Inverts a dictionary of student grades by making grades the keys and student names the values.
    
    This function takes a dictionary where student names are keys and grades are values,
    and returns a new dictionary where grades are keys and lists of student names are values.
    The values are lists because multiple students can have the same grade.
    
    Args:
        student_grades (Dict[str, int]): Dictionary with student names as keys and grades as values
        
    Returns:
        Dict[int, List[str]]: Dictionary with grades as keys and lists of student names as values
        
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
    assert isinstance(student_grades, dict), "Input must be a dictionary"
    
    # Initialize the inverted dictionary
    inverted = {}
    
    # Iterate through each student and grade
    for student, grade in student_grades.items():
        # If this grade is already a key in inverted dict, add student to the list
        if grade in inverted:
            inverted[grade].append(student)
        else:
            # If this grade is not yet a key, create a new list with this student
            inverted[grade] = [student]
    
    return inverted

doctest.testmod()