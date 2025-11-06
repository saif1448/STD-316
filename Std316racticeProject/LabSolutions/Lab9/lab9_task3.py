from typing import Dict

def add_to_inventory(inventory: Dict[str, int], product: str, quality: int) -> int:
    """
    Adds a specified quantity of a product to the inventory and returns the new quantity.
    
    Parameters:
        inventory (Dict[str, int]): A dictionary representing the store's inventory 
                                  where keys are product names and values are quantities.
        product (str): The name of the product to add to inventory.
        quality (int): The quantity to add (must be non-negative).
        
    Returns:
        int: The new quantity of the product in the inventory after addition.
        
    >>> add_to_inventory({"Laptop": 20, "Smartphone": 15, "Tablet": 30, "Headphones": 10}, "Keyboard", 5)
    5
    >>> add_to_inventory({"Laptop": 20, "Smartphone": 15, "Tablet": 30, "Headphones": 10}, "Smartphone", 10)
    25
    >>> add_to_inventory({}, "Apple", 1)
    1
    >>> add_to_inventory({"Plates": 3}, "Plates", 4)
    7
    >>> add_to_inventory({"Orange": 45, "Apple": 60}, "Pear", 30)
    30
    >>> add_to_inventory({"Orange": 45, "Apple": 60}, "Apple", 30)
    90
    >>> add_to_inventory({"Book": 10, "Pen": 5}, "Pencil", 0)
    0
    >>> add_to_inventory({"Mouse": 12}, "Mouse", 8)
    20
    >>> add_to_inventory({"TV": 5, "Radio": 3}, "Speaker", 15)
    15
    >>> add_to_inventory({"Water": 100}, "Water", 50)
    150
    >>> add_to_inventory({"Chair": 8, "Table": 4}, "Chair", 2)
    10
    >>> add_to_inventory({"Phone": 25, "Charger": 30}, "Case", 12)
    12
    >>> add_to_inventory({"Bread": 0}, "Bread", 10)
    10
    >>> add_to_inventory({"Car": 2, "Bike": 5, "Bus": 1}, "Truck", 3)
    3
    >>> add_to_inventory({"Pizza": 8}, "Pizza", 0)
    8
    >>> add_to_inventory({"Shirt": 15, "Pants": 20, "Shoes": 10, "Hat": 5}, "Socks", 25)
    25
    >>> add_to_inventory({"Chocolate Cake": 3, "Cheese Cake": 5}, "Strawberry Cake", -4)
    Traceback (most recent call last):
    ...
    AssertionError: quantity must be a non-negative integer
    """
    
    assert type(quality) == int and quality >= 0, "quantity must be a non-negative integer"
    
    if product in inventory:
        inventory[product] += quality
    else:
        inventory[product] = quality
    
    return inventory[product]