using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace TP1_Diseño
{
    public class ValdationsBloodRequest
    {
        public static string validateDateBoodRequest(string dateLimit)
        {
            //validateFormatDate(dateLimit);
            //DateTime date = Convert.ToDateTime(dateLimit, "dd/mm/yyyy", null);
            DateTime date = Convert.ToDateTime(validateFormatDate(dateLimit));
            DateTime dateNow = DateTime.Now.Date;
            while (date.Date < dateNow)
            {
                Console.Write("La fecha ingresada es incorrecta, por favor vuelva a ingresarla(dd/mm/yyyy): ");
                dateLimit = Console.ReadLine();
                date = Convert.ToDateTime(validateFormatDate(dateLimit));
            }
            string validityDate = Convert.ToString(date);
            return validityDate;
        }

        public static string validateFormatDate(string date)
        {
            while (!Regex.Match(date, @"^\d{2}\/\d{2}\/\d{4}$").Success)
            {
                Console.Write("Ingrese el formato correcto para la fecha(dd/mm/yyyy): ");
                date = Console.ReadLine();
            }

            return date;
        }

        public static string validateAmountDonors(string amountDonors)
        {
            while (!Regex.Match(amountDonors, @"^[1-9]$").Success)
            {
                Console.WriteLine("Error, por favor vuelva a ingresar la cantidad de donantes necesarios: ");
                amountDonors = Console.ReadLine();
            }
            return amountDonors;
        }

        public static string validateBloodGroup(string bloodGroup)
        {
            while (!Regex.Match(bloodGroup, @"^[aA]{1}$|^[bB]{1}$|^[abAB]{2}$|^[ceroCERO]{4}$|^[0]$").Success)
            {
                Console.Write("Error, por favor ingrese nuevamente el grupo sanguinieo: ");
                bloodGroup = Console.ReadLine();
            }
            return bloodGroup;
        }

        public static string validateBloodFactor(string bloodFactor)
        {
            while (!Regex.Match(bloodFactor, @"^[+-]{1}$").Success)
            {
                Console.Write("Error, por favor ingrese nuevamente el factor sanguinieo: ");
                bloodFactor = Console.ReadLine();
            }
            return bloodFactor;
        }


    }
}
