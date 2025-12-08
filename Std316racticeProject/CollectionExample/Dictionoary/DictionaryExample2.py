d =  {1 : 2, 2: 3, 3 : 3, 4 : 2, 5 : 2}

print(d.keys()) # keys() ---> gives all teh keys in the dictionary
print(d.values()) # value() ---> gives all the values in the dictionary

m = max(d.values())
print(m)


# items

print(d.items()) # it will give you both the keys and values

# ls = [(1, 2), (2, 3), (3, 3), (4, 2), (5, 2)]
res = []
for key, value  in d.items():
    if value == m:
        res.append(key)

print(res)