
i = 12345
lastDigit = 0
original = i
reversed = 0

while i > 0:
    lastDigit = i % 10
    i  = i // 10
    reversed = reversed * 10 + lastDigit


print(f"Reversed {reversed}")