//Christian Palma
// CS 145
// 8/01/2023


import java.util.Arrays;
// move disk keeps track of the direction the disk is moved. from source to destination
// the position is stored as towerposition
public class TowersOfHanoi {
    public static void moveDisk(int diskNumber, String source, String destination,
     int[] towerPositions) {
        // Function to move a single disk from the source tower to the destination tower.
        System.out.println("Move disk " + diskNumber + " from " + source + " to " + destination);
        towerPositions[diskNumber - 1] = destination.charAt(0) - 'A'; // Update disk position
        displayTowerPositions(towerPositions);
    }

    public static void hanoi(int n, String source, String auxiliary, String destination,
     int[] towerPositions) {
        // Recursive function to solve the Towers of Hanoi puzzle.
        if (n == 1) {
            // Base case: Only one disk to move, simply move it from the source to the destination.
            moveDisk(n, source, destination, towerPositions);
        } else {
            // Move n-1 disks from the source tower to the auxiliary tower 
            //using the destination tower.
            hanoi(n - 1, source, destination, auxiliary, towerPositions);

            // Move the largest disk from the source tower to the destination tower.
            moveDisk(n, source, destination, towerPositions);

            // Move the n-1 disks from the auxiliary tower to the destination 
            //tower using the source tower.
            hanoi(n - 1, auxiliary, source, destination, towerPositions);
        }
    }

    public static void displayTowerPositions(int[] towerPositions) {
        // Function to display the current positions of the disks on each tower.
        char[] towers = { 'A', 'B', 'C' };
        for (char tower : towers) {
            System.out.print(tower + " - ");
            for (int i = 0; i < towerPositions.length; i++) {
                if (towerPositions[i] == (tower - 'A')) {
                    System.out.print(i + 1 + " ");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Define the names of the three towers.
        String sourceTower = "A";
        String auxiliaryTower = "B";
        String destinationTower = "C";

        // Number of disks to move.
        int numDisks = 4;

        // Create an array to track the disk positions 
        //(0 represents A, 1 represents B, 2 represents C).
        int[] towerPositions = new int[numDisks];
        Arrays.fill(towerPositions, 0); // Initially, all disks are on tower A.

        // Display the starting position.
        System.out.println("Starting position:");
        displayTowerPositions(towerPositions);

        // Call the recursive function to solve the Towers of Hanoi puzzle.
        hanoi(numDisks, sourceTower, auxiliaryTower, destinationTower, towerPositions);
    }
}
