package encapsulation;

public class Vehicle {
    private char vehicleType;
    private char fuelType;
    private String regNr;


    private boolean validVehicleType(char vehicleType) {
        return vehicleType == 'C' || vehicleType == 'M' ? true : false;
    }

    private boolean validFuelType(char fuelType) {
        return fuelType == 'H' || fuelType == 'E' || fuelType == 'D' || fuelType == 'G' ? true : false;
    }

    private boolean validRegNr(String regNr) {
       String startRegNr = regNr.substring(0, 2);
       String endRegNr = regNr.substring(2, regNr.length());

        if (this.vehicleType == 'C' && startRegNr.matches("[A-Z]{2}") && endRegNr.matches("[0-9]{5}")) {
            if (startRegNr.equals("EL") || startRegNr.equals("EK")) {
                return this.fuelType == 'E' ? true : false;
           } else if (startRegNr.equals("HY")) {
            return this.fuelType == 'H' ? true : false;
           }
           return this.fuelType == 'D' || this.fuelType == 'G' ? true : false;
        } else if (this.vehicleType == 'M' && startRegNr.matches("[A-Z]{2}") && endRegNr.matches("[0-9]{4}")) {
            if (startRegNr.equals("EL") || startRegNr.equals("EK")) {
                return this.fuelType == 'E' ? true : false;
           } else if (startRegNr.equals("HY")) {
            return false;
           }
           return this.fuelType == 'D' || this.fuelType == 'G' ? true : false;
        }
        return false;
       }

    public Vehicle(char vehicleType, char fuelType, String regNr) {
        if (!validVehicleType(vehicleType)) {
            throw new IllegalArgumentException("Vehicle type must be either 'C' or 'M'");
        } 
        this.vehicleType = vehicleType;

        if (!validFuelType(fuelType)) {
            throw new IllegalArgumentException("Fuel type must be either 'H' or 'E' or 'D' or 'G'");
        }
        this.fuelType = fuelType;

        if (!validRegNr(regNr)) {
            throw new IllegalArgumentException("Innvalid registration number");
        }
        this.regNr = regNr;
    }

    public char getFuelType() {
        return fuelType;
    }

    public String getRegistrationNumber() {
        return regNr;
    }

    public char getVehicleType() {
        return vehicleType;
    }

    public void setRegistrationNumber(String regNr) {
        if (!validRegNr(regNr)) {
            throw new IllegalArgumentException("Innvalid registration number");
        }
        this.regNr = regNr;
    }

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle('M', 'G', "HY1234");
        System.out.println(vehicle.getFuelType());
        System.out.println(vehicle.getRegistrationNumber());
    }
}
