package com.dylan.aic.page;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/**
  * @ClassName: CleanupMybatisPaginatorListener
  * @Description: TODO
  * @author Dylan
  * @date 2016年1月14日
  *
  */
public class CleanupMybatisPaginatorListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        OffsetLimitInterceptor.Pool.shutdownNow();
    }
}
