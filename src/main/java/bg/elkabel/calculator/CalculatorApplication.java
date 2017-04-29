package bg.elkabel.calculator;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculatorApplication.class, args);
	}
	
	@Bean
	ModelMapper getModelMapper(){
		return new ModelMapper();
	}
	
	@Bean
	Gson getGson(){
		return new Gson();
	}
}
