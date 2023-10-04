import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Edge {
        int from;
        int to;
        long weight;

        public Edge(int from, int to, long weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stringTokenizer;

    static int N;
    static int[] parents;
    static List<int[]> positionList = new ArrayList<>();
    static PriorityQueue<Edge> priorityQueue = new PriorityQueue<>((o1, o2) -> Long.compare(o1.weight, o2.weight));

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            int z = Integer.parseInt(stringTokenizer.nextToken());
            positionList.add(new int[]{i + 1, x, y, z});
        }

        Collections.sort(positionList, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        for (int i = 0; i < positionList.size() - 1; i++) {
            int[] firstPos = positionList.get(i);
            int[] secondPos = positionList.get(i + 1);

            priorityQueue.offer(new Edge(firstPos[0], secondPos[0], Math.abs(firstPos[1] - secondPos[1])));
        }


        Collections.sort(positionList, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        for (int i = 0; i < positionList.size() - 1; i++) {
            int[] firstPos = positionList.get(i);
            int[] secondPos = positionList.get(i + 1);

            priorityQueue.offer(new Edge(firstPos[0], secondPos[0], Math.abs(firstPos[2] - secondPos[2])));
        }

        Collections.sort(positionList, (o1, o2) -> Integer.compare(o1[3], o2[3]));
        for (int i = 0; i < positionList.size() - 1; i++) {
            int[] firstPos = positionList.get(i);
            int[] secondPos = positionList.get(i + 1);

            priorityQueue.offer(new Edge(firstPos[0], secondPos[0], Math.abs(firstPos[3] - secondPos[3])));
        }

        System.out.println(getResult());

    }

    private static long getResult() {
        makeSet();
        long result = 0;
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            if (findRoot(edge.from) != findRoot(edge.to)) {
                union(edge.from, edge.to);
                result += edge.weight;
            }
        }
        return result;
    }

    private static void makeSet() {
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }

    private static int findRoot(int vertex) {
        if (parents[vertex] == vertex) {
            return vertex;
        }
        return parents[vertex] = findRoot(parents[vertex]);
    }

    private static void union(int first, int second) {
        int firstRoot = findRoot(first);
        int secondRoot = findRoot(second);

        if (firstRoot != secondRoot) {
            parents[firstRoot] = secondRoot;
        }
    }
}