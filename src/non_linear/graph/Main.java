package non_linear.graph;

import java.util.Scanner;

public class Main {
    private static final Graph graph = new Graph();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;
        printInstructions();
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addNode("d");
        graph.addEdge("a","b");
        graph.addEdge("a","d");
        graph.addEdge("b","a");
        graph.addEdge("c","a");
        graph.addEdge("c","d");

        while (!quit) {
            System.out.println("\nEnter action: (6 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine(); // clear the buffer

            switch (action) {
                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;
                case 1:
                    addNode();
                    break;
                case 2:
                    removeNode();
                    break;
                case 3:
                    addEdge();
                    break;
                case 4:
                    removeEdge();
                    break;
                case 5:
                    printGraph();
                    break;
                case 6:
                    printInstructions();
                    break;
            }
        }
    }

    private static void printInstructions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0 - to shutdown\n" +
                "1 - to add a new node\n" +
                "2 - to remove a node\n" +
                "3 - to add an edge between nodes\n" +
                "4 - to remove an edge between nodes\n" +
                "5 - to print the graph\n" +
                "6 - to print a list of available actions.");
        System.out.println("Choose your action: ");
    }

    private static void addNode() {
        System.out.println("Enter a label for the new node:");
        String label = scanner.nextLine();
        graph.addNode(label);
        System.out.println("Node added: " + label);
    }

    private static void removeNode() {
        System.out.println("Enter the label of the node to remove:");
        String label = scanner.nextLine();
        graph.removeNode(label);
        System.out.println("Node removed: " + label);
    }

    private static void addEdge() {
        System.out.println("Enter the label of the from node:");
        String from = scanner.nextLine();
        System.out.println("Enter the label of the to node:");
        String to = scanner.nextLine();
        graph.addEdge(from, to);
        System.out.println("Edge added from " + from + " to " + to);
    }

    private static void removeEdge() {
        System.out.println("Enter the label of the from node:");
        String from = scanner.nextLine();
        System.out.println("Enter the label of the to node:");
        String to = scanner.nextLine();
        graph.removeEdge(from, to);
        System.out.println("Edge removed from " + from + " to " + to);
    }

    private static void printGraph() {
        graph.print();
    }
}

