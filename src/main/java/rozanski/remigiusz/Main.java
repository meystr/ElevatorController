package rozanski.remigiusz;


import rozanski.remigiusz.building.Building;
import rozanski.remigiusz.building.Floor;
import rozanski.remigiusz.controller.Controller;
import rozanski.remigiusz.elevator.Direction;
import rozanski.remigiusz.elevator.Elevator;
import rozanski.remigiusz.request.CallElevator;
import rozanski.remigiusz.request.CallForFloor;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main extends Thread {
    public static void main(String[] args) throws InterruptedException {

        Elevator elevator = new Elevator(new Floor(0));
        List<Floor> floorList = new ArrayList<>();
        Controller controller = Controller.getInstance(elevator);
        Building building = new Building(floorList, controller);
        building.passFloorListToController(floorList);
        elevator.setCurrentFloor(new Floor(55));
      /*  elevator.setDirection(Direction.DOWN);
        elevator.setCurrentFloor(new Floor(55));
        controller.addRequest(new CallForFloor(new Floor(50)));
        controller.addRequest(new CallForFloor(new Floor(5)));
        controller.addRequest(new CallForFloor(new Floor(18)));
        controller.addRequest(new CallForFloor(new Floor(19)));
        controller.addRequest(new CallForFloor(new Floor(17)));
        controller.addRequest(new CallForFloor(new Floor(87)));
        controller.addRequest(new CallForFloor(new Floor(32)));
        controller.addRequest(new CallForFloor(new Floor(1)));
        controller.addRequest(new CallForFloor(new Floor(76)));
        controller.addRequest(new CallForFloor(new Floor(50)));
        controller.addRequest(new CallForFloor(new Floor(34)));
        controller.addRequest(new CallForFloor(new Floor(99)));
        controller.addRequest(new CallForFloor(new Floor(37)));
        elevator.setDirection(Direction.UP);
        controller.reprioritizeRequests();
        while (controller.getRequestList().size() > 0) {
            System.out.println(controller.removeRequest().getFloor().getFloorNumber());
        }*/

        Random random = new Random();
        int randomFloor = random.nextInt(100);
        Thread MyThread = new Thread();
        MyThread.start();
        while (true) {
            controller.addRequest(new CallForFloor(new Floor(randomFloor)));
            System.out.println("Request elevator to the floor: " + randomFloor);
            System.out.println("Elevator is on the floor number: " + elevator.getCurrentFloor().getFloorNumber());
            if (randomFloor > elevator.getCurrentFloor().getFloorNumber()) {
                elevator.setDirection(Direction.UP);
                elevator.changeFloor();
            }
            if (randomFloor < elevator.getCurrentFloor().getFloorNumber()){
                elevator.setDirection(Direction.DOWN);
                elevator.changeFloor();
            }
            if (randomFloor == elevator.getCurrentFloor().getFloorNumber()) {
                elevator.setDirection(Direction.STOP);
                controller.removeRequest();
                controller.addRequest(new CallForFloor(new Floor(randomFloor)));
                // break;
                // controller.reprioritizeRequests();
                //  elevator.getCurrentFloor().setFloorNumber(randomFloor);
               // continue;
            }
            sleep(300);
        }
    }
}
