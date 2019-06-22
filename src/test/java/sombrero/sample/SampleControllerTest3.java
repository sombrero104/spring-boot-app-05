package sombrero.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleControllerTest3 {

    /**
     * WebTestClient
     * WebFlux에 추가된 Rest Client 중 하나.
     * 기존 클라이언트는 Synchronous (동기식) -> 요청을 하나 보내고 그 요청이 끝나야 다음 요청을 보낼 수 있음.
     * WebTestClient는 Asynchronous (비동기식) -> 요청을 보낸 후 응답이 오면 콜백 이벤트가 옴.
     *  => 실제 웹 클라이언트와 비스무리하게 테스트할 수 있음.
     */
    @Autowired
    WebTestClient webTestClient;

    @MockBean
    SampleService mockSampleService;

    @Test
    public void hello() throws Exception {
        when(mockSampleService.getName()).thenReturn("xavier");

        webTestClient.get().uri("/hello").exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("hello xavier");
    }

    /**
     * @SpringBootTest
     *  => @SpringBootApplication 이 붙은 클래스를 찾아서
     *  그 클래스부터 모든 테스트를 다 함. (통합 테스트)
     *  모든 빈을 다 가져와서 mock인 것은 mock 빈으로 교체.
     *  모든 빈이 다 등록됨. 수많은 빈들이..
     */
}