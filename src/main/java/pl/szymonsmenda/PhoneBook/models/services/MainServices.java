package pl.szymonsmenda.PhoneBook.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szymonsmenda.PhoneBook.models.NumberEntity;
import pl.szymonsmenda.PhoneBook.models.forms.NumberForm;
import pl.szymonsmenda.PhoneBook.models.repositories.NumberRepository;

import java.util.List;

@Service
public class MainServices {

    final NumberRepository numberRepository;

    @Autowired
    public MainServices(NumberRepository numberRepository) {
        this.numberRepository = numberRepository;
    }

    public boolean tryToAddNumber(NumberForm numberForm){
        if (numberRepository.existsByNumber(numberForm.getNumber())){
            return false;
        }
        NumberEntity numberEntity = createEntityFromForm(numberForm);
        numberRepository.save(numberEntity);
        return true;
    }

    private NumberEntity createEntityFromForm(NumberForm numberForm) {
        NumberEntity numberEntity = new NumberEntity();
        numberEntity.setName(numberForm.getName());
        numberEntity.setSurname(numberForm.getSurname());
        numberEntity.setNumber(numberForm.getNumber());
        return numberEntity;
    }

   public List<NumberEntity> getAll(){
        return numberRepository.findAll();
   }

   public NumberEntity getAllDetails(int id){
        return numberRepository.findById(id).get();
   }
}
