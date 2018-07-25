package pl.krzysiekstuglik.PhoneBook.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.krzysiekstuglik.PhoneBook.models.NumberEntity;

import java.util.List;

@Repository
public interface NumberRepository extends CrudRepository<NumberEntity, Integer>{
    boolean existsByNumber(int number);
    List<NumberEntity> findAll();


}
