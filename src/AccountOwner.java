public class AccountOwner {

    private String firstName;
    private String lastName;
    private String emailAddress;
    private long phoneNumber;
    private String salutation;
    MailingAddress mailingAddress;

    public AccountOwner(String salutation, String firstName, String lastName, String emailAddress, long phoneNumber, MailingAddress mailingAddress) {
    }

    public String getEmailAddress() {
        return emailAddress;
    }
    public String getFirstName() {
        return firstName;

    }
    public String getFormattedPhoneNumber() {

        return "(" + String.valueOf(phoneNumber).substring(0, 3) + ") " + String.valueOf(phoneNumber).substring(3, 7) + "-" + String.valueOf(phoneNumber).substring(7, 11);
    }
    public String getLastName() {
        return lastName;
    }
    public MailingAddress getMailingAddress() {

        return mailingAddress;
    }
    public String getName(int format) {
            String name = "";
            if (getSalutation() == null) {
                name = getFirstName() + " " + getLastName();
            }
            else if (format == 2) {
                name = getSalutation() + ". " + getLastName();
            }
            else if (format == 3) {
                name = getLastName() + ", " + getFirstName();
            }
            else {
                name = getFirstName() + " " + getLastName();
            }
            return name;
    }
    public long getPhoneNumber() {
        return phoneNumber;

    }
    public String getSalutation() {
        return salutation;

    }
    public void setEmailAddress(java.lang.String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public void setFirstName(java.lang.String firstName) {
    this.firstName = firstName;

    }
    public void setLastName(java.lang.String lastName) {
        this.lastName = lastName;

    }
    public void setMailingAddress(MailingAddress mailingAddress) {
        this.mailingAddress = mailingAddress;

    }
    public void setPhoneNumber(long phoneNumber) {
   this.phoneNumber = phoneNumber;

    }
    public void setSalutation(java.lang.String salutation) {
        this.salutation = salutation;

    }
    public String validateEmailAddress(String emailAddress) {
        if (emailAddress == null) {
            return null;
        }
        int atSignCount = 0;
        int periodCount = 0;
        for (int i = 0; i < emailAddress.length(); i++) {
            if (emailAddress.charAt(i) == '@') atSignCount++;
            if (emailAddress.charAt(i) == '.') periodCount++;
        }
        if (emailAddress.length() >= 7 && emailAddress.length() <= 254 && atSignCount == 1 && periodCount == 1 && emailAddress.charAt(emailAddress.length() - 4) == '.' && emailAddress.charAt(0) != '@' && emailAddress.indexOf(".") - emailAddress.indexOf("@") == 2) {
            return emailAddress;
        }
        else {
            return null;
        }
    }
    public long validatePhoneNumber(long phoneNumber) {
        if (String.valueOf(phoneNumber).length() == 10) {
            return phoneNumber;
        } else {
            return 0L;
        }

    }
    public String validateSalutation(java.lang.String Salutation) {
        if (salutation == null) {
            return null;
        } else if (salutation.length() > 0) {
            return salutation;
        }

        return null;
    }

}