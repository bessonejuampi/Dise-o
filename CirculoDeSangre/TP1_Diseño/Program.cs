using System;
using FluentValidation;
using FluentValidation.Results;

namespace TP1_Diseño
{
    class program
    {
        public static List<Partner> listPartners = new List<Partner>();
        public static List<BloodRequest> listBloodRequest = new List<BloodRequest>();
        static void Main(string[] args)
        {
            Inicialization();
            starMenu();
        }
        static void starMenu()
        {
            Console.WriteLine(" Elija la opración que desea ejecutar: ");
            Console.WriteLine(" -------------------------------------");
            Console.WriteLine(" 1.Registrar un nuevo socio ");
            Console.WriteLine(" 2.Mostrar datos de un socio ");
            Console.WriteLine(" 3.Cargar una solicitud de donacion y buscar donantes ");
            Console.WriteLine(" -------------------------------------");
            Console.Write("Operacion: ");
            int option = Convert.ToInt32(Console.ReadLine());
            switch (option)
            {
                case 1:
                    option = 1;
                    Partner newpartner = new Partner();
                    newpartner = newpartner.registerPartner();
                    listPartners.Add(newpartner);
                Console.WriteLine("¡Nuevo socio registrado!");
                starMenu();
                    break;

                case 2:
                    option = 2;
                    break;

                case 3:
                    option = 3;
                    BloodRequest bloodRequest = new BloodRequest();
                    bloodRequest = bloodRequest.StartRequest();
                    bloodRequest.AssignTurns(listPartners, bloodRequest);
                    starMenu();
                    

                    break;

            }   
        
        
        }

        static void Inicialization()
        {
            Partner partner1 = new Partner()
            {
                namePartner = "Matias",
                lastNamePartner = "Trivisonno",
                dni = 42880304,
                category = "ACTIVO",
                disease = false,
                medicine = false,
                nameMedicine = null,
                dateBrith = "17/05/2001",
                address = "chubut 444",
                location = "San Francisco",
                phone = "3514456314",
                email = "tirvi@gmail.com",
                bloodGroup = "A",
                bloodFactor = "+",
                donations = new List<DateTime>()
            };
            string dateDonation = "17/04/2020";
            DateTime date = DateTime.ParseExact(dateDonation, "dd/mm/yyyy", null);
            partner1.donations.Add(date);
            listPartners.Add(partner1);

            Partner partner2 = new Partner()
            {
                namePartner = "Lautaro",
                lastNamePartner = "Gomez",
                dni = 43456789,
                category = "ACTIVO",
                disease = false,
                medicine = false,
                nameMedicine = null,
                dateBrith = "23/08/2001",
                address = "chubut 444",
                location = "San Francisco",
                phone = "3547456123",
                email = "lauti@gmail.com",
                bloodGroup = "A",
                bloodFactor = "-",
                donations = new List<DateTime>()
            };
            dateDonation = "17/04/2022";
            date = DateTime.ParseExact(dateDonation, "dd/mm/yyyy", null);
            partner2.donations.Add(date);
            dateDonation = "17/05/2022";
            date = DateTime.ParseExact(dateDonation, "dd/mm/yyyy", null);
            partner2.donations.Add(date);
            listPartners.Add(partner2);

            Partner partner3 = new Partner()
            {
                namePartner = "Melina",
                lastNamePartner = "Bertea",
                dni = 43227644,
                category = "ACTIVO",
                disease = true,
                medicine = false,
                nameMedicine = null,
                dateBrith = "03/04/2001",
                address = "castelli 3123",
                location = "San Francisco",
                phone = "3564358304",
                email = "melina@gmail.com",
                bloodGroup = "CERO",
                bloodFactor = "+",
                donations = new List<DateTime>()
            };
            listPartners.Add(partner3);
        } 
    }
        
}

    

