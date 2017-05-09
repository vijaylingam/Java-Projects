/**
 * Created by vijaychandra on 5/13/16.
 */
public class Knight {
    static int[][] chessboard;
    //defining list of possible moves for the knight
    static int[] xaxismove = { 2, 1, -1, -2, -2, -1, 1, 2};
    static int[] yaxismove = {1, 2, 2, 1, -1, -2, -2, -1};

    /**
     *
     * @param xcoordinate
     * @param ycoordinate
     * @param movenumber
     * @param xmove refers to all the possible x moves
     * @param ymove refers to all the corresponding y moves
     * @return
     * findPath method takes in 5 inputs described above and returns true or false.
     * returns true if all the knight moves have been correctly allocated on the chessboard
     * returns false if a possible assignment couldn't be found and leaves the state of the chessboard unchanged.
     */

    public boolean findPath(int xcoordinate, int ycoordinate, int movenumber, int xmove[], int ymove[] ){
    int next_x_move, next_y_move;

        //final case where all the moves have been figured out
        if (movenumber == chessboard.length * chessboard.length)
            return true;
        for (int k = 0; k < xaxismove.length; k++){
            //figuring out the next move
            next_x_move = xcoordinate + xmove[k];
            next_y_move = ycoordinate + ymove[k];

            //check if the move is valid and the cell in chessboard is equal to -1 (cell is empty)
            if((next_x_move >=0 && next_x_move < chessboard.length) &&(next_y_move >= 0 && next_y_move < chessboard.length) && chessboard[next_x_move][next_y_move] == -1){
                chessboard[next_x_move][next_y_move] = movenumber;
                //doing a recursive call for the next move
                if(findPath(next_x_move, next_y_move, movenumber+1,xmove,ymove))
                    return true;
                else
                    //resetting the move to original state i.e. -1
                    chessboard[next_x_move][next_y_move] = -1;

            }
        }
    return false;
    }

    /**
     * @param args
     * main method takes in one command line argument which decides the size of the chessboard. main method invokes filePath and if it returns true
     * it prints out the (X,Y) coordinates of the knight to cover all the squares without repetition.
     */
    public static void main(String[] args){
    int boardsize = Integer.parseInt(args[0]);
    chessboard = new int[boardsize][boardsize];
        Knight start = new Knight();
        for(int i = 0; i < boardsize; i++){
            for(int j = 0; j < boardsize; j++){
                chessboard[i][j] = -1; //setting all the slots of the chessboard to -1
            }
        }
        //defining the starting position of the knight
        chessboard[boardsize-1][0] = 0; //placing the knight at the bottom left corner of chessboard; 0 indicates 0th move
        if(start.findPath(boardsize-1, 0, 1, xaxismove, yaxismove)){
            //printing (X,Y) coordinates of a path to exhaust all squares
            for(int movenum = 0; movenum < (boardsize*boardsize); movenum++) {
                for (int i = 0; i < boardsize; i++) {
                    for (int j = 0; j < boardsize; j++) {
                        if(movenum == chessboard[i][j]) //Move 0 reflects the starting position (bottom left corner)
                            System.out.println("Move "+ (movenum) +": "+ "("+(i+1)+", "+(j+1)+")");

                    }
                }
            }
        }else{
            System.out.println("No path exists.");
        }
    }
}
