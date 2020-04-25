package com.example.egyptcorona;

import com.google.gson.annotations.SerializedName;

public class Api2 {


    /**
     * updated : 1587770293304
     * country : Afghanistan
     * countryInfo : {"_id":4,"iso2":"AF","iso3":"AFG","lat":33,"long":65,"flag":"https://corona.lmao.ninja/assets/img/flags/af.png"}
     * cases : 1351
     * todayCases : 72
     * deaths : 43
     * todayDeaths : 1
     * recovered : 188
     * active : 1120
     * critical : 7
     * casesPerOneMillion : 35
     * deathsPerOneMillion : 1
     * tests : 6422
     * testsPerOneMillion : 165
     * continent : Asia
     */

    private long updated;
    private String country;
    private int cases;
    private int todayCases;
    private int deaths;
    private int todayDeaths;
    private int recovered;
    private int active;
    private int critical;
    private int casesPerOneMillion;
    private int deathsPerOneMillion;
    private int tests;
    private int testsPerOneMillion;
    private String continent;

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getCases() {
        return cases;
    }

    public void setCases(int cases) {
        this.cases = cases;
    }

    public int getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(int todayCases) {
        this.todayCases = todayCases;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(int todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getCritical() {
        return critical;
    }

    public void setCritical(int critical) {
        this.critical = critical;
    }

    public int getCasesPerOneMillion() {
        return casesPerOneMillion;
    }

    public void setCasesPerOneMillion(int casesPerOneMillion) {
        this.casesPerOneMillion = casesPerOneMillion;
    }

    public int getDeathsPerOneMillion() {
        return deathsPerOneMillion;
    }

    public void setDeathsPerOneMillion(int deathsPerOneMillion) {
        this.deathsPerOneMillion = deathsPerOneMillion;
    }

    public int getTests() {
        return tests;
    }

    public void setTests(int tests) {
        this.tests = tests;
    }

    public int getTestsPerOneMillion() {
        return testsPerOneMillion;
    }

    public void setTestsPerOneMillion(int testsPerOneMillion) {
        this.testsPerOneMillion = testsPerOneMillion;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public static class CountryInfoBean {
        /**
         * _id : 4
         * iso2 : AF
         * iso3 : AFG
         * lat : 33
         * long : 65
         * flag : https://corona.lmao.ninja/assets/img/flags/af.png
         */

        private int _id;
        private String iso2;
        private String iso3;
        private int lat;
        @SerializedName("long")
        private int longX;
        private String flag;

        public int get_id() {
            return _id;
        }

        public void set_id(int _id) {
            this._id = _id;
        }

        public String getIso2() {
            return iso2;
        }

        public void setIso2(String iso2) {
            this.iso2 = iso2;
        }

        public String getIso3() {
            return iso3;
        }

        public void setIso3(String iso3) {
            this.iso3 = iso3;
        }

        public int getLat() {
            return lat;
        }

        public void setLat(int lat) {
            this.lat = lat;
        }

        public int getLongX() {
            return longX;
        }

        public void setLongX(int longX) {
            this.longX = longX;
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }
    }
}
