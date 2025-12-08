# List is similar to an array
# it is a dynamic array
# means you can add as many element as you want
# also you can delete any element as you want

# in the list, items are placed sequentially

# we can insert different types of data inside a list
# but best practice is not to insert different types of data
# only insert single type of data

# every collection is  form of data structure
# there are several basic operations
# 1. insertion
# 2. deletion
# 3. traversal
# 4. sort ---> not every one support sorting
# 5. merge

ls = [] # it is a blank list, square bracket indicates it is a list

# len() --->

print(len(ls))
print(type(ls))

# insert
# 1. append()
ls.append("abcd")
ls.append("qweqwe")
# 2. insert()
ls.insert(1, "oiqwoe")
ls.insert(5, "asdasd")

print(ls)


ls1 = [1,2,3]
ls2 = [4,5,6]

#merging
# this is only for joining multiple list

# ls1 = ls1 + ls2
ls1.extend(ls2)
print(ls1)


# deletion
# 1. remove()
# 2. pop() --> deletes value at an index pop(index)
# 3. clear()
ls1.remove(2)
print(ls1)


ls1.clear()
print(ls1)

# traversing
ls1 = ['apple', 'banana', 'grape']
for v in ls1:
    print(v)


# sorting
ls1 = [5,1,6,2,8,23,9]
ls1.sort()
print(ls1)





