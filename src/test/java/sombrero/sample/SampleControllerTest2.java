package sombrero.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleControllerTest2 {

    /**
     * @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
     * 를 사용하게 되면 실제 내장 톰캣에 요청을 보내서 응답을 받음.
     */

    @Autowired
    TestRestTemplate testRestTemplate;

    /**
     * 컨트롤러까지만 테스트하고 서비스는 테스트하고 싶지 않을 경우
     * 아래처럼 만들면
     * 애플리케이션에서 만든 SampleService를 여기에서 만든 mockSampleService로 교체함.
     * 그럼 여기에서 컨트롤러는 mockSampleService를 사용하게 됨.
     */
    @MockBean
    SampleService mockSampleService;

    @Test
    public void hello() throws Exception {
        /*String result = testRestTemplate.getForObject("/hello", String.class);
        assertThat(result).isEqualTo("hello sombrero");*/

        when(mockSampleService.getName()).thenReturn("xavier");

        String result = testRestTemplate.getForObject("/hello", String.class);
        assertThat(result).isEqualTo("hello xavier");
    }

}