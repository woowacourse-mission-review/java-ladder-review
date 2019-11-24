import domain.Height;
import domain.Ladder;
import domain.Names;
import domain.Results;
import domain.strategy.RandomLineCreateStrategy;
import view.ConsoleInputView;
import view.ConsoleOutputView;

public class LadderGame {
    public static void main(String[] args) {
        ConsoleInputView inputView = new ConsoleInputView();

        Names names = inputView.inputNames();
        Results results = inputView.inputResults(names.size());
        Height height = inputView.inputHeight();
        Ladder ladder = new Ladder(height, names.size() - 1, new RandomLineCreateStrategy());

        ConsoleOutputView outputView = new ConsoleOutputView(ladder, names, results);
        outputView.drawLadder();

        String wantedResult = inputView.inputWantedResult(names);
        do {
            outputView.outputResult(wantedResult);
            wantedResult = inputView.inputWantedResult(names);
        } while(!wantedResult.equals("all"));
        outputView.outputResult(wantedResult);
    }
}
