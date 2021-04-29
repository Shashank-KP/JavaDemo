package org.clp.xslt.demo.source.adms;

import javax.persistence.*;
@Entity
@Table(name = "pull_data")
public class PullData {   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    
    public PullData() {
    }
    public PullData(Integer id, String name) {
    	this.id = id;
        this.name = name;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PullData{" +
        		"  id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
