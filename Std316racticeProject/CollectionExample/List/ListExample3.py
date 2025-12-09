
ls1 = [1,2,3,4,5]  # 1-D list
ls2 = [10,20,30,40,50] # 1-D list

#nested_list = [ls1, ls2] # 2-D list , which is a list of 1-d lists

nested_list = [[1,2,3,4,5], [10,20,30,40,50]]
            #     0   3          1 2

# for ls in nested_list:
#     for item in ls:
#         print(item)

# print(nested_list[0][3])
# print(nested_list[1][2])

# print(len(nested_list))
length = len(nested_list) # 2
# range(2) -> 0,1
for i in range(length):
    # for item in nested_list[i]:
    #     print(item)
    list_length = len(nested_list[i])
    # list_length = 5, for i = 0
    # range(list_length), range(5) -> 0,1,2,3,4
    for j in range(list_length):
        print(nested_list[i][j])
        # i = 0, j = 0 -> nested_list[0][0] -> 1
        # i = 0, j = 1 -> nested_list[0][1] -> 2
        # i = 0, j = 2 -> nested_list[0][2] -> 3
        # i = 0, j = 3 -> nested_list[0][3] -> 4
        # i = 0, j = 4 -> nested_list[0][4] -> 5
        # i = 1, j = 0 -> nested_list[1][0] -> 10
        # i = 1, j = 1 -> nested_list[1][1] -> 20
        # i = 1, j = 2 -> nested_list[1][2] -> 30
        # i = 1, j = 3 -> nested_list[1][3]
        # i = 1, j = 4 -> nested_list[1][4] -> 50
        # and so on...