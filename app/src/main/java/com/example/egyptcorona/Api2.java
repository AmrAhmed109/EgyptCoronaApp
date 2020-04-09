package com.example.egyptcorona;

public class Api2 {


    /**
     * data : {"total_cases":"1,583,188","recovery_cases":"348,467","death_cases":"94,588","last_update":"Apr, 09 2020, 18:59, UTC","currently_infected":"1,140,133","cases_with_outcome":"443,055","mild_condition_active_cases":"1,091,188","critical_condition_active_cases":"48,945","recovered_closed_cases":"348,467","death_closed_cases":"94,588","closed_cases_recovered_percentage":"79.0","closed_cases_death_percentage":"21.0","active_cases_mild_percentage":"96.0","active_cases_critical_percentage":"4.0","general_death_rate":"6.0"}
     * status : success
     */

    private DataBean data;
    private String status;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class DataBean {
        /**
         * total_cases : 1,583,188
         * recovery_cases : 348,467
         * death_cases : 94,588
         * last_update : Apr, 09 2020, 18:59, UTC
         * currently_infected : 1,140,133
         * cases_with_outcome : 443,055
         * mild_condition_active_cases : 1,091,188
         * critical_condition_active_cases : 48,945
         * recovered_closed_cases : 348,467
         * death_closed_cases : 94,588
         * closed_cases_recovered_percentage : 79.0
         * closed_cases_death_percentage : 21.0
         * active_cases_mild_percentage : 96.0
         * active_cases_critical_percentage : 4.0
         * general_death_rate : 6.0
         */

        private String total_cases;
        private String recovery_cases;
        private String death_cases;
        private String last_update;
        private String currently_infected;
        private String cases_with_outcome;
        private String mild_condition_active_cases;
        private String critical_condition_active_cases;
        private String recovered_closed_cases;
        private String death_closed_cases;
        private String closed_cases_recovered_percentage;
        private String closed_cases_death_percentage;
        private String active_cases_mild_percentage;
        private String active_cases_critical_percentage;
        private String general_death_rate;

        public String getTotal_cases() {
            return total_cases;
        }

        public void setTotal_cases(String total_cases) {
            this.total_cases = total_cases;
        }

        public String getRecovery_cases() {
            return recovery_cases;
        }

        public void setRecovery_cases(String recovery_cases) {
            this.recovery_cases = recovery_cases;
        }

        public String getDeath_cases() {
            return death_cases;
        }

        public void setDeath_cases(String death_cases) {
            this.death_cases = death_cases;
        }

        public String getLast_update() {
            return last_update;
        }

        public void setLast_update(String last_update) {
            this.last_update = last_update;
        }

        public String getCurrently_infected() {
            return currently_infected;
        }

        public void setCurrently_infected(String currently_infected) {
            this.currently_infected = currently_infected;
        }

        public String getCases_with_outcome() {
            return cases_with_outcome;
        }

        public void setCases_with_outcome(String cases_with_outcome) {
            this.cases_with_outcome = cases_with_outcome;
        }

        public String getMild_condition_active_cases() {
            return mild_condition_active_cases;
        }

        public void setMild_condition_active_cases(String mild_condition_active_cases) {
            this.mild_condition_active_cases = mild_condition_active_cases;
        }

        public String getCritical_condition_active_cases() {
            return critical_condition_active_cases;
        }

        public void setCritical_condition_active_cases(String critical_condition_active_cases) {
            this.critical_condition_active_cases = critical_condition_active_cases;
        }

        public String getRecovered_closed_cases() {
            return recovered_closed_cases;
        }

        public void setRecovered_closed_cases(String recovered_closed_cases) {
            this.recovered_closed_cases = recovered_closed_cases;
        }

        public String getDeath_closed_cases() {
            return death_closed_cases;
        }

        public void setDeath_closed_cases(String death_closed_cases) {
            this.death_closed_cases = death_closed_cases;
        }

        public String getClosed_cases_recovered_percentage() {
            return closed_cases_recovered_percentage;
        }

        public void setClosed_cases_recovered_percentage(String closed_cases_recovered_percentage) {
            this.closed_cases_recovered_percentage = closed_cases_recovered_percentage;
        }

        public String getClosed_cases_death_percentage() {
            return closed_cases_death_percentage;
        }

        public void setClosed_cases_death_percentage(String closed_cases_death_percentage) {
            this.closed_cases_death_percentage = closed_cases_death_percentage;
        }

        public String getActive_cases_mild_percentage() {
            return active_cases_mild_percentage;
        }

        public void setActive_cases_mild_percentage(String active_cases_mild_percentage) {
            this.active_cases_mild_percentage = active_cases_mild_percentage;
        }

        public String getActive_cases_critical_percentage() {
            return active_cases_critical_percentage;
        }

        public void setActive_cases_critical_percentage(String active_cases_critical_percentage) {
            this.active_cases_critical_percentage = active_cases_critical_percentage;
        }

        public String getGeneral_death_rate() {
            return general_death_rate;
        }

        public void setGeneral_death_rate(String general_death_rate) {
            this.general_death_rate = general_death_rate;
        }
    }
}
