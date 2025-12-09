
std1 = {'identification': 101, 'name': 'Alice', 'age': 20, "marks" : [85, 90, 95], "hobbies" : ['reading', 'swimming']}
std2 = {'identification': 102, 'name': 'Bob', 'age': 22, "marks" : [80, 70, 75], "hobbies" : ['gaming', 'cycling']}

# Dictionary of dictionaries
std_list = {
    0: std1,
    1 : std2
}
    #0, std1
    #1, std2
for slno, student in std_list.items():
    for key, value in student.items():
        print(f"{key} : {value}")

