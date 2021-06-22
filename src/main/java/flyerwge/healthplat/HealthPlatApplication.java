package flyerwge.healthplat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("flyerwge.healthplat.mapper")
public class HealthPlatApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthPlatApplication.class, args);
    }

}
