import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03 extends Day {

    public static void main(String[] args) {
        new Day03().run("day03.txt");
    }

    @Override
    public String part1() {
//        var line = this.input.get(0);
//        var regex = "mul\\(\\d{1,3},\\d{1,3}\\)";

//        // Create a Pattern object
//        Pattern r = Pattern.compile(regex);

//        // Now create matcher object.
//        Matcher m = r.matcher(line);
//        var sum = 0;
//        while (m.find()) {
//            System.out.println("Found value: " + m.group(0));
//            String match = m.group(0);
//            var digits = (match.substring(match.indexOf("(") + 1, match.length() -1)).split(",");
//            var digit1 = Integer.parseInt(digits[0]);
//            var digit2 = Integer.parseInt(digits[1]);

//            System.out.println("Digits : " + digit1 + " " + digit2);
//            sum += digit1 * digit2;
//        }

//        return "" + getSum(m);;
        return "";
    }

    @Override
    public String part2() {
        var line = this.input.get(0);
        var dosRegex = "(^|do\\(\\))(.*?)(don't\\(\\)|$)";
        var regex = "mul\\(\\d{1,3},\\d{1,3}\\)";

        // Create a Pattern object
        Pattern r = Pattern.compile(regex);
        Pattern dosPattern = Pattern.compile(dosRegex);

        // Now create matcher object
        Matcher dosMatcher = dosPattern.matcher(line);
        int acc = 0;
        while(dosMatcher.find()) {
            String dos = dosMatcher.group(2);
            Matcher m = r.matcher(dos);
            acc += getSum(m);
        }


        return "" + acc;
    }

    private int getSum(Matcher m) {
        var sum = 0;
        while (m.find()) {
            System.out.println("Found value: " + m.group(0));
            String match = m.group(0);
            var digits = (match.substring(match.indexOf("(") + 1, match.length() -1)).split(",");
            var digit1 = Integer.parseInt(digits[0]);
            var digit2 = Integer.parseInt(digits[1]);

            System.out.println("Digits : " + digit1 + " " + digit2);
            sum += digit1 * digit2;
        }
        return sum;
    }
}