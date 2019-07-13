package ladder.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class PointTest {

    @Test
    @DisplayName("왼쪽 첫번째 포인터 생성 테스트")
    void first() {
        Point point = Point.first(true);
        StatusOfPoint statusOfPoint = point.getStatusOfPoint();
        assertThat(statusOfPoint.isLeft()).isEqualTo(FALSE);
        assertThat(statusOfPoint.isRight()).isEqualTo(TRUE);
    }

    @Test
    @DisplayName("오른쪽 마지막 포인터 생성 테스트")
    void last() {
        Point point = Point.first(true);
        point = point.last();
        StatusOfPoint statusOfPoint = point.getStatusOfPoint();
        assertThat(statusOfPoint.isLeft()).isEqualTo(TRUE);
        assertThat(statusOfPoint.isRight()).isEqualTo(FALSE);
    }

    @Test
    @DisplayName("오른쪽으로 이동 테스트")
    void rignht_move() {
        Point point = new Point(0, new StatusOfPoint(FALSE, TRUE));
        assertThat(point.move()).isEqualTo(1);
    }

    @Test
    @DisplayName("왼쪽으로 이동 테스트")
    void left_move() {
        Point point = new Point(1, new StatusOfPoint(TRUE, FALSE));
        assertThat(point.move()).isEqualTo(0);
    }

    @Test
    @DisplayName("이동 내용 없음 테스트")
    void pass_move() {
        Point point = new Point(1, new StatusOfPoint(FALSE, FALSE));
        assertThat(point.move()).isEqualTo(1);
    }

    @Test
    @DisplayName("더이상 왼쪽으로 이동 할 수 없을 때 오류 테스트")
    void left_not_move() {
        Point point = new Point(0, new StatusOfPoint(TRUE, FALSE));
        Assertions.assertThatThrownBy(() -> point.move())
                  .isInstanceOf(IllegalStateException.class)
                  .hasMessage("더 이상 왼쪽으로 이동 할 수 없습니다.");
    }

}
