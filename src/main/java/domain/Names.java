package domain;

import domain.exception.DuplicatedNameException;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Names {
    private List<Name> names;

    public Names(List<String> names) {
        this.names = names.stream()
                .map(Name::new)
                .collect(Collectors.toList())
        ;

        if (isDuplicated()) {
            throw new DuplicatedNameException();
        }
    }

    private boolean isDuplicated() {
        Set<String> uniqueNames = names.stream()
                .map(Name::getName)
                .collect(Collectors.toSet())
                ;

        return !(uniqueNames.size() == names.size());
    }

    public int size() {
        return names.size();
    }
}
