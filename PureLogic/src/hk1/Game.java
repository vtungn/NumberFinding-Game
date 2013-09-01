package hk1;

import java.util.Stack;

public class Game {
	
	final int DEFAULT_DIFFICULTY = 0;
	
	int difficulty;
	public Stack<Integer> numberStack;
	
	public Game()
	{
		difficulty = DEFAULT_DIFFICULTY;		
		numberStack = new Stack<Integer>();
	}
	
	public void Init(int desiredDifficulty) {

		difficulty = desiredDifficulty;
		
		for (int i = difficulty; i >= 1; i--)
		{
			numberStack.push(i);
		}
	}	
	
	public int GetDifficulty() {

		return difficulty;
	}

	public boolean ChooseNumber(int number) {
		
		if (number != numberStack.peek())
		{
			return false;
		}		
		
		numberStack.pop();
		
		return true;
	}	
	
	public boolean IsWon() {

		return numberStack.isEmpty();
	}
}
