package in.teca.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;

@Configuration
@ComponentScan("in.tca.beans")
//@ComponentScan(basePackage = {"in.tca.beans","in.tca.users"})
public class AnnotationJavaConfig {

	@Bean("gsonObj")
	public Gson createGsonObj() {
		return new Gson();
	}
}
