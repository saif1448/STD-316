import doctest

def get_store1_revenue(store1_monthly_sales: float) -> float:
    assert type(store1_monthly_sales) == float, "invalid argument"
    assert store1_monthly_sales >= 0, "Store 1 monthly sales must be non-negative"
    return store1_monthly_sales/5
def get_store2_revenue(store2_monthly_sales: float) -> float:
    assert type(store2_monthly_sales) == float, "invalid argument"
    assert store2_monthly_sales >= 0, "Store 2 monthly sales must be non-negative"
    return store2_monthly_sales / 8
def get_total_revenue(store1_monthly_sales, store2_monthly_sales):
    """
    This function calculates the combined revenue from Store 1 and Store 2 based on their monthly sales.
    Preconditions:
    - store1_monthly_sales and store2_monthly_sales must be non-negative floats.
    - store1_monthly_sales and store2_monthly_sales must be type of float.

    >>> get_total_revenue(800.0, 600.0)
    235.0
    >>> get_total_revenue(-400.0, 600.0)
    Traceback (most recent call last):
    ...
    AssertionError: Monthly sales must be non-negative
    >>> get_total_revenue(0.0, 37.4)
    4.675
    >>> get_total_revenue(1000.0, 800.0)
    300.0
    >>> get_total_revenue(500.0, 0.0)
    100.0
    >>> get_total_revenue(250.0, 400.0)
    100.0
    >>> get_total_revenue(100.0, 200.0)
    45.0
    """
    assert type(store1_monthly_sales) == float and type(store2_monthly_sales) == float, "invalid argument"
    assert store1_monthly_sales >= 0 and store2_monthly_sales >= 0, "Monthly sales must be non-negative"
    store1_profit = get_store1_revenue(store1_monthly_sales)
    store2_profit = get_store2_revenue(store2_monthly_sales)
    total_revenue = store1_profit + store2_profit
    return total_revenue

if __name__ == "__main__":
    doctest.testmod()
