import java.util.ArrayList;
import java.util.Scanner;

class Room {
    private int roomNumber;
    private String type;
    private double price;
    private boolean booked;
    private String guestName;

    Room(int roomNumber, String type, double price) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.booked = false;
        this.guestName = "";
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isBooked() {
        return booked;
    }

    public void bookRoom(String guestName) {
        booked = true;
        this.guestName = guestName;
    }

    public void checkOut() {
        booked = false;
        guestName = "";
    }

    public void displayRoom() {
        System.out.println(
            "Room: " + roomNumber +
            " | Type: " + type +
            " | Price: ₹" + price +
            " | Status: " + (booked ? "Booked" : "Available")
        );

        if (booked) {
            System.out.println("Guest: " + guestName);
        }
    }
}

public class HotelManagement {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Room> rooms = new ArrayList<>();

    public static void addRooms() {
        rooms.add(new Room(101, "Single", 1500));
        rooms.add(new Room(102, "Single", 1500));
        rooms.add(new Room(201, "Double", 2500));
        rooms.add(new Room(202, "Double", 2500));
        rooms.add(new Room(301, "Deluxe", 4000));
        rooms.add(new Room(302, "Deluxe", 4000));
    }

    public static Room findRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }

        return null;
    }

    public static void viewRooms() {
        System.out.println("\n----- ALL ROOMS -----");

        for (Room room : rooms) {
            room.displayRoom();
        }
    }

    public static void bookRoom() {
        System.out.println("\n----- BOOK ROOM -----");

        System.out.print("Enter room number: ");
        int roomNumber = Integer.parseInt(sc.nextLine());

        Room room = findRoom(roomNumber);

        if (room == null) {
            System.out.println("Room not found.");
            return;
        }

        if (room.isBooked()) {
            System.out.println("Room is already booked.");
            return;
        }

        System.out.print("Enter guest name: ");
        String guestName = sc.nextLine();

        room.bookRoom(guestName);

        System.out.println("Room booked successfully.");
    }

    public static void searchRoom() {
        System.out.println("\n----- SEARCH ROOM -----");

        System.out.print("Enter room number: ");
        int roomNumber = Integer.parseInt(sc.nextLine());

        Room room = findRoom(roomNumber);

        if (room == null) {
            System.out.println("Room not found.");
            return;
        }

        room.displayRoom();
    }

    public static void checkOut() {
        System.out.println("\n----- CHECK OUT -----");

        System.out.print("Enter room number: ");
        int roomNumber = Integer.parseInt(sc.nextLine());

        Room room = findRoom(roomNumber);

        if (room == null) {
            System.out.println("Room not found.");
            return;
        }

        if (!room.isBooked()) {
            System.out.println("This room is not booked.");
            return;
        }

        room.checkOut();

        System.out.println("Check-out completed successfully.");
    }

    public static void main(String[] args) {

        addRooms();

        while (true) {

            System.out.println("\n==============================");
            System.out.println("      HOTEL MANAGEMENT");
            System.out.println("==============================");
            System.out.println("1. View All Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Search Room");
            System.out.println("4. Check Out");
            System.out.println("5. Exit");
            System.out.println("==============================");

            System.out.print("Enter your choice: ");
            String choice = sc.nextLine();

            if (choice.equals("1")) {
                viewRooms();

            } else if (choice.equals("2")) {
                bookRoom();

            } else if (choice.equals("3")) {
                searchRoom();

            } else if (choice.equals("4")) {
                checkOut();

            } else if (choice.equals("5")) {
                System.out.println("Thank you for using Hotel Management System.");
                break;

            } else {
                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}