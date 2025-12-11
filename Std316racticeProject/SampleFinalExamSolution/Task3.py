from typing import List, Dict
import doctest


class Student:
    """ A class representing a student in EECS 1015 """

    def __init__(self, name: str, student_id: str, lab_grades: List[float]) -> None:
        """
        Constructor

        Param: name - str, student's name
               student_id - str, student's id
               lab_grades - a list of float (between 0.0 and 100.0), representing the grade of the first
               n labs in the order of labs (max 10 labs).

        >>> student_sam = Student("Sam", "samn3", [90.2, 97.8, 92.2])
        >>> student_sam._name
        'Sam'
        >>> student_sam._id
        'samn3'
        >>> student_sam._lab_grades["lab1"]
        90.2
        """
        assert type(name) == str, "Invalid name type"
        assert type(student_id) == str, "Invalid id type"
        assert type(lab_grades) == list and len(lab_grades) <= 10, "Invalid lab grade type"

        self._name = name
        self._id = student_id
        self._lab_grades = {}
        #[90.2, 97.8, 92.2]
        #  0    1     2
        #  lab1 lab2  lab3
        for i in range(len(lab_grades)):
            assert type(lab_grades[i]) == float and 0.0 <= lab_grades[i] <= 100.0, "Invalid grade"
            self._lab_grades[f"lab{i+1}"] = lab_grades[i]

    def update_grade(self, lab_index: int, grade: float) -> None:
        """
        Update the grade of a certain lab. Add the lab grade if it is not already in
        self._lab_grades

        >>> student_sam = Student("Sam", "samn3", [90.2, 97.8, 92.2])
        >>> student_sam.update_grade(5, 99.0)
        >>> student_sam._lab_grades["lab5"]
        99.0
        >>> student_sam.update_grade(2, 100.0)
        >>> student_sam._lab_grades["lab2"]
        100.0
        """
        assert type(lab_index) == int and 1 <= lab_index <= 10, "Invalid parameter"
        assert type(grade) == float and 0.0 <= grade <= 100.0, "Invalid parameter type"

        # [99.0, 97.8, 92.2]
        # lab1 -> 99.0
        # lab2 -> 97.8
        # lab3 -> 92.2

        # 2, 100.00
        # lab2 -> 100.0

        # 5, 67.0
        # lab5 -> 67.0
        lab_index = f"lab{lab_index}"
        self._lab_grades[lab_index] = grade

    def calculate_lab_average_grade(self, n: int) -> float:
        """
        Return the average of the lab grade if all 10 lab grades are available. n lowest grades are
        dropped (0 <= n <= 5).

        >>> student_sam = Student("Sam", "samn3", [100.0, 100.0, 100.0, 100.0, 100.0, 100.0,
        100.0, 0.0, 0.0, 0.0])
        >>> student_sam.calculate_lab_average_grade(3)
        100.0
        """

        assert len(self._lab_grades.values()) == 10, "Must have the grade of all 10 labs"
        assert type(n) == int and 0 <= n <= 5, "n must be an int that is <= 5"

        all_lab_grades = list(self._lab_grades.values())
        all_lab_grades.sort()

        included_lab_grade = all_lab_grades[n + 1:]

        return sum(included_lab_grade) / len(included_lab_grade)

    if __name__ == '__main__':
        doctest.testmod()


