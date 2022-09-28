package com.loscampesinos.loscampesinos.model.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.loscampesinos.loscampesinos.model.entity.producto;

// @Repository
public interface ProductoRepository extends JpaRepository<producto, Integer>{

    // List<producto> findAll();

    List<producto> findAllByTipo(String tipo);
}
