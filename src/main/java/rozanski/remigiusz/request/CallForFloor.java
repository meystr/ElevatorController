package rozanski.remigiusz.request;

import rozanski.remigiusz.building.Floor;

public class CallForFloor implements Request {
    private Floor floor;

    public CallForFloor(Floor floor) {
        this.floor = floor;
    }



    @Override
    public Floor getFloor() {
        return this.floor;
    }
}
