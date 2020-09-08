package CB;

public class RotateImage {

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static void rotate(int[][] image) {

        for (int row = 0; row < image.length; row++) {
            int i = 0;
            int j = image[0].length - 1;
            while (j > i) {
                int temp = image[row][i];
                image[row][i] = image[row][j];
                image[row][j] = temp;
                i++;
                j--;
            }
        }
       

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                if (i < j) {
                    
                    int temp = image[i][j];
                    image[i][j] = image[j][i];
                    image[j][i] = temp;
                }
            }
        }
        System.out.println();

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {

        int[][] image = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
        rotate(image);
        
    }

}