import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Vaccines {

    public class Country {
        private int ID;
        private int vaccine_threshold;
        private int vaccine_to_receive;
        private ArrayList<Integer> allies_ID;
        private ArrayList<Integer> allies_vaccine;

        public Country() {
            this.allies_ID = new ArrayList<Integer>();
            this.allies_vaccine = new ArrayList<Integer>();
            this.vaccine_threshold = 0;
            this.vaccine_to_receive = 0;
        }

        public int get_ID() {
            return this.ID;
        }

        public int get_vaccine_threshold() {
            return this.vaccine_threshold;
        }

        public ArrayList<Integer> get_all_allies_ID() {
            return allies_ID;
        }

        public ArrayList<Integer> get_all_allies_vaccine() {
            return allies_vaccine;
        }

        public int get_allies_ID(int index) {
            return allies_ID.get(index);
        }

        public int get_allies_vaccine(int index) {
            return allies_vaccine.get(index);
        }

        public int get_num_allies() {
            return allies_ID.size();
        }

        public int get_vaccines_to_receive() {
            return vaccine_to_receive;
        }

        public void set_allies_ID(int value) {
            allies_ID.add(value);
        }

        public void set_allies_vaccine(int value) {
            allies_vaccine.add(value);
        }

        public void set_ID(int value) {
            this.ID = value;
        }

        public void set_vaccine_threshold(int value) {
            this.vaccine_threshold = value;
        }

        public void set_vaccines_to_receive(int value) {
            this.vaccine_to_receive = value;
        }

    }

    public int vaccines(Country[] graph) {
        //Computing the exceed in vaccines per country.
        return 0;
    }



    public void test(String filename) throws FileNotFoundException {
        Vaccines hern = new Vaccines();
        Scanner sc = new Scanner(new File(filename));
        int num_countries = sc.nextInt();
        Country[] graph = new Country[num_countries];
        for (int i = 0; i < num_countries; i++) {
            graph[i] = hern.new Country();
        }
        for (int i = 0; i < num_countries; i++) {
            if (!sc.hasNext()) {
                sc.close();
                sc = new Scanner(new File(filename + ".2"));
            }
            int amount_vaccine = sc.nextInt();
            graph[i].set_ID(i + 1);
            graph[i].set_vaccine_threshold(amount_vaccine);
            int other_countries = sc.nextInt();
            for (int j = 0; j < other_countries; j++) {
                int neighbor = sc.nextInt();
                int vaccine = sc.nextInt();
                graph[neighbor - 1].set_allies_ID(i + 1);
                graph[neighbor - 1].set_allies_vaccine(vaccine);
                graph[i].set_vaccines_to_receive(graph[i].get_vaccines_to_receive() + vaccine);
            }
        }
        sc.close();
        int answer = vaccines(graph);
        System.out.println(answer);
    }

    public int[] testCustom(String filename) throws FileNotFoundException {
        Vaccines hern = new Vaccines();
        Scanner sc = new Scanner(new File(filename+".in"));
        int num_countries = sc.nextInt();
        Country[] graph = new Country[num_countries];
        for (int i = 0; i < num_countries; i++) {
            graph[i] = hern.new Country();
        }
        for (int i = 0; i < num_countries; i++) {
            if (!sc.hasNext()) {
                sc.close();
                sc = new Scanner(new File(filename + ".in.2"));
            }
            int amount_vaccine = sc.nextInt();
            graph[i].set_ID(i + 1);
            graph[i].set_vaccine_threshold(amount_vaccine);
            int other_countries = sc.nextInt();
            for (int j = 0; j < other_countries; j++) {
                int neighbor = sc.nextInt();
                int vaccine = sc.nextInt();
                graph[neighbor - 1].set_allies_ID(i + 1);
                graph[neighbor - 1].set_allies_vaccine(vaccine);
                graph[i].set_vaccines_to_receive(graph[i].get_vaccines_to_receive() + vaccine);
            }
        }
        sc.close();
        int answer = vaccines(graph);
        sc = new Scanner(new File(filename+".out"));
        int trueAnswer = Integer.parseInt(sc.nextLine());
        sc.close();
        int[]res = {answer, trueAnswer};
        return res;
    }




    public int[] autoTest(String filename) throws FileNotFoundException {
        Random r = new Random();
        Scanner sc = new Scanner(new File(filename));
        int nbCountry = Integer.parseInt(sc.nextLine());
        Vaccines vac = new Vaccines();
        Country[] c = new Country[nbCountry];
        int vm = 0;
        int id = 0;
        int am = 0;

        for (int i = 0; i < nbCountry; i++) {
            c[i] = new Country();
            c[i].set_ID(i + 1);
        }

        for (int i = 0; i < nbCountry; i++) {
            Country co = c[i];
            String line = sc.nextLine();
            String[] arr = line.split(" ");
            line = sc.nextLine();
            String[] arr2 = line.split(" ");
            co.vaccine_threshold = Integer.parseInt(arr[0]);
            int size = arr2.length;


            for (int j = 0; j < size; j++) {
                id = Integer.parseInt(arr[j + 1]);
                am = Integer.parseInt(arr2[j]);
                vm = c[id - 1].get_vaccines_to_receive();

                c[id - 1].set_vaccines_to_receive(vm + am);
                co.allies_ID.add(id);
                co.allies_vaccine.add(am);
            }
        }
        int answer = Integer.parseInt(sc.nextLine());
        int[] res = {vac.vaccines(c), answer};
        return res;
    }

    public static void rafaleTesting(int total) throws FileNotFoundException {
        int result = 0;
        Vaccines v = new Vaccines();
        for (int i = 0; i < total; i++) {
            int[] res = v.testCustom("A3//Q2//0" + (i+1));
            if(res[0] == res[1]){
                result++;
            } else {
                System.out.println("\n------------------------------------");
                System.out.println("Failed test with file p" + i + ".txt");
                System.out.println("Your answer: "+res[0]+ " expected: "+res[1]);
                System.out.println("------------------------------------");
            }
        }
        System.out.println("Total for vaccine (CodePost tests) is "+result + " / " + total);
    }

    public static void rafaleCustomTesting(int total) throws FileNotFoundException {
        int result = 0;
        Vaccines v = new Vaccines();
        for (int i = 0; i < total; i++) {
            int[] res = v.autoTest("A3//Q2//p" + i + ".txt");
            if(res[0] == res[1]){
                result++;
            } else {
                System.out.println("\n------------------------------------");
                System.out.println("Failed test with file p" + i + ".txt");
                System.out.println("Your answer: "+res[0]+ " expected: "+res[1]);
                System.out.println("------------------------------------");
            }
        }
        System.out.println("Total for vaccine (Custom tests) is "+result + " / " + total);
    }

    public static void main(String[] args) throws FileNotFoundException {

    }

}
