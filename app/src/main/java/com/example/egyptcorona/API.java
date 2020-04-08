package com.example.egyptcorona;

import com.google.gson.annotations.SerializedName;

public class API {


    /**
     * country : USA
     * countryInfo : {"_id":840,"iso2":"US","iso3":"USA","lat":38,"long":-97,"flag":"https://raw.githubusercontent.com/NovelCOVID/API/master/assets/flags/us.png"}
     * updated : 1586359294021
     * cases : 404056
     * todayCases : 3721
     * deaths : 12988
     * todayDeaths : 147
     * recovered : 21815
     * active : 369253
     * critical : 9200
     * casesPerOneMillion : 1221
     * deathsPerOneMillion : 39
     * tests : 2107442
     * testsPerOneMillion : 636
     */

    private String country;
    private CountryInfoBean countryInfo;
    private long updated;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public CountryInfoBean getCountryInfo() {
        return countryInfo;
    }

    public void setCountryInfo(CountryInfoBean countryInfo) {
        this.countryInfo = countryInfo;
    }

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
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

    public static class CountryInfoBean {
        /**
         * _id : 840
         * iso2 : US
         * iso3 : USA
         * lat : 38
         * long : -97
         * flag : https://raw.githubusercontent.com/NovelCOVID/API/master/assets/flags/us.png
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
