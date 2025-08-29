package com.hackerrank.validator.controller;

import com.hackerrank.validator.model.Employee;
import com.hackerrank.validator.repository.EmployeeRepository;
import com.hackerrank.validator.validation.EmployeeValidator;
import com.hackerrank.validator.validation.FieldValidationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepository repository;

    @RequestMapping(value = "/employee", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> validateBody(@RequestBody Employee employee) throws BindException {
        EmployeeValidator validator = new EmployeeValidator();

        WebDataBinder binder = new WebDataBinder(employee);
        binder.setValidator(validator);
        BindingResult result = binder.getBindingResult();

        if(result.hasErrors()){
            List<FieldValidationMessage> error = result.getAllErrors().stream().map(err -> new FieldValidationMessage(err.getDefaultMessage())).collect(Collectors.toList());
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
            throw new BindException(result);
        }

        // throws BindException if there are binding/validation
        // errors, exceptions are handled using @ControllerAdvice EmployeeValidationErrorHandler
        binder.validate();
        binder.close();

        //If no validation errors save and return status
        repository.save(employee);

        return new ResponseEntity(HttpStatus.OK);
    }
}


/**
 * package com.hackerrank.validator.controller;
 *
 * import com.hackerrank.validator.model.Employee;
 * import com.hackerrank.validator.repository.EmployeeRepository;
 * import com.hackerrank.validator.validation.EmployeeValidator;
 * import com.hackerrank.validator.validation.FieldValidationMessage;
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.http.MediaType;
 * import org.springframework.http.ResponseEntity;
 * import org.springframework.validation.BindException;
 * import org.springframework.validation.BindingResult;
 * import org.springframework.web.bind.WebDataBinder;
 * import org.springframework.web.bind.annotation.*;
 *
 * import java.util.List;
 * import java.util.stream.Collectors;
 *
 * @RestController
 * public class EmployeeController {
 *     @Autowired
 *     EmployeeRepository repository;
 *
 *     @RequestMapping(value = "/employee", method = RequestMethod.POST,
 *             consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
 *     public ResponseEntity<?> validateBody(@RequestBody Employee employee) throws BindException {
 *         // Validator instance
 *         EmployeeValidator validator = new EmployeeValidator();
 *
 *         // Create WebDataBinder instance for validation
 *         WebDataBinder binder = new WebDataBinder(employee);
 *         binder.setValidator(validator);
 *
 *         // Validate the employee object
 *         BindingResult result = binder.getBindingResult();
 *         binder.validate(); // Perform validation
 *
 *         // Check for validation errors
 *         if (result.hasErrors()) {
 *             List<FieldValidationMessage> errors = result.getAllErrors().stream()
 *                     .map(err -> new FieldValidationMessage(err.getDefaultMessage()))
 *                     .collect(Collectors.toList());
 *             throw new BindException(result);  // Throw BindException here if there are errors
 *         }
 *
 *         // If no validation errors, save the employee
 *         repository.save(employee);
 *
 *         // Return a successful response
 *         return new ResponseEntity<>(HttpStatus.OK);
 *     }
 * }
 */