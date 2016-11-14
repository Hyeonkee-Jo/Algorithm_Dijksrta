/**
 * Created by jo930_000 on 2016-11-09.
 */
public class MinPQ {
    Edge[] heap = new Edge[65];
    int init_size = 0;
    int heap_size;

    public void create_heap() {
        for(int i = 0; i < 65; i++) {
            heap[i] = new Edge();
        }
    }

    // implement MAX-HEAPIFY(A, i)
    public void min_heapify(Edge[] heap_node, int index) {
        int min;
        int left_child = 2*index;
        int right_child = 2*index+1;

        if (left_child <= heap_size && heap_node[left_child].distance < heap_node[index].distance){
            min = left_child;
        }
        else {
            min = index;
        }

        if (right_child <= heap_size && heap_node[right_child].distance < heap_node[min].distance) {
            min = right_child;
        }

        if (min != index) {
            Edge temp;
            temp = heap_node[index];
            heap_node[index] = heap_node[min];
            heap_node[min] = temp;
            this.min_heapify(heap_node, min);
        }
    }

    // implement BUILD-MIN-HEAP(A)
    public void build_min_heap(Edge[] heap_node) {
        heap_size = init_size;

        for(int i = heap_size/2; i >= 1; i--) {
            this.min_heapify(heap_node, i);
        }
    }

    // a. implement insert(S, x)
    public void insert(Edge[] heap_node, Edge x) {
        init_size++;
        heap_node[init_size] = x;
        this.build_min_heap(heap_node);
    }

    // b. implement min(S)
    public Edge min(Edge[] heap_node) {
        return heap_node[1];
    }

    // c. implement extract_min(S)
    public void extract_min(Edge[] heap_node) {
        heap_node[1].setDistance(heap_node[init_size].getDistance());
        heap_node[1].setIndex(heap_node[init_size].getIndex());
        heap_node[init_size].setDistance(Integer.MAX_VALUE);
        heap_node[init_size].setIndex(-1);
        init_size--;
        this.build_min_heap(heap_node);
    }

}
