package junseok.snr.study.java.eight.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateWithAndWithoutNameFilter {
    public List<String> filterWithoutPredicate(String start,List<String> names) {
        final List<String> namesStartingWiths = new ArrayList<>();
        for (String name : names) {
            if (name.startsWith(start)) {
                namesStartingWiths.add(name);
            }
        }
        return namesStartingWiths;
    }

    public List<String> filterWithPredicate(String start, List<String> names) {
        Predicate<String> predicate = (name) -> name.startsWith(start);
        return names.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

}
