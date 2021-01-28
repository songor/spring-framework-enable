package server;

/**
 * @author chensongyu
 */
public interface Server {
  /**
   * 启动服务器
   */
  void start();

  /**
   * 关闭服务器
   */
  void stop();

  enum Type {
    /**
     * HTTP 服务器
     */
    HTTP,
    /**
     * FTP 服务器
     */
    FTP
  }
}
