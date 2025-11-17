from typing import Dict

def update_subject_grade(subject_grade: Dict[str, int], subject: str, new_grade: int) -> None:
    """
    Updates the grade for a specific subject in the given dictionary.
    
    This function modifies the original dictionary in-place by updating the grade
    for the specified subject with the new grade value. The function returns nothing.
    
    Args:
        subject_grade (Dict[str, int]): Dictionary with subject names as keys and grades as values
        subject (str): The subject name to update
        new_grade (int): The new grade value to assign
        
    Returns:
        None: This function modifies the dictionary in-place and returns nothing
        
    Raises:
        AssertionError: If new_grade is not an integer
        AssertionError: If subject does not exist in subject_grade dictionary
    """
    
    # Precondition: new_grade must be an integer
    assert isinstance(new_grade, int), "grade must be integer"
    
    # Precondition: subject must already exist in the dictionary
    assert subject in subject_grade, "subject must be already exist in subject_grade"
    
    # Update the grade for the specified subject
    subject_grade[subject] = new_grade