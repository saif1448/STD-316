from typing import Dict
import doctest

def return_subject_grade(subject_grade: Dict[str, int], subject: str, new_grade: int) -> Dict[str, int]:
    """
    Creates a copy of the original dictionary and updates the grade for the specified subject.
    
    Args:
        subject_grade (Dict[str, int]): Dictionary with subject names as keys and grades as values
        subject (str): The subject name to update
        new_grade (int): The new grade value to assign
        
    Returns:
        Dict[str, int]: A new dictionary with the updated grade
        
    Raises:
        AssertionError: If new_grade is not an integer
        AssertionError: If subject does not exist in subject_grade dictionary
    
    >>> return_subject_grade({"Math": 90, "English": 75, "Introduction to Python": 95, "Biology": 88}, "Math", 100)
    {'Math': 100, 'English': 75, 'Introduction to Python': 95, 'Biology': 88}
    
    >>> return_subject_grade({"Math": 90, "English": 75, "Introduction to Python": 95, "Biology": 88}, "English", 55)
    {'Math': 90, 'English': 55, 'Introduction to Python': 95, 'Biology': 88}
    
    >>> return_subject_grade({"Math": 90, "English": 75, "Introduction to Python": 95, "Biology": 88, "Introduction to Machine Learning": 97, "Database": 100}, "Introduction to Machine Learning", 56.5)
    Traceback (most recent call last):
    ...
    AssertionError: grade must be integer
    
    >>> return_subject_grade({"Math": 90, "English": 75, "Introduction to Python": 95, "Biology": 88, "Introduction to Machine Learning": 97, "Database": 100}, "Introduction to Machine Learning", 56)
    {'Math': 90, 'English': 75, 'Introduction to Python': 95, 'Biology': 88, 'Introduction to Machine Learning': 56, 'Database': 100}
    
    >>> return_subject_grade({"Math": 90}, "History", 80)
    Traceback (most recent call last):
    ...
    AssertionError: subject must be already exist in subject_grade
    """
    
    assert isinstance(new_grade, int), "grade must be integer"
    
    
    assert subject in subject_grade, "subject must be already exist in subject_grade"
    
    
    updated_grades = subject_grade.copy()
    
    
    updated_grades[subject] = new_grade
    
    
    return updated_grades

doctest.testmod()