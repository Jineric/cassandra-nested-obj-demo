//package com.jineric.cassandranestedobj.model;
//
//import org.springframework.data.cassandra.core.mapping.PrimaryKey;
//import org.springframework.data.cassandra.core.mapping.Table;
//
//import javax.validation.constraints.NotBlank;
//import java.util.Map;
//
//@Table("Heroes")
//public class Hero {
//
//    @PrimaryKey
//    @NotBlank
//    private String name;
//
//    @NotBlank
//    private Map<String,String> stats;
//
//    public Hero() {
//
//    }
//
//    public Hero(@NotBlank String name, @NotBlank Map<String, String> stats) {
//        this.name = name;
//        this.stats = stats;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Map<String, String> getStats() {
//        return stats;
//    }
//
//    public void setStats(Map<String, String> stats) {
//        this.stats = stats;
//    }
//}
