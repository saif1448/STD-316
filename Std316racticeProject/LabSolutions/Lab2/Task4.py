lab1_grade = int(input())
lab2_grade = int(input())
assignment_grade = int(input())
midterm_grade = int(input())
final_grade = int(input())
lab = max(lab1_grade, lab2_grade)
course_score = lab * 0.05 + assignment_grade * 0.2 + midterm_grade * 0.25 + final_grade * 0.5
print(course_score)