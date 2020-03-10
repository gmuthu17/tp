package seedu.duke.commands;

import seedu.duke.reservation.ReservationList;

/* Command object for "list reservations" command */
public class ListReservationCommand extends ReservationCommand {
    /**
     * Lists all reservations, including served, unserved, and invalid reservations.
     * 
     * @param reservations Existing reservation list.
     */
    @Override
    public void execute(ReservationList reservations) {
        // TODO: wrap it into Ui class
        for (int i = 1; i <= reservations.getSize(); i++) {
            System.out.println(reservations.getReservation(i));
        }
    }
}