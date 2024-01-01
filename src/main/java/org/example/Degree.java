package org.example;

import org.apache.commons.lang3.Validate;

public class Degree {
    public enum DegreeField{
        ENGINEERING, CHEMISTRY, PHYSICS, MANAGEMENT
    }

    private DegreeField degreeField;
    private int grade;
    private String holderName;

    private Degree(DegreeBuilder builder){
        this.degreeField = builder.degreeField;
        this.grade = builder.grade;
        this.holderName = builder.holderName;
    }
    public DegreeField getDegreeField() {
        return degreeField;
    }

    public int getGrade() {
        return grade;
    }

    public String getHolderName() {
        return holderName;
    }

    @Override
    public String toString() {
        return "Degree{" +
                "degreeField=" + degreeField +
                ", grade=" + grade +
                ", holderName='" + holderName + '\'' +
                '}';
    }

    public static class DegreeBuilder{
        private DegreeField degreeField;
        private int grade;
        private String holderName;

        public DegreeBuilder withField(DegreeField field){
            this.degreeField = field;
            return this;
        }

        public DegreeBuilder withGrade(int grade){
            this.grade = grade;
            return this;
        }

        public DegreeBuilder withHolderName(String holderName){
            this.holderName = holderName;
            return this;
        }

        public Degree build(){
            Validate.notNull(degreeField, "Undefined degree field!");
            Validate.notEmpty(holderName, "Undefined degree holder's name!");
            return new Degree(this);
        }

    }
}
