package bootstrap;

import annotation.EnableServer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import server.Server;
import server.Server.Type;

/**
 * @author chensongyu
 */
@Configuration
@EnableServer(type = Type.HTTP)
public class EnableServerBootstrap {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    context.register(EnableServerBootstrap.class);
    context.refresh();
    Server server = context.getBean(Server.class);
    server.start();
    server.stop();
  }
}
