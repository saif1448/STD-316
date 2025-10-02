- String
- Method
- Class
- Object
- Algorithm and Flowchart


# String
- We always use ""  double quote to create a string
    - '' ---> single quote is used to create character ---> type char
- The data type of the string is #String
```
	String name = "ABCD";
```

- The most common functions we use with the string
    - length() ---> to show the length of the string
    - equals(given_string) ---> it checks if the string is equally matched with a given string
        - in java we don't use == to equal match the string values
        - for equality check in string, always use this method
    - toLowerCase() ---> converts to lower case
    - toUpperCase() ---> converts to upper case
    - startsWith()
        - it checks if a string with starting with the given string
        - it is case sensitive
    - endsWith()
        - it checks if a string ends with the given string
        - also it is case sensitive
    - contains()
        - it checks if a substring is present in a string
        - it is case sensitive
    - concat()
        - it adds string value to another string value
        - it is better to use + operator to concat string
    - charAt()
        - it gives you the character at a particular index of the string
    - isEmpty()
        - it is gonna return true only if the string length is 0
    - isBlank()
        - Returns true if the string is empty or contains only white space codepoints, otherwise false
    - indexOf()
        - it is by default search from index 0 to see if a string or character is present.
            - if present it returns the index of its first occurrence
            - if not present it returns -1
        - if we give the from index value as parameter, instead of searching from index 0, it will start searching from the given index
            - then it will return the index of the character of its first occurrence
            - if not present , -1
    - replace()
        - this function replace a substring with another substring, but it doesnt change the original string
        - rather it creates a new string with the replaced substring and return this new string
        - pattern
            - char replace
            - substring replace
    - split()
        - it is gonna split the string depending on the delimiter
        - after splitting, it is gonna give an array of the splitted values
        - if we give -1 in the parameter also, it is not gonna leave behind any blank value after splitting
            - otherwise it is not gonna consider the blank value
    - strip()
        - It removes trailing and leading white spaces
        - use it always if java version is  >= 11
    - trim()
        - do as the same as split() but doesn't handle unicode
        - use it if java version is < 11
    - toCharArray()
        - it converts a string to a char array --> char[]
        - you can index over a char array
    - string formatting
        - for printing, printf()
        - %s: For formatting strings.
        - %d: For formatting decimal (integer) values.
        - %f: For formatting floating-point numbers. Precision can be controlled (e.g., %.2f for two decimal places).
        - %b or %B: For formatting boolean values as "true"/"false" or "TRUE"/"FALSE".
        - %c or %C: For formatting characters.
        - %x or %X: For formatting integers as unsigned hexadecimal.
        - %n: For inserting a platform-specific line break.
        - %t: For formatting date and time values, often followed by specific characters like tY (year), tm (month), td (day), tH (hour), tM (minute), tS (second).


he said, "We are going to the movie today"
I said, "No! it is not possible! I am busy 24*7"