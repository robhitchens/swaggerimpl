package hello.repository;

import hello.entity.Billionaire;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillionareRepository extends CrudRepository<Billionaire, Integer> {

    public List<Billionaire> findByFirstName(String firstName);

    public Billionaire findBillionaireById(Integer id);
}
