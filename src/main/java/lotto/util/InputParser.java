package lotto.util;

public class InputParser {
    private final String input;

    public InputParser(String input) {
        this.input = input;
    }

    public int parseInt() {
        return Integer.parseInt(input);
    }

}
