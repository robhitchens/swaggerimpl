package hello;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingsController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @ApiOperation(
            value="Returns a greeting",
            notes = "Accepts name as query parameter for generating a greeting, defaults to world",
            response = Greeting.class
    )
    //@ApiResponses({@ApiResponse(code = 200, message="")})
    //TODO: setup spring boot development tools.
    @RequestMapping(value = "/greeting", method = RequestMethod.GET, produces = {"application/json"})
    public Greeting greeting(@RequestParam(value="name", defaultValue = "World")String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
