################################### TASK 4 ###################################
### Starting code ###
import doctest
def encrypt(message, shift):
    """
    Encrypts a message using Caesar Cipher with the given shift value.
    
    Only uppercase letters are shifted. Numbers, spaces, and punctuation 
    remain unchanged.
    
    >>> encrypt("ABCDEFG", 4)
    'EFGHIJK'
    >>> encrypt("SEND 5 PIZZAS", 12)
    'EQZP 5 BULLME'
    >>> encrypt("READY THE TROOPS!!", 20)
    'LYUXS NBY NLIIJM!!'
    >>> encrypt("SUPER SECRET MESSAGE 123", 13)
    'FHCRE FRPERG ZRFFNTR 123'
    >>> encrypt("HELLO", 3)
    'KHOOR'
    >>> encrypt("XYZ", 5)
    'CDE'
    >>> encrypt("ATTACK AT DAWN", 1)
    'BUUBDL BU EBXO'
    >>> encrypt("ZZZZ", 1)
    'AAAA'
    """
    
    encrypted_message = ""
    for char in message:
        if char.isupper():
            # XYZ, 4
            char_position = ord(char) - ord('A') # it gives the position within 0 - 25 # ord(x) - ord('A') = 88 - 65 = 23
            new_position = (char_position + shift) % 26 # 23 + 4 = 27 % 26 = 1
            new_char = chr(new_position + ord('A')) # 1 + ord('A') = 1 + 65 = 66 ---> chr(66) ---> B ====> X, 4 ---> B
            
            encrypted_message += new_char
        else:
            encrypted_message += char
    
    return encrypted_message
    
doctest.testmod()


