import java.util.Scanner;
import java.util.Arrays;

public class Matrix {

    static Scanner input = new Scanner(System.in);

    public static void printMatrix(int[][] matrix) {
        System.out.println("\nMatriks:");
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] copyMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] copy = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                copy[i][j] = matrix[i][j];
            }
        }

        return copy;
    }

    // 1. Sort Row Wise
    public static void sortRowWise(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            Arrays.sort(matrix[i]);
        }
    }

    // 2. Sort Column Wise
    public static void sortColumnWise(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int j = 0; j < cols; j++) {

            int[] temp = new int[rows];

            for (int i = 0; i < rows; i++) {
                temp[i] = matrix[i][j];
            }

            Arrays.sort(temp);

            for (int i = 0; i < rows; i++) {
                matrix[i][j] = temp[i];
            }
        }
    }

    // 3. Rotate Clockwise by 1
    public static void rotateClockwiseByOne(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        if (rows < 2 || cols < 2)
            return;

        int temp = matrix[0][0];

        for (int i = 0; i < rows - 1; i++)
            matrix[i][0] = matrix[i + 1][0];

        for (int j = 0; j < cols - 1; j++)
            matrix[rows - 1][j] = matrix[rows - 1][j + 1];

        for (int i = rows - 1; i > 0; i--)
            matrix[i][cols - 1] = matrix[i - 1][cols - 1];

        for (int j = cols - 1; j > 1; j--)
            matrix[0][j] = matrix[0][j - 1];

        matrix[0][1] = temp;
    }

    // 4. Rotate Counter Clockwise by 1
    public static void rotateCounterClockwiseByOne(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        if (rows < 2 || cols < 2)
            return;

        int temp = matrix[0][0];

        for (int j = 0; j < cols - 1; j++)
            matrix[0][j] = matrix[0][j + 1];

        for (int i = 0; i < rows - 1; i++)
            matrix[i][cols - 1] = matrix[i + 1][cols - 1];

        for (int j = cols - 1; j > 0; j--)
            matrix[rows - 1][j] = matrix[rows - 1][j - 1];

        for (int i = rows - 1; i > 1; i--)
            matrix[i][0] = matrix[i - 1][0];

        matrix[1][0] = temp;
    }

    // 5. Rotate 90 Derajat
    public static int[][] rotate90(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] result = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][rows - 1 - i] = matrix[i][j];
            }
        }

        return result;
    }

    // 6. Rotate 180 Derajat
    public static int[][] rotate180(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[rows - 1 - i][cols - 1 - j] = matrix[i][j];
            }
        }

        return result;
    }

    // 7. Row Wise Traversal
    public static void rowWiseTraversal(int[][] matrix) {

        System.out.println("Row Wise Traversal:");

        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
        }

        System.out.println("\n");
    }

    // 8. Column Wise Traversal
    public static void columnWiseTraversal(int[][] matrix) {

        System.out.println("Column Wise Traversal:");

        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                System.out.print(matrix[i][j] + " ");
            }
        }

        System.out.println("\n");
    }

    // 9. Spiral Print
    public static void spiralPrint(int[][] matrix) {

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        System.out.println("Spiral Traversal:");

        while (top <= bottom && left <= right) {

            for (int i = left; i <= right; i++)
                System.out.print(matrix[top][i] + " ");

            top++;

            for (int i = top; i <= bottom; i++)
                System.out.print(matrix[i][right] + " ");

            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    System.out.print(matrix[bottom][i] + " ");

                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    System.out.print(matrix[i][left] + " ");

                left++;
            }
        }

        System.out.println("\n");
    }

    // 10. Transpose
    public static int[][] transpose(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] result = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.print("Jumlah baris: ");
        int rows = input.nextInt();

        System.out.print("Jumlah kolom: ");
        int cols = input.nextInt();

        int[][] matrixAsli = new int[rows][cols];

        System.out.println("Masukkan elemen matrix:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrixAsli[i][j] = input.nextInt();
            }
        }

        int pilihan;

        do {

            System.out.println("===== MENU MATRIX =====");
            System.out.println("1. Sort Matrix Row-wise");
            System.out.println("2. Sort Matrix Column-wise");
            System.out.println("3. Rotate Matrix Clockwise by 1");
            System.out.println("4. Rotate Matrix Counter-Clockwise by 1");
            System.out.println("5. Rotate Matrix 90°");
            System.out.println("6. Rotate Matrix 180°");
            System.out.println("7. Row-wise Traversal");
            System.out.println("8. Column-wise Traversal");
            System.out.println("9. Print Matrix in Spiral Form");
            System.out.println("10. Transpose Matrix");
            System.out.println("11. Quit");
            System.out.print("Pilih menu: ");

            pilihan = input.nextInt();

            int[][] hasil = copyMatrix(matrixAsli);

            switch (pilihan) {

                case 1:
                    sortRowWise(hasil);
                    printMatrix(hasil);
                    break;

                case 2:
                    sortColumnWise(hasil);
                    printMatrix(hasil);
                    break;

                case 3:
                    rotateClockwiseByOne(hasil);
                    printMatrix(hasil);
                    break;

                case 4:
                    rotateCounterClockwiseByOne(hasil);
                    printMatrix(hasil);
                    break;

                case 5:
                    hasil = rotate90(hasil);
                    printMatrix(hasil);
                    break;

                case 6:
                    hasil = rotate180(hasil);
                    printMatrix(hasil);
                    break;

                case 7:
                    rowWiseTraversal(matrixAsli);
                    break;

                case 8:
                    columnWiseTraversal(matrixAsli);
                    break;

                case 9:
                    spiralPrint(matrixAsli);
                    break;

                case 10:
                    hasil = transpose(hasil);
                    printMatrix(hasil);
                    break;

                case 11:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilihan != 11);
    }
}
