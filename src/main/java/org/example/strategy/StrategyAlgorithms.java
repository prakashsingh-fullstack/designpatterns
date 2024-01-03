package org.example.strategy;

import org.example.Candidate;
import org.example.Degree.DegreeField;

/*
* Provides the generic forms of the applied hiring strategy algorithms
*
* */
public class StrategyAlgorithms {
    /*
    * Degree relevant hiring strategy algorithm, the specified candidate is hiring if he has a
    * degree relevant to the specific field.
    *
    * @param candidate the candidate
    * @param field the degree field
    * @return true if the candidate is hire, otherwise false.
    * */

    public static boolean degree(Candidate candidate, DegreeField degreeField) {
        return candidate.getDegrees().stream().anyMatch(d -> degreeField == d.getDegreeField());
    }

    /*
     * Grade hiring strategy algorithm, the specified candidate is hiring if he has a
     * grade greater than the specific field.
     *
     * @param candidate the candidate
     * @param threshold the threshold
     * @return true if the candidate is hire, otherwise false.
     * */
    public static boolean grade(Candidate candidate, int threshold) {
        return candidate.getDegrees().stream().anyMatch(d -> threshold <=d.getGrade());
    }
}
