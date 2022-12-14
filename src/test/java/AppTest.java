import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ll.exam.article.dto.ArticleDto;
import com.ll.exam.member.Ut;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    @Test
    void 테스트_assertThat() {
        int rs = 10 + 20;
        assertThat(rs).isEqualTo(30);
    }
    @Test
    void ObjectMapper_객체에서_json() throws JsonProcessingException {
        ArticleDto articleDto = new ArticleDto(1, "제목1","내용1");
        String rs = Ut.json.toStr(articleDto,"");
        assertThat(rs).isNotBlank();
        assertThat(rs).isEqualTo("""
                {"id":1,"title":"제목1","body":"내용1"}
                """.trim());
    }

    @Test
    void ObjectMapper_json에서_객체() throws JsonProcessingException {
        ArticleDto articleDtoOrigin = new ArticleDto(1, "제목1","내용1");
        String jsonStr = Ut.json.toStr(articleDtoOrigin,"");
        ArticleDto articleDtoObj = Ut.json.toObj(jsonStr,ArticleDto.class,null);
        assertThat(articleDtoOrigin).isEqualTo(articleDtoObj);
    }


}