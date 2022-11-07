package baseball.controller;

import baseball.model.GameNumber;
import baseball.view.InputView;

public class GameController {
    GameNumber gameNumber = new GameNumber();
    ComputerController computerController = new ComputerController();
    InputView inputView = new InputView();

    public void gameProcess() {
        computerController.startGame(gameNumber);

        gameNumber.setInputString(inputView.enterGameNumber());
        computerController.compareNumbers(gameNumber);
        computerController.provideHint();

        if (computerController.isThreeStrike()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다!");
        }
    }
}
