package services;

import entities.Room;
import entities.RoomType;
import services.exeptions.RequiredFieldMissedException;
import services.exeptions.RoomNotFoundException;

import java.util.List;
import java.util.Map;

public interface RoomService {
    /**
     * Получить комнату по идентификатору.
     *
     * @param id идентификатор комнаты
     * @throws RoomNotFoundException если комната с таким id не найдена
     * @return комната
     */
    Room getBy(String id) throws RoomNotFoundException;

    /**
     * Создать комнату.
     *
     * @param room комната
     * @return созданная комната с присвоенным идентификатором
     */
    Room createRoom(Room room) throws RequiredFieldMissedException;

    /**
     * Обновить данные комнаты.
     *
     * @param id идентификатор обновляемой комнаты
     * @param room обновленная комната
     * @throws RoomNotFoundException если комната с таким id не найдена
     * @return обновленная комната
     */
    Room updateRoom(String id, Room room)  throws RoomNotFoundException;

    /**
     * Удалить комнату.
     *
     * @param room комната
     */
    void deleteRoom(Room room);

    /**
     * Получить комнаты, сгруппированные по типу.
     * @return сгруппированные по типу комнаты
     */
    Map<RoomType, List<Room>> getRoomsGroupByType();
}
