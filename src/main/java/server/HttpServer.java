package server;

import org.springframework.stereotype.Component;

/**
 * @author chensongyu
 */
@Component
public class HttpServer implements Server {
  @Override
  public void start() {
    System.out.println("启动 HTTP 服务器");
  }

  @Override
  public void stop() {
    System.out.println("关闭 HTTP 服务器");
  }
}
