package rozanski.remigiusz.controller;

import rozanski.remigiusz.building.Floor;
import rozanski.remigiusz.controller.comparators.RequestComparator;
import rozanski.remigiusz.elevator.Elevator;
import rozanski.remigiusz.request.Request;

import java.util.*;

public class Controller {
    private List<Floor> floorList;
    private Queue<Request> requestList;
    private Elevator elevator;
    private static Controller controller;

    private Controller(Elevator elevator) {
        this.elevator = elevator;
        Comparator<Request> comparator = new RequestComparator(this);
        requestList = new PriorityQueue<>(comparator);
    }

    public static Controller getInstance(Elevator elevator) {
        if (controller == null) {
            controller = new Controller(elevator);
        }
        return controller;
    }

    public Elevator getElevator() {
        return elevator;
    }

    public void reprioritizeRequests() {

        int len = requestList.size();
        Queue<Request> newQ = new PriorityQueue<>(len, new RequestComparator(this));
      //  System.out.println("Wielkosc listy: " + len);
        while (!requestList.isEmpty()) {
            newQ.add(requestList.remove());
        }
    requestList =newQ;
}

    public void addRequest(Request request) {
        requestList.add(request);
    }

    public Request removeRequest() {
        return requestList.poll();
    }

    public void setFloorList(List<Floor> floorList) {
        this.floorList = floorList;
    }

    public String listRequests() {
        String list = "";
        for (Request request : this.requestList) {
            list = list + request.getFloor().getFloorNumber() + ", ";
        }
        return list;
    }

    public Queue<Request> getRequestList() {
        return requestList;
    }

    @Override
    public String toString() {
        return "Controller{" +
                "floorList=" + floorList +
                ", requestList=" + listRequests() +
                ", elevator=" + elevator +
                '}';
    }
}
