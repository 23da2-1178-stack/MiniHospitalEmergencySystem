package Mini;

import java.util.Stack;

public class TreatmentStack {

    private Stack<String> treatments = new Stack<>();

    // Push
    public void pushTreatment(String treatment) {

        treatments.push(treatment);

        System.out.println("Treatment record added.");
    }

    // Pop
    public void popTreatment() {

        if (treatments.isEmpty()) {
            System.out.println("Treatment history is empty.");
            return;
        }

        String treatment = treatments.pop();

        System.out.println("Removed Treatment: " + treatment);
    }

    // Display
    public void displayTreatments() {

        if (treatments.isEmpty()) {
            System.out.println("Treatment history is empty.");
            return;
        }

        System.out.println("\nTreatment History:");

        for (int i = treatments.size() - 1; i >= 0; i--) {
            System.out.println(treatments.get(i));
        }
    }
}
