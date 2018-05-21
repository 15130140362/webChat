package grapecity.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * Created by hello on 2018/5/20.
 */
@Configuration
public class Scanner {
    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        System.out.println("启动");
        return new ServerEndpointExporter();
    }

}
