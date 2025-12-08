from typing import Dict


def update_subject_grade(subject_grade: Dict[str, int], subject: str, new_grade: int) -> None:


    # Precondition: new_grade must be an integer
    assert isinstance(new_grade, int), "grade must be integer"

    # Precondition: subject must already exist in the dictionary
    assert subject in subject_grade, "subject must be already exist in subject_grade"

    # Update the grade for the specified subject
    subject_grade[subject] = new_grade


d = {"Math": 90, "English": 75, "Introduction to Python": 95, "Biology": 88}

print(f'Before: \n {d}')
update_subject_grade(d, "Math", 76)
print(f'Afrer: \n {d}')


subject_grade = d

# 1001 ---> d