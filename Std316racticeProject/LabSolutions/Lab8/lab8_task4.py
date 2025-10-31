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
            char_position = ord(char) - ord('A')
            new_position = (char_position + shift) % 26
            new_char = chr(new_position + ord('A'))
            
            encrypted_message += new_char
        else:
            encrypted_message += char
    
    return encrypted_message
    
doctest.testmod()