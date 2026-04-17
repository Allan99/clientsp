package com.devsuperior.clientsp.dto;

import com.devsuperior.clientsp.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class ClientDTO {

    private Long id;
    @Size(min = 3, max = 20, message = "The name size needs to be between 3 and 20 characters")
    @NotBlank(message = "Field cannot be blank")
    private String name;
    @Size(min = 11, max = 11, message = "Invalid CPF number: needs to have 11 digits")
    @NotBlank
    private String cpf;
    @Positive(message = "The income must be a positive value")
    private Double income;
    private LocalDate birthDate;
    private Integer children;

    public ClientDTO(){

    }

    public ClientDTO(Long id, String name, String cpf, Double income,
                     LocalDate birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }
}
