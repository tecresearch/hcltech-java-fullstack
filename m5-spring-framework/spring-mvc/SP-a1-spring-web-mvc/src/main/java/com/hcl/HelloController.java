
/**
 * Spring MVC Annotations Documentation
This documentation provides an overview of key Spring MVC annotations used for handling web requests: @RequestParam, @PathVariable, and @RequestBody. Each annotation serves a specific purpose in the context of web applications, particularly in RESTful services.

1. @RequestParam
The @RequestParam annotation is used to bind web request parameters to method parameters in your controller. It is particularly useful for extracting query parameters from the URL.

Key Features:
Parameter Binding:
Allows you to specify which request parameter should be mapped to a method parameter.
Example:

@GetMapping("/send")
public String sendMessage(@RequestParam("sms") String sms) {
    return "Message sent: " + sms;
}
Required Attribute:
By default, the parameter is required. If the specified parameter is not present in the request, Spring will throw an exception.
Optional Parameter: You can set required = false to make it optional:

@GetMapping("/send")
public String sendMessage(@RequestParam(value = "sms", required = false) String sms) {
    return sms != null ? "Message sent: " + sms : "No message provided.";
}
Default Value:
You can provide a default value that will be used if the parameter is not present:

@GetMapping("/send")
public String sendMessage(@RequestParam(value = "sms", defaultValue = "default message") String sms) {
    return "Message sent: " + sms;
}
Type Conversion:
Spring automatically converts the request parameter to the appropriate type based on the method parameter type. For example, if the method parameter is an int, Spring will convert the string value to an integer.

2. @PathVariable
The @PathVariable annotation is used to extract values from the URI path. It allows you to capture dynamic values from the URL, making it essential for RESTful web services.

Key Features:
Purpose:
Used to extract values from the URI path, enabling dynamic routing based on URL segments.

Usage:
Typically used in RESTful web services where the URL contains variable parts.
Example:

@GetMapping("/users/{id}")
public String getUserById(@PathVariable String id) {
    return "User ID: " + id;
}
Request:
A GET request to /users/123 will return User ID: 123.

3. @RequestBody
The @RequestBody annotation is used to bind the HTTP request body to a Java object. It is commonly used for POST and PUT requests where the client sends data in the body of the request.

Key Features:
Purpose:
Binds the HTTP request body to a Java object, making it ideal for handling complex data structures like JSON or XML.

Usage:
Commonly used in scenarios where the client sends data in the request body.
Example:

@PostMapping("/users")
public String createUser(@RequestBody User user) {
    return "User created: " + user.getName();
}
Request:
A POST request with JSON body {"name":"John", "age":30} to /users will create a user and return User created: John.

Conclusion
These annotations are essential for building RESTful APIs in Spring MVC, allowing for flexible and powerful request handling. By understanding and utilizing @RequestParam, @PathVariable, and @RequestBody, developers can create robust web applications that effectively manage user input and data exchange.


 
 */

package com.hcl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@GetMapping("/hello")
	public ModelAndView getInputView() {
		System.out.println("In getInput");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("input.jsp");
		return modelAndView;
	}

	@GetMapping("sayhello")
	public ModelAndView getOutputView(@RequestParam("sms") String sms) {
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("output.jsp");
	    modelAndView.addObject("name", sms);
	    return modelAndView;
	}
}
