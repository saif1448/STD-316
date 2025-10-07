weight = float(input("What is your weight in kg "))
height = float(input("What is your height in cm "))
height_in_meters = height / 100
BMI = weight / (height_in_meters ** 2)
print(round(BMI, 2))