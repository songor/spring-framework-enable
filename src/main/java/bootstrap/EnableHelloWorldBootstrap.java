package bootstrap;

import annotation.EnableHelloWorld;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author chensongyu
 */
@EnableHelloWorld
@Configuration
public class EnableHelloWorldBootstrap {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    context.register(EnableHelloWorldBootstrap.class);
    context.refresh();
    String helloWorld = context.getBean("helloWorld", String.class);
    System.out.println(helloWorld);
    context.close();
  }
}
