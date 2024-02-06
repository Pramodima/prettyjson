package org.prettyjson.codec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PrettyJSONCApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PrettyJSONCApplication.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(PrettyJSONCApplication.class);
	}
	/*@Bean
	public RestTemplate restTemplate() {
		SimpleClientHttpRequestFactory rf = new SimpleClientHttpRequestFactory();
		rf.setBufferRequestBody(false);
		return new RestTemplate(rf);
	}*/
}
