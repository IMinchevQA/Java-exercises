package Ex04_Telephony;


public class Smartphone implements Call, Browse {
    private String[] phoneNumbers;
    private String[] sites;

    public Smartphone (String[] phoneNumbers, String[] sites) {
        this.setPhoneNumbers(phoneNumbers);
        this.setSites(sites);
    }


    public String[] getPhoneNumbers() {
        return this.phoneNumbers;
    }

    private void setPhoneNumbers(String[] phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String[] getSites() {
        return this.sites;
    }

    private void setSites(String[] sites) {
        this.sites = sites;
    }
}
