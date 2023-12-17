package soa.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soa.entities.Devise;
import soa.repository.DeviseRepository;

@Service
public class DeviseMetierImpl implements DeviseMetierInterface{
    @Autowired
    DeviseRepository deviseRepository ;
    @Override
    public  void ajouterDevise(Devise d){

        deviseRepository.save(d);
    }
}
