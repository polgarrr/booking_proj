package repository.impl;

import entities.Room;
import repository.RoomRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class RoomRepositoryImpl implements RoomRepository {
    private static final Set<Room> rooms = new HashSet<>();

    // конструктор
    public RoomRepositoryImpl() {
    }

    @Override
    public Room save(Room room) {
        // этот метод создает новую комнату (добавляет в поле rooms), если такого id нет и
        // обновляет, если комната с таким идентификатором существует
        Optional<Room> optionalRoom = rooms.stream().filter(currentRoom -> currentRoom.getId().equals(room.getId())).findFirst();
        if (optionalRoom.isPresent()) {
            Room oldRoom = optionalRoom.get();
            rooms.remove(oldRoom);
        }
        rooms.add(room);
        return room;
    }

    @Override
    public void delete(Room room) {
        // удаляет комнату из поля rooms, если такой комнаты нет -- ничего не происходит
        Optional<Room> optionalRoom = rooms.stream().filter(currentRoom -> currentRoom.equals(room)).findFirst();
        if (optionalRoom.isPresent()) {
            Room oldRoom = optionalRoom.get();
            rooms.remove(oldRoom);
        }
    }

    @Override
    public Room getBy(String id) {
        // возвращает комнату по идентификатору, если такой комнаты нет -- вернуть null
        Optional<Room> optionalRoom = rooms.stream().filter(currentRoom -> currentRoom.getId().equals(id)).findFirst();
        return optionalRoom.orElse(null);
    }

    @Override
    public Set<Room> getAll() {
        // возвращает все комнаты
        return rooms;
    }
}
