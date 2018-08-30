package com.iafnstudios.petclinic.services;

import com.iafnstudios.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long>{

    Owner findByLastName(String lastName);


}
