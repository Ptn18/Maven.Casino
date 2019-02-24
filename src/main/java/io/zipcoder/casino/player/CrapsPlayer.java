package io.zipcoder.casino.player;

import io.zipcoder.casino.utilities.GamblingPlayer;

import java.util.List;

public class CrapsPlayer extends DicePlayer implements GamblingPlayer {

    private List<Integer> bin;

    private static final int CrapsBetMoney = 10;

    public int betMoney(){
        int betMoney = -1;
        if (player.getMoney() > CrapsBetMoney){
            player.reduceMoney(CrapsBetMoney);
            betMoney = CrapsBetMoney;
        }
        return betMoney;
    }

    public void winMoney() {
            player.addMoney(CrapsBetMoney);
    }


}