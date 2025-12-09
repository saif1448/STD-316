
# class
# instance variable
# constructor
# we mention instance variable inside the constructor in python
# getter and setter
# instance method
# everything will be inside the class

class Loan:
    # this is the constructor
    # you should create this method first
    def __init__(self, annual_interest_rate, number_of_years, loan_amount, loan_date):
        # instance variables
        self._annual_interest_rate = annual_interest_rate
        self._number_of_years = number_of_years
        self._loan_amount = loan_amount
        self._loan_date = loan_date

    def get_annual_interest_rate(self) -> float:
        return self._annual_interest_rate

    def get_number_of_years(self) -> int:
        return self._number_of_years

    def get_loan_amount(self) -> float:
        return self._loan_amount

    def get_loan_date(self):
        return self._loan_date

    def set_annual_interest_rate(self, annual_interest_rate: float) -> None:
        self._annual_interest_rate = annual_interest_rate

    def set_number_of_years(self, number_of_years: int) -> None:
        self._number_of_years = number_of_years

    def set_loan_amount(self, loan_amount: float) -> None:
        self._loan_amount = loan_amount

    def set_loan_date(self, loan_date: str) -> None:
        self._loan_date = loan_date

    def get_monthly_payment(self) -> float:
        number_of_months = self._number_of_years * 12
        monthly_interest_rate = self._annual_interest_rate / 12

        if self._annual_interest_rate == 0:
            return round(self._loan_amount / number_of_months, 2)

        monthly_payment = self._loan_amount * monthly_interest_rate / (1 - (1 + monthly_interest_rate) ** number_of_months)

        return round(monthly_payment, 2)

