package com.udigo.hotel.admin.dto;

public class AcmDTO {
    private Integer acmId;
    private String acmName;
    private String acmLocation;
    private String acmAddress;
    private Integer acmPrice;
    private Integer maxGuest;
    private String acmPhone;
    private String acmInfo;
    private String acmPhoto1;
    private String acmPhoto2;
    private String acmPhoto3;
    private String acmPhoto4;
    private String acmPhoto5;

    public AcmDTO() {}

    public AcmDTO(Integer acmId, String acmName, String acmLocation, String acmAddress, Integer acmPrice,
                  Integer maxGuest, String acmPhone, String acmInfo, String acmPhoto1, String acmPhoto2,
                  String acmPhoto3, String acmPhoto4, String acmPhoto5) {
        this.acmId = acmId;
        this.acmName = acmName;
        this.acmLocation = acmLocation;
        this.acmAddress = acmAddress;
        this.acmPrice = acmPrice;
        this.maxGuest = maxGuest;
        this.acmPhone = acmPhone;
        this.acmInfo = acmInfo;
        this.acmPhoto1 = acmPhoto1;
        this.acmPhoto2 = acmPhoto2;
        this.acmPhoto3 = acmPhoto3;
        this.acmPhoto4 = acmPhoto4;
        this.acmPhoto5 = acmPhoto5;
    }

    public Integer getAcmId() {
        return acmId;
    }

    public void setAcmId(Integer acmId) {
        this.acmId = acmId;
    }

    public String getAcmName() {
        return acmName;
    }

    public void setAcmName(String acmName) {
        this.acmName = acmName;
    }

    public String getAcmLocation() {
        return acmLocation;
    }

    public void setAcmLocation(String acmLocation) {
        this.acmLocation = acmLocation;
    }

    public String getAcmAddress() {
        return acmAddress;
    }

    public void setAcmAddress(String acmAddress) {
        this.acmAddress = acmAddress;
    }

    public Integer getAcmPrice() {
        return acmPrice;
    }

    public void setAcmPrice(Integer acmPrice) {
        this.acmPrice = acmPrice;
    }

    public Integer getMaxGuest() {
        return maxGuest;
    }

    public void setMaxGuest(Integer maxGuest) {
        this.maxGuest = maxGuest;
    }

    public String getAcmPhone() {
        return acmPhone;
    }

    public void setAcmPhone(String acmPhone) {
        this.acmPhone = acmPhone;
    }

    public String getAcmInfo() {
        return acmInfo;
    }

    public void setAcmInfo(String acmInfo) {
        this.acmInfo = acmInfo;
    }

    public String getAcmPhoto1() {
        return acmPhoto1;
    }

    public void setAcmPhoto1(String acmPhoto1) {
        this.acmPhoto1 = acmPhoto1;
    }

    public String getAcmPhoto2() {
        return acmPhoto2;
    }

    public void setAcmPhoto2(String acmPhoto2) {
        this.acmPhoto2 = acmPhoto2;
    }

    public String getAcmPhoto3() {
        return acmPhoto3;
    }

    public void setAcmPhoto3(String acmPhoto3) {
        this.acmPhoto3 = acmPhoto3;
    }

    public String getAcmPhoto4() {
        return acmPhoto4;
    }

    public void setAcmPhoto4(String acmPhoto4) {
        this.acmPhoto4 = acmPhoto4;
    }

    public String getAcmPhoto5() {
        return acmPhoto5;
    }

    public void setAcmPhoto5(String acmPhoto5) {
        this.acmPhoto5 = acmPhoto5;
    }

    // 정적 Builder 메소드 추가
    public static AcmDTOBuilder builder() {
        return new AcmDTOBuilder();
    }

    // 정적 Builder 클래스
    public static class AcmDTOBuilder {
        private Integer acmId;
        private String acmName;
        private String acmLocation;
        private String acmAddress;
        private Integer acmPrice;
        private Integer maxGuest;
        private String acmPhone;
        private String acmInfo;
        private String acmPhoto1;
        private String acmPhoto2;
        private String acmPhoto3;
        private String acmPhoto4;
        private String acmPhoto5;

        public AcmDTOBuilder acmId(Integer acmId) {
            this.acmId = acmId;
            return this;
        }

        public AcmDTOBuilder acmName(String acmName) {
            this.acmName = acmName;
            return this;
        }

        public AcmDTOBuilder acmLocation(String acmLocation) {
            this.acmLocation = acmLocation;
            return this;
        }

        public AcmDTOBuilder acmAddress(String acmAddress) {
            this.acmAddress = acmAddress;
            return this;
        }

        public AcmDTOBuilder acmPrice(Integer acmPrice) {
            this.acmPrice = acmPrice;
            return this;
        }

        public AcmDTOBuilder maxGuest(Integer maxGuest) {
            this.maxGuest = maxGuest;
            return this;
        }

        public AcmDTOBuilder acmPhone(String acmPhone) {
            this.acmPhone = acmPhone;
            return this;
        }

        public AcmDTOBuilder acmInfo(String acmInfo) {
            this.acmInfo = acmInfo;
            return this;
        }

        public AcmDTOBuilder acmPhoto1(String acmPhoto1) {
            this.acmPhoto1 = acmPhoto1;
            return this;
        }

        public AcmDTOBuilder acmPhoto2(String acmPhoto2) {
            this.acmPhoto2 = acmPhoto2;
            return this;
        }

        public AcmDTOBuilder acmPhoto3(String acmPhoto3) {
            this.acmPhoto3 = acmPhoto3;
            return this;
        }

        public AcmDTOBuilder acmPhoto4(String acmPhoto4) {
            this.acmPhoto4 = acmPhoto4;
            return this;
        }

        public AcmDTOBuilder acmPhoto5(String acmPhoto5) {
            this.acmPhoto5 = acmPhoto5;
            return this;
        }

        public AcmDTO build() {
            return new AcmDTO(acmId, acmName, acmLocation, acmAddress, acmPrice, maxGuest, acmPhone,
                    acmInfo, acmPhoto1, acmPhoto2, acmPhoto3, acmPhoto4, acmPhoto5);
        }
    }
}