package com.loscampesinos.loscampesinos;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class losCampesinosController {
    
    @GetMapping("/productos")
    public String goToProductos(Model model){
        model.addAttribute("titulo", "Productos");
        return "productos";
    }

    @GetMapping("/ayuda")
    public String goToAyuda(Model model){
        model.addAttribute("titulo", "Estas En La Sección De Ayuda");
        return "ayuda";
    }

    @GetMapping("/carrito")
    public String goToCarrito(Model model){
        model.addAttribute("titulo", "Estas En La Sección De Carrito");
        return "carrito";
    }

    @GetMapping("/verduras")
    public String goToInicioVerduras(Model model){
        model.addAttribute("titulo", "Verduras");
        return "productos";
    }

    @GetMapping("/frutas")
    public String goToInicioFrutas(Model model){
        model.addAttribute("titulo", "Frutas");
        return "productos";
    }

    @GetMapping("/granos")
    public String goToInicioGranos(Model model){
        model.addAttribute("titulo", "Granos");
        return "productos";
    }
    

}
