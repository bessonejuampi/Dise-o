namespace Mediator
{
    class program
    {
        static void Main(string[] args)
        {
            User user1 = new User();

            Console.WriteLine("Hola ¿Quieres enviar un mensaje?");
            string response = Console.ReadLine();
            while (response == "SI")
            {
                user1.sendMessage();
                Console.WriteLine("¿Deseas enviar otro mensaje?");
                response = Console.ReadLine();
            }
            
        }
        
    }
}