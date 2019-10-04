package hello.service;

import hello.entity.Billionaire;
import hello.repository.BillionareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BillionaireService {

    @Autowired
    private BillionareRepository billionareRepository;

    public List<Billionaire> getAll(){
        return StreamSupport
                .stream(billionareRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Billionaire getBillionaireById(int id){
        return billionareRepository.findBillionaireById(id);
    }

    public List<Billionaire> getBillionaireByFirstName(String firstName){
        return billionareRepository.findByFirstName(firstName);
    }
}
