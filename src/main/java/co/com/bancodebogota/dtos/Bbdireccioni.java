package co.com.bancodebogota.dtos;

public class Bbdireccioni
{
    private String address1;

    private String bbpurposedir;

    public String getAddress1 ()
    {
        return address1;
    }

    public void setAddress1 (String address1)
    {
        this.address1 = address1;
    }

    public String getBbpurposedir ()
    {
        return bbpurposedir;
    }

    public void setBbpurposedir (String bbpurposedir)
    {
        this.bbpurposedir = bbpurposedir;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [address1 = "+address1+", bbpurposedir = "+bbpurposedir + "]";
    }
}