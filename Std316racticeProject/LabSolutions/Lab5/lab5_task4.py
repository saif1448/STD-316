import doctest

def input_validation(food_ate: float, opp_food_ate: float) -> None:
    """
    Validates the input values for food eaten by the mine and opponent.
    """
    assert type(food_ate) == float and type(opp_food_ate) == float, "invalid argument"
    assert food_ate >= 0 and opp_food_ate >= 0, "Food consumed cannot be negative"

def calculate_final_credit(raw_credit: float, opp_raw_credit: float) -> float:
    """
    Calculates the final credit based on raw credit and opponent's raw credit.
    """
    final_credit = raw_credit - (0.2 * opp_raw_credit)

    if final_credit < 0:
        return 0.0
    else:
        return final_credit

def my_food_credit(food_ate, opp_food_ate):
    """
    Calculate final food credit for Flyweight class participant.

    Raw credit is calculated as food consumed multiplied by 10.
    Final credit is raw credit minus 20% of opponent's raw credit.
    Minimum credit is 0.

    Preconditions:
    - my_food_ate and opp_food_ate must be non-negative float values

    >>> my_food_credit(20.0, 10.0)
    170.0
    >>> my_food_credit("10", 20.0)
    Traceback (most recent call last):
    ...
    AssertionError: Food consumed must be a float
    >>> my_food_credit(6.12, 36.172)
    34.344
    """

    input_validation(opp_food_ate, food_ate)
    my_raw_credit = food_ate * 10
    opp_raw_credit = opp_food_ate * 15
    final_credit = calculate_final_credit(my_raw_credit, opp_raw_credit)
    return final_credit

def opponent_food_credit(opp_food_ate, food_ate):
    """
    Calculate final food credit for Straw weight class opponent.

    Raw credit is calculated as food consumed multiplied by 15.
    Final credit is raw credit minus 20% of player's raw credit.
    Minimum credit is 0.

    Preconditions:
    - opp_food_ate and my_food_ate must be non-negative floats

    >>> opponent_food_credit(10.0, 20.0)
    110.0
    >>> opponent_food_credit("10", 20.0)
    Traceback (most recent call last):
    ...
    AssertionError: invalid argument
    >>> opponent_food_credit(6.13, 36.1)
    19.75
    """
    input_validation(food_ate, opp_food_ate)
    opp_raw_credit = opp_food_ate * 15
    my_raw_credit = food_ate * 10
    final_credit = calculate_final_credit(opp_raw_credit, my_raw_credit)
    return final_credit

if __name__ == "__main__":
    doctest.testmod()
