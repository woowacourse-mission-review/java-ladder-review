# java-ladder
요구사항: https://techcourse.woowahan.com/s/1aKh56So/ls/CrsGkpWG

## Sketch
사다리 타기의 기본 개념은 다음과 같다.
- 왼쪽에 다리가 놓여있고, 오른쪽에는 놓여있지 않은 경우 왼쪽으로 진행한다.
- 오른쪽에 다리가 놓여있고, 왼쪽에는 놓여있지 않은 경우 오른쪽으로 진행한다.
- 양 쪽 모두에 다리가 놓여있는 경우는 발생하지 않는다.
- 다리가 어느쪽에도 놓여있지 않은 경우엔 수평방향으로 움직이지 않는다.
- 어느 경우이든 상관없이 수직 방향으로는 아래쪽으로 진행한다.

요점은, 사다리 타기는 플레이어 현재 위치의 왼쪽, 오른쪽에 다리가 놓여있는 지 여부만 중요하다.

따라서, 왼쪽 및 오른쪽에 다리가 놓여있는 지 여부를 담은 Point 객체와 이를 기반으로 자신의 위치를 갱신하는 Player 객체가 중요하다.

## To-do-list
- 입출력
    - [ ] 사다리 타기 게임에 참여할 사람들의 이름을 콘솔로 입력받는다. (e.g., "moomin, conas, comac")
    - [ ] 사다리 높이를 자연수로 입력받는다.
    - [ ] 사다리 타기 결과를 콘솔로 출력한다.
- 사다리
    - Direction enum
        - [x] 왼쪽은 -1, 직진은 0, 오른쪽은 1 의 값을 갖는 열거형
    - Point 객체
        - [x] 왼쪽으로 움직여야 하는 지, 오른쪽으로 움직여야 하는 지 알려준다.
        - [x] [제약조건] 왼쪽, 오른쪽 모두 다리가 놓여있는 경우는 발생하지 않아야 한다.
    - NumOfPlayers 객체
        - [x] 이 게임에 참여하는 플레이어의 수를 나타낸다.
        - [x] [제약조건] 2 이상, 100 이하의 자연수여야한다.
    - Line 객체
        - [x] 위치를 입력받았을 때, 해당 위치의 다음 Direction 을 반환한다.
        - [x] [제약조건] Point 객체들의 일관성이 유지되어야한다. 즉, 이전 포인트의 오른쪽 값과 다음 포인트의 왼쪽 값은 같아야한다. (정보의 중복)
        - [x] [제약조건] Line 의 첫 번째 포인트의 왼쪽 값과 마지막 포인트의 오른쪽 값은 false 여야한다.
        - [x] [제약조건] Line 내의 포인트 수는 플레이어 수와 같아야한다.
    - LadderHeight 객체
        - [x] 사다리의 높이를 나타낸다.
        - [x] [제약조건] 1 이상, 1000 이하의 자연수여야한다.
    - Ladder 객체
        - ~~플레이어들을 입력받아 사다리타기를 진행하고, 플레이어들의 위치를 갱신한다.~~
            - 사다리가 플레이어들에 의존하는 것이 안 좋다고 생각. (사다리가 더 고수준)
            - 플레이어의 변경에 사다리가 영향받을 수도!
            - 따라서 사다리가 플레이어의 위치를 갱신하는 게 아니라 플레이어가 움직여야할 Direction
            들을 반환하는 쪽으로 생각을 바꿈
        - [x] 사다리 타기를 한 단계 진행해 Direction 의 리스트를 반환한다.
        - [x] [제약조건] 사다리의 높이와 라인의 수가 일치해야한다.
- 사용자
    - Player 객체
        - [ ] 이름과 위치를 갖는 사용자 객체이다.
    - Name 객체
        - [x] [제약조건] 사용자의 이름은 3 글자 이상, 20 글자 이하여야 한다. (공백 포함)
        - [x] [제약조건] 사용자의 이름은 영문과 스페이스 바 로만 이루어져야한다.
    - Position 객체
        - [ ] 사용자의 사다리 내 수평 현재 위치를 나타낸다.
        - [ ] [제약조건] 사용자 수를 넘는 위치를 가질 수 없다.
        
## Refactoring
- Direction.of 메서드 내에서 left, right validation 이 이루어져야 하는가 아니면 
Point 객체에서 이루어져야 하는가

## 리뷰어에게
- 정보를 가지고 있는 객체에 로직을 담으려 노력했습니다. 데이터와 로직이 분리될수록 절차지향적인 
코드로 변모한다고 생각하기 때문입니다.
- 지난 미션에서 오류 검증이 너무 없다는 리뷰를 받아, 사다리 미션에는 다양한 오류 검증과 테스트를 
추가했습니다. 
    - 원시값을 포장하는 것 외에 별다른 책임을 갖지 않는 객체들은 validation test
를 통해 TDD 할 수 있다는 것을 깨달았습니다.
- Static 메서드/클래스의 사용은 테스트를 힘들게 만들고 컴파일 타임에 의존관계를 확정시키기 때문에
최소화 했습니다.
- 예외 상황에 대하여 매번 Exception 클래스를 생성하지 않고 자바가 제공하는 것을 사용했습니다.