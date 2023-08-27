package exceptions.exercicioProposto.model.entities;

import exceptions.exercicioProposto.model.exceptions.DomainException;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {
    private Integer roomNumber;
    private LocalDate checkin;
    private LocalDate checkout;

    private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout) throws DomainException {
        if (checkin.isAfter(checkout)) {
            throw new DomainException("Check-out date must be after check-in date");
        }
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public long duration() {
        return Duration.between(checkin.atStartOfDay(), checkout.atStartOfDay()).toDays();
    }

    // throws DomainException propaga a excecao na assinatura do metodo;
    public void updateDates(LocalDate checkin, LocalDate checkout) throws DomainException {

        if (checkin.isBefore(LocalDate.now()) || checkout.isBefore(LocalDate.now())) {
            throw new DomainException("Reservation dates for update must be future dates");
        }

        if (checkin.isAfter(checkout)) {
            throw new DomainException("Check-out date must be after check-in date");
        }
        this.checkin = checkin;
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Reservation: ");
        sb.append("Room " + getRoomNumber() + ", check-in: "
                + getCheckin().format(fmt) + " check-out: " + getCheckout().format(fmt)
                + ", " + duration() + " nights");
        sb.append("\n");
        return sb.toString();
    }
}
