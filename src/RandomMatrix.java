import java.util.Random;

public class RandomMatrix {
    public static void main(String[] args) {
        // Set the dimensions of the matrix
        int rows = 5;
        int cols = 40;
        int numChars = rows * cols;

        // Create an empty matrix
        char[][] matrix = new char[rows][cols];

        // Populate the matrix with random uppercase letters
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Choose a random uppercase letter
                char letter = (char) (random.nextInt(26) + 'A');
                matrix[i][j] = letter;
            }
        }

        // Group the letters by 5 and print the matrix
        for (int i = 0; i < rows; i++) {
            StringBuilder rowWithSpaces = new StringBuilder();
            for (int j = 0; j < cols; j++) {
                rowWithSpaces.append(matrix[i][j]);
                if ((j + 1) % 5 == 0 && j != cols - 1) {
                    rowWithSpaces.append(' ');
                }
            }
            System.out.println(rowWithSpaces.toString());
        }
    }
}
