from typing import List
import doctest

def intersecting_chars(my_str: str) -> List[str]:
    """
    interescting_chars returns the common characters among 3 strings


    >>> intersecting_chars("ab_aaab_bCC")
    ['b']

    >>> intersecting_chars("aBcd_aaab_bCC")
    ['b']

    >>> intersecting_chars("m_CCda_acz")
    []
    >>> intersecting_chars("CAB_cab_cxaxb")
    ['a', 'b', 'c']
    >>> intersecting_chars("za3g34_0a_a")
    Traceback (most recent call last):
    ...
    AssertionError: invalid input
    """
    assert my_str.count("_") == 2, "invalid input"

    str_list = my_str.split("_")

    for i in range(len(str_list)):
        if str_list[i] != "":
            assert str_list[i].isalpha() == True, "invalid input"
        str_list[i] = str_list[i].lower()

    if "" in str_list:
        return []

    char_set_list = []

    for string in str_list:
        # "aabe" --> "aabe"
        s = set()
        for char in string:
            #abe
            s.add(char)
        char_set_list.append(s)
        #[{a,b,c,e}, {a,b,e}, {b,c}]

    common_char_set = char_set_list[0].intersection(char_set_list[1])

    common_char_set = common_char_set.intersection(char_set_list[2])

    common_char_list = list(common_char_set)

    common_char_list.sort()

    return common_char_list







doctest.testmod()