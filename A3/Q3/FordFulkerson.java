import java.util.*;
import java.io.File;

public class FordFulkerson {

    public static ArrayList<Integer> pathDFS(Integer source, Integer destination, WGraph graph) {
        return new ArrayList<>();
    }


    public static String fordfulkerson(WGraph graph) {
        String answer = "";
        int maxFlow = 0;
        answer += maxFlow + "\n" + graph.toString();
        return answer;
    }

public static int[] fordFulkersonCustomTesting(String file) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(file + "ans.txt"));
        int realAns = sc.nextInt();
        WGraph g = new WGraph(file+".txt");
        int[] res = {getNumberFromFF(fordfulkerson(g)), realAns};
        return res;
    }

    public static void fordFulkersonCustomRafaleTesting(int nbTest) throws FileNotFoundException {
        int points = 0;
        for (int i = 0; i < nbTest; i++) {
            int[] res = fordFulkersonCustomTesting("A3//Q3//ff" + i);
            if (res[0] == res[1]) {
                points++;
            } else {
                System.out.println("FordFulkerson custom test failed for file: Q3//ff" + i);
                System.out.println("Your answer: " + res[0] + " expected: " + res[1]);
            }
        }
        System.out.println("Total for custom FordFulkerson tests (includes ff2.txt which is from codePost): "+points+" / "+nbTest);
        System.out.println("Disclaimer: FordFulkerson tester only verifies the maximum flow obtained, not the final graph");
    }


    public static int getNumberFromFF(String answer) {
        int positionOfNewLine = answer.indexOf("\n");
        String partBefore = null;
        if (positionOfNewLine >= 0) {
            partBefore = answer.substring(0, positionOfNewLine);
        } else {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(partBefore);
    }

    public static void main(String[] args) {
    }
}

