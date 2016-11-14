import java.util.*;

/**
 * Created by jo930_000 on 2016-11-09.
 */
public class Dijkstra {
    int[][] weight;
    int[] distance;
    MinPQ priorityQueue = new MinPQ();

    public void make_weight_matrix(int num) {
        weight = new int[num][num];
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < num; i++) {
            String input = scan.nextLine();
            String[] arr;
            arr = input.split(" ");
            for(int j = 0; j < num; j++) {
                weight[i][j] = Integer.parseInt(arr[j]);
                if(i != j && weight[i][j] == 0) weight[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    public void create_dist_arr(int num) {
        distance = new int[num];
        for(int i = 0; i < num; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
    }

    public void shortest_path(int[][] weight, int vertex) {
        distance[vertex-1] = 0;

        for(int i = 0; i < distance.length; i++) {
            if(i != vertex-1) distance[i] = Integer.MAX_VALUE;
            priorityQueue.insert(priorityQueue.heap, new Edge(i, distance[i]));
        }

        while(priorityQueue.heap[1].index != -1) {  // Queue.isEmpty
            Edge vert =new Edge(priorityQueue.min(priorityQueue.heap).index, priorityQueue.min(priorityQueue.heap).distance);
            priorityQueue.extract_min(priorityQueue.heap);

            for(int i = 1; i <= weight.length; i++) {
                if(weight[vert.index][i-1] != Integer.MAX_VALUE && weight[vert.index][i-1] != 0) {
                    if(distance[i-1] > distance[vert.index] + weight[vert.index][i-1]) {
                        distance[i-1] = distance[vert.index] + weight[vert.index][i-1];
                        priorityQueue.heap[i].distance = distance[i-1];
                    }
                }
            }
            priorityQueue.build_min_heap(priorityQueue.heap);
        }
    }

}
