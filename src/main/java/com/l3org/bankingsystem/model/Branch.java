package com.l3org.bankingsystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "branch")
public class Branch {

    @Id
    @Column(name = "ifscCode")
    private String ifscCode;

    @Column(name = "branchName", nullable = false)
    private String branchName;

    @Column(name = "branchAddress", nullable = false)
    private String branchAddress;

    public Branch() {
    }

	public Branch(String ifscCode, String branchName, String branchAddress) {
		super();
		this.ifscCode = ifscCode;
		this.branchName = branchName;
		this.branchAddress = branchAddress;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}
    
}
