package br.com.pc3.sp2.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "cliente")
@Table(name = "Cliente", schema = "sp2")
public class ClienteEntity implements Serializable {
    public static final long serialVersionUID = -4046340826881594880L;
    @Id
    @Length(message = "O número de caracteres não é compatível com um CPF.", min = 11, max = 14)
    @Pattern(message = "O CPF precisa ser válido.", regexp = "([0-9]{2}[.]?[0-9]{3}[.]?[0-9]{3}[.]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[.]?[0-9]{3}[.]?[0-9]{3}[-]?[0-9]{2})")
    @NotNull(message = "O CPF do cliente é um campo obrigatório.")
    @Column(name = "cpf", nullable = false, length = 14)
    private String cpf;
    @Basic
    @Column(name = "nome", nullable = true, length = 45)
    private String nome;
    @Basic
    @Column(name = "data_nascimento", nullable = true)
    private LocalDate dataNascimento;

    @JsonManagedReference
    @OneToMany(mappedBy = "cliente")
    private List<CarroEntity> carros = new ArrayList<>();

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<CarroEntity> getCarros() {
        return carros;
    }

    public void setCarros(List<CarroEntity> carros) {
        this.carros = carros;
    }

    public ClienteEntity(String cpf, String nome, LocalDate dataNascimento, List<CarroEntity> carros) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.carros = carros;
    }

    public ClienteEntity(String cpf, String nome, LocalDate dataNascimento) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public ClienteEntity(String cpf) {
        this.cpf = cpf;
    }

    public ClienteEntity() {
    }

    @Override
    public String toString() {
        return "ClienteEntity{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", carros=" + carros +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClienteEntity that)) return false;

        if (!getCpf().equals(that.getCpf())) return false;
        if (getNome() != null ? !getNome().equals(that.getNome()) : that.getNome() != null) return false;
        if (getDataNascimento() != null ? !getDataNascimento().equals(that.getDataNascimento()) : that.getDataNascimento() != null)
            return false;
        return getCarros() != null ? getCarros().equals(that.getCarros()) : that.getCarros() == null;
    }

    @Override
    public int hashCode() {
        int result = getCpf().hashCode();
        result = 31 * result + (getNome() != null ? getNome().hashCode() : 0);
        result = 31 * result + (getDataNascimento() != null ? getDataNascimento().hashCode() : 0);
        result = 31 * result + (getCarros() != null ? getCarros().hashCode() : 0);
        return result;
    }
}
