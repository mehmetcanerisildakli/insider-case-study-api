package rest.services;

import rest.helpers.ReadData;
import rest.methods.RestMethod;

public class Pet {

    ReadData readData = new ReadData();
    RestMethod restMethod = new RestMethod();

    public void uploadAnImage(String petName, int expectedCode) {
        restMethod.postUploadIMage(readData.getTestData(petName), expectedCode);
    }

    public void addANewPet(String petName, int expectedCode) {
        restMethod.postANewPet(readData.getTestData(petName), expectedCode);
    }

    public void updateAPet(String petName, int expectedCode) {
        restMethod.updateAPet(readData.getTestData(petName), expectedCode);
    }

    public void findPetsByStatus(String status, int expectedCode) {
        restMethod.getByStatus(status, expectedCode);
    }

    public void findPetById(String petName, int expectedCode) {
        restMethod.getById(readData.getTestData(petName), expectedCode);
    }

    public void updateWithFormData(String petName, int expectedCode) {
        restMethod.updateAPetWithFormData(readData.getTestData(petName), expectedCode);
    }

    public void deleteAPet(String petName, int expectedCode) {
        restMethod.deleteAPet(readData.getTestData(petName), expectedCode);
    }

    public void notAddANewPet(String petName, int expectedCode) {
        restMethod.postANewPet(readData.getTestData(petName), expectedCode);
    }

    public void notUploadAnImage(String petName, int expectedCode) {
        restMethod.postNotUploadIMage(readData.getTestData(petName), expectedCode);
    }

    public void notFindPetById(String petName, int expectedCode) {
        restMethod.getById(readData.getTestData(petName), expectedCode);
    }

    public void notUpdateAPet(String petName, int expectedCode) {
        restMethod.updateAPet(readData.getTestData(petName), expectedCode);
    }

    public void notUpdateWithFormData(String petName, int expectedCode) {
        restMethod.updateNotAPetWithFormData(readData.getTestData(petName), expectedCode);
    }

    public void notDeleteAPet(String petName, int expectedCode) {
        restMethod.deleteAPet(readData.getTestData(petName), expectedCode);
    }
}
