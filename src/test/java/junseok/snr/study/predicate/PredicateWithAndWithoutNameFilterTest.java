package junseok.snr.study.predicate;

import junseok.snr.study.java.eight.predicate.PredicateWithAndWithoutNameFilter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PredicateWithAndWithoutNameFilterTest {
    private static final String DEFAULT_DISPLAY_NAME = "List [{1}]에서 문자열 [{0}]로 시작하는 것만 필터링했을 때 결과는 List [{2}]가 되어야 한다.";
    private static PredicateWithAndWithoutNameFilter filter;

    @BeforeAll
    static void setUp() {
        filter = new PredicateWithAndWithoutNameFilter();
    }

    @MethodSource("provideDataForEqualityTest")
    @ParameterizedTest(name = "Predicate를 사용하지 않고 " + DEFAULT_DISPLAY_NAME)
    void filterWithoutPredicateTest(String start, List<String> names, List<String> expectedNames) {
        final List<String> filteredNames = filter.filterWithoutPredicate(start, names);

        assertThat(filteredNames).isEqualTo(expectedNames);
    }

    @MethodSource("provideDataForEqualityTest")
    @ParameterizedTest(name = "Predicate를 사용해서 " + DEFAULT_DISPLAY_NAME)
    void filterWithPredicateTest(String start, List<String> names, List<String> expectedNames) {
        final List<String> filteredNames = filter.filterWithPredicate(start, names);

        assertThat(filteredNames).isEqualTo(expectedNames);
    }

    static Stream<Arguments> provideDataForEqualityTest() {
        return Stream.of(
                Arguments.of("S",
                        Arrays.asList("Semi", "Hole", "Jane", "South", "Sonic"),
                        Arrays.asList("Semi", "South", "Sonic"))
        );
    }

}