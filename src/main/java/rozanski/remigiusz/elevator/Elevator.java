package rozanski.remigiusz.elevator;

import rozanski.remigiusz.building.Floor;

public class Elevator {
    private Floor currentFloor;
    private Direction direction;

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    public void changeFloor() {
        if (direction == Direction.UP) {
            currentFloor.setFloorNumber(currentFloor.getFloorNumber() + 1);
        } else if (direction == Direction.DOWN) {
            currentFloor.setFloorNumber(currentFloor.getFloorNumber() - 1);
        }
    }

    public void setCurrentFloor(Floor currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Elevator(Floor currentFloor) {
        this.currentFloor = currentFloor;
        this.direction = Direction.STOP;
    }

    public Floor getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "Elevator{" +
                "currentFloor=" + currentFloor +
                ", direction=" + direction +
                '}';
    }
}
