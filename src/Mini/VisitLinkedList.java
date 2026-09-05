package Mini;

public class VisitLinkedList {

    class Node {

        Visit visit;
        Node next;

        Node(Visit visit) {
            this.visit = visit;
            this.next = null;
        }
    }

    Node head;

    // Add visit
    public void addVisit(Visit visit) {

        Node newNode = new Node(visit);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // Search visit
    public Visit searchVisit(int visitId) {

        Node current = head;

        while (current != null) {

            if (current.visit.visitId == visitId) {
                return current.visit;
            }

            current = current.next;
        }

        return null;
    }

    // Remove visit
    public void removeVisit(int visitId) {

        if (head == null) {
            System.out.println("Visit history is empty.");
            return;
        }

        if (head.visit.visitId == visitId) {
            head = head.next;
            System.out.println("Visit removed.");
            return;
        }

        Node current = head;

        while (current.next != null) {

            if (current.next.visit.visitId == visitId) {

                current.next = current.next.next;

                System.out.println("Visit removed.");
                return;
            }

            current = current.next;
        }

        System.out.println("Visit not found.");
    }

    // Display visits
    public void displayVisits() {

        if (head == null) {
            System.out.println("No previous visits.");
            return;
        }

        Node current = head;

        while (current != null) {

            current.visit.displayVisit();

            current = current.next;
        }
    }
}
