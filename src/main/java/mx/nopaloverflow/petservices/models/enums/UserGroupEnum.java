package mx.nopaloverflow.petservices.models.enums;

public enum UserGroupEnum {
    ADMIN("admin"),
    PET_COMPANY_ADMIN("pet-company-admin"),
    PET_COMPANY_WORKER("pet-company-worker"),
    ADOPTER("pet-adopter");

    private String code;

    UserGroupEnum(final String code) {
        this.code = code;
    }
}
