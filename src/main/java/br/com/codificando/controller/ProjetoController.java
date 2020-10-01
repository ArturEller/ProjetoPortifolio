package br.com.codificando.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.codificando.model.Projeto;
import br.com.codificando.repository.FuncionarioRepository;
import br.com.codificando.repository.ProjetoRepository;

@Controller
public class ProjetoController {

	@Autowired
	ProjetoRepository projetoRepository;
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	@GetMapping("/projeto/list")
	public String listProjeto(Model model) {
		
		model.addAttribute("projetos", projetoRepository.findAll(Sort.by("dataInicio")));
		return "projeto/list";
	}
	
	@GetMapping("/projeto/add")
	public String addProjeto(Model model) {
		
		model.addAttribute("projeto", new Projeto());
		model.addAttribute("gerentes", funcionarioRepository.findAllByCargo("Gerente"));
		model.addAttribute("funcionarios", funcionarioRepository.findAllByCargoNot("Gerente"));
		return "projeto/add";
	}
	
	@PostMapping("/projeto/save")
	public String saveProjeto(Projeto projeto) {
		try {
			projetoRepository.save(projeto);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		return "redirect:/projeto/view/" + projeto.getId();
	}
	
	@GetMapping("/projeto/view/{id}")
	public String viewProjeto(@PathVariable long id, Model model) {
		model.addAttribute("projeto", projetoRepository.findById(id));
		
		return "/projeto/view";
	}
	
	
	@GetMapping("/projeto/edit/{id}")
	public String editProjeto(@PathVariable long id, Model model) {
		model.addAttribute("projeto", projetoRepository.findById(id));
		model.addAttribute("gerentes", funcionarioRepository.findAllByCargo("Gerente"));
		model.addAttribute("funcionarios", funcionarioRepository.findAllByCargoNot("Gerente"));
		
		return "projeto/edit";
	}
	
	@GetMapping("/projeto/delete/{id}")
	public String deleteProjeto(@PathVariable long id) {
		try {
			projetoRepository.deleteById(id);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		return "redirect:/projeto/list";
	}
	
	
	
	
	
	
	
	
	
}
