from typing import List
import doctest

def initialize_board(n: int) -> List[List[str]]:
    """
    Initialize an n x n game board as a nested list, where each cell is initially filled with a space.
    
    Args:
        n (int): The size of the board (n x n)
    
    Returns:
        List[List[str]]: An n x n board filled with spaces
    
    >>> initialize_board(3)
    [[' ', ' ', ' '], [' ', ' ', ' '], [' ', ' ', ' ']]
    >>> initialize_board(4)
    [[' ', ' ', ' ', ' '], [' ', ' ', ' ', ' '], [' ', ' ', ' ', ' '], [' ', ' ', ' ', ' ']]
    """
    return [[' ' for _ in range(n)] for _ in range(n)]

# This function is provided, and you can leave it as is.
def print_board(board: List[List[str]]) -> None:
    """
    Print the current state of the game board.
    
    >>> print_board([[' ', ' ', ' '], [' ', ' ', ' '], [' ', ' ', ' ']])
    -------------
    |   |   |   |
    -------------
    |   |   |   |
    -------------
    |   |   |   |
    -------------
    >>> print_board([[' ', 'X', ' '], [' ', ' ', ' '], [' ', ' ', 'O']])
    -------------
    |   | X |   |
    -------------
    |   |   |   |
    -------------
    |   |   | O |
    -------------
    """
    print('-' * (4 * len(board[0]) + 1))
    for row in board:
        print('|', end = '')
        for cell in row:
            print(f" {cell} |", end = "")
        print('\n' + '-' * (4 * len(row) + 1))

def drop_piece(board: List[List[str]], row: int, col: int, player: str) -> bool:
    """
    Allow a player to drop their piece ('X' or 'O') into a specified cell on the board.
    A player cannot overwrite a cell that is already occupied.
    
    Args:
        board (List[List[str]]): The game board
        row (int): Row index where to drop the piece
        col (int): Column index where to drop the piece
        player (str): The player's symbol ('X' or 'O')
    
    Returns:
        bool: True if the piece is successfully dropped, False if the cell is already occupied
    
    >>> board1 = [[' ', ' ', ' '], [' ', ' ', ' '], [' ', ' ', ' ']]
    >>> drop_piece(board1, 0, 0, 'X')
    True
    >>> board1
    [[' X', ' ', ' '], [' ', ' ', ' '], [' ', ' ', ' ']]
    >>> drop_piece(board1, 0, 0, 'O')
    False
    """
    if board[row][col] != ' ':
        return False
    board[row][col] = player
    return True

def is_winner(board: List[List[str]], player: str) -> bool:
    """
    Check if a player has won the game by checking rows, columns, and diagonals.
    To win, a player must occupy an entire row, column, or diagonal.
    
    Args:
        board (List[List[str]]): The game board
        player (str): The player's symbol ('X' or 'O')
    
    Returns:
        bool: True if the player has won, False otherwise
    
    >>> is_winner([['X', 'X', 'X'], [' ', 'O', ' '], [' ', 'O', ' ']], 'X')
    True
    >>> is_winner([[' ', 'X', ' '], ['O', 'X', ' '], [' ', 'X', 'O']], 'X')
    True
    >>> is_winner([['X', ' ', 'O'], [' ', 'X', ' '], [' ', ' ', 'X']], 'X')
    True
    >>> is_winner([['O', ' ', 'X'], [' ', 'O', ' '], ['X', ' ', 'O']], 'O')
    True
    >>> is_winner([[' ', ' ', ' '], [' ', ' ', ' '], [' ', ' ', ' ']], 'X')
    False
    """
    n = len(board)
    
    # Check rows
    for row in board:
        if all(cell == player for cell in row):
            return True
    
    # Check columns
    for col in range(n):
        if all(board[row][col] == player for row in range(n)):
            return True
    
    # Check diagonal from top-left to bottom-right
    if all(board[i][i] == player for i in range(n)):
        return True
    
    # Check diagonal from top-right to bottom-left
    if all(board[i][n - 1 - i] == player for i in range(n)):
        return True
    
    return False

def is_board_full(board: List[List[str]]) -> bool:
    """
    Check if the game board is full, indicating a tie if there's no winner.
    
    Args:
        board (List[List[str]]): The game board
    
    Returns:
        bool: True if the board is completely filled, False otherwise
    
    >>> is_board_full([[' ', 'X', ' '], [' ', ' ', ' '], [' ', ' ', 'O']])
    False
    >>> is_board_full([['O', 'X', 'O'], ['X', 'X', 'O'], ['X', 'O', 'X']])
    True
    >>> is_board_full([['X', 'X', 'X'], ['O', 'O', ' '], ['O', 'O', 'X']])
    False
    """
    for row in board:
        for cell in row:
            if cell == ' ':
                return False
    return True

# This function is provided, and you can leave it as is.
def play_tic_tac_toe() -> None:
    """ Orchestrate the game, allowing two players to take turns."""
    print("Welcome to Tic-Tac-Toe!")
    
    # Initialize the game board
    n = 0
    while n < 3:
        try:
            n = int(input("What is size of the board? ").strip())
        except:
            continue
            
    board = initialize_board(n)    

    # Define players
    players = ['X', 'O']
    current_player = 0
    
    player_1_name = input("What is the name of player 1? ").strip()
    player_2_name = input("What is the name of player 2? ").strip()
    if not player_1_name:
        player_1_name = '1'
    if not player_2_name:
        player_2_name = '2'
        
    player_names = [player_1_name, player_2_name]
    
    continue_game = True

    while continue_game:
        print_board(board)

        # Get player input
        # As we are facing regular players, the row and col start 1 so that they don't get confused
        row_col_examples = '/'.join([str(i + 1) for i in range(n)])
        row = input(f"Player {player_names[current_player]}, choose a row ({row_col_examples}): ").strip()
        col = input(f"Player {player_names[current_player]}, choose a column ({row_col_examples}): ").strip()
        
        try:
            row = int(row) - 1
            col = int(col) - 1
            item_range = ", ".join([str(i + 1) for i in range(n)])
            assert row in [i for i in range(n)] and col in [i for i in range(n)], f"row and col must be an int ranged from {item_range}"
        except:
            print("row and col must be an int ranged from 1, 2, 3")
            continue
        
        # Drop the player's piece into the chosen cell
        if drop_piece(board, row, col, players[current_player]):
            # Check for a winner
            if is_winner(board, players[current_player]):
                print_board(board)
                print(f"Player {player_names[current_player]} wins!")
                continue_game = False

            # Check for a tie
            if is_board_full(board):
                print_board(board)
                print("It's a tie!")
                continue_game = False

            # Switch to the other player
            current_player = 1 - current_player
        else:
            print("Cell is already occupied. Choose another cell.")

if __name__ == "__main__":
    # Usage:
    # Uncomment the line below to start playing the game
    play_tic_tac_toe()
    # doctest.testmod()