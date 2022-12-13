package kodlama.io.northwind;

import kodlama.io.northwind.core.exception.BusinessException;
import kodlama.io.northwind.core.exception.InternalException;
import kodlama.io.northwind.core.results.ErrorDataResult;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

// RestControllerAdvice => Bu class içinde ExceptionHandling yapacağım demek
@SpringBootApplication
@RestControllerAdvice
public class NorthwindApplication {

	public static void main(String[] args) {
		SpringApplication.run(NorthwindApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}

	@Bean
	public ResourceBundleMessageSource bundleMessageSource(){
		// Veritabanı bağlantısı..
		// Dosyadan çekme işlemi..
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		// Konfigurasyonlar
		messageSource.setBasename("messages");

		return messageSource;
	}

	// Kullanıcıdan dil tercihini header alanından al..
	// Accept-Language
	@Bean
	public LocaleResolver localeResolver(){
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
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
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorDataResult<Object> handleInternalException(InternalException exception){
		ErrorDataResult<Object> internalErrors = new ErrorDataResult<>(exception.getMessage(),"INTERNAL EXCEPTİON");
		return internalErrors;
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleBusinessException(BusinessException exception) {
		ErrorDataResult<Object> businessErrors = new ErrorDataResult<>(exception.getMessage(), "BUSINESS EXCEPTION");
		return businessErrors;
	}
}
