package pl.kamsoft.nfz.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.playerony.libraryV2.exception.DatabaseException;
import com.playerony.libraryV2.exception.InputException;
import com.playerony.libraryV2.model.User;

import pl.kamsoft.nfz.service.RoleService;
import pl.kamsoft.nfz.service.UserService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("/test")
	public void test() {
		System.out.println("work");
	}
	
	@GetMapping("/all")
	@ResponseStatus(HttpStatus.OK)
	public List<User> selectUsers() throws DatabaseException{
		return userService.selectUsers();
	}
	
	@PostMapping(value="/add", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void saveUser(@RequestBody User user) throws DatabaseException, InputException{
		System.out.println(user.getUsername());
		
		//userService.saveUser(user);
	}
}
