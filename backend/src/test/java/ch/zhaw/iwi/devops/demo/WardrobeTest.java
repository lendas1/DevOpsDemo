package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class WardrobeTest {

    @Test
    public void testWardrobeSingleElementFits() {
        Wardrobe wardrobe = new Wardrobe();
        List<List<Integer>> expectedCombinations = Arrays.asList(
            Arrays.asList(250)
        );
        assertEquals(expectedCombinations, wardrobe.findCombinations(250));
    }

    @Test
    public void testWardrobeCombinationOfTwoElements() {
        Wardrobe wardrobe = new Wardrobe();
        List<List<Integer>> expectedCombinations = Arrays.asList(
            Arrays.asList(50, 200),
            Arrays.asList(200, 50),
            Arrays.asList(100, 150),
            Arrays.asList(150, 100)
        );
        assertEquals(expectedCombinations, wardrobe.findCombinations(250));
    }

    @Test
    public void testWardrobeNoCombinationFits() {
        Wardrobe wardrobe = new Wardrobe();
        List<List<Integer>> expectedCombinations = Arrays.asList();
        assertEquals(expectedCombinations, wardrobe.findCombinations(45));
    }

    @Test
    public void testWardrobeMultipleCombinations() {
        Wardrobe wardrobe = new Wardrobe();
        List<List<Integer>> expectedCombinations = Arrays.asList(
            Arrays.asList(50, 50, 50, 50, 50),
            Arrays.asList(50, 50, 75, 75),
            Arrays.asList(50, 100, 100),
            Arrays.asList(75, 75, 100)
        );
        assertEquals(expectedCombinations, wardrobe.findCombinations(250));
    }

    @Test
    public void testWardrobeCombinationIncludes120cm() {
        Wardrobe wardrobe = new Wardrobe();
        List<List<Integer>> expectedCombinations = Arrays.asList(
            Arrays.asList(120, 50, 50, 30),
            Arrays.asList(120, 100, 30)
        );
        assertEquals(expectedCombinations, wardrobe.findCombinations(250));
    }

    @Test
    public void testWardrobeOnlyOneElement() {
        Wardrobe wardrobe = new Wardrobe();
        List<List<Integer>> expectedCombinations = Arrays.asList(
            Arrays.asList(120),
            Arrays.asList(75),
            Arrays.asList(50)
        );
        assertEquals(expectedCombinations, wardrobe.findCombinations(120));
    }

    @Test
    public void testWardrobeCombinationExactFit() {
        Wardrobe wardrobe = new Wardrobe();
        List<List<Integer>> expectedCombinations = Arrays.asList(
            Arrays.asList(50, 50, 100, 50)
        );
        assertEquals(expectedCombinations, wardrobe.findCombinations(250));
    }

    @Test
    public void testWardrobeCombinationNoOverlap() {
        Wardrobe wardrobe = new Wardrobe();
        List<List<Integer>> expectedCombinations = Arrays.asList(
            Arrays.asList(50, 100, 100)
        );
        assertEquals(expectedCombinations, wardrobe.findCombinations(250));
    }

    @Test
    public void testWardrobeCombinationMinimizeElements() {
        Wardrobe wardrobe = new Wardrobe();
        List<List<Integer>> expectedCombinations = Arrays.asList(
            Arrays.asList(120, 100, 30)
        );
        assertEquals(expectedCombinations, wardrobe.findCombinations(250));
    }

    @Test
    public void testWardrobeCombinationIncludeAllSizes() {
        Wardrobe wardrobe = new Wardrobe();
        List<List<Integer>> expectedCombinations = Arrays.asList(
            Arrays.asList(50, 75, 100, 25)
        );
        assertEquals(expectedCombinations, wardrobe.findCombinations(250));
    }

    @Test
    public void testFindCheapestCombination() {
        Wardrobe wardrobe = new Wardrobe();
        List<List<Integer>> combinations = Arrays.asList(
            Arrays.asList(50, 50, 50, 50, 50),
            Arrays.asList(50, 50, 75, 75),
            Arrays.asList(75, 75, 100),
            Arrays.asList(100, 50, 100),
            Arrays.asList(100, 100, 50)
        );
        Map<Integer, Integer> prices = Map.of(
            50, 59,
            75, 62,
            100, 90,
            120, 111
        );
        assertEquals(Arrays.asList(50, 50, 50, 100), wardrobe.findCheapestCombination(combinations, prices));
    }
}
