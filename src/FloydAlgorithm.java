public class FloydAlgorithm {

    private final int size;

    private final int[][] values;
    private char[][] vertices;

    public FloydAlgorithm(int[][] graphValues, char... names) {
        size = names.length;
        this.values = graphValues;
        createGraphVertices(names);
    }

    private void createGraphVertices(char... names) {
        vertices = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                vertices[j][i] = names[i];
            }
        }
    }

    public void calculateAndPrint() {
        for (int i = 0; i < size; i++) {
            System.out.println("Iteration " + (i+1));
            doIteration(i);
            print();
        }
    }

    private void doIteration(int number) {
        for (int i = 0; i < size; i++) {

            if (i == number || values[i][number] == 0) continue;

            for (int j = 0; j < size; j++) {

                if (j == number || values[number][j] == 0) continue;

                int value = values[i][j];
                int sum = values[number][j] + values[i][number];

                if (value == 0 || sum < value) {
                    values[i][j] = sum;
                    vertices[i][j] = vertices[i][number];
                }

            }
        }
    }

    private void print() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (values[i][j] == 0) System.out.print("∞ ");
                else System.out.print(values[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(vertices[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println();
    }
}