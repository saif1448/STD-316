x = min(40,100,344,56,26)
print(f'Smallest Value: {x}')

y = max(40,100,344,56,26)
print(f'Biggest Value: {x}')

# when you want to use  variable, you have to wrap it up with curly brace ---> only for f-string
name = input("Enter your name: ")
print(f'Your Name is : {name}')

#type() ---> it shows the data type of a variable

print(f'X: {type(x)} , Y: {type(y)},  NAME: {type(name)}')


print(f'Memory Address of X: {id(x)}')