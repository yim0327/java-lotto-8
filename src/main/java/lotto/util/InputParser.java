package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {
    private final String input;

    public InputParser(String input) {
        this.input = input;
    }

    public int parseInt() {
        return Integer.parseInt(input);
    }

    public List<Integer> splitString() {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
