package baseball.controller;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class NumberValidator {
    private static final int BASEBALL_GAME_NUMBER_LENGTH = 3;
    private static final String WRONG_LENGTH_INPUT_MESSAGE = "세 자리까지만 입력 가능합니다.";
    private static final String WRONG_RANGE_INPUT_MESSAGE = "1 ~ 9 사이의 숫자만 입력 가능합니다.";
    private static final String DUPLICATE_NUMBER_INPUT_MESSAGE = "서로 다른 세 자리의 숫자만 입력 가능합니다.";

    public void toValidateData(String inputNumber) {
        if (!isTreeLetters(inputNumber)) {
            throw new IllegalArgumentException(WRONG_LENGTH_INPUT_MESSAGE);
        } else if (!isNumericSting(inputNumber)) {
            throw new IllegalArgumentException(WRONG_RANGE_INPUT_MESSAGE);
        } else if (!isDifferentCharacters(inputNumber)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_INPUT_MESSAGE);
        }
    }

    public boolean isTreeLetters(String inputNumber) {
        return inputNumber.length() == BASEBALL_GAME_NUMBER_LENGTH;
    }

    public boolean isNumericSting(String inputNumber) {
        return inputNumber.chars().allMatch(Character::isDigit);
    }

    public boolean isDifferentCharacters(String inputNumber) {
        String[] numbers = inputNumber.split("");
        Set<String> setNumbers = Arrays.stream(numbers).collect(Collectors.toSet());

        return setNumbers.size() == BASEBALL_GAME_NUMBER_LENGTH;
    }
}
