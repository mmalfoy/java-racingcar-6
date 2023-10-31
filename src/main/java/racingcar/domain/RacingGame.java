package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class RacingGame {

    private List<String> resultList = new ArrayList<>();
    private List<String> winner = new ArrayList<>();

    public RacingGame() {

    }

    public void initResultList(List resultList) {
        List<String> cars = Inputs.getCars();
        for (int i = 0 ; i < cars.size() ; i++) {
            resultList.add("");
        }
    }

    public void move(List cars) {
        int randNum;
        for (int i=0; i<cars.size(); i++) {
            randNum = Randoms.pickNumberInRange(0,9);
            if(randNum >= 4) {
                resultList.set(i, resultList.get(i)+"-");
            }
        }

    }

    public void chooseWinners(List<String> resultList) {

        List<String> cars = Inputs.getCars();
        int maxLen = 0;
        for (int i=0; i<resultList.size(); i++) {
            if( resultList.get(i).length() > maxLen) {
                maxLen = resultList.get(i).length();
                winner.clear();
                winner.add(cars.get(i));
                continue;
            }
            if(resultList.get(i).length() == maxLen) {
                winner.add(cars.get(i));
                continue;
            }
        }

    }

    public void start() {
        try {
            Inputs.inputCars();
            Inputs.inputCounts();
            initResultList(resultList);
            for (int i =0; i<Inputs.getCount();i++) {
                move(Inputs.getCars());
                Outputs.resultMessage();
                Outputs.result(resultList);
            }
            chooseWinners(resultList);
            Outputs.winner(winner);
        } catch (IllegalArgumentException e) {
            throw e;
        }

    }

}
