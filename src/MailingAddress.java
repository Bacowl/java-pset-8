import java.lang.reflect.Array;

public class MailingAddress {
    public MailingAddress(String primaryStreet, String secondaryStreet, String city, String state, String zipCode) {
    }
    private String city;
    private String formattedAddress;
    private String postalCode;
    private String state;
    private String primaryStreet;
    private String secondaryStreet;
    private String allStates = " AK AL AR AZ CA CO CT DE FL GA HI IA ID IL IN KS KY LA MA MD ME MI MN MO MS MT NC ND NE NH NJ NM NV NY OH OK OR PA RI SC SD TN TX UT VA VT WA WI WV WY ";
    MailingAddress mailingAddress;

    public String getCity() {

        return city;
    }
    public String getFormattedAddress() {
        String formattedAddress = "";
        if (getPrimaryStreet() == null && getSecondaryStreet() == null && getPostalCode() == null && getCity() == null && getState() == null) {
            return "N/A";
        } else {
            if (getPrimaryStreet() != null) {
                formattedAddress += " " + getPrimaryStreet();
            }
            if (getSecondaryStreet() != null) {
                formattedAddress += " " + getSecondaryStreet();
            }
            if (getCity() != null) {
                formattedAddress += " " + getCity();
            }
            if (getState() != null) {
                formattedAddress += " " + getState();
            }
            if (getPostalCode() != null) {
                formattedAddress += " " + getPostalCode();
            }
        }
        return formattedAddress;
    }
    public String getPostalCode() {

        return postalCode;
    }
    public String getPrimaryStreet() {

        return primaryStreet;
    }
    public String getSecondaryStreet() {

        return secondaryStreet;
    }
    public String getState() {

        return state;
    }
    public void setCity(java.lang.String city) {

        this.city = city;
    }
    public void setPostalCode(java.lang.String postalCode) {

        this.postalCode = postalCode;
    }
    public void setPrimaryStreet(java.lang.String primaryStreet) {

        this.primaryStreet = primaryStreet;
    }
    public void setSecondaryStreet(java.lang.String secondaryStreet) {

        this.secondaryStreet = secondaryStreet;
    }
    public void setState(java.lang.String state) {

        this.state = state;
    }
    public String validateCity() {

        if (city == null) {
            return null;
        } else if (city.length() > 0) {
            return city;
        }
        return null;
    }
    public String validatePostalCode() {

        if (String.valueOf(postalCode).length() == 5) {
            return postalCode;
        } else {
            return null;
        }
    }
    public String validateState() {
        if (allStates.indexOf(" " + state.toLowerCase() + " " ) != -1) {
            return state;
        } else {
            return null;
        }
    }
    public String validateStreet() {
        if (primaryStreet == null) {
            return null;
        } else if (primaryStreet.length() > 0) {
            return primaryStreet;
        }
        return null;
    }

}
