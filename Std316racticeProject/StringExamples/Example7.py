# str1 = 'This is a string' + 1 --> this will give error because it doesnt automaticaly cast other types to string
# print(str1)

str1 = 'This is a string' + str(1)
print(str1)

#Placeholder
country = "Bangladesh"
str2 = 'My country is %s'%country
print(str2)

age = 23 # int ---> %d
address = "asbcasd " # str ---> %s
name = "ABCD" # str
salary = 23.56 # float ---> %f
isPresent = False # boolean ---> %r

str3 = 'His name is %s, his address is %s, his age is %d, salary is %.2f, is he canadian: %r' %(name, address, age, salary, isPresent)
print(str3)

str4 = 'His name is {}, his address is {}, his age is {}, salary is {}, is he canadian: {}'.format(name, address, age, salary, isPresent)
print(str4)

str5 = f'His name is {name}, his address is {address}, his age is {age}, salary is {salary}, is he canadian: {isPresent}'
print(str5)