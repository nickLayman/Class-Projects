package project2;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/************************************************************************
 * This program builds a GUI for SuperTicTacToe. SuperTicTacToe is a game
 * where the user chooses the size of the board and the number of
 * connections needed to win. It then allows the user to play with another
 * person or against an AI. The program will tell the user when either
 * side has won, lost, or tied.
 *
 * @author Justin Von Kulajta Winn & Nick Layman
 * @version 1.8
 ************************************************************************/

public class SuperTicTacToeGame {

    /** this is the board the that an X or O is 'placed' onto */
    private Cell[][] board;

    /** This is a variable that tells the program if one side has won or tied */
    private GameStatus status;

    /** This is a variable that determines who's turn it is */
    private Cell turn;

    /** This is the number of connections needed to win */
    private int connections;

    /** This is a variable that determines if X's or O's go first */
    private Cell starter;

    /** This is the width of the board */
    private int width;

    /** This is the height of the board */
    private int height;

    /** This is the number of board tiles that have an X or O in them */
    private int numSelected;

    /** This defines whether the AI is on or off */
    private static final boolean AI = true;

    /** This is an Array list that holds the location of previous plays made */
    private ArrayList<Point> backup = new ArrayList<Point>();

    /************************************************************************
     * This constructor is the basic constructor. It sets the board to it's
     * default settings
     ************************************************************************/
    public SuperTicTacToeGame() {
        this(3, 3, 3, Cell.X, false);
    }

    /************************************************************************
     * This constructor sets the width, height, and number of connections
     * needed to win for the current board. It also determines if X or O
     * is to go first
     * @param pHeight is the height of the board
     * @param pWidth is the width of the board
     * @param pConnections is the number of connections needed to win the game
     * @param pStarter holds the cell that lets the program know who goes
     *                 first
     * @param pAI is whether or not the AI is on or off
     ************************************************************************/
    public SuperTicTacToeGame(int pHeight, int pWidth, int pConnections,
                              Cell pStarter, boolean pAI) {
        height = pHeight;
        width = pWidth;
        connections = pConnections;
        starter = pStarter;
        turn = starter;
        numSelected = 0;
        backup = new ArrayList<Point>();

        status = GameStatus.IN_PROGRESS;
        board = new Cell[height][width];
        reset();

        for (int row = 0; row < height; row++)
            for (int col = 0; col < width; col++)
                board[row][col] = Cell.EMPTY;
    }

    /************************************************************************
     * This function returns the current board
     * @return is the current board with the currently marked X's and O's
     ************************************************************************/
    public Cell[][] getBoard() {
        return board;
    }

    /************************************************************************
     * This function selects a row and column on the board and fills it
     * with the respective X or O which is dependent on who's turn it is.
     * It then checks the status of the game and switches who's turn it is
     * @param col is the y coordinate that is being selected
     * @param row is the x coordinate that is being selected
     ************************************************************************/
    public void select(int row, int col) {
        if (board[row][col] != Cell.EMPTY)
            return;

        board[row][col] = turn;
        numSelected++;

        turn = (turn == Cell.O) ? Cell.X : Cell.O;
        status = isWinner();
        backup.add(new Point (row, col));
    }

    /************************************************************************
     * This function goes back by 1 turn. It removes the last icon placed,
     * which is either an X or O. It removes the point saved in the arrayList,
     * Backup. It then switches who's turn it is and lowers the number
     * of X's and O's by 1.
     ************************************************************************/
    public void undo(){
        Point lastMove = backup.get(backup.size() - 1);
        int r = (int) lastMove.getX();
        int c = (int) lastMove.getY();
        board[r][c] = Cell.EMPTY;
        backup.remove(backup.size() - 1);
        turn = (turn == Cell.O) ? Cell.X : Cell.O;
        numSelected--;
    }

