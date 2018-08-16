package spring.basic.bi.imported;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AppContext.class)
public class AppcontextImport {


}
