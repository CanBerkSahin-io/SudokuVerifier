package uk.ac.brunel.cs1702;



public class SudokuVerifier {
	
	public int verify(String candidateSolution){
		if (rule1(candidateSolution))
		{
			return -1;
		}
		
		if (rule5(candidateSolution))
		{
			return -5;
		}
		
		
		int [][] Sudoku = Convert(candidateSolution);

		
		if (rule2(Sudoku))
		{
			return -2;
		}
		else if (rule3(Sudoku))
		{
			return -3;
		}
		else if (rule4(Sudoku))
		{
			return -4;
		}
		

		return 0;
		
	}
	
	public static int[][] Convert(String candidateSolution){
		int counter = 0;
		int [][] tempMatrix = new int[9][9];
		for (int x = 0; x < 9; x++)
		{
			for (int y = 0; y < 9; y++)
			{
				tempMatrix[x][y] = candidateSolution.charAt(counter); 
				counter = counter + 1;
			}
		}
		return tempMatrix;
	}
	
	public static void main(String[] args){
		
	}
	
	public boolean rule1 (String candidateSolution)
	{
		if (!candidateSolution.matches("[1-9]+")) //If there's a 0 in the grid, return true (the rule has been broken)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean rule2 (int [][] Sudoku)
	{
		for (int y = 0; y < 9; y+=3) //rows
		{
			for (int x = 0; x < 9; x+=3) //columns
			{
				for (int q = x; q < 3; q++) //sub-grid rows
				{
					for (int h = y; h < 3; h++) //sub-grid columns
					{
						if ((q != x) && (h != y)) //checks if indexes aren't the same
						{
							if (Sudoku[x][y] == Sudoku[q][h]) //checks if values are the same
							{
								return true;
							}
						}
					}
				}
			}
		}
		return false;
		
	}
	
	public boolean rule4 (int[][] Sudoku)
	{
		for (int y = 0; y < Sudoku.length; y++) //rows
		{
			for (int x = 0; x < Sudoku[0].length; x++) //columns
			{
				for (int z = 0; z < Sudoku[0].length; z++) //columns
				{
					if (x != z) //if indexes are not the same
					{
						if (Sudoku[x][y] == Sudoku[z][y]) //check if the values are the same
						{
							return true; //you have failed this rule
						}
					}
				}
			}
		}
		return false;
		
	}
	
	public boolean rule3 (int[][] Sudoku)
	{
		for (int y = 0; y < Sudoku.length; y++) //rows
		{
			for (int x = 0; x < Sudoku[0].length; x++) //columns
			{
				for (int z = 0; z < Sudoku.length; z++) //rows
				{
					if (y != z) //if indexes are not the same
					{
						if (Sudoku[x][y] == Sudoku[x][z]) //check if the values are the same
						{
							return true; //you have failed this rule
						}
					}
				}
			}
		}
		return false;
		
	}
	
	
	public boolean rule5 (String candidateSolution)
	{
		if (candidateSolution.length() != 81) //If the grid's length is not 81
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	
}