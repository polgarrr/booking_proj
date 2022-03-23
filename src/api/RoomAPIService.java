package api;

import entities.Room;
import entities.RoomType;

import java.util.List;
import java.util.Map;

public interface RoomAPIService {
    Room createRoom(Room room);
    Room updateRoom(String id, Room room);
    Room getRoom(String id);
    Map<RoomType, List<Room>> getRoomsGroupedByType();
    void deleteRoom(String id);
}
