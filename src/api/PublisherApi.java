package api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Publisher;
import model.PublisherRepository;

@RestController
@RequestMapping("api")
public class PublisherApi {
	PublisherRepository repository = new PublisherRepository();
	
	@RequestMapping(value="/publisher",method=RequestMethod.GET)
	public List<Publisher> index(){
		return repository.getPublisher();
	}
	@RequestMapping("/publisher/{id}")
	public Publisher index2(@PathVariable("id")int id) {
		return repository.getPublisher(id);
	}
	@RequestMapping( value="/publisher",method=RequestMethod.POST)
	public int add(Publisher obj) {
		
		return repository.add(obj);
	}
	
	@DeleteMapping("/publisher")
	public int delete(int id) {
		return repository.delete(id);
	}
	@PutMapping("/publisher")
	public int edit(Publisher obj) {
		return repository.edit(obj);
	}
}
