package junseok.snr.study.predicate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PredicateWithAndWithoutNameFilterTest {

    private PredicateWithAndWithoutNameFilter filter;
    private List<String> names = new ArrayList<>();
    private List<String> expectedNames = new ArrayList<>();

    @BeforeEach
    void setUp() {
        filter = new PredicateWithAndWithoutNameFilter();
        names = Arrays.asList("Semi", "Hole", "Jane", "South", "Sonic");
        expectedNames = Arrays.asList("Semi", "South", "Sonic");
    }

    @DisplayName("Predicate를 사용하지 않고, List에서 파라미터로 받은 문자열로 시작하는 문자열 목록 필터링 테스트")
    @Test
    void filterWithoutPredicateTest() {
        final List<String> filteredNames = filter.filterWithoutPredicate("S", names);

        assertThat(filteredNames).isEqualTo(expectedNames);
    }

    @DisplayName("Predicate를 사용하지 않고, List에서 파라미터로 받은 문자열로 시작하는 문자열 목록 필터링 테스트")
    @Test
    void filterWithPredicateTest() {
        final List<String> filteredNames = filter.filterWithPredicate("S", names);

        assertThat(filteredNames).isEqualTo(expectedNames);
    }

}