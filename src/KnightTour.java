

public class KnightTour {
	
	static int m = 8; //Size of board game mxm
	private static int[][] knight = new int[m][m];//creating an array named knight with size of mxm
	static int count = 1;	
	
	public static void main(String[] args) {
		for (int i = 0 ; i < knight.length; i++)//assigning the knight array with value of 0 
			for (int j =0; j < knight.length; j++)
				knight[i][j] = 0;
		move(knight, 0, 0);//starting to move the knight

	}
	
	//Move() function will fill the board game with knight move
	public static void move(int[][] knight, int row, int col){
		
		if (knight[row][col] != 0)//base condition, the knight can't move to to filled positions
			return;
		knight[row][col] = count;
		count ++;
		if (isFull(knight)){	//return if the board is full	
			print();
			return;
		}
		
		//at any positions, the knight has potential 8 options to move
		//the below code will check if the knight can move whichever directions
		if ((row +1 < m)&&(col + 2 < m)) 	//move right 1, down 2
			move(knight, row + 1, col + 2);
		if((row + 2 < m)&&(col +1 < m))		//move right 2, down 1
			move(knight, row + 2, col + 1);
		if((row + 2 < m)&&(col - 1 >= 0))	//move right 2, up 1
			move(knight, row +2, col - 1);
		if ((row + 1 < m)&&(col -2 >= 0))	//move right 1, up 2
			move(knight, row +1, col - 2);
		if ((row -1 >= 0)&&(col - 2 >= 0))	//move left 1, up 2
			move(knight, row -1 , col -2);
		if ((row - 2 >= 0)&&(col -1 >= 0))	//move left 2, up 1
			move(knight, row -2, col -1);
		if ((row -2 >= 0)&&(col +1 <m))		//move left 2, down 1
			move(knight, row - 2, col +1);
		if ((row -1 >= 0)&&(col + 2 < m))	//move left 1, down 2
			move(knight, row -1, col + 2);
		if (!isFull(knight)){
			knight[row][col] = 0;
			count--;
			return;
		}
	}
	
	//isFull() function will check if the board game is filled
	public static boolean isFull(int[][] example){
		boolean isFull = true;
		for (int i = 0 ; i < example.length; i++){
			for (int j =0; j < example.length; j++)
				if(example[i][j] == 0){
					isFull = false;
					break;
				}
		}
		return isFull;
	}
	
	//print() function will print out the result after the board is filled with the knight's move
	public static void print(){
		for (int i = 0 ; i < knight.length; i++){
			for (int j =0; j < knight.length; j++){
				if (knight[i][j] <10)
					System.out.print(" " + knight[i][j] + " ");
				else System.out.print(knight[i][j] + " ");
			}
			System.out.println();
		}
	}	
}
