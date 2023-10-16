package interfc;

public class Person2 implements Named {
    
    private String fullName;

    public Person2(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public void setGivenName(String givenName) {
        String[] names = this.fullName.split(" ");
        fullName = givenName + " " + names[1];
    }

    @Override
    public void setFamilyName(String familyName) {
        String[] names = this.fullName.split(" ");
        fullName = names[0] + " " + familyName;
    }

    @Override
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String getGivenName() {
        String[] names = this.fullName.split(" ");
        return names[0];
    }

    @Override
    public String getFamilyName() {
        String[] names = this.fullName.split(" ");
        return names[1];
    }

    @Override
    public String getFullName() {
        return fullName;
    }
}
