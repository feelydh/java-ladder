package ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> ladder;

    public Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public int ladderRiding(int userIndex) {
        int userPosition = userIndex;
        for(Line line : ladder){
            Point point = line.getPoints().get(userPosition);
            userPosition = point.move();
        }
        return userPosition;
    }

    public static Ladder of(int userCount, String ladderHeight){
        List<Line> ladder = new ArrayList <>();
        for (int i = 0; i < validationNumberFormat(ladderHeight); i++) {
            ladder.add(createLine(userCount));
        }
        return new Ladder(ladder);
    }

    private static int validationNumberFormat(String ladderHeight) {
        try{
            return Integer.parseInt(ladderHeight);
        } catch (NumberFormatException ne){
            throw new NumberFormatException("최대 사다리 높이는 숫자만 입력 할 수 있습니다.");
        }
    }

    private static Line createLine(int userCount) {
        return Line.lineSet(userCount);
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(this.ladder);
    }

}
