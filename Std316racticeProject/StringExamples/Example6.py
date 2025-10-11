

str1 = "this is a sample sample string"

print(str1.count('s'))

print(str1.find('s')) # find ---> first occurance of a string

print(str1.index('s')) # same as find

print(str1.replace('is', 'of'))

# it will slice the string from sample
# then it will replace mlp with tle

intail_idx = str1.index('sam')
print(str1[intail_idx:].replace('mpl', 'tle').upper())


