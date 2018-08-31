package com.iafnstudios.petclinic.bootstrap;

import com.iafnstudios.petclinic.model.Owner;
import com.iafnstudios.petclinic.model.Vet;
import com.iafnstudios.petclinic.services.OwnerService;
import com.iafnstudios.petclinic.services.VetService;
import com.iafnstudios.petclinic.services.map.OwnerServiceMap;
import com.iafnstudios.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(){
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Abdullah");
        owner1.setLastName("SEN");

        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Ilkay");
        owner2.setLastName("SEN");

        ownerService.save(owner2);

        System.out.println("Owners are loaded...");


        Vet vet1 = new Vet();
        vet1.setId(1l);
        vet1.setFirstName("Fatma");
        vet1.setLastName("Sen");

        vetService.save(vet1);


        Vet vet2 = new Vet();
        vet2.setId(1l);
        vet2.setFirstName("Necati");
        vet2.setLastName("Sen");

        vetService.save(vet2);

        System.out.println("Vets are loaded...");



    }
}
