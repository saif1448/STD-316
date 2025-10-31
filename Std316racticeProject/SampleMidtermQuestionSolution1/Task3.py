import doctest
# print(123)

def formatting(inpt: str) -> str:
    '''
    This function format the input string

    >>> formatting("print(-875)")
    'return -875'
    '''
    inpt = inpt.lower()
    inpt = inpt.strip()

    assert inpt.find('print(') == 0, 'format error'
    assert inpt[-1] == ')', 'format error'

    start_idx = inpt.find('(') + 1
    end_idx = inpt.find(')') - 1
    num_str = inpt[start_idx:end_idx+1]

    assert num_str[1:].isnumeric(), 'value error'

    output = f'return {num_str}'

    return output



doctest.testmod()

