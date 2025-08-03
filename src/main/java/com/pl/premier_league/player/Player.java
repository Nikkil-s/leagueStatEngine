package com.pl.premier_league.player;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Player {

    @Id
    @Column(name = "name", unique = true)
    private String name;
    private String nation;
    private String position;
    private Integer age;
    private Integer mp;
    private Integer stats;
    private Double min;
    private Double dls;
    private Double ast;
    private Double pk;
    private Double crdy;
    private Double crdr;
    private Double xg;
    private Double xag;
    private String team;

    // ✅ No-args constructor (required by Hibernate)
    public Player() {
    }

    // ✅ Constructor with only name
    public Player(String name) {
        this.name = name;
    }

    // ✅ Full constructor
    public Player(String name, String nation, String position, Integer age, Integer mp, Integer stats,
                  Double min, Double dls, Double ast, Double pk, Double crdy, Double crdr,
                  Double xg, Double xag, String team) {
        this.name = name;
        this.nation = nation;
        this.position = position;
        this.age = age;
        this.mp = mp;
        this.stats = stats;
        this.min = min;
        this.dls = dls;
        this.ast = ast;
        this.pk = pk;
        this.crdy = crdy;
        this.crdr = crdr;
        this.xg = xg;
        this.xag = xag;
        this.team = team;
    }

    // ✅ Getters and Setters

    public String getName() {
        return name;
    }

    public String getNation() {
        return nation;
    }

    public String getPosition() {
        return position;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getMp() {
        return mp;
    }

    public Integer getStats() {
        return stats;
    }

    public Double getMin() {
        return min;
    }

    public Double getDls() {
        return dls;
    }

    public Double getAst() {
        return ast;
    }

    public Double getPk() {
        return pk;
    }

    public Double getCrdy() {
        return crdy;
    }

    public Double getCrdr() {
        return crdr;
    }

    public Double getXg() {
        return xg;
    }

    public Double getXag() {
        return xag;
    }

    public String getTeam() {
        return team;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setMp(Integer mp) {
        this.mp = mp;
    }

    public void setStats(Integer stats) {
        this.stats = stats;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public void setDls(Double dls) {
        this.dls = dls;
    }

    public void setAst(Double ast) {
        this.ast = ast;
    }

    public void setPk(Double pk) {
        this.pk = pk;
    }

    public void setCrdy(Double crdy) {
        this.crdy = crdy;
    }

    public void setCrdr(Double crdr) {
        this.crdr = crdr;
    }

    public void setXg(Double xg) {
        this.xg = xg;
    }

    public void setXag(Double xag) {
        this.xag = xag;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
