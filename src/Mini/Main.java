package Mini;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static PatientBST patientBST = new PatientBST();
    static EmergencyQueue emergencyQueue = new EmergencyQueue();
    static TreatmentStack treatmentStack = new TreatmentStack();

    static VisitLinkedList visitHistory =
            new VisitLinkedList();

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println(" MINI HOSPITAL EMERGENCY SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Add Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. Delete Patient");
            System.out.println("4. Display Patients");
            System.out.println("5. Add Emergency Patient");
            System.out.println("6. Treat Next Patient");
            System.out.println("7. Display Emergency Queue");
            System.out.println("8. Add Treatment Record");
            System.out.println("9. Remove Last Treatment");
            System.out.println("10. Display Treatment History");
            System.out.println("11. Add Patient Visit");
            System.out.println("12. Search Visit");
            System.out.println("13. Remove Visit");
            System.out.println("14. Display Visit History");
            System.out.println("0. Exit");

            System.out.print("\nEnter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    addPatient();
                    break;

                case 2:
                    searchPatient();
                    break;

                case 3:
                    deletePatient();
                    break;

                case 4:
                    patientBST.inorder();
                    break;

                case 5:
                    addEmergencyPatient();
                    break;

                case 6:
                    treatNextPatient();
                    break;

                case 7:
                    emergencyQueue.displayQueue();
                    break;

                case 8:
                    addTreatment();
                    break;

                case 9:
                    treatmentStack.popTreatment();
                    break;

                case 10:
                    treatmentStack.displayTreatments();
                    break;

                case 11:
                    addVisit();
                    break;

                case 12:
                    searchVisit();
                    break;

                case 13:
                    removeVisit();
                    break;

                case 14:
                    visitHistory.displayVisits();
                    break;

                case 0:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    // Add Patient
    static void addPatient() {

        System.out.print("Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Patient Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Contact Number: ");
        String contact = scanner.nextLine();

        System.out.print("Medical Condition: ");
        String condition = scanner.nextLine();

        Patient patient = new Patient(
                id, name, age, contact, condition
        );

        patientBST.insert(patient);

        System.out.println("Patient registered successfully.");
    }

    // Search Patient
    static void searchPatient() {

        System.out.print("Enter Patient ID: ");

        int id = scanner.nextInt();

        Patient patient = patientBST.search(id);

        if (patient != null) {
            patient.displayPatient();
        }
        else {
            System.out.println("Patient not found.");
        }
    }

    // Delete Patient
    static void deletePatient() {

        System.out.print("Enter Patient ID: ");

        int id = scanner.nextInt();

        patientBST.delete(id);

        System.out.println("Delete operation completed.");
    }

    // Add Emergency Patient
    static void addEmergencyPatient() {

        System.out.print("Enter Patient ID: ");

        int id = scanner.nextInt();

        Patient patient = patientBST.search(id);

        if (patient != null) {
            emergencyQueue.enqueue(patient);
        }
        else {
            System.out.println("Patient not found.");
        }
    }

    // Treat Next Patient
    static void treatNextPatient() {

        Patient patient = emergencyQueue.dequeue();

        if (patient != null) {

            System.out.println(
                    "Now treating: " +
                    patient.patientName
            );

            treatmentStack.pushTreatment(
                    "Patient " +
                    patient.patientId +
                    " - " +
                    patient.patientName
            );
        }
    }

    // Add Treatment
    static void addTreatment() {

        System.out.print("Enter treatment record: ");

        String treatment = scanner.nextLine();

        treatmentStack.pushTreatment(treatment);
    }

    // Add Visit
    static void addVisit() {

        System.out.print("Visit ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Visit Date: ");
        String date = scanner.nextLine();

        System.out.print("Doctor Name: ");
        String doctor = scanner.nextLine();

        System.out.print("Diagnosis: ");
        String diagnosis = scanner.nextLine();

        System.out.print("Treatment: ");
        String treatment = scanner.nextLine();

        Visit visit = new Visit(
                id,
                date,
                doctor,
                diagnosis,
                treatment
        );

        visitHistory.addVisit(visit);

        System.out.println("Visit added successfully.");
    }

    // Search Visit
    static void searchVisit() {

        System.out.print("Enter Visit ID: ");

        int id = scanner.nextInt();

        Visit visit = visitHistory.searchVisit(id);

        if (visit != null) {
            visit.displayVisit();
        }
        else {
            System.out.println("Visit not found.");
        }
    }

    // Remove Visit
    static void removeVisit() {

        System.out.print("Enter Visit ID: ");

        int id = scanner.nextInt();

        visitHistory.removeVisit(id);
    }
}

