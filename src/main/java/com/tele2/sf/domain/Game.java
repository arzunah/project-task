package com.tele2.sf.domain;

import java.util.*;

import static com.tele2.sf.common.Constants.*;

public class Game {

    private final Door doorWinner;
    private final Set<Door> doors;
    private Door doorUser;

    public Game() {
        doors = new HashSet<>();
        var random = new Random();
        doorWinner = new Door(random.nextInt(MAX_DOORS), true);
        doors.add(doorWinner);
        Door door;
        do {
            door = new Door(random.nextInt(MAX_DOORS), false);
            doors.add(door);
        } while (doors.size() < MAX_DOORS);
    }

    public void userChoice(int doorNumber) {
        doorUser = doors.stream()
                .filter(door -> door.doorNumber() == doorNumber)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(DOOR_DOES_NOT_EXIST));
    }

    public void swapDoor() {
        validateRemoveDoor();
        doorUser = doors.stream()
                .filter(door -> door != doorUser)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(DOOR_DOES_NOT_EXIST));
    }

    public Door getWrongDoor() {
        if (Objects.isNull(doorUser)) {
            throw new IllegalCallerException(USER_NEEDS_TO_CHOOSE_THE_PORT_FIRST);
        }
        if (doors.size() < MAX_DOORS) {
            throw new IllegalCallerException(THE_DOOR_HAS_ALREADY_BEEN_SHOWN);
        }
        var wrongDoor = doors.stream()
                .filter(door -> !door.winner() && door != doorUser)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
        doors.remove(wrongDoor);
        return wrongDoor;
    }

    public boolean isUserWinner() {
        validateRemoveDoor();
        return doorWinner == doorUser;
    }

    public Door getDoorUser() {
        return doorUser;
    }

    private void validateRemoveDoor() {
        if (doors.size() > 2) {
            throw new IllegalCallerException(PRESENTER_NEEDS_TO_REMOVE_A_DOOR_FIRST);
        }
    }
}
