package rozanski.remigiusz.request;

import rozanski.remigiusz.building.Floor;

public class CallElevator implements Request {
    private Floor floor;

    public CallElevator(Floor floor) {
        this.floor = floor;
    }

    @Override
    public Floor getFloor() {
        return this.floor;
    }
}
