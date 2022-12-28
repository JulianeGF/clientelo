package br.com.alura.clientelo.application.controller;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AleatorioController {

    @GetMapping("/aW52YWxpZGEgcmVsYXTDs3JpbyBkZSB2ZW5kYXM")
    @ResponseBody
    @CacheEvict(value = "listaDeVendas", allEntries = true)
    public ResponseEntity<?> invalidaCache() {
        return ResponseEntity.ok().build();
    }
}
