package rozanski.remigiusz.building;

import rozanski.remigiusz.controller.Controller;

import java.util.List;

public class Building {
    private final int NUMBERS_OF_FLOORS = 100;
    List<Floor> floorList;
    private Controller controller;

    public Building(List<Floor> floorList, Controller controller) {
        this.floorList = floorList;
        for (int i = 0; i <= NUMBERS_OF_FLOORS; i++) {
            floorList.add(new Floor(i));
        }
        this.controller = controller;
    }

    public void passFloorListToController(List<Floor> floorList) {
        this.controller.setFloorList(floorList);
    }

    @Override
    public String toString() {
        return "Building " + "NUMBERS OF FLOORS = " + NUMBERS_OF_FLOORS +"floorList = " + floorList;
    }
}
