from typing import Tuple, List
import doctest

def parse_inventory(data: str) -> Tuple[List[str], List[int], int, int]:
    """
    Parses an inventory string and returns item names, quantities, total quantity, and minimum quantity.
    >>> parse_inventory("A=3,B=7,C=5,")
    (['A', 'B', 'C'], [3, 7, 5], 15, 3)
    >>> parse_inventory("")
    ([], [], 0, 0)
    >>> parse_inventory("Pen=10,")
    (['Pen'], [10], 10, 10)
    >>> parse_inventory("  Milk = 4 , Eggs=12 , ")
    (['Milk', 'Eggs'], [4, 12], 16, 4)
    >>> parse_inventory("A=001,B=20")
    (['A', 'B'], [1, 20], 21, 1)
    >>> parse_inventory(" X=4 , Y = 9 , Z= 10 ")
    (['X', 'Y', 'Z'], [4, 9, 10], 23, 4)
    >>> parse_inventory(123)
    Traceback (most recent call last):
    ...
    AssertionError: Input must be a string.
    >>> parse_inventory("A=3,B=two")
    Traceback (most recent call last):
    ...
    AssertionError: Quantities must contain only digits.
    >>> parse_inventory("A=3,B")
    Traceback (most recent call last):
    ...
    AssertionError: Each entry must contain '='.
    """

    # assert isinstance(inventory_str, str), "Input must be a string"
    #
    # if inventory_str == "":
    #     return ([], [], 0, 0)
    # #("Apples=30,  Oranges=12 , Bananas = 25 ,")
    # item_quantity_str_list = inventory_str.split(",")
    # # ["apple=10", "banana=5", "orange=8"]
    #
    # # itereate over this item_quantity_str_list
    # # if the individual item is empty, we skip it
    # # if not empty, we remove the whitespaces
    # # we have to check if the individual item contains '='
    # # if it does not contain '=', we raise exception
    # # if not, we split it by '='
    # # first value will be in item name list
    # # second value will be in quantity list (after converting to int)
    #
    # name_list = []
    # quantity_list = []
    # total_quantity = 0
    # minimum_quantity = 12313123
    #
    # for individual_item in item_quantity_str_list:
    #     individual_item.strip()
    #     if individual_item == '':
    #         continue
    #     assert "=" in individual_item, "Each entry must contain '='"
    #     individual_item = individual_item.strip()
    #     # splitting the individual item by '='
    #     indiv_parts = individual_item.split('=')
    #     # name is in 0 index
    #     name = indiv_parts[0].strip()
    #     # quantity is in 1 index
    #     # also convertint the quantity to int
    #     quantity = indiv_parts[1].strip()
    #     assert quantity.isdigit() == True, "Quantities must contain only digits."
    #     quantity = int(quantity)
    #     name_list.append(name)
    #     quantity_list.append(quantity)
    #     total_quantity += quantity
    #     if quantity < minimum_quantity:
    #         minimum_quantity = quantity
    #
    # result = (name_list, quantity_list, total_quantity, minimum_quantity)
    #
    # return result
    assert isinstance(data, str), "Input must be a string."
    if data.strip() == "":
        return [], [], 0, 0
    entries = data.split(",")
    names  = []
    quantities = []

    for entry in entries:
        entry = entry.strip()
        if entry == "":
            continue
        assert "=" in entry, "Each entry must contain '='."
        parts = entry.split("=")
        assert len(parts) == 2, "Each entry must contain '='."
        name = parts[0].strip()
        qty = parts[1].strip()
        assert name != "", "Product name cannot be empty."
        assert qty.isdigit(), "Quantities must contain only digits."
        names.append(name)
        quantities.append(int(qty))
        if len(names) == 0:
            return [], [], 0, 0
    total_quantity = sum(quantities)
    min_quantity = min(quantities)
    return (names, quantities, total_quantity, min_quantity)



doctest.testmod()





# parse_inventory("  Milk = 4 , Eggs=12 , ")

