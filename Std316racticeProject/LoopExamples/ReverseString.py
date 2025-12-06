text = "Python"


reversed_text = ""
# for char in text:
#     #P
#     reversed_text = char + reversed_text
# print(reversed_text)
# Output: nohtyP



i = len(text) - 1
# i = 6 -1
# i = 5 ---> n
# i = 4 ---> o
#...
# i = 0 ---> P
while i >= 0:
    reversed_text += text[i]
    i -= 1

print(reversed_text)
