package org.clp.xslt.demo.dest.oop;

import javax.persistence.*;
@Entity
@Table(name = "push_data")
public class PushData {   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer oid;
    private String oname;
    
    public PushData() {
    }
    public PushData(Integer oid, String oname) {
    	this.oid = oid;
        this.oname = oname;
    }
    public Integer getId() {
        return oid;
    }
    public void setId(Integer oid) {
        this.oid = oid;
    }
    public String getName() {
        return oname;
    }
    public void setName(String oname) {
        this.oname = oname;
    }

    @Override
    public String toString() {
        return "PushData{" +
        		"  oid='" + oid + '\'' +
                ", oname='" + oname + '\'' +
                '}';
    }
}
