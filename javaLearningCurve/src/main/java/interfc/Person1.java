package interfc;

public class Person1 implements Named {
    private String givenName;
    private String familyName;

    public Person1(String givenName, String familyName) {
        this.givenName = givenName;
        this.familyName = familyName;
    }

    @Override
    public void setGivenName(String givenName) {
      this.givenName = givenName;
    }

    @Override
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    @Override
    public void setFullName(String fullName) {
        String[] names = fullName.split(" ");
        this.givenName = names[0];
        this.familyName = names[1];
    }
 
    @Override
    public String getGivenName() {
        return givenName;
    }

    @Override
    public String getFamilyName() {
        return familyName;
    }

    @Override
    public String getFullName() {
        return givenName + " " + familyName;
    }
    
}
