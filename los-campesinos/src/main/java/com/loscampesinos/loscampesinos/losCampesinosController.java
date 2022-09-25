package com.loscampesinos.loscampesinos;

import java.lang.annotation.Inherited;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.loscampesinos.loscampesinos.service.ProductoServie;



@Controller
public class losCampesinosController {

    private ProductoServie productoService;

    
    
    public losCampesinosController(ProductoServie productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/productos")
    public String goToProductos(Model model){
        model.addAttribute("titulo", "Productos");
        var productos = this.productoService.getProductos();

        model.addAttribute("productos", productos);
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

        var productosVerduras = this.productoService.getProductosPorTipo("1");

        model.addAttribute("productos", productosVerduras);
        model.addAttribute("activadoVerduras", true);
        model.addAttribute("mensaje", "No Hay Productos De Este Tipo.");
        return "productos";
    }

    @GetMapping("/frutas")
    public String goToInicioFrutas(Model model){
        model.addAttribute("titulo", "Frutas");

        var productosFrutas = this.productoService.getProductosPorTipo("2");

            model.addAttribute("productos", productosFrutas);
            model.addAttribute("activadoFrutas", true);
            model.addAttribute("mensaje", "No Hay Productos De Este Tipo.");
        return "productos";
    }

    @GetMapping("/granos")
    public String goToInicioGranos(Model model){
        model.addAttribute("titulo", "Granos");

        var productosGranos = this.productoService.getProductosPorTipo("3");

            model.addAttribute("productos", productosGranos);
            model.addAttribute("activadoGranos", true);
            model.addAttribute("mensaje", "No Hay Productos De Este Tipo.");
        return "productos";
    }
    
    @GetMapping("/registro")
    public String goToRegistro(Model model){
        return "registro";
    }
}
