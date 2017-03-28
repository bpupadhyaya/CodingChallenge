package com.equalinformation.car.model;

/**
 * Created by bpupadhyaya on 3/27/17.
 */
public class Rating {
    private String reviewedBy;
    private int safety;
    private int performance;
    private int technology;
    private int interior;
    private int reliability;

    public String getReviewedBy() {
        return reviewedBy;
    }

    public void setReviewedBy(String reviewedBy) {
        this.reviewedBy = reviewedBy;
    }

    public int getSafety() {
        return safety;
    }

    public void setSafety(int safety) {
        this.safety = safety;
    }

    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }

    public int getTechnology() {
        return technology;
    }

    public void setTechnology(int technology) {
        this.technology = technology;
    }

    public int getInterior() {
        return interior;
    }

    public void setInterior(int interior) {
        this.interior = interior;
    }

    public int getReliability() {
        return reliability;
    }

    public void setReliability(int reliability) {
        this.reliability = reliability;
    }
}
