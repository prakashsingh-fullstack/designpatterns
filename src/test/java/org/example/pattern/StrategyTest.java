package org.example.pattern;

import org.example.*;
import org.example.strategy.DegreeRelevantHiringStrategy;
import org.example.strategy.GradeHiringStrategy;
import org.example.strategy.HiringStrategy;
import org.example.strategy.StrategyAlgorithms;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.List;

@Test(enabled = true)
public class StrategyTest extends TestSupport {
    private static final Logger log = LoggerFactory.getLogger(StrategyTest.class);

    private Employer employer = new Employer();

    /*
    * Just to check that employer can hire when the hiring strategy is set.
    * Check the 'Optional' usages at the method.
    * */
    public void employerWithoutStrategy(){
        //The Employer is not authorized to hire.
        employer.setHiringStrategy(null);
        // build the candidate
        List<Candidate> candidates = DateUtil.buildCandidates(100);
        //find the number of hire candidate
        long hire = candidates.stream().filter(employer::hire).count();
        //Test the result
        Assert.assertEquals(hire, 0, "The Employer has no authorization for hiring");
    }

    /*
    * Test the old ways
    * */
    public  void degreeRelevantHiringStrategy(){
        Degree.DegreeField degreeField = Degree.DegreeField.ENGINEERING;
        /* Create an Engineering degree relevant hiring strategy with the old-way*/
        HiringStrategy hiringStrategy = new DegreeRelevantHiringStrategy(degreeField);
        doDegreeRelevantHiringStrategy(hiringStrategy, degreeField);
    }

    /* Test the lambda-way */
    public void degreeRelevantHiringStrategyLambda() {
        Degree.DegreeField degreeField = Degree.DegreeField.ENGINEERING;
        /* Create an 'Engineering' degree relevant hiring strategy with the lambda-way
        *  The lambda call the generic degree relevant hiring algorithms.
        * */
        HiringStrategy hiringStrategy = candidate -> StrategyAlgorithms.degree(candidate, degreeField);
        doDegreeRelevantHiringStrategy(hiringStrategy, degreeField);
    }

    /* The actual test for a DegreeRelevantHiringStrategy */
    public void doDegreeRelevantHiringStrategy(HiringStrategy hiringStrategy, Degree.DegreeField degreeField) {
        /* Set the hiring strategy to the employer */
        employer.setHiringStrategy(hiringStrategy);
        /* build the candidate */
        List<Candidate> candidates = DateUtil.buildCandidates(100);
        /* Find the expected number of the hired candidates by counting the ones that has Engineering degree*/
        long expectedHire = candidates.stream().map(Candidate::getDegrees).flatMap(Collection::stream).map(Degree::getDegreeField).
                filter(degreeField::equals).count();
        /* Find the actual number of the hiring candidate by counting the ones that hired by applying the degree relevant hiring strategy*/
        long actualHire = candidates.stream().filter(employer::hire).count();
        Assert.assertEquals(actualHire, expectedHire, "Unexpected number of hired people");
    }

    /* Test the old ways */
    public void gradeHiringStrategy() {
        final int threshold = 8;
        /* Create grade hiring strategy with the old-way */
        HiringStrategy hiringStrategy = new GradeHiringStrategy(threshold);
        doGradeHiringStrategy(hiringStrategy, threshold);
    }

    public void  gradeHiringStrategyLambda() {
        final int threshold = 8;
        HiringStrategy hiringStrategy = candidate -> StrategyAlgorithms.grade(candidate, threshold);
        doGradeHiringStrategy(hiringStrategy, threshold);
    }

    /*Actual test for a */
    public void doGradeHiringStrategy(HiringStrategy hiringStrategy, int threshold){
        /* Set the hiring strategy to the employer */
        employer.setHiringStrategy(hiringStrategy);
        /* build the candidate */
        List<Candidate> candidates = DateUtil.buildCandidates(100);
        /* Find the expected number of the hired candidate by counting the ones that has greater degree of threshold */
        long expectedResult = candidates.stream().map(Candidate::getDegrees).flatMap(Collection::stream).
                mapToInt(Degree::getGrade).filter((grade) -> grade >= threshold).count();
        /* Find the actual number of the hiring candidate by counting the ones that hired by applying the grade relevant hiring strategy*/
        long actualResult = candidates.stream().filter(employer::hire).count();
        Assert.assertEquals(expectedResult,actualResult,"Unexpected number of hired people");
    }
}
