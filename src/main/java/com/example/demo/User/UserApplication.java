package com.example.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import com.example.demo.Utils.Result;
import com.example.demo.Utils.ResultUtil;
import javax.servlet.http.HttpServletRequest;

@RestController
// @SpringBootApplication
public class UserApplication {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ContractRepository contractRepository;

	@PostMapping(path="/api/create/user")
	public Result<User> createUser(@RequestBody CreateUserVO body) {

		User u = new User();
		u.setName(body.name);
		u.setEmail(body.email);
		userRepository.save(u);

		return ResultUtil.success(u);
	}

	@PostMapping(path="/api/create/contact")
	public Result<Contract> createContact(@RequestBody CreateUserVO body) {

		Contract u = new Contract();
		u.setName(body.name);
		// u.setEmail(body.email);
		contractRepository.save(u);

		return ResultUtil.success(u);
	}

	@GetMapping(path="/api/get/ip")
	public String getIp(HttpServletRequest request) throws UnknownHostException {
		// String ipAddress = request.getHeader("x-forwarded-for");
		String ipAddress = request.getHeader("WL-Proxy-Client-IP");
		String ipAddress2 = request.getHeader("Proxy-Client-IP");
		String ipAddress3 = request.getHeader("x-forwarded-for");
		String ipAddress4 = request.getRemoteAddr();
		InetAddress inet = null;
		inet = InetAddress.getLocalHost();
		String ipAddress5 = inet.getHostAddress();
		
		System.out.print(ipAddress);
		// System.out.println(data.name);
		return ipAddress + ipAddress5 + ipAddress2 + ipAddress3 + ipAddress4;
		// Contract u = new Contract();
		// u.setName(data.name);
		// // u.setEmail(data.email);
		// contractRepository.save(u);

		// return ResultUtil.success(u);
	}


	@GetMapping(path="/api/get/user")
	Result<String> getUser(@RequestParam String id) {
		return ResultUtil.success(id);
	}
}
