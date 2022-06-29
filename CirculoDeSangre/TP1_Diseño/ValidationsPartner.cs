using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace TP1_Diseño
{
    public class ValidationsPartner
    {
        public static string ValidateName(string name)
        {
            while(!Regex.Match(name, @"^[A-Za-z]{4,8}$|^[A-Za-z]{4,8}\s[A-Za-z]{4,8}$").Success)
            {
                Console.Write("Error en el nombre ingresado.Por favor, ingrese el nombre del socio nuevamente: ");
                name = Console.ReadLine();
            }
            return name;
        }

        public static string ValidateLastname(string lastname)
        {
            while (!Regex.Match(lastname, @"^[A-Za-z]{4,8}$|^[A-Za-z]{4,8}\s[A-Za-z]{4,8}$").Success)
            {
                Console.Write("Error en el apellido ingresado.Por favor, ingrese el apellido del socio nuevamente: ");
                lastname= Console.ReadLine();
            }
            return lastname;
        }

        public static int ValidateDni(string dni)
        {
            while (!Regex.Match(dni, @"^\d{6,8}").Success)
            {
                Console.Write("Error en el DNI ingresado.Por favor, ingrese el DNI del socio nuevamente: ");
                dni = Console.ReadLine();
            }
            return Convert.ToInt32(dni);
        }

        public static string ValidateDateBrith(string dateBrith)
        {
            ValdationsBloodRequest.validateFormatDate(dateBrith);

            DateTime date = DateTime.ParseExact(dateBrith, "dd/mm/yyyy", null);
            while (date > DateTime.Now)
            {
                Console.Write("La fecha ingresada es incorrecta, por favor vuelva a ingresarla(dd/mm/yyyy): ");
                dateBrith = Console.ReadLine();
                ValdationsBloodRequest.validateFormatDate(dateBrith);
                date = DateTime.ParseExact(dateBrith, "dd/mm/yyyy", null);
            }
            string validityDate = date.ToString("dd/mm/yyyy");
            return validityDate;
        }

        public static bool ValidateDisease(string disease)
        {
            while (!Regex.Match(disease, @"^[siSI]{2}$|^[noNO]{2}$").Success)
            {
                Console.Write("Error. Por favor, ingrese nuevamente su respuesta: ");
                disease = Console.ReadLine();
            }
            if (disease == "no" | disease == "NO")
            {
                return false;
            }
            else
            {
                return true;
            }
        }

        public static bool ValidateMedicine(string medicine)
        {
            while (!Regex.Match(medicine, @"^[siSI]{2}$|^[noNO]{2}$").Success)
            {
                Console.Write("Error. Por favor, ingrese nuevamente su respuesta: ");
                medicine = Console.ReadLine();
            }
            if (medicine == "no" | medicine == "NO")
            {
                return false;
            }
            else
            {
                return true;
            }
        }

        public static string ValidateNameMedicine(string nameMedicine)
        {
            while(!Regex.Match(nameMedicine, @"^[A-Za-z]{4,15}$").Success)
            {
                Console.Write("Error. Por favor vuelva a ingresar el nombre de la medicación: ");
                nameMedicine = Console.ReadLine();
            }
            return nameMedicine;
        }

        public static string ValidateAddress(string address)
        {
            while(!Regex.Match(address, @"^[a-zA-Z]{3,15}\s[0-9]+$|^[a-zA-Z]{3,15}\s[a-zA-Z]{3,15}\s[0-9]+$").Success)
            {
                Console.Write("Error.Por favor, vuelva a ingresar la dirección: ");
                address = Console.ReadLine();
            }
            return address;
        }

        public static string ValidateLocation(string location)
        {
            while (!Regex.Match(location, @"^[a-zA-Z]{3,15}$|^[a-zA-Z]{3,15}\s[a-zA-Z]{3,15}$").Success)
            {
                Console.Write("Error en el localidad ingresada.Por favor, ingresela del socio nuevamente: ");
                location = Console.ReadLine();
            }
            return location;
        }

        public static string ValidatePhone(string phone)
        {
            while (!Regex.Match(phone, @"^\d{8,10}").Success)
            {
                Console.Write("Error, recuerde ingresar el numero sin espacios. Por favor, ingrese el telefono del socio nuevamente: ");
                phone = Console.ReadLine();
            }
            return phone;  
        }

        public static string ValidateEmail(string email)
        {
            while (!Regex.Match(email, @"^([\w\.\-]+)@([\w\-]+)((\.(\w){2,3})+)$").Success)
            {
                Console.Write("Error.Por favor, ingrese el email nuevamente: ");
                email = Console.ReadLine(); 
            }
            return email;
        }
    }
}
