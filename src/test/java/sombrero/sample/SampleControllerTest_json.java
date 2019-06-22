package sombrero.sample;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@JsonTest
public class SampleControllerTest_json {

    /*@Autowired
    JacksonTester<Sample> jacksonTester;*/

    /**
     * 슬라이스 테스트
     * ● 레이어 별로 잘라서 테스트하고 싶을 때
     * ● @JsonTest
     * ● @WebMvcTest
     * ● @WebFluxTest
     * ● @DataJpaTest
     */

}