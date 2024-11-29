
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public abstract class Day {
    protected List<String> input;

    public abstract String part1();

    public abstract String part2();

    public void run(String file) {
        try {
            this.input = Files.readAllLines(Paths.get("src/main/resources/" + file));
        } catch (Exception e) {
            System.err.println("failed to read input file");
            return;
        }
        System.out.println("Part 1: " + part1());
        System.out.println("Part 2: " + part2());
    }
}