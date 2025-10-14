

def calculate_grade(mark : int) -> str:
    #precondition ---> check if you are providing right input
    """
    This function calculates the grade

    >>> calculate_grade(100)
    'A'
    >>> calculate_grade(60)
    'B'
    >>> calculate_grade(700)
    Traceback (most recent call last):
    ...
    AssertionError: Mark is out of range: 0-100
    >>> calculate_grade('abcd')
    Traceback (most recent call last):
    ...
    AssertionError: Type of mark should be int
    """
    assert type(mark) is int, 'Type of mark should be int'
    assert mark >=0 and mark <=100, f'Mark is out of range: 0-100'

    grade = ""
    if mark >= 90:
        grade = 'A'
    elif mark >= 60:
        grade = 'B'
    elif mark >= 30:
        grade = 'C'
    elif mark >= 20:
        grade = 'D'
    else:
        grade = 'F'

    #post condition
    assert grade, 'Grade is empty'  # This checks for non-empty and non-None
    return grade


grade_cal = calculate_grade(100)
print(grade_cal)