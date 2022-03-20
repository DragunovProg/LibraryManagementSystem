package ua.dragunov.library.model;

import java.time.LocalDate;
import java.util.Objects;

public class Booking {
    private long id;
    private User user;
    private Book book;
    private LocalDate startBookingDate;
    private LocalDate endBookingDate;


    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getStartBookingDate() {
        return startBookingDate;
    }

    public void setStartBookingDate(LocalDate startBookingDate) {
        this.startBookingDate = startBookingDate;
    }

    public LocalDate getEndBookingDate() {
        return endBookingDate;
    }

    public void setEndBookingDate(LocalDate endBookingDate) {
        this.endBookingDate = endBookingDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return getId() == booking.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", user=" + user +
                ", book=" + book +
                ", startBookingDate=" + startBookingDate +
                ", endBookingDate=" + endBookingDate +
                '}';
    }


}
