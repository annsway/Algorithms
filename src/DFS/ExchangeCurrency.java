package DFS;

import java.util.*;

public class ExchangeCurrency {
/**
 * Parameters:
 * array of currency conversion rates. E.g. ['USD', 'GBP', 0.77] which means 1 USD is equal to 0.77 GBP
 * an array containing a 'from' currency and a 'to' currency
 * Given the above parameters, find the conversion rate that maps to the 'from' currency to the 'to' currency.
 * Your return value should be a number.
 *
 * Example:
 * You are given the following parameters:
 *
 * Rates: ['USD', 'JPY', 110] ['USD', 'AUD', 1.45] ['JPY', 'GBP', 0.0070]
 * To/From currency ['GBP', 'AUD']
 * Find the rate for the 'To/From' currency. In this case, the correct result is 1.89.
 * */
    public double exchange(List<List<String>> rates, List<String> query) {
        // step 1. build the graph
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (List<String> rate : rates) {
            String c1 = rate.get(0), c2 = rate.get(1);
            double r = Double.parseDouble(rate.get(2));
            if (!graph.containsKey(c1)) {
                graph.put(c1, new HashMap<>());
            }
            if (!graph.containsKey(c2)) {
                graph.put(c2, new HashMap<>());
            }
            graph.get(c1).put(c2, r);
            graph.get(c2).put(c1, 1 / r);
        }
        // step 2. evaluate query
        if (!graph.containsKey(query.get(0)) || !graph.containsKey(query.get(1))) {
            return -1;
        } else if (query.get(0).equals(query.get(1))) {
            return 1;
        }
        // step 3. backtrack
        return backtrack(graph, query.get(0), query.get(1), 1.0, new HashSet<>());
    }

    private double backtrack(Map<String, Map<String, Double>> graph,
                             String cur, String target, double product, Set<String> visited) {
        visited.add(cur);
        double res = -1;
        Map<String, Double> neighbors = graph.get(cur);

        if (neighbors.containsKey(target)) {
            res = product * neighbors.get(target);
        } else {
            for (Map.Entry<String, Double> entry : neighbors.entrySet()) {
                String next = entry.getKey();
                if (visited.contains(next)) {
                    continue;
                }
                res = backtrack(graph, next, target, entry.getValue() * product, visited);
                if (res != -1) {
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ExchangeCurrency sol = new ExchangeCurrency();
        List<List<String>> rates = new ArrayList<>();
        rates.add(new ArrayList<>());
        rates.add(new ArrayList<>());
        rates.add(new ArrayList<>());
        rates.get(0).add("USD"); rates.get(0).add("JPY");rates.get(0).add("110");
        rates.get(1).add("USD"); rates.get(1).add("AUD");rates.get(1).add("1.45");
        rates.get(2).add("JPY"); rates.get(2).add("GBP");rates.get(2).add("0.007");

        List<String> query = new ArrayList<>();
        query.add("GBP"); query.add("AUD");
        System.out.println(sol.exchange(rates, query)); // 1.89
    }
}
