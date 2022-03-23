package services.impl;

import entities.Room;
import entities.RoomType;
import repository.RoomRepository;
import services.RoomService;
import services.exeptions.RequiredFieldMissedException;
import services.exeptions.RoomNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    // конструктор
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    // нужно с помощью roomRepository вернуть комнату по идентификатору,
    // в случае если комната не найдена -- выбросить RoomNotFoundException
    // (его нужно создать в пакете service.exceptions, там будут создаваться и остальные исключения)
    @Override
    public Room getBy(String id) throws RoomNotFoundException {
        Room room = roomRepository.getBy(id);
        if (room == null) {
            throw new RoomNotFoundException("Room with id: " + id + " not found");
        }
        return room;
    }


    @Override
    public Room createRoom(Room room) throws RequiredFieldMissedException {
        // а также перед этим проверить, что заполнены поля roomNumber, floor, type, price --
        // иначе выкинуть исключение RequiredFieldMissedException
        if (room.getRoomNumber() == null || room.getFloor() == null || room.getType() == null || room.getPrice() == null) {
            throw new RequiredFieldMissedException("Room is not completed with all required fields: roomNumber = " + room.getRoomNumber() + ", floor, type, price");
        }
        room.setId(UUID.randomUUID().toString());
        // здесь нужно с помощью roomRepository создать комнату и присвоить ей идентификатор
        // поле bookings не заполнять
        return roomRepository.save(room);
    }

    @Override
    public Room updateRoom(String id, Room room) throws RoomNotFoundException {
        getBy(id);
        return roomRepository.save(room);
        // здесь нужно проверить, что комната с таким id существует
        // обновить данные комнаты с помощью roomRepository
    }

    @Override
    public void deleteRoom(Room room) {
        roomRepository.delete(room);
        // удалить переданную комнату с помощью roomRepository вместе со всеми прикрепленными к ней бронированиями
    }

    @Override
    public Map<RoomType, List<Room>> getRoomsGroupByType() {
        return roomRepository.getAll().stream()
                .collect(Collectors.groupingBy(Room::getType));
        // получить комнаты, сгруппированные по типу, то есть должна получиться мапа вида
        // {LUXE: [Room1, Room2, Room3], ECONOM: [Room5, Room6], ... }
    }
}
