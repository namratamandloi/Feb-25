// TicketController.cs
using Microsoft.AspNetCore.Mvc;
using OnlineTicketSystem.Data;
using OnlineTicketSystem.Models;

namespace OnlineTicketSystem.Controllers
{
    public class TicketController : Controller
    {
        private readonly ApplicationDbContext _context;

        public TicketController(ApplicationDbContext context)
        {
            _context = context;
        }

        public IActionResult Index()
        {
            return View(_context.Tickets.ToList());
        }

        public IActionResult Create()
        {
            return View();
        }

        [HttpPost]
        public IActionResult Create(Ticket ticket)
        {
            if (ModelState.IsValid)
            {
                _context.Tickets.Add(ticket);
                _context.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(ticket);
        }

        public IActionResult Edit(int id)
        {
            var ticket = _context.Tickets.Find(id);
            return View(ticket);
        }

        [HttpPost]
        public IActionResult Edit(Ticket ticket)
        {
            _context.Tickets.Update(ticket);
            _context.SaveChanges();
            return RedirectToAction("Index");
        }

        public IActionResult Delete(int id)
        {
            var ticket = _context.Tickets.Find(id);
            return View(ticket);
        }

        [HttpPost, ActionName("Delete")]
        public IActionResult DeleteConfirmed(int id)
        {
            var ticket = _context.Tickets.Find(id);
            _context.Tickets.Remove(ticket);
            _context.SaveChanges();
            return RedirectToAction("Index");
        }
    }
}
