package com.iafnstudios.petclinic.bootstrap;

import com.iafnstudios.petclinic.model.*;
import com.iafnstudios.petclinic.services.OwnerService;
import com.iafnstudios.petclinic.services.PetTypeService;
import com.iafnstudios.petclinic.services.SpecialityService;
import com.iafnstudios.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    @Autowired //It is not necessary
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count ==0){
            loadData();
        }


    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("PetTypes are loaded...");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery= specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        System.out.println("Specialities are loaded...");


        Owner owner1 = new Owner();
        owner1.setFirstName("Abdullah");
        owner1.setLastName("SEN");
        owner1.setAddress("123 Street");
        owner1.setCity("Helsinki");
        owner1.setTelephone("987546313322");

        Pet abdsPet = new Pet();
        abdsPet.setPetType(savedCatPetType);
        abdsPet.setOwner(owner1);
        abdsPet.setBirthDate(LocalDate.now());
        abdsPet.setPetName("Kabuk");
        owner1.getPets().add(abdsPet);
        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setFirstName("Ilkay");
        owner2.setLastName("SEN");
        owner2.setAddress("987 Street");
        owner2.setCity("Oslo");
        owner2.setTelephone("54987461546465");

        Pet ilksPet = new Pet();
        ilksPet.setPetType(savedDogPetType);
        ilksPet.setOwner(owner2);
        ilksPet.setBirthDate(LocalDate.now());
        ilksPet.setPetName("Bıçak");
        owner2.getPets().add(ilksPet);

        ownerService.save(owner2);

        System.out.println("Owners are loaded...");


        Vet vet1 = new Vet();
        vet1.setFirstName("Fatma");
        vet1.setLastName("Sen");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);


        Vet vet2 = new Vet();
        vet2.setFirstName("Necati");
        vet2.setLastName("Sen");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Vets are loaded...");
    }
}
