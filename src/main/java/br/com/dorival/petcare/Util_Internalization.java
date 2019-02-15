package br.com.dorival.petcare;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;

//@EnableAutoConfiguration
//@ComponentScan
@Configuration
public class Util_Internalization { //implements WebMvcConfigurer { //extends WebMvcConfigurerAdapter  
	
	//Locale locale = LocaleContextHolder.getLocale();
	//Locale ptBr = new Locale("pt", "BR"); //Locale para o Brasil
	//Locale enUS = new Locale("en", "US"); //Locale para o EUA

	//@Autowired
	//PetCare_Internalization(LocaleContextHolder context) { //ResourceBundleMessageSource messageSource
	//	//PetCare_Internalization.messageSource = messageSource;
	//	PetCare_Internalization.locale = LocaleContextHolder.getLocale();
	//	System.out.println("*** Locale: " + locale.toString() + " ***");
	//	//PetCare_Internalization.locale = resolveLocale;	
	//}


	@Autowired
    private MessageSource messageSource;
	
	public String Translate(String key) {
		return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
	}
	
	public String Translate(String key, Locale locale) {
		return messageSource.getMessage(key, null, locale);
	}
	
	// -- JAVA---------------------------------------------------------------------
	//public String Translate2(String key, Locale locale) {
	//	ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
	//	return bundle.getString(key);
	//}
	// ----------------------------------------------------------------------------
	
/*
	@Bean //i18n
	public LocaleResolver localeResolver() {
		// SessionLocaleResolver locResolver = new SessionLocaleResolver();
		AcceptHeaderLocaleResolver locResolver = new AcceptHeaderLocaleResolver();
		locResolver.setDefaultLocale(Locale.US);
		return locResolver;
	}
	
	
	
	
	
	// ----------------------------------------------------------------------------
	//@Configuration
	public class PetCare_CustomLocaleResolver extends AcceptHeaderLocaleResolver implements WebMvcConfigurer { //
	
	 List<Locale> LOCALES = Arrays.asList(
         new Locale("en"),
         new Locale("pt"));
     
    
     @Override
   public Locale resolveLocale(HttpServletRequest request) {
      String headerLang = request.getHeader("Accept-Language");
      return headerLang == null || headerLang.isEmpty()
            ? Locale.getDefault()
            : Locale.lookup(Locale.LanguageRange.parse(headerLang), LOCALES);
            
           //System.out.println("#################################################");
   }

   
   @Bean
   public ResourceBundleMessageSource messageSource() {
      ResourceBundleMessageSource rs = new ResourceBundleMessageSource();
      rs.setBasename("messages");
      //rs.setDefaultEncoding("UTF-8");
      rs.setUseCodeAsDefaultMessage(true);
      
      System.out.println("**** ResourceBundleMessageSource ***");
      return rs;
   }
         
*/
	
}
