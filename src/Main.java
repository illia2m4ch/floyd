import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the number of vertices: ");
        int size = in.nextInt();

        System.out.println("Enter the names of all the vertices: ");
        char[] names = new char[size];
        for (int i = 0; i < size; i++) {
            char name = in.next().charAt(0);
            names[i] = name;
        }

        System.out.println("Enter an array with weights: ");
        int[][] values = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int value = in.nextInt();
                values[i][j] = value;
            }
        }

        FloydAlgorithm algorithm = new FloydAlgorithm(values, names);
        algorithm.calculateAndPrint();
    }
}
