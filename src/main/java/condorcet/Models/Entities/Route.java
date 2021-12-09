package condorcet.Models.Entities;

import javax.persistence.*;

@Entity
@Table(name = "route")
public class Route {
    private int Id;
    private String DeparturePoint;
    private String ArrivalPoint;
    private String FlightTime;
    private int Distance;

    public Route() {

    }

    public Route(int id, String departurePoint, String arrivalPoint, String flightTime, int distance) {
        Id = id;
        DeparturePoint = departurePoint;
        ArrivalPoint = arrivalPoint;
        FlightTime = flightTime;
        Distance = distance;
    }

    @Column(name = "flight_time", length = 45)
    public String getFlightTime() {
        return FlightTime;
    }

    public void setFlightTime(String flightTime) {
        FlightTime = flightTime;
    }

    @Column(name = "arrival_point", length = 45)
    public String getArrivalPoint() {
        return ArrivalPoint;
    }

    public void setArrivalPoint(String arrivalPoint) {
        ArrivalPoint = arrivalPoint;
    }

    @Column(name = "departure_point", length = 45)

    public String getDeparturePoint() {
        return DeparturePoint;
    }

    public void setDeparturePoint(String departurePoint) {
        DeparturePoint = departurePoint;
    }

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @Column(name = "distance")
    public int getDistance() {
        return Distance;
    }

    public void setDistance(int distance) {
        Distance = distance;
    }
}
