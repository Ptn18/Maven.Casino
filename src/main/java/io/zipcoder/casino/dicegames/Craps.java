package io.zipcoder.casino.dicegames;

import io.zipcoder.casino.ioconsoles.IOConsole;
import io.zipcoder.casino.player.CrapsPlayer;
import io.zipcoder.casino.player.DicePlayer;
import io.zipcoder.casino.ioconsoles.IOCrapsConsole;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.utilities.GamblingGame;

import java.util.Arrays;

public class Craps extends DiceGame implements GamblingGame {

    private CrapsPlayer player;
    private IOCrapsConsole console;
    private int setPoint;
    private boolean passChoice;
    public int giveMoney() {
        return 0;
    }
    int turnNumber = 1;

    public Craps(DicePlayer player, IOConsole console){

        this.player = (CrapsPlayer) player;
        this.console = (IOCrapsConsole) console;
        dice = new Dice(2);
        passChoice = true;

    }

    public void bet() {

    }


    public void evaluateGame(){
        if(didWin){
            console.printResult(didWin);
        }
    }

    public void play() {

        boolean isDone = false;
        console.crapsWelcome();
        passChoice = console.passOrNotPass();

        do{
            console.promptRollDice();
            roll();
            int result = dice.getSum();
            console.printTossOutcome(result);
            isDone = evaluateTurn(turnNumber, result);

            if(!isDone)
                console.printContinueMessage();
            turnNumber ++;

        }while(!isDone);
    }

    private boolean evaluateTurn(int turnNumber, int result){

        boolean isDone = false;
        if(passChoice){
            if(turnNumber == 1 ) {
                if (result == 7 || result == 11) {
                    isDone = true;
                    didWin = true;
                } else if (isInDoNotPassList(result)){
                    isDone = true;
                    didWin = false;
                }else{
                    setPoint = result;
                }
            }else{
                if(result == 7){
                    isDone = true;
                    didWin = false;
                }
                else if(result == setPoint){
                    isDone = true;
                    didWin = true;
                }
            }
        }
        else{
            isDone = true;
            if(isInDoNotPassList(result)){
                didWin = true;
            }
        }
        return isDone;
    }

    private boolean isInPassList(int result){
        final int [] passList = {4,5,6,8,9,10};
        int isPresent = Arrays.binarySearch(passList,result);
        return isPresent > 0;
    }
    private boolean isInDoNotPassList(int result){
        final int [] passList = {2, 3, 12};
        int isPresent = Arrays.binarySearch(passList,result);
        return isPresent > 0;

    }
    public void exit() {

    }

    public static void main(String[] args) {
        Craps craps = new Craps(null, new IOCrapsConsole("Aswathy"));
        craps.play();
    }
}