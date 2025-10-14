import doctest

def count_wheels(num_bicycles: int, num_tricycles: int, num_cars: int, num_trucks: int) -> int:
    """
       Count the total number of wheels from different vehicles.

       Args:
           num_bicycles (int): The number of bicycles.
           num_tricycles (int): The number of tricycles.
           num_cars (int): The number of cars.
           num_trucks (int): The number of trucks.

       Returns:
           int: The total number of wheels.

       Examples:
           >>> count_wheels(1, 0, 2, 5)
           100
           >>> count_wheels(0, 0, 0, 0)
           0
           >>> count_wheels("a", 3, 1, 0)
           Traceback (most recent call last):
           ...
           AssertionError: invalid argument type
           >>> count_wheels(5, 2, 3, 1)
           46
           >>> count_wheels(1, -2, 4, 3)
           Traceback (most recent call last):
           ...
           AssertionError: Number of vehicles cannot be negative
       """

    assert type(num_bicycles) == int and type(num_tricycles) == int and type(num_cars) == int and type(
        num_trucks) == int, "invalid argument type"

    assert num_bicycles >= 0 and num_tricycles >= 0 and num_cars >= 0 and num_trucks >= 0, "Number of vehicles cannot be negative"

    return 2 * num_bicycles + 3 * num_tricycles + 4 * num_cars + 18 * num_trucks


doctest.testmod()