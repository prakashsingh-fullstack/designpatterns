package org.example;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DateUtil {
    private static Logger log = LoggerFactory.getLogger(DateUtil.class);

    //some Supplier
    public static final Supplier<String> RANDOM_STRING_SUPPL = () -> RandomStringUtils.randomAlphabetic(15);
    public static final IntSupplier RANDOM_AGE_SUPPL = () -> RandomUtils.nextInt(20, 50);
    public static final Supplier<Candidate.Gender> GENDER_SUPPLIER = () ->
            Candidate.Gender.values()[RandomUtils.nextInt(0, Candidate.Gender.values().length)];
    public  static final IntSupplier RANDOM_GRADE_SUPPL = () -> RandomUtils.nextInt(0,10);

    public static final Supplier<Degree.DegreeField> DEGREE_FIELD_SUPPLIER = () ->
            Degree.DegreeField.values()[RandomUtils.nextInt(0, Degree.DegreeField.values().length)];

    private DateUtil(){

    }

    public static Candidate buildCandidate(Supplier<String> strSupplier, IntSupplier intSupplier,
                                    Supplier<Candidate.Gender> genderSupplier) {
        return  new Candidate.CandidateBuilder().withName(strSupplier.get()).withAge(intSupplier.getAsInt()).
                withGender(genderSupplier.get()).withDegree(buildDegree()).withContactInfo(new ContactInfo(strSupplier.get(), genRandomBoolean())).build();
    }

    public static Candidate buildCandidate(){
        return buildCandidate(RANDOM_STRING_SUPPL, RANDOM_AGE_SUPPL, GENDER_SUPPLIER);
    }

    public static List<Candidate> buildCandidates(Supplier<String> strSupplier, IntSupplier intSupplier,
                                                  Supplier<Candidate.Gender> genderSupplier, int noOfCandidate) {
        return IntStream.range(0, noOfCandidate).mapToObj(i -> buildCandidate(strSupplier, intSupplier, genderSupplier)).collect(Collectors.toList());
    }

    public static List<Candidate> buildCandidates(int noOfCandidate) {
        return buildCandidates(RANDOM_STRING_SUPPL, RANDOM_AGE_SUPPL, GENDER_SUPPLIER, noOfCandidate);
    }

    public static boolean genRandomBoolean(){
        return Math.random() < 0.5;
    }

    public static Degree buildDegree(){
         return new Degree.DegreeBuilder().withField(DEGREE_FIELD_SUPPLIER.get()).withHolderName(RANDOM_STRING_SUPPL.get()).
                 withGrade(RANDOM_GRADE_SUPPL.getAsInt()).build();
    }
}
