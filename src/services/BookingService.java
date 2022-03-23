package services;

import entities.Booking;
import services.exeptions.BookingNotFoundException;
import services.exeptions.RequiredFieldMissedException;
import services.exeptions.RoomNotFoundException;

public interface BookingService {
    /**
     * Получить бронирование по идентификатору.
     *
     * @param id идентификатор
     * @throws BookingNotFoundException если бронирование с таким id не найдено
     * @return бронирование
     */
    Booking getBy(String id) throws BookingNotFoundException;

    /**
     * Создать бронирование.
     *
     * @param booking бронирование
     * @return созданное бронирование с присвоенным идентификатором
     */
    Booking createBooking(Booking booking) throws RoomNotFoundException, RequiredFieldMissedException;

    /**
     * Обновить бронирование.
     *
     * @param booking обновленное бронирование
     * @throws BookingNotFoundException если бронирование с таким id не найдено
     * @return обновленное бронирование
     */
    Booking updateBooking(String id, Booking booking) throws RoomNotFoundException, RequiredFieldMissedException, BookingNotFoundException;

    /**
     * Удалить бронирование.
     *
     * @param booking бронирование
     */
    void deleteBooking(Booking booking);
}
