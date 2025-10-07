# Membership operator ---> in

name = "Saif Mahmud Parvez"
middle_name = "Mahmud"

print(middle_name in name)

if middle_name in name:
    print("Valid Name")
else:
    print("Invalid Name")


# len() ---> this function returns how many elements in that

print(f"Name has {len(name)} this many chars")


# that means string is a list of character --> list means array
# so we can index on string

print(name[0]) # we are indexing here

# we can use negative index value to index from the end --> it starts form -1
print(name[-3])

