package hello.controller;

import hello.entity.Billionaire;
import hello.service.BillionaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("billionaire")
public class BillionaireController {

    @Autowired
    private BillionaireService billionaireService;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public List<Billionaire> getAllBillionare(){
        return billionaireService.getAll();
    }

    @RequestMapping(value = "firstname/{firstName}", method = RequestMethod.GET)
    public List<Billionaire> getBillionairesByFirstName(@PathVariable("firstName")String firstName){
        return billionaireService.getBillionaireByFirstName(firstName);
    }

    @RequestMapping(value = "id/{id}", method = RequestMethod.GET)
    public Billionaire getBillionaireById(@PathVariable("id")Integer id){
        return billionaireService.getBillionaireById(id);
    }

    //TODO add methods for creating billionaires and deleteing billionaires, and updating billionaires
}
