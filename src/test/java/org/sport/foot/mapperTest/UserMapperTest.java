package org.sport.foot.mapperTest;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserMapperTest {

    //Скачать плагин divBlue который генерит тесты,
    // как откатывается транзакция после тестов

    private static final Logger log = LogManager.getLogger(UserMapperTest.class);

    @Test
    public void test(){

        log.info("Здаров");
        log.debug("debug");
        log.trace("trace");
    }

}
