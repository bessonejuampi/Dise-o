using System.Collections;
using System.ComponentModel;


namespace TP1_Diseño;

public class Partner
{
    public string namePartner { get; set;}
    public string lastNamePartner { get; set; }
    public int dni { get; set; }
    public string category { get; set; }
    public bool disease { get; set; }
    public bool medicine { get; set; }
    public string nameMedicine { get; set; }
    public string dateBrith { get; set; }
    public string address { get; set; }
    public string location { get; set; }
    public string phone { get; set; }
    public string email { get; set; }
    public string bloodGroup { get; set; }
    public string bloodFactor { get; set; }
    public List<DateTime> donations { get; set; }
    

    void getData()
    {
        Console.WriteLine("Nombre: " + namePartner + "Apellido: " + lastNamePartner + "DNI: " + dni);
    }

    public Partner registerPartner()
    {
        Partner partner = new Partner();
        
        Console.WriteLine("Ingrese el nombre del socio: ");
        string namePartner = Console.ReadLine();
        partner.namePartner = ValidationsPartner.ValidateName(namePartner);
        
        Console.WriteLine("Ingrese el apellido del socio: ");
        string lastNamePartner = Console.ReadLine();
        partner.lastNamePartner = ValidationsPartner.ValidateLastname(lastNamePartner);
        
        Console.WriteLine("Ingrese el dni del socio: ");
        string dni = Console.ReadLine();
        partner.dni = ValidationsPartner.ValidateDni(dni);

        Console.WriteLine("Ingrese el la fecha de namcimiento del socio(dd/MM/yyyy): ");
        string dateBrith = Console.ReadLine();
        partner.dateBrith = ValidationsPartner.ValidateDateBrith(dateBrith);

        if (calculateAge(partner.dateBrith) > 18 && calculateAge(partner.dateBrith) < 57)
        {
            partner.category = "ACTIVO";
        }
        else
        {
            partner.category = "PASIVO";
        }
        
        Console.WriteLine("¿Padece alguna enferedad cronica?(SI, NO): ");
        string disease = Console.ReadLine();
        partner.disease = ValidationsPartner.ValidateDisease(disease);
        if (!partner.disease)
        {
            partner.category = "ACTIVO";    
        }
        
        Console.WriteLine("¿Toma alguna medicina de forma permanente?(SI, NO): ");
        string medicine = Console.ReadLine();
        partner.medicine = ValidationsPartner.ValidateMedicine(medicine);
        if (partner.medicine)
        {
            Console.WriteLine("Ingrese el nombre de la medicina: ");
            string nameMedicine = Console.ReadLine();
            partner.nameMedicine = ValidationsPartner.ValidateNameMedicine(nameMedicine);
        }

        Console.WriteLine("Ingrese la direccion del socio: ");
        string address = Console.ReadLine();
        partner.address = ValidationsPartner.ValidateAddress(address);
        
        Console.WriteLine("Ingrese la localidad del socio: ");
        string location = Console.ReadLine();
        partner.location = ValidationsPartner.ValidateLocation(location);
        
        Console.WriteLine("Ingrese el telefono del socio: ");
        string phone = Console.ReadLine();
        partner.phone = ValidationsPartner.ValidatePhone(phone);
        
        Console.WriteLine("Ingrese el emial del socio: ");
        string email = Console.ReadLine();
        partner.email = ValidationsPartner.ValidateEmail(email);
        
        Console.WriteLine("Ingrese el grupo sanguineo del socio: ");
        string bloodGroup = Console.ReadLine();
        partner.bloodGroup = ValdationsBloodRequest.validateBloodGroup(bloodGroup);

        Console.WriteLine("Ingrese el factor sanguineo del socio: ");
        string bloodFactor = Console.ReadLine();
        partner.bloodFactor = ValdationsBloodRequest.validateBloodFactor(bloodFactor);

        return partner;
    }
    public  double calculateAge(string dateBrithString)
    {
        DateTime dateBrithDate = DateTime.Now;
        dateBrithDate = DateTime.ParseExact(dateBrithString, "dd/MM/yyyy", null);
        
        DateTime dateCurret = DateTime.Now;

        TimeSpan difference = dateCurret - dateBrithDate;
        double days = difference.TotalDays;
        double years = Math.Floor(days / 365);
        return years; 
    }
    
    public Partner UpdateCategory(Partner partner)
    { 
        double years= calculateAge(partner.dateBrith);
        if (years > 18 && years < 57)
        {
            partner.category = "ACTIVO";
        }
        else
        {
            partner.category = "PASIVO";
        }
        return partner;
    }

    

}



