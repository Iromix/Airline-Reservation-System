package airline.reservation;

import airline.reservation.domain.*;
import airline.reservation.infrastracture.HashmapReservationRepository;
import org.junit.*;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class HashmapReservationRepositoryTest {

    private ReservationRepository repository = new HashmapReservationRepository();

    @Test
    public void saveReservation() {
        //given
        Reservation reservation = new Reservation(new Seat(SeatRate.POOR).getId(), "abc1");

        //when
        repository.save(reservation);

        //then
        Reservation reservationFromRepo = repository.findById(reservation.getId());
        assertThat(reservationFromRepo.getClientId(), equalTo("abc1"));
    }

    @Test
    public void deleteReservation() {
        //given
        Reservation reservation = new Reservation(new Seat(SeatRate.POOR).getId(), "deleteRes1");
        repository.save(reservation);
        int amountOfReservations = repository.countReservations();

        //when
        repository.delete(reservation.getId());

        //then
        assertThat(repository.countReservations(), equalTo(amountOfReservations - 1));
    }

    @Test
    public void updateReservation() {
        //given
        Reservation reservation = new Reservation(new Seat(SeatRate.POOR).getId(), "clientId123");
        repository.save(reservation);
        int amountOfReservations = repository.countReservations();

        //when
        repository.update(reservation.getId(), new Reservation(new Seat(SeatRate.POOR).getId(), "ccc111"));

        //then
        assertThat(repository.countReservations(), equalTo(amountOfReservations));
    }
}