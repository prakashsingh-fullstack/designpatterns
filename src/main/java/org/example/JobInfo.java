package org.example;

public class JobInfo {
    /*
    * Some Job Categories for easiest filtering by the departments.
    * */
    public enum JobCategory{
        ENGINEERING, SALES, LOGISTICS
    }
    private  JobCategory category;
    private  String description;

    public JobInfo(JobCategory category, String description) {
        this.category = category;
        this.description = description;
    }

    public JobCategory getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }
}
