package ch.zhaw.iwi.devops.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Wardrobe {

    public List<List<Integer>> findCombinations(int totalLength) {
        int[] sizes = {50, 75, 100, 120};
        List<List<Integer>> result = new ArrayList<>();
        findCombinationsHelper(new ArrayList<>(), 0, totalLength, sizes, result);
        return result;
    }

    private void findCombinationsHelper(List<Integer> current, int currentSum, int target, int[] sizes, List<List<Integer>> result) {
        if (currentSum == target) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (currentSum > target) {
            return;
        }
        for (int size : sizes) {
            current.add(size);
            findCombinationsHelper(current, currentSum + size, target, sizes, result);
            current.remove(current.size() - 1);
        }
    }

    public List<Integer> findCheapestCombination(List<List<Integer>> combinations, Map<Integer, Integer> prices) {
        int minCost = Integer.MAX_VALUE;
        List<Integer> cheapestCombination = null;

        for (List<Integer> combination : combinations) {
            int cost = 0;
            for (int size : combination) {
                cost += prices.get(size);
            }
            if (cost < minCost) {
                minCost = cost;
                cheapestCombination = combination;
            }
        }

        return cheapestCombination;
    }
}
