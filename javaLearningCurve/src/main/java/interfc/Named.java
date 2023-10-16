package interfc;

public interface Named {
    
    public void setGivenName(String givenName);
    public void setFamilyName(String familyName);
    public void setFullName(String fullName);

    public String getGivenName();
    public String getFamilyName();
    public String getFullName();
    
    public static void main(String[] args) {
        Named p1 = new Person1("Hallvard", "Trætteberg");
		Named p2 = new Person2("Jens Trætteberg");
        
        NamedComparator comp = new NamedComparator();

        System.out.println(comp.compare(p2, p1) > 0);
    }
}
