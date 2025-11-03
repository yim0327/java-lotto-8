package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputParser {
    private final String input;

    public InputParser(String input) {
        this.input = input;
    }

    public int parseInt() {
        return Integer.parseInt(input);
    }

    public List<Integer> splitString() {
        List<Integer> numbers = new ArrayList<>();

        Arrays.stream(input.split(","))
                .map(String::trim)
                .forEach(s -> numbers.add(parseInt()));

        return numbers;
    }

}
