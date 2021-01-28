package annotation;

import java.util.Map;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import server.FtpServer;
import server.HttpServer;
import server.Server;
import server.Server.Type;

/**
 * @author chensongyu
 */
public class ServerImportSelector implements ImportSelector {
  @Override
  public String[] selectImports(AnnotationMetadata annotationMetadata) {
    Map<String, Object> annotationAttributes = annotationMetadata
        .getAnnotationAttributes(EnableServer.class.getName());
    Server.Type type = (Type) annotationAttributes.get("type");
    String[] imports;
    switch (type) {
      case HTTP:
        imports = new String[]{HttpServer.class.getName()};
        break;
      case FTP:
        imports = new String[]{FtpServer.class.getName()};
        break;
      default:
        throw new IllegalArgumentException();
    }
    return imports;
  }
}
