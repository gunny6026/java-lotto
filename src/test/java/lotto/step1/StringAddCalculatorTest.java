package lotto.step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StringAddCalculatorTest {

    @Test
    @DisplayName("빈 문자열이나 null 일 때 0 반환하는 테스트")
    void calculator_null() {
        String text = " ";
        StringAddCalculator stringAddCalculator = new StringAddCalculator(text);
        int result = stringAddCalculator.splitAndSum();
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환하는 테스트 ")
    void calculator_onlyNumber() {
        String text = "2";
        StringAddCalculator stringAddCalculator = new StringAddCalculator(text);
        int result = stringAddCalculator.splitAndSum();
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("컴마(,)로 구분된 숫자들의 합을 반환하는 테스트")
    void calculator_commaDelimiter() {
        String text = "2,5";
        StringAddCalculator stringAddCalculator = new StringAddCalculator(text);
        int result = stringAddCalculator.splitAndSum();
        assertThat(result).isEqualTo(7);
    }

    @Test
    @DisplayName("컴마(,) 콜론(:) 으로 구분된 숫자들의 합을 반환하는 테스트")
    void calculator_commaAndColonDelimiter() {
        String text = "2,5:14";
        StringAddCalculator stringAddCalculator = new StringAddCalculator(text);
        int result = stringAddCalculator.splitAndSum();
        assertThat(result).isEqualTo(21);
    }

    @Test
    @DisplayName("커스텀 구분자로 구분된 숫자들의 합을 반환하는 테스트")
    void calculator_customDelimiter() {
        String text = "//;\n1;2;3";
        StringAddCalculator stringAddCalculator = new StringAddCalculator(text);
        int result = stringAddCalculator.splitAndSum();
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자로 구분된 숫자들의 합을 반환하는 테스트 2")
    void calculator_customDelimiter2() {
        String text = "//;\n1;2,3:4;2";
        StringAddCalculator stringAddCalculator = new StringAddCalculator(text);
        int result = stringAddCalculator.splitAndSum();
        assertThat(result).isEqualTo(12);
    }

    @Test
    @DisplayName("커스텀 구분자로 구분된 숫자들의 합을 반환하는 테스트 3")
    void calculator_customDelimiter3() {
        String text = "//,\n3,4,2";
        StringAddCalculator stringAddCalculator = new StringAddCalculator(text);
        int result = stringAddCalculator.splitAndSum();
        assertThat(result).isEqualTo(9);
    }

    @Test
    @DisplayName("커스텀 구분자로 구분된 숫자들의 합을 반환하는 테스트 4")
    void calculator_customDelimiter4() {
        String text = "///\n3/4/2";
        StringAddCalculator stringAddCalculator = new StringAddCalculator(text);
        int result = stringAddCalculator.splitAndSum();
        assertThat(result).isEqualTo(9);
    }
}