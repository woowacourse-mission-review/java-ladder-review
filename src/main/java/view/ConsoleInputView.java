package view;

import domain.Height;
import domain.Name;
import domain.Names;
import domain.Results;
import domain.exception.*;
import support.StringParser;

import java.util.List;
import java.util.Scanner;

public class ConsoleInputView {
    private final Scanner scanner = new Scanner(System.in);

    public Names inputNames() {
        try {
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            String nameString = scanner.nextLine();
            List<String> inputNames = StringParser.parse(nameString);
            return new Names(inputNames);
        } catch (EmptyNameException | NameLengthExcessException | DuplicatedNameException e) {
            System.out.println(e.getMessage());
            return inputNames();
        }
    }

    public Results inputResults(int nameSize) {
        try {
            System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
            String resultString = scanner.nextLine();
            List<String> inputResults = StringParser.parse(resultString);
            return new Results(inputResults, nameSize);
        } catch (EmptyResultException | DifferentSizeFromNameException e) {
            System.out.println(e.getMessage());
            return inputResults(nameSize);
        }
    }

    public Height inputHeight() {
        try {
            System.out.println("최대 사다리 높이는 몇 개인가요?");
            String heightString = scanner.nextLine();
            return new Height(heightString);
        } catch (InvalidHeightException e) {
            System.out.println(e.getMessage());
            return inputHeight();
        }
    }

    public String inputWantedResult(Names names) {
        try {
            System.out.println("결과를 보고 싶은 사람은?");
            String wantedResult = scanner.nextLine();
            names.checkValidName(new Name(wantedResult));
            return wantedResult;
        } catch (DoesNotExistValidNameException | EmptyNameException e) {
            System.out.println(e.getMessage());
            return inputWantedResult(names);
        }
    }
}
