package net.stsmedia.financemanager.web.mvc;

import net.stsmedia.financemanager.domain.Person;
import net.stsmedia.financemanager.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This is a Controller for the Person domain object. It 
 * demonstrates the use of the new Spring 3.0 REST support.
 * 
 * @author Stefan Schmidt
 * 
 */
@Controller
@RequestMapping("/person/**")
public class PersonController {

	@Autowired
	private PersonService personService;

	@RequestMapping(value = "person/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") Long id, ModelMap modelMap) {
		Assert.notNull(id, "Identifier must be provided.");
		modelMap.addAttribute("person", personService.find(id));
		return "person/show";
	}	

	@RequestMapping(value = "person", method = RequestMethod.GET)
	public String list(ModelMap modelMap) {
		modelMap.addAttribute("people", personService.findAll());
		return "person/list";
	}

	@RequestMapping(value = "person/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id) {
		Assert.notNull(id, "Identifier must be provided.");
		personService.remove(personService.find(id));
		return "redirect:/person";
	}

	@RequestMapping(value = "person/form", method = RequestMethod.GET)
	public String form(ModelMap modelMap) {
		modelMap.addAttribute("person", new Person());
		return "person/create";
	}

	@RequestMapping(value = "person", method = RequestMethod.POST)
	public String create(@ModelAttribute("person") Person person) {
		Assert.notNull(person, "Person must be provided.");
		personService.persist(person);
		return "redirect:/person/" + person.getId();
	}

	@RequestMapping(value = "person/{id}/form", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") Long id, ModelMap modelMap) {
		Assert.notNull(id, "Identifier must be provided.");
		modelMap.addAttribute("person", personService.find(id));
		return "person/update";
	}

	@RequestMapping(method = RequestMethod.PUT)
	public String update(@ModelAttribute("person") Person person) {
		Assert.notNull(person, "Person must be provided.");
		personService.merge(person);
		return "redirect:/person/" + person.getId();
	}	
}
