using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Mediator
{
    internal class User 
    {
        public string id { get; set; }
        public string message { get; set; }

        public void sendMessage()
        {
            User destiny = new User();

            Console.WriteLine("Ingrese el ID de destino: ");
            destiny.id = Console.ReadLine();
            Console.WriteLine("Ingrese el Mensaje: ");
            string message = Console.ReadLine();

            Operator @operator = new Operator();
            @operator.Notify(destiny, message);
         }

        public void receiveMessage(string message)
        {
            Console.WriteLine("-------------------------------");
            Console.WriteLine("¡Hola! Usuario  " + this.id);
            Console.WriteLine("¡Tienes un mensaje!");
            Console.WriteLine("El mensaje es: " + message);
            Console.WriteLine("-------------------------------");
        }
    }
}
