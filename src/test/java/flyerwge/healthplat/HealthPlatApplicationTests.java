package flyerwge.healthplat;

import flyerwge.healthplat.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HealthPlatApplicationTests {


    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
    System.out.println("user:"+userMapper);
    }

}
