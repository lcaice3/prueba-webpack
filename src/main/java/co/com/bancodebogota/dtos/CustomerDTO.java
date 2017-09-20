package co.com.bancodebogota.dtos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import co.com.bancodebogota.transformations.ToFrontend;
import co.com.bancodebogota.utils.MaskRemover;
import co.com.bancodebogota.utils.MaskRemoverImpl;

public class CustomerDTO
{
    private String bbletrascore;

    private String bbscorecomporta;

    private String sex;

    private String bbbloqueo;

    private String bbcodpaquete;

    private String aavlringbrumes;

    private String aafecvinculacion;

    private List<Bbdireccioni> bbdireccioni;

    private String lastname;

    private String aalugarexpdoc;

    private String nameparent;

    private String bbbbs;

    private String bbpurposetel;

    private String aavlregresomes;

    private String messagetext;

    private String aatipovivienda;

    private String birthdate;

    private String bbcitytel;

    private String regiondescr;

    private String bbportalavalnet;

    private String aatipovinculo;

    private String educationlvl;

    private String bbregioncliente;

    private String secondlastname;

    private String aacodciiu;

    private String emailaddr;

    private String aavlrpasivos;

    private String bbcaa;

    private String middlename;

    private String firstname;

    private String bbnacionalidad;

    private String aadeclararenta;

    private List<Bbtelefonoi> bbtelefonoi;

    private String marstatus;

    private String aafecdocumento;

    private String bbpurposedir;

    private String bbreportecostos;

    private String bbsegcomercial;

    private String aagrupoeconomico;

    private String effdt;

    private String messagenbr;

    private String aacodocupacion;

    private String aavlractivos;
    
    private String aaestrato;
    
    private String bbenvioextracto;
    
    private String companyname;
    
    private String hiredt;
    
    private String jobcode;
    
    private String aanroperscargo;
    
    private String bbnroperscargo2;
    
    
    
    
    
    
    
    
    
    
    
    

    public String getAanroperscargo() {
		return aanroperscargo;
	}

	public void setAanroperscargo(String aanroperscargo) {
		this.aanroperscargo = aanroperscargo;
	}

	public String getBbnroperscargo2() {
		return bbnroperscargo2;
	}

	public void setBbnroperscargo2(String bbnroperscargo2) {
		this.bbnroperscargo2 = bbnroperscargo2;
	}

	public String getHiredt() {
		return hiredt;
	}

	public void setHiredt(String hiredt) {
		this.hiredt = hiredt;
	}

	public String getJobcode() {
		return jobcode;
	}

