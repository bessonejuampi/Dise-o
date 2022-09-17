using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Mediator
{
    internal class Operator : IMediator
    {
        public void Notify(User destiny, string message)
        {
            destiny.receiveMessage(message);
        }
    }
}
