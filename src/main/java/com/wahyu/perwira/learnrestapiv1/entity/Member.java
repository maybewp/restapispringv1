package com.wahyu.perwira.learnrestapiv1.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "Fullname is Required")
    @Column(name = "fullname")
    private String fullname;
    @NotNull(message =  "Stage Name is Required")
    @Column(name = "stage_name")
    private String stageName;
    @NotNull(message = "Birthday is Required")
    @Column(name = "birthday")
    private LocalDate birthday;
    @Column(name = "groups_id")
    private int groupsId;

    public Member() {
    }

    public Member(String fullname, String stageName, LocalDate birthday, int groupsId) {
        this.fullname = fullname;
        this.stageName = stageName;
        this.birthday = birthday;
        this.groupsId = groupsId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getGroupsId() {
        return groupsId;
    }

    public void setGroupsId(int groupsId) {
        this.groupsId = groupsId;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", stageName='" + stageName + '\'' +
                ", birthday=" + birthday +
                ", groupsId=" + groupsId +
                '}';
    }
}
