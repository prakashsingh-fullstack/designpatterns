package org.example;

import org.example.strategy.HiringStrategy;

import java.util.Optional;

/*
* The employer that decides who candidate is hiring based on the applied.
* */
public class Employer {

    /*Let's assume that the Employer will have the authorization to hire people
    * if that the hiring strategy is set. This can be expressed with the optional in java 8
    * */
    private Optional<HiringStrategy> hiringStrategy = Optional.empty();
    public  Employer(){

    }

    public Employer(HiringStrategy hiringStrategy) {
        this.hiringStrategy = Optional.of(hiringStrategy);
    }

    public void setHiringStrategy(HiringStrategy hiringStrategy){
        this.hiringStrategy = Optional.ofNullable(hiringStrategy);
    }

    public boolean hire(Candidate candidate) {
        /*
        * If the hiringStrategy is set, the mapper at the map is called which determine the
        * result of the method is call. otherwise return false. The 'orElseThrow can be used' accordingly the requirement
        * */
        return hiringStrategy.map(s ->s.hire(candidate)).orElse(Boolean.FALSE);
    }

}
