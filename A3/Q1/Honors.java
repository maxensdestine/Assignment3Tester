import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Honors {

    public static int min_moves(int[][] board) {
        return 0;
    }


    public static void test(String filename) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filename));
        int num_rows = sc.nextInt();
        int num_columns = sc.nextInt();
        int[][] board = new int[num_rows][num_columns];
        for (int i = 0; i < num_rows; i++) {
            char line[] = sc.next().toCharArray();
            for (int j = 0; j < num_columns; j++) {
                board[i][j] = (int) (line[j] - '0');
            }

        }
        sc.close();
        int answer = min_moves(board);
        System.out.println(answer);
    }

    public static int[] modTest(String filename) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filename+".in"));
        int num_rows = sc.nextInt();
        int num_columns = sc.nextInt();
        int[][] board = new int[num_rows][num_columns];
        for (int i = 0; i < num_rows; i++) {
            char line[] = sc.next().toCharArray();
            for (int j = 0; j < num_columns; j++) {
                board[i][j] = (int) (line[j] - '0');
            }

        }
        sc.close();
        sc = new Scanner(new File(filename+".ans"));
        int trueAnswer = Integer.parseInt(sc.nextLine());
        sc.close();
        int answer = min_moves(board);
        int[]res = {answer, trueAnswer};
        return res;
    }

    public void rafaleTesting(int total) throws FileNotFoundException {
        int result = 0;

        for (int i = 0; i < total; i++) {
            int[]res = modTest("A3//Q1//Grid-"+(i+1));
            if(res[0] == res[1]){
                result++;
            } else {
                System.out.println("\n------------------------------------");
                System.out.println("Failed test with file p" + i + ".txt");
                System.out.println("Your answer: "+res[0]+ " expected: "+res[1]);
                System.out.println("------------------------------------");
            }
        }
        System.out.println("Total for honors (CodePost tests) is "+result + " / " + total);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Honors honors = new Honors();

    }


}