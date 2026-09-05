package Mini;

public class PatientBST {

    class Node {
        Patient patient;
        Node left;
        Node right;

        Node(Patient patient) {
            this.patient = patient;
            left = null;
            right = null;
        }
    }

    Node root;

    // Insert patient
    public void insert(Patient patient) {
        root = insertNode(root, patient);
    }

    private Node insertNode(Node root, Patient patient) {

        if (root == null) {
            return new Node(patient);
        }

        if (patient.patientId < root.patient.patientId) {
            root.left = insertNode(root.left, patient);
        }
        else if (patient.patientId > root.patient.patientId) {
            root.right = insertNode(root.right, patient);
        }

        return root;
    }

    // Search patient
    public Patient search(int patientId) {

        Node current = root;

        while (current != null) {

            if (patientId == current.patient.patientId) {
                return current.patient;
            }

            if (patientId < current.patient.patientId) {
                current = current.left;
            }
            else {
                current = current.right;
            }
        }

        return null;
    }

    // In-order traversal
    public void inorder() {
        inorderTraversal(root);
    }

    private void inorderTraversal(Node root) {

        if (root != null) {

            inorderTraversal(root.left);

            root.patient.displayPatient();

            inorderTraversal(root.right);
        }
    }

    // Delete patient
    public void delete(int patientId) {
        root = deleteNode(root, patientId);
    }

    private Node deleteNode(Node root, int patientId) {

        if (root == null) {
            return null;
        }

        if (patientId < root.patient.patientId) {
            root.left = deleteNode(root.left, patientId);
        }
        else if (patientId > root.patient.patientId) {
            root.right = deleteNode(root.right, patientId);
        }
        else {

            // No child
            if (root.left == null && root.right == null) {
                return null;
            }

            // One child
            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            // Two children
            Node successor = findMinimum(root.right);

            root.patient = successor.patient;

            root.right = deleteNode(
                root.right,
                successor.patient.patientId
            );
        }

        return root;
    }

    private Node findMinimum(Node root) {

        while (root.left != null) {
            root = root.left;
        }

        return root;
    }
}
