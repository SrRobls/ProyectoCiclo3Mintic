package com.loscampesinos.loscampesinos;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class losCampesinosController {
    
    @GetMapping("/inicio")
    public String goToInicio(Model model){
        return "inicio";
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

}
