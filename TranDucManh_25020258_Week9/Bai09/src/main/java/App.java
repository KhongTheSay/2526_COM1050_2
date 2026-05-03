package TranDucManh_25020258_Week9.Bai09.src;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        String name = "lil homie";
        // Sử dụng Parameterized Logging với dấu {}
        logger.info("Xin chào {}, bắt đầu hệ thống...", name);
        
        try {
            // Giả lập logic
            int result = 10 / 0;
        } catch (Exception e) {
            logger.error("Có lỗi xảy ra: {}", e.getMessage());
        }
    }
}