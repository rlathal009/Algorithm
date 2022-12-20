import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int MAX = 1000001;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        Station station = new Station();
        int target = -1;

        for(int i=0; i<N; i++) {
            int number = Integer.parseInt(st.nextToken());
            station.add(target, number);
            target = number;
        }
        
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int targetNumber = Integer.parseInt(st.nextToken());
            int newNumber = -1;
            if(st.hasMoreTokens()) newNumber = Integer.parseInt(st.nextToken());

            if(command.equals("BN")) {
                station.print(station.nextNodes[targetNumber]);
                station.add(targetNumber, newNumber);
            } else if(command.equals("BP")) {
                station.print(station.preNodes[targetNumber]);
                station.add(station.preNodes[targetNumber], newNumber);
            } else if(command.equals("CN")) {
                station.print(station.nextNodes[targetNumber]);
                station.delete(station.nextNodes[targetNumber]);
            } else {
                station.print(station.preNodes[targetNumber]);
                station.delete(station.preNodes[targetNumber]);
            }
        }
        System.out.println(sb);
    }

    static class Station{
        int[] preNodes;
        int[] nextNodes;

        Station() {
            preNodes = new int[MAX];
            nextNodes = new int[MAX];
        }
        
        void add(int target, int node) {
            if(target==-1) {
                preNodes[node] = nextNodes[node] = node;
                return;
            }
            preNodes[node] = target;
            nextNodes[node] = nextNodes[target];
            preNodes[nextNodes[target]] = node;
            nextNodes[target] = node;
        }

        void delete(int target) {
            preNodes[nextNodes[target]] = preNodes[target];
            nextNodes[preNodes[target]] = nextNodes[target];
        }

        void print(int num) {
            sb.append(num + "\n");
        }
    }
}
