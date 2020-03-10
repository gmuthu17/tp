package seedu.duke.reservation;

import java.util.ArrayList;
import java.util.List;

import static seedu.duke.utils.Constants.INVALID;
import static seedu.duke.utils.Constants.SERVED;

public class ReservationList {
    List<Reservation> reservations;

    /**
     * Defines the constructor and starts with an empty list.
     */
    public ReservationList() {
         reservations = new ArrayList<>();
    }

    /**
     * Defines the constructor and starts with a given ArrayList of reservations.
     * 
     * @param reservations Beginning list of reservations.
     */
    public ReservationList(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    /**
     * Adds the reservation into the list.
     * 
     * @param reservation Reservation that needs to be added into the list.
     */
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    /**
     * Marks the reservation as served.
     * 
     * @param reservationNumber The index number of the reservation.
     */
    public void markReservationAsServed(int reservationNumber) {
        reservations.get(reservationNumber).setStatus(SERVED);
    }

    /**
     * Marks the reservation as invalid, etc. the customer wants to cancel the reservation or wrong reservation
     * 
     * @param reservationNumber The index number of the reservation.
     */
    public void voidReservation(int reservationNumber) {
        reservations.get(reservationNumber).setStatus(INVALID);
    }

    /**
     * Gets the size of the reservation list.
     * 
     * @return Size of reservation list.
     */
    public int getSize() {
        return this.reservations.size();
    }
    
    public Reservation getReservation(int reservationNumber) {
        return reservations.get(reservationNumber - 1);
    }
}