package com.gouveia.bancobuilder.controller;

import com.gouveia.bancobuilder.Usuario;
import com.gouveia.bancobuilder.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class indexController {
    @Autowired
    UsuarioRepository usuarioRepository;
    private int counterId = 1;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ModelAndView dadosUsuario(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("dadosUsuario");
        Usuario usuario = usuarioRepository.findById(id);
        modelAndView.addObject("usuario", usuario);
        return modelAndView;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String formContato(@RequestParam Map<String, String> payload){
        Usuario user;

        if(payload.get("casado").equals("true")){
            user = new Usuario.UsuarioBuilder()
                    .DeNome(payload.get("nome"))
                    .comONomeDaMae(payload.get("nomemae"))
                    .comONomeDoPai(payload.get("nomepai"))
                    .moraNoEndereco(payload.get("endereco"))
                    .ComOcpf(payload.get("cpf"))
                    .possuiOEmail(payload.get("email"))
                    .comIdade(Integer.parseInt(payload.get("idade")))
                    .casadoCom(payload.get("nomeconjuge"))
                    .casado()
                    .id(counterId)
                    .criarUsuario();
        }else {
            user = new Usuario.UsuarioBuilder()
                    .DeNome(payload.get("nome"))
                    .comONomeDaMae(payload.get("nomemae"))
                    .comONomeDoPai(payload.get("nomepai"))
                    .moraNoEndereco(payload.get("endereco"))
                    .ComOcpf(payload.get("cpf"))
                    .possuiOEmail(payload.get("email"))
                    .comIdade(Integer.parseInt(payload.get("idade")))
                    .id(counterId)
                    .criarUsuario();
        }
        usuarioRepository.save(user);
        counterId++;

        int id = user.getId();

        return "redirect:/"+id;
    }
}
