N1 = float(input("What is your first number? "))
N2 = float(input("What is your second number? "))
N3 = float(input("What is your third number? "))
N4 = float(input("What is your fourth number? "))
Largest_Number = max(N1, N2, N3, N4)
Smallest_Number = min(N1, N2, N3, N4)
Average_Number = (Largest_Number + Smallest_Number) / 2
print(Average_Number)