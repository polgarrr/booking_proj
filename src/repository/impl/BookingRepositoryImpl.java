package repository.impl;

import entities.Booking;
import repository.BookingRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class BookingRepositoryImpl implements BookingRepository {
    private static final Set<Booking> bookings = new HashSet<>();

    // конструктор
    public BookingRepositoryImpl() {
    }

    @Override
    public Booking save(Booking booking) {
        // аналогично RoomRepository, создает новое бронирование, если такого id нет и
        // обновляет, если бронирование с таким идентификатором существует
        Optional<Booking> optionalBooking = bookings.stream().filter(currentBooking -> currentBooking.getId().equals(booking.getId())).findFirst();
        if (optionalBooking.isPresent()) {
            Booking oldBooking = optionalBooking.get();
            bookings.remove(oldBooking);
        }
        bookings.add(booking);
        return booking;
    }

    @Override
    public void delete(Booking booking) {
        // удаляет бронирование из поля bookings, если такого нет -- ничего не происходит
        Optional<Booking> optionalBooking = bookings.stream().filter(currentBooking -> currentBooking.equals(booking)).findFirst();
        if (optionalBooking.isPresent()) {
            Booking oldBooking = optionalBooking.get();
            bookings.remove(oldBooking);
        }
    }

    @Override
    public Booking getBy(String id) {
        // возвращает бронирование по идентификатору, если такого нет -- вернуть null
        Optional<Booking> optionalBooking = bookings.stream().filter(currentBooking -> currentBooking.getId().equals(id)).findFirst();
        return optionalBooking.orElse(null);
    }

    public Set<Booking> getAll() {
        // возвращает все бронирования
        return bookings;
    }
}
