import api.BookingAPIService;
import api.RoomAPIService;
import api.impl.BookingAPIServiceImpl;
import api.impl.RoomAPIServiceImpl;
import entities.Booking;
import entities.Guest;
import entities.Room;
import entities.RoomType;
import services.BookingService;
import services.RoomService;
import services.impl.BookingServiceImpl;
import services.impl.RoomServiceImpl;

import java.util.HashSet;

public class Application {
    public static void main(String[] args) {
        BookingService bookingService = new BookingServiceImpl();
        RoomService roomService = new RoomServiceImpl();

        RoomAPIService roomAPIService = new RoomAPIServiceImpl(roomService);
        BookingAPIService bookingAPIService = new BookingAPIServiceImpl(bookingService);

        Room room = new Room("00001", "404", 4, RoomType.ECONOM, "base room", 3990, new HashSet<>());
        Guest guest = new Guest("88005553535", "sobaka.net", "Aristarch", "Bagrovich", "Aristarchovich");
        Booking booking = new Booking("001", 2022-09-01, 2022-09-05, guest, room);
    }
}
