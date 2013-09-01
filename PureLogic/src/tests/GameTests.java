package tests;

import static org.junit.Assert.*;
import hk1.Game;

import org.junit.Before;
import org.junit.Test;

public class GameTests {
	
	Game game;
	
	@Before
	public void Setup()	{
		
		game = new Game();
	}
	
	@Test
	public void TestSetDifficulty() {

		int desiredDifficulty = 10;
		game.Init(desiredDifficulty);
		
		int difficulty = game.GetDifficulty();
		assertEquals(difficulty, desiredDifficulty);
	}

	@Test
	public void TestChooseNumber() {
		
		int maxNumber = 10;
		game.Init(maxNumber);
		boolean result = false;;
		
		result = game.ChooseNumber(2);
		assertTrue(!result);
		
		result = game.ChooseNumber(1);
		assertTrue(result);
	}
	
	@Test
	public void TestCompleteGame()
	{
		int maxNumber = 10;
		game.Init(maxNumber);
		
		for (int i = 1; i <= maxNumber; i++)
		{
			game.ChooseNumber(i);
		}
		
		boolean gameResult = game.IsWon();
		assertTrue(gameResult);
	}
}
