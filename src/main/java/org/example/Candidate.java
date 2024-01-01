package org.example;

import org.apache.commons.lang3.Validate;

import java.util.List;
import java.util.Optional;

public class Candidate {

    public enum Gender{
        MALE, FEMALE
    }
    private String name;
    private int age;
    private Gender gender;
    private List<Degree> degrees;
    /* Optionally, put here more information about the candidate
    * Not at all the information is mandatory. You can desperately set the information using Builder patter*/
    private Optional<ContactInfo> contactInfo;

    private Candidate(CandidateBuilder builder){
        this.name = builder.name;
        this.age = builder.age;
        this.gender = builder.gender;
        this.degrees = builder.degrees;
        this.contactInfo = builder.contactInfo;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public List<Degree> getDegrees() {
        return degrees;
    }

    public Optional<ContactInfo> getContactInfo() {
        return contactInfo;
    }

    public void  addDegree(Degree degree){
        this.degrees.add(degree);
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", degrees=" + degrees +
                ", contactInfo=" + contactInfo +
                '}';
    }

    public static class CandidateBuilder {
        private String name;
        private int age;
        private Gender gender;
        private List<Degree> degrees;
        private Optional<ContactInfo> contactInfo;

        public CandidateBuilder withName(String name){
            this.name = name;
            return this;
        }

        public CandidateBuilder withAge(int age){
            this.age = age;
            return this;
        }

        public CandidateBuilder withGender(Gender gender){
            this.gender = gender;
            return this;
        }
        public CandidateBuilder withDegree(Degree degree){
            this.degrees.add(degree);
            return this;
        }

        public CandidateBuilder withDegrees(List<Degree> degrees){
            this.degrees = degrees;
            return this;
        }

        public CandidateBuilder withContactInfo(ContactInfo contactInfo){
            this.contactInfo = Optional.ofNullable(contactInfo);
            return this;
        }

        public Candidate build(){
            Validate.notEmpty(name, "Candidate not is not defined");
            return new Candidate(this);
        }

    }
}
