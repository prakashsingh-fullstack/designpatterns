package org.example.strategy;

import org.example.Candidate;

/*
* The hiring Strategy API (the <b> Strategy </b>).
*  */

public interface HiringStrategy {
    /*
    * Decides weather a candidate should be hire or not.
    *
    * @param candidate
    * @return true if the candidate is hire return true otherwise return false
    * */
    boolean hire(Candidate candidate);
}
