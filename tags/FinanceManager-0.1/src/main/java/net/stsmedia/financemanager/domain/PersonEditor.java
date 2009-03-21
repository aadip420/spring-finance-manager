package net.stsmedia.financemanager.domain;

import java.beans.PropertyEditorSupport;

import net.stsmedia.financemanager.service.PersonService;

import org.springframework.beans.SimpleTypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * A editor which allows the translation between {@link String} 
 * and {@link Person}. 
 * 
 * Needs to be {@link Configurable} to allow for injection of
 * {@link Autowired} fields such as {@link PersonService}.
 * 
 * @author Stefan Schmidt
 *
 */
@Configurable
public class PersonEditor extends PropertyEditorSupport{
	
	@Autowired
	private PersonService personService;
	
	SimpleTypeConverter typeConverter = new SimpleTypeConverter();    
    
    public String getAsText() {    
        Object obj = getValue();        
        if (obj == null) {        
            return null;            
        }        
        return (String) typeConverter.convertIfNecessary(((net.stsmedia.financemanager.domain.Person) obj).getId() , String.class);        
    }    
    
    public void setAsText(String text) {    
        if (text == null || "".equals(text)) {        
            setValue(null);            
            return;            
        }        
        
        Long identifier = (Long) typeConverter.convertIfNecessary(text, Long.class);        
        if (identifier == null) {        
            setValue(null);            
            return;            
        }        
        
        setValue(personService.find(identifier));        
    }    
}
