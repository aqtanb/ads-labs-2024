package lab12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class taskC {
    private static final int MAX_NODES = 410;
    private static List<Integer>[] roadGraph = new ArrayList[MAX_NODES];
    private static List<Integer>[] airGraph = new ArrayList[MAX_NODES];
    private static int[][] roadMatrix = new int[MAX_NODES][MAX_NODES];

    static {
        for (int i = 0; i < MAX_NODES; i++) {
            roadGraph[i] = new ArrayList<>();
            airGraph[i] = new ArrayList<>();
        }
    }

    private static void findShortestPaths(int[] distances, boolean[] visited, List<Integer>[] graph) {
        Queue<Integer> nodesQueue = new LinkedList<>();
        nodesQueue.add(0);
        visited[0] = true;

        while (!nodesQueue.isEmpty()) {
            int currentNode = nodesQueue.poll();

            for (int neighbor : graph[currentNode]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    nodesQueue.add(neighbor);
                    distances[neighbor] = distances[currentNode] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int totalNodes = Integer.parseInt(firstLine[0]);
        int totalEdges = Integer.parseInt(firstLine[1]);

        for (int i = 0; i < totalEdges; i++) {
            String[] edge = br.readLine().split(" ");
            int fromNode = Integer.parseInt(edge[0]) - 1;
            int toNode = Integer.parseInt(edge[1]) - 1;
            roadGraph[fromNode].add(toNode);
            roadGraph[toNode].add(fromNode);
            roadMatrix[fromNode][toNode] = roadMatrix[toNode][fromNode] = 1;
        }

        for (int i = 0; i < totalNodes; i++) {
            for (int j = 0; j < totalNodes; j++) {
                if (roadMatrix[i][j] == 0 && i != j) {
                    airGraph[i].add(j);
                    airGraph[j].add(i);
                }
            }
        }

        int[] roadDistances = new int[totalNodes];
        int[] airDistances = new int[totalNodes];
        boolean[] roadVisited = new boolean[totalNodes];
        boolean[] airVisited = new boolean[totalNodes];

        findShortestPaths(roadDistances, roadVisited, roadGraph);
        findShortestPaths(airDistances, airVisited, airGraph);

        if (!roadVisited[totalNodes - 1] || !airVisited[totalNodes - 1]) {
            System.out.println(-1);
        } else {
            System.out.println(Math.max(roadDistances[totalNodes - 1], airDistances[totalNodes - 1]));
        }
    }
}

