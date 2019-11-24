package domain;

import domain.exception.DoesNotExistValidNameException;
import domain.exception.DuplicatedNameException;

import java.util.Collections;
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
                .collect(Collectors.toSet());

        return !(uniqueNames.size() == names.size());
    }

    public void checkValidName(Name name) {
        if (!name.equals(new Name("all")) && !names.contains(name)) {
            throw new DoesNotExistValidNameException();
        }
    }

    public int size() {
        return names.size();
    }

    public Name get(int index) {
        return names.get(index);
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(names);
    }

    // TODO: 2019/11/24 인덴트 줄이기
    public int getIndex(Name name) {
        for (int index = 0; index < size(); ++index) {
            if (get(index).equals(name)) {
                return index;
            }
        }

        throw new DoesNotExistValidNameException();
    }
}
