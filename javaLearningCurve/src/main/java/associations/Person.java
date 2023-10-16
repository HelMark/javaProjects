package associations;

import java.util.*;

public class Person {
    
    private String name;
    private char gender;
    private Person mother;
    private Person father;
    private ArrayList<Person> children;

    public Person(String name, char gender) {
        this.name = name;
        this.gender = gender;

        this.mother = null;
        this.father = null;
        this.children = new ArrayList<Person>();
    }

    //getters
    public String getName() {
        return name;
    }
    public char getGender() {
        return gender;
    }
    public Person getMother() {
        return mother;
    }
    public Person getFather() {
        return father;
    }
    public int getChildCount() {
        return children.size();
    }
    public Person getChild(int index) {
        return children.get(index);
    }

    //setters
    public void addChild(Person child) {
        if(this.getGender() == 'F' && !this.children.contains(child)) {
            if (child.getMother() != null) {
                child.getMother().removeChild(child);
            }
            children.add(child);
            child.setMother(this);
        } else if(this.getGender() == 'M' && !this.children.contains(child)) {
            if (child.getFather() != null) {
                child.getFather().removeChild(child);
            }
            children.add(child);
            child.setFather(this);
        }
    }

    public void removeChild(Person child) {
        if (this.getGender() == 'F' && this.children.contains(child)) {
            children.remove(child);
            child.setMother(null);
        } else if (this.getGender() == 'M' && this.children.contains(child)) {
            children.remove(child);
            child.setFather(null);
        }
    }

    public void setMother(Person mother) {
        if (mother == null) {
            this.mother = null;
            return;
        }
        if(mother.getGender() != 'F' || this == mother) {
            throw new IllegalArgumentException("Kun kvinne kan være mor");
        }
        mother.addChild(this);
        this.mother = mother;
    }

    public void setFather(Person father) {
        if (father == null) {
            this.father = null;
            return;
        }
        if(father.getGender() != 'M' || this == father) {
            throw new IllegalArgumentException("Kun mann kan være far");
        }    
        father.addChild(this);
        this.father = father;
    }

    public static void main(String[] args) {
        Person hallard = new Person("Jens", 'M');
        Person kolly = new Person("Kolly", 'F');
        Person jens = new Person("Jens", 'M');

        kolly.setFather(jens);
        kolly.setFather(hallard);

        System.out.println(hallard.getChildCount());
        System.out.println(jens.getChildCount());

    }
}
