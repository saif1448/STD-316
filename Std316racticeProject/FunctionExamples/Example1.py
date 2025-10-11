import math
# the function which will not take any input and not return any output

def say_hello():
    print('Saying hello from the function')


# the function will not take any input will return some output
def say_hello_multiple_times():
    hello = 'hello '* 5
    hi = 'hi ' * 6
    return hello + hi

# the function will take input in the parameter and not return any value
# the variables which are recieving inputs, they are called as parameters
def say_hello_to(name):
    print(f'Hello {name}')



say_hello()
output = say_hello_multiple_times()
print(output)

say_hello_to("Saif") # the value you are passing to the parameter , is called the argument
say_hello_to("Nafiur")

# the function will take take input and will return some output
def find_the_biggest_number(a, b, c):
    if a > b and a > c:
        return a
    elif b > a and b > c:
        return b
    else:
        return c


output = find_the_biggest_number(44,33,11)
print(output)
output = find_the_biggest_number(77,101,87)
print(output)
output = find_the_biggest_number(201, 301, 401)
print(output)
