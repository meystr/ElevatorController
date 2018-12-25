package rozanski.remigiusz.controller.comparators;

import rozanski.remigiusz.controller.Controller;
import rozanski.remigiusz.elevator.Direction;
import rozanski.remigiusz.request.Request;

import java.util.Comparator;

public class RequestComparator implements Comparator<Request> {
    private Controller controller;

    public RequestComparator(Controller controller) {
        this.controller = controller;
    }


    @Override
    public int compare(Request o1, Request o2) {
        int o1Floor = o1.getFloor().getFloorNumber();
        int o2Floor = o2.getFloor().getFloorNumber();
        int currFloor = controller.getElevator().getCurrentFloor().getFloorNumber();
        int direction = controller.getElevator().getDirection() == Direction.DOWN ? -1 : 1;
        int deltaFloor1 = o1Floor - currFloor;
        int deltaFloor2 = o2Floor - currFloor;
        if (deltaFloor1 * deltaFloor2 > 0) {
            if (deltaFloor1 < deltaFloor2) {
                return -direction;
            } else {
                return direction;
            }
        } else {
            if (deltaFloor1 < deltaFloor2) {
                return direction;
            } else {
                return -direction;
            }
        }
    }
}
