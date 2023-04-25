package com.tele2.sf.service;

import com.tele2.sf.domain.Game;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

import static com.tele2.sf.common.Constants.MATCHES;
import static com.tele2.sf.common.Constants.MAX_DOORS;

@Slf4j
public class GameSimulationService {

    public GameSimulationService() {

        int wins = 0;
        var random = new Random();

        for (int i = 0; i < MATCHES; i++) {
            var game = new Game();
            game.userChoice(random.nextInt(MAX_DOORS));
            game.getWrongDoor();
            if (game.isUserWinner()) {
                wins++;
            }
        }

        log.info("Not changing the door made him win {} of {} matches!", wins, MATCHES);

        wins = 0;

        for (int i = 0; i < MATCHES; i++) {
            var game = new Game();
            game.userChoice(random.nextInt(MAX_DOORS));
            game.getWrongDoor();
            game.swapDoor();
            if (game.isUserWinner()) {
                wins++;
            }
        }

        log.info("Changing the door made him win {} of {} matches!", wins, MATCHES);

    }

}
