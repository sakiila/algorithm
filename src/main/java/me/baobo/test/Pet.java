package me.baobo.test;

/**
 * @author Bob
 */
public class Pet {
    public Pet(String petName, Integer petId) {
        this.petName = petName;
        this.petId = petId;
    }
    
    public Pet() {
    }
    
    private String petName;
    private String petBreed;
    private Integer petId;

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetBreed() {
        return petBreed;
    }

    public void setPetBreed(String petBreed) {
        this.petBreed = petBreed;
    }

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }
}
