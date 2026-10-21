package productservice.config;

import java.util.Map;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * Конфигурация для Кафки
 */
@Configuration
public class KafkaConfig {

    /**
     * Бин, который создает топик в кафка при запуске контекста. Топик будет иметь 3 партиции,
     * 3 реплики и минимальное количество синхронных реплик с лидером 2
     * @return
     */
    @Bean
    NewTopic createTopic() {
        return TopicBuilder.name("product-created-events-topic")
            .partitions(3)                          // Количество партиций
            .replicas(3)                             // Количество реплик
            .configs(Map.of("min.insync.replicas", "2")) // Минимальное количество синхронизированных серверов
            .build();
    }

}
