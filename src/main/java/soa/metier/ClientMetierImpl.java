package soa.metier;

import org.springframework.stereotype.Service;
import soa.entities.Client;
import soa.repository.ClientRepository;
@Service
public class ClientMetierImpl implements  ClientMetierInterface{
    ClientRepository clientRepository;
    @Override
    public void ajouterClient(Client c) {
        clientRepository.save(c);
    }
}
