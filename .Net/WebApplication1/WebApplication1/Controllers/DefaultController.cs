using Microsoft.AspNetCore.Mvc;

namespace WebApplication1.Controllers
{
    public class DefaultController : Controller
    {
        public IActionResult Index(int? id, int a=30, int b=20, int c=10)
        {
            //if(id == null)
            //  return NotFound();
            ViewBag.id = id;
            ViewBag.a = a;
            ViewBag.b = b;
            ViewBag.c = c;
            return View();
            //return View("ViewName");
        }
    }
}
