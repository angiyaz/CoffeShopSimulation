package Adapters;

import Abstract.CustomerCheckService;
import Entities.Customer;
import MernisService.AFEKPSPublicSoap;

public class MernisServiceAdapter implements CustomerCheckService {
    AFEKPSPublicSoap afekpsPublicSoap=new AFEKPSPublicSoap();


    @Override
    public boolean checkIfRealPerson(Customer customer) {
        try {
            return afekpsPublicSoap.TCKimlikNoDogrula(Long.valueOf(customer.getNationalityId()), customer.getFirstName(), customer.getLastName(),customer.getDateOfBirth().getYear());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }
}
