package com.StockMarket.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.StockMarket.Entity.User;
import com.StockMarket.Exception.StockMarketExceptionHandler;
import com.StockMarket.Service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String welcome() {
		return "index";
	}

	@GetMapping("/signup")
	public ModelAndView signup() {
		ModelAndView model = new ModelAndView();
		model.setViewName("Registration");
		return model;
	}

	@RequestMapping("registerUser")
	public ResponseEntity<String> registerUser(@RequestParam String username, @RequestParam String password,
			@RequestParam String email, @RequestParam long number, @RequestParam String userType) {
		ResponseEntity<String> response = null;
		// ModelAndView mv=new ModelAndView();
		User user = null;
		user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setMobileNumber(number);
		user.setUserType(userType);
		boolean status = userService.adduserRegistration(user);
		String stringStatus = null;
		if (status == true) {
			stringStatus = "User Registered";
			response = new ResponseEntity<String>(stringStatus, HttpStatus.OK);
		} else {
			stringStatus = "Unsuccessful Registration";
			response = new ResponseEntity<String>(stringStatus, HttpStatus.NOT_MODIFIED);

		}
		return response;

		// if (userService.adduserRegistration(user))
		// {
		// System.out.println("User Added...");
		// }
		// return mv;
	}

	@RequestMapping(value = "login")
	@ResponseBody
	public User userLogin(@RequestParam("username") String userName, @RequestParam("password") String password,
			HttpSession httpsession) throws StockMarketExceptionHandler {
		System.out.println("username-->" + userName);
		System.out.println("password-->" + password);
		RestTemplate rest= new RestTemplate();
	//	rest.exchange(url, method, requestEntity, responseType)
		boolean status = userService.checkForVerifiedUser(userName, password);
		System.out.println(status + "555555");
		Boolean loginstatus = false;
		User fetchUser1 = new User();
		if (status) { // user is present
			try {
				loginstatus = userService.login(userName, password);
				System.out.println(loginstatus + "<---login status");
				if (loginstatus) {
					System.out.println("login true");
					User fetchUser = (User)userService.fetchUser(userName, password);
					fetchUser1 = fetchUser;
					System.out.println("FetchUser-------->" + fetchUser);
					httpsession.setAttribute("loginId", fetchUser.getUserId());
					return fetchUser;
				} else {
					System.out.println("User Is Not Login");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {

			fetchUser1 = null;
		}
		return fetchUser1;
	}
	/*
	 * @RequestMapping(value="login") public ResponseEntity<User>
	 * userLogin(@RequestParam("username") String userName,
	 * 
	 * @RequestParam("password") String password, HttpSession httpsession)
	 * throws StockMarketExceptionHandler { // ModelAndView mv=new
	 * ModelAndView(); ResponseEntity<User> response = null;
	 * System.out.println("username-->" + userName);
	 * System.out.println("password-->" + password);
	 * 
	 * boolean status = userService.checkForVerifiedUser(userName, password);
	 * System.out.println(status + "555555"); Boolean loginstatus = false; User
	 * fetchUser = null; if (status) { try { loginstatus =
	 * userService.login(userName, password); System.out.println(loginstatus +
	 * "<---login staus");
	 * 
	 * if (loginstatus) { System.out.println("login true"); fetchUser =
	 * userService.fetchUser(userName, password);
	 * System.out.println("FetchUser-------->" + fetchUser);
	 * httpsession.setAttribute("loginId", fetchUser.getUserId());
	 * 
	 * // mv.addObject("User",fetchUser); // mv.setViewName("addCompany"); if
	 * (fetchUser.getUserType().equals("admin")) { System.out.println(
	 * "admin here..."); response = new ResponseEntity<User>(fetchUser,
	 * HttpStatus.OK);
	 * 
	 * 
	 * } else response = new ResponseEntity<User>(fetchUser, HttpStatus.OK);
	 * 
	 * } } catch (Exception e) { // mv.addObject("loginfailed",
	 * "too soon first login properly"); // mv.setViewName("Welcome");
	 * e.printStackTrace(); }
	 * 
	 * } else {
	 * 
	 * 
	 * fetchUser = null; response = new ResponseEntity<User>(fetchUser,
	 * HttpStatus.CONFLICT); // mv.addObject("verification",
	 * "verification failed"); // // mv.setViewName("Welcome"); }
	 * 
	 * } return response; }
	 */
}
