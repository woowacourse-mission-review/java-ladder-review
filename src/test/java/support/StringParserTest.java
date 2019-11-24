package support;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringParserTest {

    @Test
    @DisplayName("입력받은 이름 문자열을 쉼표(,) 기준으로 나눈 후 리스트로 반환한다.")
    void create_string_name_list() {
        String input = "pobi,honux,crong,jk";
        List<String> inputs = StringParser.parse(input);

        assertThat(inputs.get(0)).isEqualTo("pobi");
        assertThat(inputs.get(1)).isEqualTo("honux");
        assertThat(inputs.get(2)).isEqualTo("crong");
        assertThat(inputs.get(3)).isEqualTo("jk");
    }

    @Test
    @DisplayName("입력받은 결과 문자열을 쉼표(,) 기준으로 나눈 후 리스트로 반환한다.")
    void create_string_result_list() {
        String input = "꽝,5000,꽝,3000";
        List<String> inputs = StringParser.parse(input);

        assertThat(inputs.get(0)).isEqualTo("꽝");
        assertThat(inputs.get(1)).isEqualTo("5000");
        assertThat(inputs.get(2)).isEqualTo("꽝");
        assertThat(inputs.get(3)).isEqualTo("3000");
    }

    @Test
    @DisplayName("입력받은 문자열 중간에 빈 문자열이 있는 경우 빈 문자열이 리스트에 포함된다.")
    void create_include_empty_string() {
        String input = "pobi,honux,,jk";
        List<String> inputs = StringParser.parse(input);

        assertThat(inputs.get(0)).isEqualTo("pobi");
        assertThat(inputs.get(1)).isEqualTo("honux");
        assertThat(inputs.get(2)).isEqualTo("");
        assertThat(inputs.get(3)).isEqualTo("jk");
    }

    @Test
    @DisplayName("입력받은 문자열 맨 앞과 끝에 빈 문자열이 있는 경우 빈 문자열이 리스트에 포함되지 않는다.")
    void create_include_empty_string_at_first_and_final_position() {
        String input = ",honux,crong,";
        List<String> inputs = StringParser.parse(input);

        assertThat(inputs.get(1)).isEqualTo("honux");
        assertThat(inputs.get(2)).isEqualTo("crong");
    }
}
