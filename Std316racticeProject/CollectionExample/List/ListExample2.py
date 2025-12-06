ls1 = ['apple', 'banana', 'lichi', 'xyz']

ls2 = ls1 # it is creating an aliasing, both variables are indicating the same list

ls2.remove('banana') # removing from ls2 will also show the removing in ls1

print(ls1)


ls3 = ls1.copy()

print(f'ls1 -> {ls1}')
print(f'ls3 -> {ls3}')

ls3.remove('xyz')
print(f'ls1 -> {ls1}')
print(f'ls3 -> {ls3}')


# list is mutable ----> you can change the value of the list