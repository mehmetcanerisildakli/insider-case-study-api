package tests;

import org.testng.annotations.Test;
import rest.services.Pet;

public class InsiderRest {

    Pet pet = new Pet();

    @Test(priority = 1)
    public void positiveCases() {

        pet.addANewPet("PET-1", 200);
        pet.uploadAnImage("PET-1", 200);
        pet.findPetById("PET-1", 200);
        pet.findPetsByStatus("available", 200);
        pet.updateAPet("UPDATED-PET-1", 200);
        pet.updateWithFormData("PET-1", 200);
        pet.deleteAPet("PET-1", 200);
    }

    //@Test (priority=2)
    public void negativeCases() {

        pet.notAddANewPet("WRONG-PET-1", 500);
        pet.notUploadAnImage("WRONG-PET-2", 404);
        pet.notFindPetById("WRONG-PET-2", 404);
        pet.notUpdateAPet("WRONG-PET-1", 500);
        pet.notUpdateWithFormData("PET-1", 200);
        pet.notDeleteAPet("WRONG-PET-2", 404);
    }
}
