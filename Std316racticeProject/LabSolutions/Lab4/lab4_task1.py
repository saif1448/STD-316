def fruit_price(num_peaches: int, num_apples: int, num_watermelons: int) -> float:
    """
    Compute the total price for a purchase of fruits.

    Argument annotations:
        num_peaches (int): number of peaches (must be int, >= 0)
        num_apples (int): number of apples (must be int, >= 0)
        num_watermelons (int): number of watermelons (must be int, >= 0)

    Returns:
        float: total cost in dollars

    Description:
        Uses unit prices:
            peach  = 3.99
            apple  = 2.94
            watermelon = 7.99

    Preconditions:
        - All inputs must be of type int.
        - All inputs must be non-negative.

    Examples / test cases (doctest-style):
    >>> fruit_price(1, 0, 0)
    3.99
    >>> fruit_price(0, 1, 1)
    2.94 + 7.99  # doctest can't evaluate this expression, so show expected numeric:
    10.93
    >>> fruit_price(0, 0, 0)
    0.0
    >>> # invalid type -> raises AssertionError
    ... # doctest expects traceback lines below in tests; Prairielearn uses similar checks
    >>> # Traceback (most recent call last):
    >>> # ...
    >>> # AssertionError: num_peaches must be int and non-negative
    """
    # prices
    PRICE_PEACH = 3.99
    PRICE_APPLE = 2.94
    PRICE_WATERMELON = 7.99

    # precondition checks
    assert type(num_peaches) == int and num_peaches >= 0, "num_peaches must be int and non-negative"
    assert type(num_apples) == int and num_apples >= 0, "num_apples must be int and non-negative"
    assert type(num_watermelons) == int and num_watermelons >= 0, "num_watermelons must be int and non-negative"

    total = (PRICE_PEACH * num_peaches +
             PRICE_APPLE * num_apples +
             PRICE_WATERMELON * num_watermelons)
    # return numeric total (float)
    return round(total, 2)
