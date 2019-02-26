package io.zipcoder.casino.dicegames;

import io.zipcoder.casino.ioconsoles.IOConsole;
import io.zipcoder.casino.ioconsoles.IOCrapsConsole;
import io.zipcoder.casino.player.CrapsPlayer;
import io.zipcoder.casino.player.DicePlayer;
import io.zipcoder.casino.player.Player;
import org.junit.Assert;
import org.junit.Test;

public class CrapsTest {

    @Test
    public void crapsConstructorTest() {
        //Given
        IOConsole console = new IOConsole();
        DicePlayer newPlayer = new DicePlayer();
        Craps newgame = new Craps(newPlayer, console);

        //Then
        Assert.assertNotNull(newgame);
    }


    //Pass - First Round Win 7
    @Test
    public void testPassFirstRound7()
    {
        Integer[] toss1 = {4};
        Integer[] toss2 = {3};
        Dice dice = new DummyDiceForCrapsTest(toss1,toss2);
        Craps craps = new Craps(new CrapsPlayer(new Player(100,"Aswathy")),
                new DummyIOForCrapsTest("Aswathy", true), dice);
        craps.play();
        craps.printResults();
        int retrievedTurnNumber = craps.getTurnNumber();
        Assert.assertEquals(retrievedTurnNumber, 1);
        Assert.assertTrue(craps.didWin());
    }

    //Pass - First Round Win 11
    @Test
    public void testPassFirstRound11()
    {
        Integer[] toss1 = {5};
        Integer[] toss2 = {6};
        Dice dice = new DummyDiceForCrapsTest(toss1,toss2);
        Craps craps = new Craps(new CrapsPlayer(new Player(100,"Aswathy")),
                new DummyIOForCrapsTest("Aswathy", true), dice);
        craps.play();
        craps.printResults();
        int retrievedTurnNumber = craps.getTurnNumber();
        Assert.assertEquals(retrievedTurnNumber, 1);
        Assert.assertTrue(craps.didWin());
    }

    //Pass - FirstRound SetPoint 6 Win
    @Test
    public void testPassWinWithSetPoInteger()
    {
        Integer[] toss1 = {1,2,3,4};
        Integer[] toss2 = {5,2,6,2};
        Dice dice = new DummyDiceForCrapsTest(toss1,toss2);
        Craps craps = new Craps(new CrapsPlayer(new Player(100,"Aswathy")),
                new DummyIOForCrapsTest("Aswathy", true), dice);
        craps.play();
        craps.printResults();
        int retrievedTurnNumber = craps.getTurnNumber();
        Assert.assertEquals(retrievedTurnNumber, 4);
        Assert.assertTrue(craps.didWin());
    }

    //Pass - First Round Fail
    @Test
    public void testPassFirstRoundFail()
    {
        Integer[] toss1 = {1};
        Integer[] toss2 = {1};
        Dice dice = new DummyDiceForCrapsTest(toss1,toss2);
        Craps craps = new Craps(new CrapsPlayer(new Player(100,"Aswathy")),
                new DummyIOForCrapsTest("Aswathy", true), dice);
        craps.play();
        craps.printResults();
        int retrievedTurnNumber = craps.getTurnNumber();
        Assert.assertEquals(retrievedTurnNumber, 1);
        Assert.assertFalse(craps.didWin());

    }

    //Pass - FirstRound SetPoint 6 Fail
    @Test
    public void testPassFailWithSetPoint()
    {
        Integer[] toss1 = {1,2,3,5};
        Integer[] toss2 = {5,2,6,2};
        Dice dice = new DummyDiceForCrapsTest(toss1,toss2);
        Craps craps = new Craps(new CrapsPlayer(new Player(100,"Aswathy")),
                new DummyIOForCrapsTest("Aswathy", true), dice);
        craps.play();
        craps.printResults();
        int retrievedTurnNumber = craps.getTurnNumber();
        Assert.assertEquals(retrievedTurnNumber, 4);
        Assert.assertFalse(craps.didWin());

    }

    //Dont Pass - First Round Win
    @Test
    public void testDontPassFirstRoundWin()
    {
        Integer[] toss1 = {1};
        Integer[] toss2 = {1};
        Dice dice = new DummyDiceForCrapsTest(toss1,toss2);
        Craps craps = new Craps(new CrapsPlayer(new Player(100,"Aswathy")),
                new DummyIOForCrapsTest("Aswathy", false), dice);
        craps.play();
        craps.printResults();
        int retrievedTurnNumber = craps.getTurnNumber();
        Assert.assertEquals(retrievedTurnNumber, 1);
        Assert.assertTrue(craps.didWin());
    }

    //Dont Pass - First Round Fail
    @Test
    public void testDontPassFirstRoundLost()
    {
        Integer[] toss1 = {1};
        Integer[] toss2 = {3};
        Dice dice = new DummyDiceForCrapsTest(toss1,toss2);
        Craps craps = new Craps(new CrapsPlayer(new Player(100,"Aswathy")),
                new DummyIOForCrapsTest("Aswathy", false), dice);
        craps.play();
        craps.printResults();
        int retrievedTurnNumber = craps.getTurnNumber();
        Assert.assertEquals(retrievedTurnNumber, 1);
        Assert.assertFalse(craps.didWin());
    }

}
