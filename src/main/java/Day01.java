import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day01 extends Day {

    public static void main(String[] args) {
        new Day01().run("day01.txt");
    }

    @Override
    public String part1() {
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        this.input.forEach(k -> {
            listA.add(Integer.parseInt(k.split("   ")[0]));
            listB.add(Integer.parseInt(k.split("   ")[1]));
        });
        Collections.sort(listA);
        Collections.sort(listB);

        var result = IntStream.range(0, listA.size()).boxed().map(k -> {
            return listA.get(k) - listB.get(k);
        }).map(Math::abs)
                .reduce(0, Integer::sum);

        return "" + result;
    }

    @Override
    public String part2() {
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        this.input.forEach(k -> {
            listA.add(Integer.parseInt(k.split("   ")[0]));
            listB.add(Integer.parseInt(k.split("   ")[1]));
        });
        var mapB = listB.stream()
                .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));
        // System.out.println(mapB);
        var result = listA.stream().map(k -> {
            if (mapB.get(k) != null) {
                return k * mapB.get(k).intValue();
            } else {
                return 0;
            }
        }).reduce(0, Integer::sum);
        return "" + result;
    }

}