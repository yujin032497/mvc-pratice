package org.example;

import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class WebApplicationServer {

    private static final Logger log = LoggerFactory.getLogger(WebApplicationServer.class);

    public static void main(String[] args) throws Exception {

        String webAppDirLocation = "webapps/"; // webapps로 경로 설정 => 빌드된 파일이 있음
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080); // Tomcat으로 8080 연결

        tomcat.addWebapp("/", new File(webAppDirLocation).getAbsolutePath());
        log.info("configuring app with basedir: {}", new File("./" + webAppDirLocation).getAbsoluteFile());

        tomcat.start();
        tomcat.getServer().await();

    }
}
