using Microsoft.EntityFrameworkCore;
using OnlineTicketSystem.Models;

namespace OnlineTicketSystem.Data
{
    public class ApplicationDbContext : DbContext
    {
        public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options) : base(options) { }

        public DbSet<Ticket> Tickets { get; set; }
    }
}
