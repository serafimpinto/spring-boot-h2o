package net.performetric.h2o;

import static hex.genmodel.MojoReaderBackendFactory.createReaderBackend;

import hex.genmodel.MojoModel;
import hex.genmodel.MojoReaderBackend;
import hex.genmodel.MojoReaderBackendFactory.CachingStrategy;
import hex.genmodel.easy.EasyPredictModelWrapper;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
@Configuration
public class H2OApplication {

  @Value("${h2o.mojos.titanic.path}")
  private String h2oTitanicModel;

  public static void main(String[] args) {
    SpringApplication.run(H2OApplication.class, args);
  }

  /**
   * H2O
   */
  @Bean
  public EasyPredictModelWrapper h2oTitanicModel() throws IOException {
    ClassPathResource resource = new ClassPathResource(h2oTitanicModel);
    return h2oModel(resource);
  }

  private EasyPredictModelWrapper h2oModel(ClassPathResource resource) throws IOException {
    MojoReaderBackend reader = createReaderBackend(resource.getInputStream(), CachingStrategy.MEMORY);
    EasyPredictModelWrapper.Config config = new EasyPredictModelWrapper.Config()
        .setModel(MojoModel.load(reader))
        .setConvertUnknownCategoricalLevelsToNa(true)
        .setConvertInvalidNumbersToNa(true);
    return new EasyPredictModelWrapper(config);
  }
}
