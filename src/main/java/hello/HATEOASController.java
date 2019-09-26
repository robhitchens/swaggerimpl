package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HATEOASController {

    @RequestMapping(value="/custom", method = RequestMethod.GET)
    public String get(){
        return "get";
    }

    @RequestMapping(value="/custom", method = RequestMethod.POST)
    public String post(){
        return "post";
    }

    @RequestMapping(value="/custom", method = RequestMethod.PUT)
    public String put(){
        return "put";
    }

    @RequestMapping(value="/custom", method = RequestMethod.PATCH)
    public String patch(){
        return "patch";
    }

    @RequestMapping(value="/custom", method = RequestMethod.DELETE)
    public String delete(){
        return "delete";
    }

    @RequestMapping(value="/custom", method = RequestMethod.HEAD)
    public String head(){
        return "head";
    }


    @RequestMapping(value="/custom", method = RequestMethod.OPTIONS)
    public String options(){
        return "options";
    }

    @RequestMapping(value="/custom", method = RequestMethod.TRACE)
    public String trace(){
        return "trace";
    }
}