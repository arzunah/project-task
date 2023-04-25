package com.tele2.sf.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static com.tele2.sf.common.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    @DisplayName("userChoice -> Should be the door set!")
    public void userChoice() {
        final var game = new Game();
        game.userChoice(1);
        assertEquals(1, game.getDoorUser().doorNumber());
    }

    @Test
    @DisplayName("userChoice -> Door not exist!")
    void userChoiceNoSuchElementException() {
        final var game = new Game();
        Throwable exception = assertThrows(NoSuchElementException.class, () -> game.userChoice(4));
        assertEquals(exception.getMessage(), DOOR_DOES_NOT_EXIST);
    }

    @Test
    @DisplayName("swapDoor -> Presenter needs to remove a door first!")
    void swapDoorNoSuchElementException() {
        final var game = new Game();
        Throwable exception = assertThrows(IllegalCallerException.class, game::swapDoor);
        assertEquals(exception.getMessage(), PRESENTER_NEEDS_TO_REMOVE_A_DOOR_FIRST);
    }

    @Test
    @DisplayName("swapDoor -> Should be the door change")
    void swapDoor() {
        final var game = new Game();
        game.userChoice(1);
        game.getWrongDoor();
        game.swapDoor();
        assertNotEquals(1, game.getDoorUser().doorNumber());
    }

    @Test
    @DisplayName("WrongDoor -> The door has already been shown!")
    void getWrongDoorIllegalCallerExceptionAlreadyBeenShown() {
        final var game = new Game();
        game.userChoice(1);
        game.getWrongDoor();
        Throwable exception = assertThrows(IllegalCallerException.class, game::getWrongDoor);
        assertEquals(exception.getMessage(), THE_DOOR_HAS_ALREADY_BEEN_SHOWN);
    }

    @Test
    @DisplayName("WrongDoor -> User needs to choose the port first!")
    void getWrongDoorIllegalCallerExceptionUserChooseFirst() {
        final var game = new Game();
        Throwable exception = assertThrows(IllegalCallerException.class, game::getWrongDoor);
        assertEquals(exception.getMessage(), USER_NEEDS_TO_CHOOSE_THE_PORT_FIRST);
    }

    @Test
    @DisplayName("WrongDoor -> Get Wrong door!")
    void getWrongDoor() {
        final var game = new Game();
        game.userChoice(1);
        final var wrongDoor = game.getWrongDoor();
        assertFalse(wrongDoor.winner());
    }

    @Test
    @DisplayName("isUserWinner -> Presenter needs to remove a door first!")
    void isUserWinnerIllegalCallerException() {
        final var game = new Game();
        Throwable exception = assertThrows(IllegalCallerException.class, game::isUserWinner);
        assertEquals(exception.getMessage(), PRESENTER_NEEDS_TO_REMOVE_A_DOOR_FIRST);
    }
}