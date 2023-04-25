package com.tele2.sf.domain;

import java.util.Objects;

public record Door(int doorNumber, boolean winner) {

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Door door)) {
            return false;
        }
        return doorNumber() == door.doorNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(doorNumber());
    }
}
