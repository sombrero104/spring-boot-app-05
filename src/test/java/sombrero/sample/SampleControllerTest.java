package sombrero.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class SampleControllerTest {

    /**
     * @SpringBootTest
     * ● @RunWith(SpringRunner.class)랑 같이 써야 함.
     * ● 빈 설정 파일은 설정을 안해주나? 알아서 찾습니다. (@SpringBootApplication)
     * ● webEnvironment
     * ○ MOCK: mock servlet environment. 내장 톰캣 구동 안 함.
     * ○ RANDON_PORT, DEFINED_PORT: 내장 톰캣 사용 함.
     * ○ NONE: 서블릿 환경 제공 안 함.
     */

    /**
     * @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
     * 서블릿 컨테이너를 띄우지 않고 서블릿을 Mocking을 한 것이 뜸.
     * DispatcherServlet이 만들어지긴 함.
     * DispatcherServlet에 요청을 보내는 것과 비슷하게 실험을 할 수 있도록 함.
     * 이 때 Mock up이 된 서블릿에 interaction(상호작용)을 하려면
     * MockMVC라는 클라이언트를 꼭 사용해야 함.
     * MockMVC라는 클라이언트를 사용하려면 @AutoConfigureMockMvc 설정 사용.
     */

    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello sombrero"))
                .andDo(print());
    }

    /**
     * MockHttpServletRequest:
     *       HTTP Method = GET
     *       Request URI = /hello
     *        Parameters = {}
     *           Headers = []
     *              Body = null
     *     Session Attrs = {}
     *
     * Handler:
     *              Type = sombrero.sample.SampleController
     *            Method = public java.lang.String sombrero.sample.SampleController.hello()
     *
     * Async:
     *     Async started = false
     *      Async result = null
     *
     * Resolved Exception:
     *              Type = null
     *
     * ModelAndView:
     *         View name = null
     *              View = null
     *             Model = null
     *
     * FlashMap:
     *        Attributes = null
     *
     * MockHttpServletResponse:
     *            Status = 200
     *     Error message = null
     *           Headers = [Content-Type:"text/plain;charset=UTF-8", Content-Length:"14"]
     *      Content type = text/plain;charset=UTF-8
     *              Body = hello sombrero
     *     Forwarded URL = null
     *    Redirected URL = null
     *           Cookies = []
     */

}