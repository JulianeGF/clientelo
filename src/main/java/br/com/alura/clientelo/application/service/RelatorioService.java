package br.com.alura.clientelo.application.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.alura.clientelo.domain.report.Report;

public class RelatorioService {

    private static final Logger logger = LoggerFactory.getLogger(RelatorioService.class);

    public void exibirRelatorio(Report report) {
        report.export();
    }
}
