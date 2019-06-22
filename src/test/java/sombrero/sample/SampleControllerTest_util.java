package sombrero.sample;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class) // 가볍게 컨트롤러 하나만 테스
public class SampleControllerTest_util {

    /**
     * 테스트 유틸
     * 엇? 스프링 부트 테스트 끝난줄 알았는데...
     * ● OutputCapture
     * ● TestPropertyValues
     * ● TestRestTemplate
     * ● ConfigFileApplicationContextInitializer
     */

    @MockBean
    SampleService mockSampleService;

    @Autowired
    MockMvc mockMvc;

    @Rule
    public OutputCapture outputCapture = new OutputCapture();
    // JUnit꺼라서 이렇게 등록..
    // 로그를 비롯해서 콘솔에 찍히는 것을 모두 캡쳐함.

    @Test
    public void hello() throws Exception {
        when(mockSampleService.getName()).thenReturn("xavier");

        mockMvc.perform(get("/hello"))
                .andExpect(content().string("hello xavier"));

        assertThat(outputCapture.toString())
                .contains("holoman")
                .contains("skip");
    }

}