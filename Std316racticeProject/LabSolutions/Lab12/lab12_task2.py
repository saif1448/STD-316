import doctest

class Product:
    """ A class representing one project """
    
    def __init__(self, name: str, price: float, quantity: int) -> None:
        """
        Constructor

        >>> laptop = Product("laptop", 2030.5, 2)
        >>> laptop._name
        'laptop'
        >>> laptop._price
        2030.5
        >>> laptop._quantity
        2
        """

        assert isinstance(name, str), "the name must be a string"
        assert isinstance(price, float) and price > 0, "the price must be a positive float"
        assert isinstance(quantity, int) and quantity > 0, "the quantity must be a positive int"

        self._name = name
        self._price = price
        self._quantity = quantity
    
    def get_name(self) -> str:
        """
        get the name of the product
        
        >>> laptop = Product("laptop", 2030.5, 2)
        >>> laptop.get_name()
        'laptop'
        """
        
        return self._name
    
    def get_price(self) -> float:
        """
        get the price of the product
        
        >>> laptop = Product("laptop", 2030.5, 2)
        >>> laptop.get_price()
        2030.5
        """
        
        return self._price
    
    def get_quantity(self) -> int:
        """
        get the quantity of the product
        
        >>> laptop = Product("laptop", 2030.5, 2)
        >>> laptop.get_quantity()
        2
        """
        
        return self._quantity    
    
    def add_quantity(self, quantity=1) -> None:
        """
        Add the quantity of the product
        
        >>> laptop = Product("laptop", 2030.5, 2)
        >>> laptop.add_quantity()
        >>> laptop._quantity
        3
        """
        
        assert isinstance(quantity, int) and quantity > 0, "the quantity must be a positive int"
        
        self._quantity += quantity
        
    def reduce_quantity(self, quantity=1) -> None:
        """
        Reduce the quantity of the product
        
        >>> laptop = Product("laptop", 2030.5, 2)
        >>> laptop.reduce_quantity()
        >>> laptop._quantity
        1
        """
        
        assert isinstance(quantity, int) and quantity > 0, "the quantity must be a positive int"
        
        self._quantity -= quantity
        if self._quantity < 0:
            self._quantity = 0
        
class Inventory:
    """ A class representing the inventory """
    
    def __init__(self) -> None:
        """
        Constructor
        
        >>> retail_store_inventory = Inventory()
        >>> retail_store_inventory._products
        []
        """
        
        self._products = []


    def _find_product(self, name: str) -> Product:
        """
        
        Find the product with the given game. Return None if the product is not found
        
        >>> laptop = Product("laptop", 2030.5, 2)
        >>> retail_store_inventory = Inventory()
        >>> retail_store_inventory.stock_product(laptop)
        >>> retail_store_inventory._find_product("laptop") is laptop
        True
        """
        for product in self._products:
            if product.get_name() == name:
                return product
        return None

    def stock_product(self, product: Product) -> None:
        """
        Add a product to the inventory
        
        >>> laptop = Product("laptop", 2030.5, 2)
        >>> retail_store_inventory = Inventory()
        >>> retail_store_inventory.stock_product(laptop)
        >>> retail_store_inventory._products[0] is laptop
        True
        """
        
        assert isinstance(product, Product), "the parameter product product must be an instance of the Class Product"
        
        existing_product = self._find_product(product.get_name())
        
        if existing_product:
            # If product exists, check if price matches
            assert existing_product.get_price() == product.get_price(), "Cannot add product with same name but different price"
            # If price matches, add quantities
            existing_product.add_quantity(product.get_quantity())
        else:
            # If product doesn't exist, add it to inventory
            self._products.append(product)


        
    def sell_product(self, product_name: str, quantity: int):
        """
        Sell product in inventory
        
        >>> laptop = Product("laptop", 2030.5, 2)
        >>> retail_store_inventory = Inventory()
        >>> retail_store_inventory.stock_product(laptop)
        >>> retail_store_inventory.sell_product("laptop", 1)
        >>> laptop._quantity
        1
        """
        
        assert isinstance(product_name, str), "the name must be a string"
        assert isinstance(quantity, int) and quantity > 0, "the quantity must be a positive int"        
        
        product = self._find_product(product_name)
        
        if product:
            product.reduce_quantity(quantity)

    def calculate_inventory_value(self) -> float:
        """
        Calcuatel the total value of the current inventory
        
        >>> laptop = Product("laptop", 2030.5, 2)
        >>> retail_store_inventory = Inventory()
        >>> retail_store_inventory.stock_product(laptop)
        >>> retail_store_inventory.calculate_inventory_value()
        4061.0
        """
        
        total_value = 0
        
        for product in self._products:
            total_value += product.get_price() * product.get_quantity()
            
        return total_value

if __name__ == '__main__':
    doctest.testmod()