package co.com.bancodebogota.dtos;


public class Bbtelefonoi
{
    private String extension;

    private String bbpurposetel;

    private String countrycode;

    private String bbtelefono;

    public String getExtension ()
    {
        return extension;
    }

    public void setExtension (String extension)
    {
        this.extension = extension;
    }

    public String getBbpurposetel ()
    {
        return bbpurposetel;
    }

    public void setBbpurposetel (String bbpurposetel)
    {
        this.bbpurposetel = bbpurposetel;
    }

    public String getCountrycode ()
    {
        return countrycode;
    }

    public void setCountrycode (String countrycode)
    {
        this.countrycode = countrycode;
    }

    public String getBbtelefono ()
    {
        return bbtelefono;
    }

    public void setBbtelefono (String bbtelefono)
    {
        this.bbtelefono = bbtelefono;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [extension = "+extension+", bbpurposetel = "+bbpurposetel+", countrycode = "+countrycode+", bbtelefono = "+bbtelefono+"]";
    }
}
