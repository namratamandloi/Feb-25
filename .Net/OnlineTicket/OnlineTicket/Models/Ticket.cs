using System;
using System.ComponentModel.DataAnnotations;

namespace OnlineTicketSystem.Models
{
    public class Ticket
    {
        public int Id { get; set; }

        [Required]
        public string CustomerName { get; set; }

        [Required]
        public string EventName { get; set; }

        [Required]
        public DateTime BookingDate { get; set; }

        [Range(1, 10)]
        public int NumberOfTickets { get; set; }

        public string Status { get; set; }
    }
}
