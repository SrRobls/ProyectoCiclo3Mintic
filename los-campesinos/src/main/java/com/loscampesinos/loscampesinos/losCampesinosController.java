package com.loscampesinos.loscampesinos;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.loscampesinos.loscampesinos.controller.dto.ProductoDto;


@Controller
public class losCampesinosController {

    private final List<ProductoDto> productos = Arrays.asList(
        new ProductoDto("1", "Platanos", 2000.0, 
        "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Excepturi asperiores quis unde fuga fugit quae accusantium deserunt nesciunt consequatur. Ad dolore perferendis unde quaerat nesciunt! Et error reprehenderit quisquam unde!",
        "https://th.bing.com/th/id/R.c56bc40476e312a259480b67d95688eb?rik=BrillB7IJisw8g&pid=ImgRaw&r=0", "2"),
        new ProductoDto("2", "Tomates", 2000.0, 
        "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Excepturi asperiores quis unde fuga fugit quae accusantium deserunt nesciunt consequatur. Ad dolore perferendis unde quaerat nesciunt! Et error reprehenderit quisquam unde!",
        "https://th.bing.com/th/id/R.03c950bde87ff3e4f79f99097d173c4a?rik=ysRrPxzFxfBtng&pid=ImgRaw&r=0", "1"),
        new ProductoDto("3", "Lentejas", 2000.0, 
        "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Excepturi asperiores quis unde fuga fugit quae accusantium deserunt nesciunt consequatur. Ad dolore perferendis unde quaerat nesciunt! Et error reprehenderit quisquam unde!",
        "https://th.bing.com/th/id/R.1776dc38c2ce7e33009a28d0f78f2570?rik=gvkECWBXSUl9GA&riu=http%3a%2f%2fwww.bioenciclopedia.com%2fwp-content%2fuploads%2f2016%2f07%2flentejas.jpg&ehk=Pj4GW9JzDrj5P6SVCTYLHvVQCiCqejlbglVHG7pczY8%3d&risl=&pid=ImgRaw&r=0&sres=1&sresct=1", "3"),
        new ProductoDto("4", "Papas", 1000.0, 
        "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Excepturi asperiores quis unde fuga fugit quae accusantium deserunt nesciunt consequatur. Ad dolore perferendis unde quaerat nesciunt! Et error reprehenderit quisquam unde!",
        "https://th.bing.com/th/id/OIP.c_IqoET2rga0SiEzlrgyRgHaE9?pid=ImgDet&rs=1", "1"),
        new ProductoDto("4", "Garbanzos", 3000.0, 
        "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Excepturi asperiores quis unde fuga fugit quae accusantium deserunt nesciunt consequatur. Ad dolore perferendis unde quaerat nesciunt! Et error reprehenderit quisquam unde!",
        "https://th.bing.com/th/id/R.449d015f6d405cf3a68ad26c7dd588f9?rik=S1yJbKjFdQTytQ&riu=http%3a%2f%2fwww.gastronomicspain.com%2fblog%2fwp-content%2fuploads%2f2017%2f03%2fgarbanzos.gif&ehk=rLDBD9bXUa8eXOGUv%2f4JBSlePNh0fDoDTxe7CgrPlJI%3d&risl=&pid=ImgRaw&r=0", "3")
    );
    
    @GetMapping("/productos")
    public String goToProductos(Model model){
        model.addAttribute("titulo", "Productos");
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
        var productosVerduras = productos.stream()
            .filter(p -> p.getId_Tipo() == "1")
            .collect(Collectors.toList());

        model.addAttribute("productos", productosVerduras);
        return "productos";
    }

    @GetMapping("/frutas")
    public String goToInicioFrutas(Model model){
        model.addAttribute("titulo", "Frutas");
        var productosVerduras = productos.stream()
            .filter(p -> p.getId_Tipo() == "2")
            .collect(Collectors.toList());
            model.addAttribute("productos", productosVerduras);
        return "productos";
    }

    @GetMapping("/granos")
    public String goToInicioGranos(Model model){
        model.addAttribute("titulo", "Granos");
        var productosVerduras = productos.stream()
            .filter(p -> p.getId_Tipo() == "3")
            .collect(Collectors.toList());
            model.addAttribute("productos", productosVerduras);
        return "productos";
    }
}