	public void setJobcode(String jobcode) {
		this.jobcode = jobcode;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getBbenvioextracto() {
		return bbenvioextracto;
	}

	public void setBbenvioextracto(String bbenvioextracto) {
		this.bbenvioextracto = bbenvioextracto;
	}

	public String getAaestrato() {
		return aaestrato;
	}

	public void setAaestrato(String aaestrato) {
		this.aaestrato = aaestrato;
	}

	public String getBbletrascore ()
    {
        return bbletrascore;
    }

    public void setBbletrascore (String bbletrascore)
    {
        this.bbletrascore = bbletrascore;
    }

    public String getBbscorecomporta ()
    {
        return bbscorecomporta;
    }

    public void setBbscorecomporta (String bbscorecomporta)
    {
        this.bbscorecomporta = bbscorecomporta;
    }

    public String getSex ()
    {
        return sex;
    }

    public void setSex (String sex)
    {
        this.sex = sex;
    }

    public String getBbbloqueo ()
    {
        return bbbloqueo;
    }

    public void setBbbloqueo (String bbbloqueo)
    {
        this.bbbloqueo = bbbloqueo;
    }

    public String getBbcodpaquete ()
    {
        return bbcodpaquete;
    }

    public void setBbcodpaquete (String bbcodpaquete)
    {
        this.bbcodpaquete = bbcodpaquete;
    }

    public String getAavlringbrumes ()
    {
        return aavlringbrumes;
    }

    public void setAavlringbrumes (String aavlringbrumes)
    {
        this.aavlringbrumes = aavlringbrumes;
    }

    public String getAafecvinculacion ()
    {
        return aafecvinculacion;
    }

    public void setAafecvinculacion (String aafecvinculacion)
    {
        this.aafecvinculacion = aafecvinculacion;
    }

    

    public List<Bbdireccioni> getBbdireccioni() {
		return bbdireccioni;
	}

	public void setBbdireccioni(List<Bbdireccioni> bbdireccioni) {
		this.bbdireccioni = bbdireccioni;
	}

	public String getLastname ()
    {
        return lastname;
    }

    public void setLastname (String lastname)
    {
        this.lastname = lastname;
    }

    public String getAalugarexpdoc ()
    {
        return aalugarexpdoc;
    }

    public void setAalugarexpdoc (String aalugarexpdoc)
    {
        this.aalugarexpdoc = aalugarexpdoc;
    }

    public String getNameparent ()
    {
        return nameparent;
    }

    public void setNameparent (String nameparent)
    {
        this.nameparent = nameparent;
    }

    public String getBbbbs ()
    {
        return bbbbs;
    }

    public void setBbbbs (String bbbbs)
    {
        this.bbbbs = bbbbs;
    }

    public String getBbpurposetel ()
    {
        return bbpurposetel;
    }

    public void setBbpurposetel (String bbpurposetel)
    {
        this.bbpurposetel = bbpurposetel;
    }

    public String getAavlregresomes ()
    {
        return aavlregresomes;
    }

    public void setAavlregresomes (String aavlregresomes)
    {
        this.aavlregresomes = aavlregresomes;
    }

    public String getMessagetext ()
    {
        return messagetext;
    }

    public void setMessagetext (String messagetext)
    {
        this.messagetext = messagetext;
    }

    public String getAatipovivienda ()
    {
        return aatipovivienda;
    }

    public void setAatipovivienda (String aatipovivienda)
    {
        this.aatipovivienda = aatipovivienda;
    }

    public String getBirthdate ()
    {
        return birthdate;
    }

    public void setBirthdate (String birthdate)
    {
        this.birthdate = birthdate;
    }

    public String getBbcitytel ()
    {
        return bbcitytel;
    }

    public void setBbcitytel (String bbcitytel)
    {
        this.bbcitytel = bbcitytel;
    }

    public String getRegiondescr ()
    {
        return regiondescr;
    }

    public void setRegiondescr (String regiondescr)
    {
        this.regiondescr = regiondescr;
    }

    public String getBbportalavalnet ()
    {
        return bbportalavalnet;
    }

    public void setBbportalavalnet (String bbportalavalnet)
    {
        this.bbportalavalnet = bbportalavalnet;
    }

    public String getAatipovinculo ()
    {
        return aatipovinculo;
    }

    public void setAatipovinculo (String aatipovinculo)
    {
        this.aatipovinculo = aatipovinculo;
    }

    public String getEducationlvl ()
    {
        return educationlvl;
    }

    public void setEducationlvl (String educationlvl)
    {
        this.educationlvl = educationlvl;
    }

    public String getBbregioncliente ()
    {
        return bbregioncliente;
    }

    public void setBbregioncliente (String bbregioncliente)
    {
        this.bbregioncliente = bbregioncliente;
    }

    public String getSecondlastname ()
    {
        return secondlastname;
    }

    public void setSecondlastname (String secondlastname)
    {
        this.secondlastname = secondlastname;
    }

    public String getAacodciiu ()
    {
        return aacodciiu;
    }

    public void setAacodciiu (String aacodciiu)
    {
        this.aacodciiu = aacodciiu;
    }

    public String getEmailaddr ()
    {
        return emailaddr;
    }

    public void setEmailaddr (String emailaddr)
    {
        this.emailaddr = emailaddr;
    }

    public String getAavlrpasivos ()
    {
        return aavlrpasivos;
    }

    public void setAavlrpasivos (String aavlrpasivos)
    {
        this.aavlrpasivos = aavlrpasivos;
    }

    public String getBbcaa ()
    {
        return bbcaa;
    }

    public void setBbcaa (String bbcaa)
    {
        this.bbcaa = bbcaa;
    }

    public String getMiddlename ()
    {
        return middlename;
    }

    public void setMiddlename (String middlename)
    {
        this.middlename = middlename;
    }

    public String getFirstname ()
    {
        return firstname;
    }

    public void setFirstname (String firstname)
    {
        this.firstname = firstname;
    }

    public String getBbnacionalidad ()
    {
        return bbnacionalidad;
    }

    public void setBbnacionalidad (String bbnacionalidad)
    {
        this.bbnacionalidad = bbnacionalidad;
    }

    public String getAadeclararenta ()
    {
        return aadeclararenta;
    }

    public void setAadeclararenta (String aadeclararenta)
    {
        this.aadeclararenta = aadeclararenta;
    }



    public List<Bbtelefonoi> getBbtelefonoi() {
		return bbtelefonoi;
	}

	public void setBbtelefonoi(List<Bbtelefonoi> bbtelefonoi) {
		this.bbtelefonoi = bbtelefonoi;
	}

	public String getMarstatus ()
    {
        return marstatus;
    }

    public void setMarstatus (String marstatus)
    {
        this.marstatus = marstatus;
    }

    public String getAafecdocumento ()
    {
        return aafecdocumento;
    }

    public void setAafecdocumento (String aafecdocumento)
    {
        this.aafecdocumento = aafecdocumento;
    }

    public String getBbpurposedir ()
    {
        return bbpurposedir;
    }

    public void setBbpurposedir (String bbpurposedir)
    {
        this.bbpurposedir = bbpurposedir;
    }

    public String getBbreportecostos ()
    {
        return bbreportecostos;
    }

    public void setBbreportecostos (String bbreportecostos)
    {
        this.bbreportecostos = bbreportecostos;
    }

    public String getBbsegcomercial ()
    {
        return bbsegcomercial;
    }

    public void setBbsegcomercial (String bbsegcomercial)
    {
        this.bbsegcomercial = bbsegcomercial;
    }

    public String getAagrupoeconomico ()
    {
        return aagrupoeconomico;
    }

    public void setAagrupoeconomico (String aagrupoeconomico)
    {
        this.aagrupoeconomico = aagrupoeconomico;
    }

    public String getEffdt ()
    {
        return effdt;
    }

    public void setEffdt (String effdt)
    {
        this.effdt = effdt;
    }

    public String getMessagenbr ()
    {
        return messagenbr;
    }

    public void setMessagenbr (String messagenbr)
    {
        this.messagenbr = messagenbr;
    }

    public String getAacodocupacion ()
    {
        return aacodocupacion;
    }

    public void setAacodocupacion (String aacodocupacion)
    {
        this.aacodocupacion = aacodocupacion;
    }

    public String getAavlractivos ()
    {
        return aavlractivos;
    }

    public void setAavlractivos (String aavlractivos)
    {
        this.aavlractivos = aavlractivos;
    }

    @Override
    public String toString()
    {
        return "CustomerDTO [" +
            " bbletrascore: " + bbletrascore +
            " bbscorecomporta: " + bbscorecomporta +
            " sex: " + sex +
            " bbbloqueo: " + bbbloqueo +
            " bbcodpaquete: " + bbcodpaquete +
            " aavlringbrumes: " + aavlringbrumes +
            " aafecvinculacion: " + aafecvinculacion +
            " bbdireccioni: " + bbdireccioni +
            " lastname: " + lastname +
            " aalugarexpdoc: " + aalugarexpdoc +
            " nameparent: " + nameparent +
            " bbbbs: " + bbbbs +
            " bbpurposetel: " + bbpurposetel +
            " aavlregresomes: " + aavlregresomes +
            " messagetext: " + messagetext +
            " aatipovivienda: " + aatipovivienda +
            " birthdate: " + birthdate +
            " bbcitytel: " + bbcitytel +
            " regiondescr: " + regiondescr +
            " bbportalavalnet: " + bbportalavalnet +
            " aatipovinculo: " + aatipovinculo +
            " educationlvl: " + educationlvl +
            " bbregioncliente: " + bbregioncliente +
            " secondlastname: " + secondlastname +
            " aacodciiu: " + aacodciiu +
            " emailaddr: " + emailaddr +
            " aavlrpasivos: " + aavlrpasivos +
            " bbcaa: " + bbcaa +
            " middlename: " + middlename +
            " firstname: " + firstname +
            " bbnacionalidad: " + bbnacionalidad +
            " aadeclararenta: " + aadeclararenta +
            " bbtelefonoi: " + bbtelefonoi +
            " marstatus: " + marstatus +
            " aafecdocumento: " + aafecdocumento +
            " bbpurposedir: " + bbpurposedir +
            " bbreportecostos: " + bbreportecostos +
            " bbsegcomercial: " + bbsegcomercial +
            " aagrupoeconomico: " + aagrupoeconomico +
            " effdt: " + effdt +
            " messagenbr: " + messagenbr +
            " aacodocupacion: " + aacodocupacion +
            " aavlractivos: " + aavlractivos + "]";
    }

    // used to send message to frontend
	public Map<String, String> serialize() {
		MaskRemover maskRemover = new MaskRemoverImpl();
		HashMap<String, String> map = new HashMap<>();
		map.put("firstName", ToFrontend.asName(getFirstname()));
		map.put("middleName", ToFrontend.asName(getMiddlename()));
		map.put("lastName", ToFrontend.asName(getLastname()));
		map.put("secondLastName", ToFrontend.asName(getSecondlastname()));
		map.put("birthDate", maskRemover.dateFromBackendToFront(getBirthdate()));
		map.put("expeditionDate", maskRemover.dateFromBackendToFront(getAafecdocumento()));
		map.put("expeditionCityId", getAalugarexpdoc());
		map.put("email", getEmailaddr());
		if (!getBbtelefonoi().isEmpty()) {
			List<Bbtelefonoi> cellStream = getBbtelefonoi().stream().filter(p->p.getBbpurposetel().equalsIgnoreCase("12")).collect(Collectors.toList());
				map.put("cellphone",!cellStream.isEmpty()?cellStream.get(0).getBbtelefono():"");
		}
		return map;
	}
}