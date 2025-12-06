
s1 = set()

s1.add(1)
s1.add(2)
s1.add(3)

print(s1)

s1.add(1)
s1.add(2)
s1.add(4)

print(s1)

s2 = set()
s2.add(4)
s2.add(5)
s2.add(7)

s3 = s1.union(s2)

print(s3)

s4 = s1.intersection(s2)
print(s4)


s5 = s1.difference(s2)

print(s5)