package app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController  // notifies Spring MVC that this class should be registered with Spring Application
@RequestMapping("/api")  // Mapping determines if a given URL, HTTP method, context and that it may contain methods that handle REST requests
public class SimpleController {
    @GetMapping // Signals to Spring MVC that this method can only handle HTTP requests using GET method
    public String[] helloWorld() {
        String[] result = {"Hello", "World", "!"};
        return result;
    }

    @PostMapping("/calculate") // Tells SpringMVC to execute method if an HTTP request's method is POST and URL is
                                // "/api/calculate"
    public String calculate(int operand1, String operator, int operand2) {
        int result = 0;
        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                result = operand1 / operand2;
                break;
            default:
                String message = String.format("operator '%s' is invalid", operator);
                throw new IllegalArgumentException(message);
        }
        return String.format("%s %s %s = %s", operand1, operator, operand2, result);
    }

    @DeleteMapping("/resource/{id}")  //tells Spring MVC to call our method when the HTTP method is DELETE.
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        // This is where we would use our id to delete.
    }

}
