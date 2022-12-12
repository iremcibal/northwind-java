package kodlama.io.northwind;

import kodlama.io.northwind.core.exception.BusinessException;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class NorthwindApplication {

	public static void main(String[] args) {
		SpringApplication.run(NorthwindApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Object handleValidationException(MethodArgumentNotValidException exception){
		Map<String,String> errors = new HashMap<>();

		for(FieldError fieldError : exception.getBindingResult().getFieldErrors()){
			errors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}

		return errors;
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleBusinessException(BusinessException exception){
		return exception.getMessage();
	}
}
