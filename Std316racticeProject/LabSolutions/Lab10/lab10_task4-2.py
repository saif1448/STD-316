from typing import Dict
import doctest

def return_subject_grade(subject_grade: Dict[str, int], subject: str, new_grade: int) -> Dict[str, int]:
    """
    Creates a copy of the original dictionary and updates the grade for the specified subject.
    
    This function creates a copy of the original subject_grade dictionary, updates the grade
    for the specified subject with the new grade in the copied dictionary, and returns the
    updated dictionary without altering the original dictionary.
    
    Args:
        subject_grade (Dict[str, int]): Dictionary with subject names as keys and grades as values
        subject (str): The subject name to update
        new_grade (int): The new grade value to assign
        
    Returns:
        Dict[str, int]: A new dictionary with the updated grade
        
    Raises:
        AssertionError: If new_grade is not an integer
        AssertionError: If subject does not exist in subject_grade dictionary
    
    >>> return_subject_grade({"Math": 90, "English": 75}, "Math", 85)
    {'Math': 85, 'English': 75}
    >>> return_subject_grade({"Science": 80, "History": 90, "Art": 95}, "History", 88)
    {'Science': 80, 'History': 88, 'Art': 95}
    """
    
    assert isinstance(new_grade, int), "grade must be integer"
    
    
    assert subject in subject_grade, "subject must be already exist in subject_grade"
    
    
    updated_grades = subject_grade.copy()
    
    
    updated_grades[subject] = new_grade
    
    
    return updated_grades

doctest.testmod()