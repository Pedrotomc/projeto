package br.edu.famper.projeto.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "tbl_projeto")
@Data
public class Projeto {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private Long id;

        @Column(name = "nome", length = 150)
        private String nome;

        @Column(name = "descricao", length = 150)
        private String descricao;

        @Column(name = "datainicio", length = 150)
        private Date dataInicio;

        @Column(name = "datafim", length = 150)
        private Date dataFim;
}
