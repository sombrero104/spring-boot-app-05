package sombrero.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class) // 가볍게 컨트롤러 하나만 테스
public class SampleControllerTest_webMvc {

    /**
     * 슬라이스 테스트
     * ● 레이어 별로 잘라서 테스트하고 싶을 때
     * ● @JsonTest
     * ● @WebMvcTest
     * ● @WebFluxTest
     * ● @DataJpaTest
     */

    @MockBean
    SampleService mockSampleService;

    /**
     * 일반적인 @Component들은 빈으로 등록되지 않음.
     * 컨트롤러(웹)과 관련된 빈들만 등록됨.
     * 이외의 의존성들은 끊김.
     * 그렇기 때문에 사용하는 의존성이 있다면 @MockBean으로 채워줘야 함.
     */

    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception {
        when(mockSampleService.getName()).thenReturn("xavier");

        mockMvc.perform(get("/hello"))
                .andExpect(content().string("hello xavier"));
    }
}