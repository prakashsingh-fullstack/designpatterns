package org.example.strategy;

import org.example.Candidate;

/*
* The hiring strategy uses the candidate's grade hiring criteria.
* */
public class GradeHiringStrategy implements HiringStrategy{
    private int threshold;

    public GradeHiringStrategy(){
        this(8);
    }
    public  GradeHiringStrategy(int threshold) {
        this.threshold = threshold;
    }
    @Override
    public boolean hire(Candidate candidate) {
        return StrategyAlgorithms.grade(candidate, threshold);
    }
}
