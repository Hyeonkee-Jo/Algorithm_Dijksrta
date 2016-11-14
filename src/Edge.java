/**
 * Created by jo930_000 on 2016-11-09.
 */
public class Edge {
    int index;
    int distance;

    public Edge() {
        this.index = 0;
        this.distance = Integer.MAX_VALUE;
    }

    public Edge(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getDistance() {
        return this.distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

}
