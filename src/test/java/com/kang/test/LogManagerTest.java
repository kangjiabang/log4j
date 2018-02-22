package com.kang.test;

import com.kang.log4j.core.Logger;
import com.kang.manager.LogManager;
import org.junit.Test;

/**
 * @Author：zeqi
 * @Date: Created in 21:28 8/1/18.
 * @Description:
 */
public class LogManagerTest {

    @Test
    public  void testLogManagerInit() {

        LogManager manager = new LogManager();
        Logger logger = manager.getLogger("root");

        logger.info("hello logger");
    }
}
