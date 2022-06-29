using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace TP1_Diseño
{
    public class BloodRequest
    {
        public int amountDonors { get; set; }
        public string dateLimit { get; set; }
        public string bloodGroup { get; set; }
        public string bloodFactor { get; set; }


        public BloodRequest StartRequest()
        {
            BloodRequest bloodRequest = new BloodRequest();
            Console.WriteLine("Ingrese la cantidad de donadores que necesita: ");
            string amountDonors = Console.ReadLine();
            amountDonors = ValdationsBloodRequest.validateAmountDonors(amountDonors);
            bloodRequest.amountDonors = Convert.ToInt32(amountDonors);

            Console.WriteLine("Ingrese la fecha limite para la donación(dd/mm/yyyy): ");
            string dateLimit = Console.ReadLine();
            dateLimit = ValdationsBloodRequest.validateDateBoodRequest(dateLimit);
            bloodRequest.dateLimit = dateLimit;

            Console.WriteLine("Ingrese el grupo sanguineo(A,B,AB,0): ");
            string bloodGroup = Console.ReadLine();
            bloodRequest.bloodGroup = ValdationsBloodRequest.validateBloodGroup(bloodGroup);

            Console.WriteLine("Ingrese el factor sanguineo(+,-): ");
            string bloodFactor = Console.ReadLine();
            bloodRequest.bloodFactor = ValdationsBloodRequest.validateBloodFactor(bloodFactor);


            return bloodRequest;
        }

        public void AssignTurns(List<Partner> partners, BloodRequest bloodRequest)
        {
            List<Partner> _avaliblesPartners = new List<Partner>();
            List<Partner> _selectedPartners = new List<Partner>();
            int contDonations = 0;
            foreach (var partner in partners)
            {
                contDonations = 0;
                foreach (var donation in partner.donations)
                {
                    if (donation.Year == DateTime.Now.Year)
                    {
                        contDonations++;
                    }
                }
                if (contDonations < 2 && partner.category == "ACTIVO")
                {
                    _avaliblesPartners.Add(partner);
                }
            }

            for (int i = 0; i < bloodRequest.amountDonors; i++)
            {
                _selectedPartners.Add(_avaliblesPartners[i]);
            }

            Console.WriteLine("los socios selecionados son: ");
            foreach (var partner in _selectedPartners)
            {
                Console.WriteLine("nombre: " + partner.namePartner+ " dni: " +partner.dni);
            }
            foreach (var partner in _selectedPartners)
            {
                Console.WriteLine("Seleccione una de las fechas disponibles para el socio " + partner.dni);
                DateTime dateLimit = Convert.ToDateTime(bloodRequest.dateLimit);
                int option =ShowDonationsDate(dateLimit);
                Console.Write("Opcion: ");
                int chosenDate= Convert.ToInt32(Console.ReadLine());
                while(chosenDate > option | chosenDate < 0)
                {
                    Console.Write("La opcion elegida no existe.Por favor, eliga una opcion valida: ");
                    option = ShowDonationsDate(dateLimit);
                    chosenDate = Convert.ToInt32(Console.ReadLine());
                }
                Console.WriteLine("!Se ha registrado la fecha para la donacion¡");
            }

        }

        public int ShowDonationsDate(DateTime dateLimit)
        {
            DateTime dateTemp = DateTime.Now.Date;
            int option = 0;
            while (dateTemp < dateLimit)
            {
                option++;
                Console.WriteLine("Opción " + option + ": " + dateTemp.Date);
                dateTemp = dateTemp.AddDays(3); // se concidera que hay turnos cada 3 dias 
            }
            return option;
        }
    }
}
