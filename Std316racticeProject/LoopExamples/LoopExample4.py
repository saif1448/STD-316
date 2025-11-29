

# Choose one of the following operation to perform:
# 1. Add 2 numer
# 2. Subtract 2 number
# 3. Multiply 2 number
# 4. Divide 2 number

def add_number(num1: int, num2: int)->int:
    return  num1 + num2

def subtract_number(num1: int, num2: int)->int:
    return num1 - num2

def mult_number(num1, num2):
    return  num1 * num2

def div_number(num1, num2):
    if num2 == 0:
        return 1
    return num1/num2

# is_program_running = True

while True:
    choice = int(input("Choose one of the following operation to perform:\n"
    + "1. Add 2 numer\n"
    + "2. Subtract 2 number\n"
    + "3. Multiply 2 number\n"
    + "4. Divide 2 number\n"
    + "0. Exit the program\n"))

    if choice == 1:
        result = add_number(5, 7)
        print(f'Result of addition: {result}')
    elif choice == 2:
        result = subtract_number(6, 7)
        print(f'Result of subtraction {result}')
    elif choice == 3:
        result = mult_number(6, 7)
        print(f'Result of multiplication {result}')
    elif choice == 4:
        result = div_number(6, 7)
        print(f'Result of division {result}')
    elif choice == 0:
        # is_program_running = False
        break
    else:
        print("Wrong input, try again!\n")


print("Good bye! Exiting the program!")



