package com.project383.springboot.controller;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project383.springboot.model.User;
import com.project383.springboot.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("users")
	public List<User> getUsers() {
		return this.userRepository.findAll();
	}
	
	@PostMapping("users")
	public User createUser(@RequestBody User user) throws InterruptedException {
		user.setResult(999);
		user.setTime("None");
		int nValue = user.getnValue();
		String response = "-1";
		try {
			RPCClient fibonacciRpc = new RPCClient();
			String i_str = Integer.toString(nValue);
			System.out.println(" [x] Requesting fib(" + i_str + ")");
			response = fibonacciRpc.call(i_str);
			System.out.println(" [.] Got '" + response + "'");
		}  catch (IOException | TimeoutException e) {
		      e.printStackTrace();
		}  

		String spl[] = response.split("/");
		int receviedN = Integer.parseInt(spl[0]);
		String receivedTime = spl[1] + " μs";
		
		user.setResult(receviedN);
		user.setTime(receivedTime);
		
		return userRepository.save(user);
	}
}
