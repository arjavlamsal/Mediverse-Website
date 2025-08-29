package com.hospital.Mediverse.Website.model;

public enum Role {
    ADMIN,
    DOCTOR,
    PATIENT;

    public String getAuthority() {
        return "ROLE_" + this.name();
    }
}
