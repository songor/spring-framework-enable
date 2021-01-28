package server;

import org.springframework.stereotype.Component;

/**
 * @author chensongyu
 */
@Component
public class FtpServer implements Server {
  @Override
  public void start() {
    System.out.println("启动 FTP 服务器");
  }

  @Override
  public void stop() {
    System.out.println("关闭 FTP 服务器");
  }
}
