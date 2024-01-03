package org.example.strategy;


import org.example.Candidate;
import org.example.Degree.DegreeField;

/*
* The hiring strategy use candidate's degree field hiring criteria.
* */
public class DegreeRelevantHiringStrategy implements HiringStrategy{
    private DegreeField degreeField;
    public  DegreeRelevantHiringStrategy(){
        this(DegreeField.ENGINEERING);
    }

    public DegreeRelevantHiringStrategy(DegreeField degreeField) {
        this.degreeField = degreeField;
    }

    @Override
    public boolean hire(Candidate candidate) {
        return StrategyAlgorithms.degree(candidate, degreeField);
    }
}
