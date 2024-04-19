package main.java.come.magicvet.component;

import main.java.come.magicvet.model.Pet;
import main.java.come.magicvet.model.client;
import main.java.come.magicvet.service.ClientService;
import main.java.come.magicvet.service.PetService;

public class AppRunner {

    private ClientService clientService = new ClientService();
    private PetService petService = new PetService();


    public void  run() {
        if (Aunteficator.auth()) {
            client cli  = clientService.registerNewClient();

            if(cli != null) {
                System.out.println("Adding a new pet.");

                Pet pet = petService.registerNewPet();
                cli.setPet(pet);
                pet.setOwner(cli.getFristName() + " " + cli.getLastName());
                System.out.println("Pet has been added. ");
            }
        }
    }


}
