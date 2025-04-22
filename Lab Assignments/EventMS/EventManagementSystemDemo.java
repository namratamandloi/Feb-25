import java.time.LocalDate;
import java.util.*;

class Participant {
    int participantId;
    String participantName;
    int age;
    String email;
    String phone;

    public Participant(int participantId, String participantName, int age, String email, String phone) {
        this.participantId = participantId;
        this.participantName = participantName;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "ID: " + participantId + ", Name: " + participantName + ", Age: " + age + ", Email: " + email + ", Phone: " + phone;
    }
}

class Event implements Comparable<Event> {
    int eventId;
    String eventName;
    LocalDate eventDate;
    String eventType;
    List<Participant> participantsList;

    public Event(int eventId, String eventName, LocalDate eventDate, String eventType) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventType = eventType;
        this.participantsList = new ArrayList<>();
    }

    public void addParticipant(Participant p) {
        participantsList.add(p);
    }

    public void removeParticipant(int participantId) {
        participantsList.removeIf(p -> p.participantId == participantId);
    }

    @Override
    public int compareTo(Event other) {
        return this.eventDate.compareTo(other.eventDate);
    }

    @Override
    public String toString() {
        return "Event ID: " + eventId + ", Name: " + eventName + ", Date: " + eventDate + ", Type: " + eventType;
    }
}

public class EventManagementSystemDemo {
    Map<Integer, Event> events = new HashMap<>();
    Set<Event> eventSet = new TreeSet<>();

    public void addEvent(Event event) {
        events.put(event.eventId, event);
        eventSet.add(event);
    }

    public void registerParticipant(int eventId, Participant participant) {
        Event event = events.get(eventId);
        if (event != null) {
            event.addParticipant(participant);
        } else {
            System.out.println("Event not found");
        }
    }

    public void displayEventsSortedByDate() {
        eventSet.forEach(System.out::println);
    }

    public void listParticipantsInEvent(int eventId) {
        Event event = events.get(eventId);
        if (event != null) {
            event.participantsList.forEach(System.out::println);
        } else {
            System.out.println("Event not found");
        }
    }

    public static void main(String[] args) {
        EventManagementSystemDemo system = new EventManagementSystemDemo();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Event");
            System.out.println("2. Register Participant");
            System.out.println("3. Display All Events Sorted by Date");
            System.out.println("4. List Participants in an Event");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Event ID: ");
                    int eventId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Event Name: ");
                    String eventName = scanner.nextLine();
                    System.out.print("Enter Event Date (YYYY-MM-DD): ");
                    LocalDate eventDate = LocalDate.parse(scanner.nextLine());
                    System.out.print("Enter Event Type: ");
                    String eventType = scanner.nextLine();
                    system.addEvent(new Event(eventId, eventName, eventDate, eventType));
                    break;
                case 2:
                    System.out.print("Enter Event ID: ");
                    int eId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Participant ID: ");
                    int pId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Participant Name: ");
                    String pName = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = scanner.nextLine();
                    system.registerParticipant(eId, new Participant(pId, pName, age, email, phone));
                    break;
                case 3:
                    System.out.println("All Events Sorted by Date:");
                    system.displayEventsSortedByDate();
                    break;
                case 4:
                    System.out.print("Enter Event ID: ");
                    int eventToCheck = scanner.nextInt();
                    system.listParticipantsInEvent(eventToCheck);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}