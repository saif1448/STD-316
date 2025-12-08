#key
# list [1,2,4,5] ---> using the index ,
#      [ (0,1), (1,2), (2,4), (3,5) ]
# here the index number is the key
# the 'value' is always associated with a 'key'
# 'key' will always be unique
# 'key-value' pair

weapon_inventory = {} # we use {} brace to initiate a blank dictionary
# weapon_inventory[str, int]

# grande, ak-47 ammos, bazuka, uzi round
#   10       100       5        15

# inserting into dictionary
weapon_inventory['granade'] = 10
weapon_inventory['ak47'] = 100
weapon_inventory['bazuka'] = 0
weapon_inventory['uzi'] = 0


print(weapon_inventory)

#updating
weapon_inventory['bazuka'] = 89
print(weapon_inventory)






