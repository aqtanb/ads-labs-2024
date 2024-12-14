package bonus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Cycles {

    // Создаем конструктор для данных с жсон
    static class JSONData {
        String fromBank;
        String fromAccount;
        String toBank;
        String toAccount;
        String str;

        public JSONData(String[] fields) {
            this.fromBank = fields[1];
            this.fromAccount = fields[2];
            this.toBank = fields[3];
            this.toAccount = fields[4];
            this.str = String.join(",", fields);
        }
    }

    // загружаем жсон
    static Map<String, List<JSONData>> loadJSON() throws IOException {
        Map<String, List<JSONData>> hm = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader("C:/gradleapp/ADS/src/bonus/HI-Small_Trans.csv"));
        String line;

        // пропускаем названия столбов
        br.readLine();

        while ((line = br.readLine()) != null) {
            String[] fields = line.split(",");
            JSONData transaction = new JSONData(fields);

            // берем банк_аккаунт как ключ чтобы потом находить циклы
            String sender = transaction.fromBank + "_" + transaction.fromAccount;
            hm.computeIfAbsent(sender, k -> new ArrayList<>()).add(transaction);
        }
        return hm;
    }



    static void bfs(Map<String, List<JSONData>> hm, String startNode) {
        Queue<List<JSONData>> queue = new LinkedList<>();
        // чтобы один нод не посещать постоянно
        Set<String> visited = new HashSet<>();
        // чтобы edges не повторялись и дупликатов не было
        Set<String> processedTransactions = new HashSet<>();

        queue.add(new ArrayList<>());

        while (!queue.isEmpty()) {
            List<JSONData> path = queue.poll();

            String currentNode = path.isEmpty() ? startNode : path.get(path.size() - 1).toBank + "_" + path.get(path.size() - 1).toAccount;

            if (currentNode.equals(startNode) && path.size() > 1) {
                print(path);
                continue;
            }

            if (path.size() > 5) {
                continue;
            }

            // обработка всех транзакций нода
            List<JSONData> neighbors = hm.get(currentNode);
            if (neighbors != null) {
                for (JSONData transaction : neighbors) {
                    String nextNode = transaction.toBank + "_" + transaction.toAccount;
                    String transactionDetails = transaction.str;

                    // можно вернуться на посещенный нод ток если формируется цикл
                    if ((!visited.contains(nextNode) || nextNode.equals(startNode))
                            && !processedTransactions.contains(transactionDetails)) {
                        List<JSONData> newPath = new ArrayList<>(path);
                        newPath.add(transaction);
                        queue.add(newPath);
                        processedTransactions.add(transactionDetails);
                    }
                }
            }

            visited.add(currentNode);
        }
    }




    public static void main(String[] args) throws IOException {
        Map<String, List<JSONData>> hm = loadJSON();
        for (String startNode : hm.keySet()) {
            bfs(hm, startNode);
        }
    }

    static void print(List<JSONData> cycle) {
        System.out.println("BEGIN LAUNDERING ATTEMPT - CYCLE: Max " + cycle.size() + " hops");
        for (JSONData transaction : cycle) {
            System.out.println(transaction.str);
        }
        System.out.println("END LAUNDERING ATTEMPT - CYCLE");
    }
}