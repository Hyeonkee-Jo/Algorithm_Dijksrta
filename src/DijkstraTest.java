import java.util.Scanner;

/**
 * Created by jo930_000 on 2016-11-09.
 */
public class DijkstraTest {
    public static void main(String[] args) {
        Dijkstra test = new Dijkstra();
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the number of nodes : ");
        int node_number = scan.nextInt();    // 그래프를 형성할 행,열 입력(행과 열의 수는 일치)

        System.out.println("\nEnter the cost matrix : ");  // 각 행을 스트링 형식으로 입력 ex) 1 2 3 4 5
        /* 0 7 0 0 3 10 0          <- 각 행을 한 입력에 스트링형식으로 입력
           7 0 4 10 2 6 0
           0 4 0 2 0 0 0
           0 10 2 0 11 9 4
           3 2 0 11 0 0 5
           10 6 0 9 0 0 0
           0 0 0 4 5 0 0
           */

        test.make_weight_matrix(node_number);
        test.create_dist_arr(node_number);

        System.out.print("Enter the source matrix : ");  // 시작 vertex가 될 source를 입력
        int source_number = scan.nextInt();
        test.shortest_path(test.weight, source_number);

        System.out.println("\nShortest Path : ");
        for(int i = 0; i < test.distance.length; i++) {
            if(source_number-1 != i) System.out.println(source_number-1 + " -> "+ i + ", cost = " + test.distance[i]);
        }
    }
}
