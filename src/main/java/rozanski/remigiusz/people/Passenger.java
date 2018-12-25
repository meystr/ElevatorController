package rozanski.remigiusz.people;

import rozanski.remigiusz.request.Request;

import java.util.HashSet;
import java.util.Set;

public class Passenger {

    private Request request;

    Set<Request> requestSet = new HashSet<>();

    public void addRequest(Request request) {
        requestSet.add(request);
    }

    public Passenger(Request request) {
        this.request = request;
    }
}