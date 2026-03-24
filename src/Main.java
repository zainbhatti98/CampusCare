import person.*;
import ticket.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Person> persons = new ArrayList<>();
        ArrayList<Ticket> tickets = new ArrayList<>();

        int choice = 0;

        do {
            System.out.println("\n------ CampusCare Menu ------");
            System.out.println("1. Add Person");
            System.out.println("2. Create Ticket");
            System.out.println("3. View Tickets");
            System.out.println("4. Update Ticket Status");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = Integer.parseInt(sc.nextLine()); // ✅ FIXED INPUT

            switch (choice) {

                case 1:
                    System.out.println("\n1. Student");
                    System.out.println("2. Staff");
                    System.out.print("Select type: ");
                    int type = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter ID: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    if (type == 1) {
                        System.out.print("Enter Program: ");
                        String program = sc.nextLine();

                        System.out.print("Enter Semester: ");
                        int sem = Integer.parseInt(sc.nextLine());

                        persons.add(new Student(id, name, email, program, sem));

                    } else {
                        System.out.print("Enter Department: ");
                        String dept = sc.nextLine();

                        persons.add(new Staff(id, name, email, dept));
                    }

                    System.out.println("Person added successfully!");
                    break;

                case 2:
                    System.out.println("\n1. Maintenance Ticket");
                    System.out.println("2. Cleaning Ticket");
                    System.out.print("Select type: ");
                    int t = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter Ticket ID: ");
                    int tid = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Description: ");
                    String desc = sc.nextLine();

                    System.out.print("Enter Location: ");
                    String loc = sc.nextLine();

                    System.out.print("Enter Type: ");
                    String ttype = sc.nextLine();

                    if (t == 1) {
                        tickets.add(new Maintain(tid, title, desc, loc, ttype));
                    } else {
                        tickets.add(new Clean(tid, title, desc, loc, ttype));
                    }

                    System.out.println("Ticket created successfully!");
                    break;
                case 3:
                    System.out.println("\n--- All Tickets ---");
                    for (Ticket tk : tickets) {
                        System.out.println("ID: " + tk.getTicketId() +
                                " | Status: " + tk.getStatus() +
                                " | Priority: " + tk.priorityScore());
                    }
                    break;

                case 4:
                    System.out.print("Enter Ticket ID: ");
                    int searchId = Integer.parseInt(sc.nextLine());

                    boolean found = false;

                    for (Ticket tk : tickets) {
                        if (tk.getTicketId() == searchId) {

                            System.out.println("1. Assigned");
                            System.out.println("2. Resolved");
                            System.out.print("Choose status: ");

                            int s = Integer.parseInt(sc.nextLine());

                            if (s == 1) {
                                tk.setStatus("Assigned");
                            } else if (s == 2) {
                                tk.setStatus("Resolved");
                            }

                            System.out.println("Status updated!");
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Ticket not found!");
                    }

                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}