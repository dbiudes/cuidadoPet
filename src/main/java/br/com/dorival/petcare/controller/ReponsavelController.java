package br.com.dorival.petcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.dorival.petcare.persistence.entity.Responsavel;
import br.com.dorival.petcare.service.ResponsavelService;
//import br.com.dorival.utilitarios.service.EmailService; //vide POM = <artifactId>Utilitarios_SB</artifactId>

@Controller
public class ReponsavelController {
	
	
	@Autowired
	private ResponsavelService service;
	
	@RequestMapping("listaPets")
	public String listaResponsaveis(Model model){

	    model.addAttribute("responsaveis", service.obterTodos());

	    return "listaPets";
	}

	@RequestMapping(value= "salvar", method = RequestMethod.POST)
	public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email, @RequestParam("telefone") String telefone, Model model ) {

		service.salvar(new Responsavel(nome, email, telefone));
		
		//vide POM = <artifactId>Utilitarios_SB</artifactId>
		//new EmailService().enviar(nome, email);
		
		model.addAttribute("responsaveis", service.obterTodos());

		return "listaPets";
		
	}
	
	@RequestMapping(value="excluir", method = RequestMethod.DELETE)
	public String excluir(Long idResponsavel) {

		//Responsavel responsavel = repository.findById(idResponsavel);
		//repository.delete(responsavel);

		return "listaPets";
	}
	
	//public void obterConvidadoPor(String nome){
	//	repository.findByNome(nome);
	//}
	
}
