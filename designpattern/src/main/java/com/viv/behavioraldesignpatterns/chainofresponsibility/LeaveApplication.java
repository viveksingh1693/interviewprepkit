package com.viv.behavioraldesignpatterns.chainofresponsibility;

import java.time.LocalDate;
import java.time.Period;

public class LeaveApplication {

    public enum Type {
        SICK, PTO, LOP
    }

    public enum Status {
        APPLIED, APPROVED, REJECTED
    }

    private Type type;

    private LocalDate from;

    private LocalDate to;

    private String processedBy;

    private Status status;


    public int getNoOfDays() {
        return Period.between(from, to).getDays();
    }


    public LeaveApplication(Type type, LocalDate from, LocalDate to) {
        this.type = type;
        this.from = from;
        this.to = to;
        this.status = Status.APPLIED;
    }



    public Type getType() {
        return type;
    }

    public LocalDate getFrom() {
        return from;
    }

    public LocalDate getTo() {
        return to;
    }

    public String getProcessedBy() {
        return processedBy;
    }

    public void setProcessedBy(String processedBy) {
        this.processedBy = processedBy;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void approve(String approverRole) {
        setStatus(Status.APPROVED);
        setProcessedBy(approverRole);
    }

    public void reject(String approverRole) {
        setStatus(Status.REJECTED);
        setProcessedBy(approverRole);
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    @Override
    public String toString() {
        return "LeaveApplication{" +
                "type=" + type +
                ", from=" + from +
                ", to=" + to +
                ", processedBy='" + processedBy + '\'' +
                ", status=" + status +
                '}';
    }

    public static class Builder{
        private Type type;

        private LocalDate from;

        private LocalDate to;

        private LeaveApplication leaveApplication;

        private Builder(){}

        public Builder withType(Type type){
            this.type = type;
            return this;
        }

        public Builder from(LocalDate from){
            this.from = from;
            return this;
        }

        public Builder to(LocalDate to){
            this.to = to;
            return this;
        }

        public LeaveApplication build(){
            this.leaveApplication = new LeaveApplication(type, from, to);
            return this.leaveApplication;
        }
    }
}