    /************************************************************************
     * This function determines if there has been a winner or not of the
     * game. It checks if X or O has won vertically, horizontally, or
     * diagonally. If the board is completely full, it declares the game
     * a CATS game. IF none of these conditions are true, it returns the
     * game status 'IN_PROGRESS."
     * @return the current GameStatus of the board which will
     *         be either IN_PROGRESS, X_WON, O_WON, OR CATS
     ************************************************************************/
    private GameStatus isWinner() {
        int xCount = 0;
        int oCount = 0;
        for (int r = 0; r < height; r++)
            for (int c = 0; c < width; c++) {
                // horizontal win
                if (c <= width - connections) {
                    xCount = 0;
                    oCount = 0;

                    for (int i = 0; i < connections; i++) {
                        if (board[r][c + i] == Cell.X)
                            xCount++;
                        if (board[r][c + i] == Cell.O)
                            oCount++;
                    }

                    if (xCount == connections)
                        return GameStatus.X_WON;
                    else if (oCount == connections)
                        return GameStatus.O_WON;
                }

                // vertical win
                if (r <= height - connections) {
                    xCount = 0;
                    oCount = 0;

                    for (int i = 0; i < connections; i++) {
                        if (board[r + i][c] == Cell.X)
                            xCount++;
                        if (board[r + i][c] == Cell.O)
                            oCount++;
                    }

                    if (xCount == connections)
                        return GameStatus.X_WON;
                    else if (oCount == connections)
                        return GameStatus.O_WON;
                }

                // major diagonal win
                if (r <= height - connections && c <= width - connections) {
                    xCount = 0;
                    oCount = 0;

                    for (int i = 0; i < connections; i++) {
                        if (board[r + i][c + i] == Cell.X)
                            xCount++;
                        if (board[r + i][c + i] == Cell.O)
                            oCount++;
                    }

                    if (xCount == connections)
                        return GameStatus.X_WON;
                    else if (oCount == connections)
                        return GameStatus.O_WON;
                }

                // minor diagonal win
                if (r >= connections - 1 && c <= width - connections) {
                    xCount = 0;
                    oCount = 0;

                    for (int i = 0; i < connections; i++) {
                        if (board[r - i][c + i] == Cell.X)
                            xCount++;
                        if (board[r - i][c + i] == Cell.O)
                            oCount++;
                    }

                    if (xCount == connections)
                        return GameStatus.X_WON;
                    else if (oCount == connections)
                        return GameStatus.O_WON;
                }
            }

        if (numSelected >= height * width)
            return GameStatus.CATS;

        return GameStatus.IN_PROGRESS;
    }

    /************************************************************************
     * This function returns the current status of the game. It will
     * either be IN_PROGRESS, X_WON, O_WON, OR CATS
     * @return the current status of the game
     ************************************************************************/
    public GameStatus getGameStatus() {
        return isWinner();
    }

    /************************************************************************
     * This function resets the board. It resets the arrayLIst backup,
     * clears the board, clears the number of X's and O's, and lets the AI
     * go if it was desired to go first
     ************************************************************************/
    public void reset() {
        for (int i = backup.size(); i > 0; i--){
            backup.remove(i - 1);
        }

        for (int r = 0; r < height; r++)
            for (int c = 0; c < width; c++)
                board[r][c] = Cell.EMPTY;

        numSelected = 0;
        if (starter == Cell.O)
            AI();

        turn = starter;
    }

    /************************************************************************
     * This function is the AI that plays against a user. Its first goal is
     * to win. If it cannot win, it blocks X from winning. It will be placed
     * randomly otherwise
     ************************************************************************/
    public void AI(){
        numSelected++;
        turn = Cell.X;

        //try to win
        for (int r = 0; r < height; r++){
            for (int c = 0; c < width; c++){
                if (board[r][c] == Cell.EMPTY){
                    board[r][c] = Cell.O;
                    if (isWinner() != GameStatus.O_WON)
                        board[r][c] = Cell.EMPTY;
                    else {
                        backup.add(new Point(r, c));
                        return;
                    }
                }
            }
        }

        //try to block
        for (int r = 0; r < height; r++){
            for (int c = 0; c < width; c++){
                if (board[r][c] == Cell.EMPTY){
                    board[r][c] = Cell.X;
                    if (isWinner() != GameStatus.X_WON)
                        board[r][c] = Cell.EMPTY;
                    else {
                        board[r][c] = Cell.O;
                        backup.add(new Point(r, c));
                        return;
                    }
                }
            }
        }

        //otherwise, random
        Random rand = new Random();
        int randR;
        int randC;
        do {
            randR = rand.nextInt(height);
            randC = rand.nextInt(width);
        } while (board[randR][randC] != Cell.EMPTY);
        backup.add(new Point(randR, randC));
        board[randR][randC] = Cell.O;
    }
}