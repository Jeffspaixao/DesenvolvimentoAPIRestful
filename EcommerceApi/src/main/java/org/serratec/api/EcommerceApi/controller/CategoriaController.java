package org.serratec.api.EcommerceApi.controller;

import java.util.List;

import org.serratec.api.EcommerceApi.DTO.CategoriaDTO;
import org.serratec.api.EcommerceApi.exception.CategoriaException;
import org.serratec.api.EcommerceApi.model.Categoria;
import org.serratec.api.EcommerceApi.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;
	
	@PostMapping("/salvar")
	public ResponseEntity<Void> salvar(@RequestBody CategoriaDTO categoriaDTO) throws CategoriaException{
		categoriaService.salvar(categoriaDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/buscar/{idCategoria}")
	public ResponseEntity<Categoria> buscarPorId(@PathVariable Integer idCategoria) throws CategoriaException {
		categoriaService.buscarPorId(idCategoria);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/atualizar/{idCategoria}") 
    public ResponseEntity<Void> atualizar(@PathVariable Integer idCategoria,@RequestBody CategoriaDTO categoriaDTO) throws CategoriaException{
        categoriaService.atualizar(idCategoria, categoriaDTO);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{idCategoria}")
	public ResponseEntity<Void> delete(@PathVariable Integer idCategoria) {
		categoriaService.delete(idCategoria);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/lista")
	public ResponseEntity<List<Categoria>> listaTodos(){
		categoriaService.todosCategorias();
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	@PostMapping("/salvar-lista")
    public ResponseEntity<Void> salvarLista(@RequestBody List<CategoriaDTO> listaCategoriaDTO){
        categoriaService.salvarListaCategoria(listaCategoriaDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
