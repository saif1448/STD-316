# 2 types of loop
# 1. While Loop
# 2. For Loop
# in python, the for loop here is similar to enhanced for loop in java

# for (int v : list){
#     print(v)
# }

# ls = [1,2,3,4,5]

# def range(start: int, stop: int) -> List[int]:
#     pass


def isEven(num: int) -> bool:
    return num % 2 == 0

def isPrime(num: int) -> bool:
    # if num == 1 ---> 1 is not a prime number
    # if num divisible by one and itself only
    if num == 1:
        return False
    # flag = True
    # range(2, 6) ---> 2, 3, 4, 5, 6
    # num = 7,
    # i ---> 2...7
    # 8 % 2 == 0 --->
    # 7 % 3 == 0
    #
    for i in range(2, num):
        if num % i == 0:
            return False
            # flag = False
            # break

    return True



def count_primes(start: int, stop: int) -> int:
    count = 0
    for v in range(start, stop + 1):
        if isPrime(v):
            count += 1

    return count


count_prime = count_primes(1, 100)

print(f'Number of prime numbers: {count_prime}')







