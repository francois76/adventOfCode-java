import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Day02 extends Day {

    public static void main(String[] args) {
        new Day02().run("day02.txt");
    }

    @Override
    public String part1() {

        return this.input.stream().map((n) -> {
            // System.out.println(n);
            var rs = Arrays.stream(n.split(" ")).map(Integer::parseInt).toList();

            var diff = IntStream.range(0,rs.size()-1).map(i -> rs.get(i) - rs.get(i + 1)).boxed().toList();
            if (diff.stream().allMatch(i -> i <= 3 && i >= 1) || diff.stream().allMatch(i -> i <= -1 && i >= -3)){
                return 1;
            };
            return 0;
        }).reduce(0, Integer::sum).toString();
    }

    @Override
    public String part2() {

        return this.input.stream().map((n) -> {
            System.out.println(n);
            var rs = Arrays.stream(n.split(" ")).map(Integer::parseInt).toList();

            Function<Function<Integer,Boolean>,Integer> f = (condition)->{
                var hasError = false;
                for (int i = 0; i < rs.size() - 1; i++) {
                    System.out.println("I : " + i);
                    var delta =  rs.get(i) - rs.get(i + 1);
                    System.out.println("delta : " + delta);
                    if(condition.apply(delta)) {
                        continue;
                    }
                    if(hasError) {
                        System.out.println("=>0 Double error");
                        return 0;
                    }
                    hasError=true;
                    if(i == rs.size() - 2) {
                        System.out.println("=>1 Avec dernier element en erreur");
                        return 1;
                    }
                    if (i == 0) {
                        var delta2 =  rs.get(i+1) - rs.get(i + 2);
                        System.out.println("delta2 sur premier elem : " + delta2);
                        if(condition.apply(delta2)) {
                            i++;
                            continue;
                        }
                    }
                    var delta2 =  rs.get(i) - rs.get(i + 2);
                    System.out.println("delta2 : " + delta2);
                    if(condition.apply(delta2)) {
                        i++;
                        continue;
                    }
                    else {
                        System.out.println("=>0 Double error");
                        return 0;
                    }
                }
                if (hasError) {
                    System.out.println("Avec 1 erreur : " + n);
                }
//                System.out.println("=>1");
                return 1;
            };

            Function<Integer,Boolean> condition = (delta) -> delta <= 3 && delta >= 1;
            var test1 = f.apply(condition);

            Function<Integer,Boolean> condition2 = (delta) -> delta <= -1 && delta >= -3;
            var test2 = f.apply(condition2);

            if (test1 == 1 || test2 == 1){
                return 1;
            };

            return 0;
        }).reduce(0, Integer::sum).toString();

        // 550 trop petit
        // 571 trop grand
    }
}