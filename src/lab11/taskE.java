package lab11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class taskE {
    private static final int MAX_VERTICES = 200005;
    private static int[] dsuParent = new int[MAX_VERTICES];
    private static int[] dsuRank = new int[MAX_VERTICES];
    private static List<Integer>[] adjacencyList = new ArrayList[MAX_VERTICES];
    private static List<Integer> connectedComponents = new ArrayList<>();

    private static void initializeDSU() {
        for (int i = 0; i < MAX_VERTICES; i++) {
            dsuParent[i] = i;
            dsuRank[i] = 1;
            adjacencyList[i] = new ArrayList<>();
        }
    }

    private static int findRoot(int vertex) {
        if (dsuParent[vertex] != vertex) {
            dsuParent[vertex] = findRoot(dsuParent[vertex]);
        }
        return dsuParent[vertex];
    }

    private static boolean uniteSets(int vertexA, int vertexB) {
        int rootA = findRoot(vertexA);
        int rootB = findRoot(vertexB);

        if (rootA == rootB) {
            return false;
        }

        if (dsuRank[rootA] < dsuRank[rootB]) {
            dsuParent[rootA] = rootB;
        } else if (dsuRank[rootB] < dsuRank[rootA]) {
            dsuParent[rootB] = rootA;
        } else {
            dsuParent[rootA] = rootB;
            dsuRank[rootB]++;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vertexCount = scanner.nextInt();
        int edgeCount = scanner.nextInt();
        int componentCount = 0;

        initializeDSU();

        for (int i = 0; i < edgeCount; i++) {
            int vertexU = scanner.nextInt();
            int vertexV = scanner.nextInt();
            adjacencyList[vertexU].add(vertexV);
            adjacencyList[vertexV].add(vertexU);
        }

        for (int currentVertex = vertexCount; currentVertex >= 1; currentVertex--) {
            componentCount++;
            for (int neighbor : adjacencyList[currentVertex]) {
                if (currentVertex < neighbor && findRoot(currentVertex) != findRoot(neighbor)) {
                    componentCount--;
                    uniteSets(currentVertex, neighbor);
                }
            }
            connectedComponents.add(componentCount);
        }
        Collections.reverse(connectedComponents);
        for (int i = 1; i < connectedComponents.size(); i++) {
            System.out.println(connectedComponents.get(i));
        }

        System.out.println(0);
        scanner.close();
    }
}

