package junseok.snr.study.java.api.predicate;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
public class PredicateListOddFilter {

    public static void main(String[] args) {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Predicate<Integer> odd = number -> number % 2 != 0;
        List<Integer> oddNumbers = filterNumbers(numbers, odd);

        log.info(">>>>> numbers : {}", numbers);
        log.info(">>>>> oddNumbers : {}", oddNumbers);
    }

    private static List<Integer> filterNumbers(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
