package api.impl;

import api.BookingAPIService;
import entities.Booking;
import services.BookingService;
import services.exeptions.BookingNotFoundException;
import services.exeptions.RequiredFieldMissedException;
import services.exeptions.RoomNotFoundException;

public class BookingAPIServiceImpl implements BookingAPIService {

    private final BookingService bookingService;

    public BookingAPIServiceImpl(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Override
    public Booking createBooking(Booking booking) {
        try {
            return bookingService.createBooking(booking);
        } catch (RoomNotFoundException | RequiredFieldMissedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Booking updateBooking(String id, Booking booking) {
        try {
            return bookingService.updateBooking(id, booking);
        } catch (RoomNotFoundException | RequiredFieldMissedException | BookingNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Booking getBooking(String id) {
        try {
            return bookingService.getBy(id);
        } catch (BookingNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteBooking(String id) {
        Booking booking = getBooking(id);
        if (booking != null) {
            bookingService.deleteBooking(booking);
        }
    }
}
