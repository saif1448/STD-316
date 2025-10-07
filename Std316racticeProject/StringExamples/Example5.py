# string is immutable

str1 = "value 1"
str1 = "value 2"

print(str1)


str1 = "w" + str1[1:]

print(str1)