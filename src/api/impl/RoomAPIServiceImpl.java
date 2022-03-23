package api.impl;

import api.RoomAPIService;
import entities.Booking;
import entities.Room;
import entities.RoomType;
import services.BookingService;
import services.RoomService;
import services.exeptions.BookingNotFoundException;
import services.exeptions.RequiredFieldMissedException;
import services.exeptions.RoomNotFoundException;

import java.util.List;
import java.util.Map;

public class RoomAPIServiceImpl implements RoomAPIService {

    private final RoomService roomService;

    public RoomAPIServiceImpl(RoomService roomService) {
        this.roomService = roomService;
    }

    @Override
    public Room createRoom(Room room) {
        try {
            return roomService.createRoom(room);
        } catch (RequiredFieldMissedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Room updateRoom(String id, Room room) {
        try {
            return roomService.updateRoom(id, room);
        } catch (RoomNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Room getRoom(String id) {
        try {
            return roomService.getBy(id);
        } catch (RoomNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Map<RoomType, List<Room>> getRoomsGroupedByType() {
        return roomService.getRoomsGroupByType();
    }

    @Override
    public void deleteRoom(String id) {
        Room room = getRoom(id);
        if (room != null) {
            roomService.deleteRoom(room);
        }
    }
}
