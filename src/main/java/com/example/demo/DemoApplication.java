package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

// import com.example.demo.SwaggerResVO;

import org.springframework.web.bind.annotation.*;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import com.example.demo.Utils.Result;
import com.example.demo.Utils.ResultUtil;
import com.example.demo.User.User;
import com.example.demo.User.UserRepository;


@RestController
// @RestAssuredRestDocumentationConfigurer
// @EnableAutoConfiguration
@SpringBootApplication
@Api(tags = {"用户管理"}, description = "用户管理")
public class DemoApplication {
	@Autowired // This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private UserRepository userRepository;
	// private RequestSpecification spec;

	// @Before
	// public void setUp() {
	// 	// this.spec = new RequestSpecBuilder().addFilter(
	// 	// 		documentationConfiguration(this.restDocumentation)) 
	// 	// 		.build();
	// }
	private static final String template = "Hello, %s!";
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(1, String.format(template, name));
	}

	@RequestMapping(value = "/upload", method = POST)
	String home() {
		return "Hello World!";
	}

	@RequestMapping("/home2")
	Greeting home2() {
		return new Greeting(1, "jiao ba ba");
		// return "Hello home2!";
	}

	@GetMapping(path="/add") // Map ONLY POST Requests
	public @ResponseBody String addNewUser (@RequestParam String name
			, @RequestParam String email) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		User n = new User();
		n.setName(name);
		n.setEmail(email);
		userRepository.save(n);
		return "Saved";
	}
	@GetMapping(path="/api/demo/user/list")

	//	public @ResponseBody

	Result<Iterable<User[]>> getAllUsers() {
		Iterable<User> data = userRepository.findAll();
		return ResultUtil.success(data);
		// return ResultUtil.error(401, "xxxx");
	}
	@GetMapping(path="/user/info")
	@ApiOperation(value = "用户列表")
	Result<User> getUserInfo (@RequestParam Integer id) {
		return ResultUtil.success(userRepository.findByUid(id));
	}

	@PostMapping(path="/edit/user")
	Result<User> editUser (@RequestBody User u) {
		System.out.println("name:"+ u.getName());
		System.out.println("id:"+ u.getId());
		userRepository.updateName(u.getId(), u.getName());
//		return "ok";
		return ResultUtil.success(u);
	}
	// @RestAssuredRestDocumentation
	// public static void documentationConfiguration() {

	// }
	// public static void main(String[] args) {
	// 	// SpringApplication.run(DemoApplication.class, args);
	// }

}
