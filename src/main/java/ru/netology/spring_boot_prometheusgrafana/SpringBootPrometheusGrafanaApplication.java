package ru.netology.spring_boot_prometheusgrafana;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringBootPrometheusGrafanaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootPrometheusGrafanaApplication.class, args);
    }


@Service
public class MemoryConsumerService {

    private final List<byte[]> memory = new ArrayList<>();

    @PostConstruct
    public void consumeMemory() {
        new Thread(() -> {
            while (true) {
                memory.add(new byte[5 * 1024 * 1024]); // 5 MB
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {}
            }
        }).start();
    }
}

}
