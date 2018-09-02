package com.iafnstudios.petclinic.bootstrap;

import com.iafnstudios.petclinic.model.Owner;
import com.iafnstudios.petclinic.model.PetType;
import com.iafnstudios.petclinic.model.Vet;
import com.iafnstudios.petclinic.services.OwnerService;
import com.iafnstudios.petclinic.services.PetTypeService;
import com.iafnstudios.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired //It is not necessary
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");

        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");

        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("PetTypes are loaded...");

        Owner owner1 = new Owner();
        owner1.setFirstName("Abdullah");
        owner1.setLastName("SEN");

        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setFirstName("Ilkay");
        owner2.setLastName("SEN");

        ownerService.save(owner2);

        System.out.println("Owners are loaded...");


        Vet vet1 = new Vet();
        vet1.setFirstName("Fatma");
        vet1.setLastName("Sen");

        vetService.save(vet1);


        Vet vet2 = new Vet();
        vet2.setFirstName("Necati");
        vet2.setLastName("Sen");

        vetService.save(vet2);

        System.out.println("Vets are loaded...");



    }
}
