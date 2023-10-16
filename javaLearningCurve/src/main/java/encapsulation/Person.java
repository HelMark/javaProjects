package encapsulation;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class Person {
    private String name;
    private String email; 
    private char gender;
    private Date birthDay;
    private String ssn;

    //validXXX
    public boolean validName(String name) {
        try {
            String firstName = name.split(" ")[0];
            String lastName = name.split(" ")[1];
            
            if (firstName.length() < 2 || lastName.length() < 2) {
                return false;
            } else if (!(Pattern.matches("[a-zA-Z]+?", firstName) && Pattern.matches("[a-zA-Z]+?", lastName))) {
                return false;
            }
            try {
                String middlename = name.split(" ")[2];
                return false;
            } catch (Exception e) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        }
    public boolean validEmail(String email) {
        if (email == null) {
            return true;
        }
        try {
            String firstName = this.name.split(" ")[0].toLowerCase();
            String lastName = this.name.split(" ")[1].toLowerCase();
            
            String eMailFirstName = email.split("\\.")[0].toLowerCase();
            String eMailLastName = email.split("\\.")[1].split("\\@")[0].toLowerCase();

            Countrycode c = new Countrycode();
            String[] countryCode = c.getCountryCodes();
            String countryCodeInEmail = email.split("\\.")[2];

            String domain = email.split("\\.")[1].split("\\@")[1];

            if (!eMailFirstName.equals(firstName) || !eMailLastName.equals(lastName)) { //if (!(eMailFirstName == firstName && eMailLastName == lastName))
                return false;
            } else if (eMailFirstName == "" || eMailLastName == "" || domain == "" || countryCodeInEmail == "") {
                return false;
            } 
            for (int i  = 0; i < countryCode.length; i++) {
                if(countryCodeInEmail.equals(countryCode[i])) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean validGender(char gender) {
        if (!(gender == 'M' || gender == 'F' || gender == '\0')) {
            return false;
        }
        return true;
    }
    public boolean validBirthDate(Date birthDay) {
       Date dateNow = new Date();
       double dateNowInMilliseconds = dateNow.getTime();
       double birthdateInMilliseconds = birthDay.getTime();
       //SimpleDateFormat dateNowInMMddY = new SimpleDateFormat("MM/dd/Y");

        if (!(dateNowInMilliseconds < birthdateInMilliseconds)) {
            return false;
        }
        return true;
    }

    public boolean validSsn(String ssn) {
        try {
            //SimpleDateFormat dateFormat = new SimpleDateFormat("MMddYY");
            //String birtdateInString = dateFormat.format(this.birthDay);
            int year = this.birthDay.getYear();
            int month = this.birthDay.getMonth() + 1;
            int day = this.birthDay.getDate();
            String birtdateInString = String.format("%02d%02d%02d", month, day, year);
            //
            String ssnBirthdate = ssn.substring(0, 6);
            String ssnGender = ssn.substring(8, 9);
        
            int K1 = Integer.parseInt(ssn.substring(9, 10));
            int K2 = Integer.parseInt(ssn.substring(10, 11));

            int N1 = Integer.parseInt(ssn.substring(6, 7));
            int N2 = Integer.parseInt(ssn.substring(7, 8));
            int N3 = Integer.parseInt(ssn.substring(8, 9));

            int D1 = Integer.parseInt(ssn.substring(0, 1));
            int D2 = Integer.parseInt(ssn.substring(1, 2));
            int M1 = Integer.parseInt(ssn.substring(2, 3));
            int M2 = Integer.parseInt(ssn.substring(3, 4));
            int Y1 = Integer.parseInt(ssn.substring(4, 5));
            int Y2 = Integer.parseInt(ssn.substring(5, 6));

            int[] F = {3, 7, 6, 1, 8, 9, 4, 5, 2};
            int[] G = {5, 4, 3, 2, 7, 6, 5, 4, 3, 2};

            int VSK1 = D1*3 + D2*7 + M1*6 + M2*1 + Y1*8 + Y2*9 + N1*4 + N2*5 + N3*2;
            int VSK2 = D1*5 + D2*4 + M1*3 + M2*2 + Y1*7 + Y2*6 + N1*5 + N2*4 + N3*3 + K1*2;

            int K1Sum = 11 - (VSK1 % 11);
            int K2Sum = 11 - (VSK2 % 11);

            if(getGender() == '\0' || getBirthday() == null) {
                return false;
            } else if (ssn.length() != 11) {
                return false;
            } else if (!ssnBirthdate.equals(birtdateInString)) {
                return false;
            } else if (!((getGender() == 'M' && Integer.parseInt(ssnGender) % 2 == 1) || (getGender() == 'F' && Integer.parseInt(ssnGender) % 2 == 0))) {
                return false;
            } else if (K1Sum == 11 && K1 == 0) {
                if (K2Sum == 11 && K2 == 0) {
                    return true;
                } else if (K2Sum == K2) {
                    return true;
                } else {
                    return false;
                }
            } else if (K2Sum == 11 && K2 == 0) {
                if (K1Sum == 11 && K1 == 0) {
                    return true;
                } else if (K1Sum == K1) {
                    return true;
                } else {
                    return false;
                }
            }
            return (K1 == K1Sum && K2 == K2Sum) ? true : false;
        
        } catch (Exception e) {
            return false;
        }
    }
    
    //setters
    public void setName(String name) {
        if (!validName(name)) {
            throw new IllegalArgumentException("Innvalid name");
        }
        this.name = name;
    }

    public void setEmail(String email) {
        if (!validEmail(email)) {
            throw new IllegalArgumentException("Innvalid email");
        }
        this.email = email;
    }

    public void setGender(char gender) {
        if (!validGender(gender)) {
            throw new IllegalArgumentException("Innvalid pronouns");
        }
        this.gender = gender;
    }

    public void setBirthday(Date birthDay) {
        if (validBirthDate(birthDay)) {
            throw new IllegalArgumentException("Innvalid birthday");
        }
        this.birthDay = birthDay;
    }

    public void setSSN(String ssn) {
        if (!validSsn(ssn)) {
            throw new IllegalArgumentException("Innvalid ssn");
        }
        this.ssn = ssn;
    }

    //getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public char getGender() {
        return gender;
    }

    public Date getBirthday() {
        return birthDay;
    }

    public String getSSN() {
        return ssn;
    }

    
    public static void main(String[] args) {
        Person p = new Person();
        p.setBirthday(new Date(94, 0, 1));
        p.setGender('M');
        p.setSSN("01019411156");
        System.out.println(p.getSSN());

    }

    /*
     *   Person p = new Person();

        System.out.println(p.getBirthday());

        p.setName("Ola normann");
        System.out.println(p.getName());

        p.setEmail("ola.normann@ntnu.no");
        System.out.println(p.getEmail());

        p.setGender('M');
        System.out.println(p.getGender());
        
        Date thisdate = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMddYY");
        String birtdateInString = dateFormat.format(thisdate);

        System.out.println(birtdateInString);

        String l = "DDMMYYNNNKK";
        String s = l.substring(11);
        System.out.println(s);

        p.setSSN("01019411156");
        System.out.println(p.getSSN());
     */
}