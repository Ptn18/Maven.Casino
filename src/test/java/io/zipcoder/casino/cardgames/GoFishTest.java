package io.zipcoder.casino.cardgames;

import io.zipcoder.casino.Facilitator;
import io.zipcoder.casino.ioconsoles.IOConsole;
import io.zipcoder.casino.ioconsoles.IOGoFishConsole;
import io.zipcoder.casino.player.CardPlayer;
import io.zipcoder.casino.player.DicePlayer;
import io.zipcoder.casino.player.GoFishPlayer;
import io.zipcoder.casino.player.Player;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GoFishTest {

    @Test
    public void goFishConstructorTest() {
        //Given
        String name = "kate";
        IOGoFishConsole console = new IOGoFishConsole(name);
        Player player = new Player(100, name);
        GoFishPlayer newPlayer = new GoFishPlayer(player);
        GoFish newgame = new GoFish(newPlayer, console);

        //Then
        Assert.assertNotNull(newgame);
    }

    @Test
    public void playTestDealerWins() {

        int[] deckValues = {11,3,8,2,11,6,6,4,3,3,2,3,4,2};
        Deck deck = new DummyDeckForGoFishTest(deckValues);
        IOGoFishConsole console = new DummyIOForGoFishTest("Aswathy");

        GoFish game = new GoFish(new CardPlayer(new Player(100, "Aswathy")), console, deck);
        game.play();
        //game.printResults();
    }
    @Test
    public void playTestPlayerWins() {

        int[] deckValues = {11,2,8,2,11,6,6,4,3,3,2,11,4,2};
        Deck deck = new DummyDeckForGoFishTest(deckValues);
        IOGoFishConsole console = new DummyIOForGoFishTest("Aswathy");

        GoFish game = new GoFish(new CardPlayer(new Player(100, "Aswathy")), console, deck);
        game.play();
        //game.printResults();
    }



    @Test
    public void exit() {
    }

    @Test
    public void takeTurn() {
    }
}