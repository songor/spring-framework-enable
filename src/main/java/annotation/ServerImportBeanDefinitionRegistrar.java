package annotation;

import java.util.Map;
import java.util.stream.Stream;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import server.FtpServer;
import server.HttpServer;
import server.Server;
import server.Server.Type;

/**
 * @author chensongyu
 */
public class ServerImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
  @Override
  public void registerBeanDefinitions(AnnotationMetadata annotationMetadata,
      BeanDefinitionRegistry beanDefinitionRegistry) {
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

    Stream.of(imports).map(BeanDefinitionBuilder::genericBeanDefinition)
        .map(BeanDefinitionBuilder::getBeanDefinition).forEach(
        beanDefinition -> BeanDefinitionReaderUtils
            .registerWithGeneratedName(beanDefinition, beanDefinitionRegistry));
  }
}
