package br.com.pc3.sp2.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "oficina")
@Table(name = "Oficina", schema = "sp2")
public class OficinaEntity implements Serializable {
    public static final long serialVersionUID = 8173727476199831261L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @PositiveOrZero(message = "O código não pode ser negativo.")
    @NotNull(message = "O código da oficina é um campo obrigatório.")
    @Column(name = "codigo", nullable = false)
    private Integer codigo;
    @Basic
    @Column(name = "nome", nullable = true, length = 45)
    private String nome;
    @Basic
    @Column(name = "especialidade", nullable = true, length = 45)
    private String especialidade;
    @Basic
    @Column(name = "endereco", nullable = true, length = 45)
    private String endereco;

    @JsonManagedReference
    @OneToMany(mappedBy = "oficina")
    private List<CarroEntity> carros = new ArrayList<>();

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<CarroEntity> getCarros() {
        return carros;
    }

    public void setCarros(List<CarroEntity> carros) {
        this.carros = carros;
    }

    public OficinaEntity(Integer codigo, String nome, String especialidade, String endereco, List<CarroEntity> carros) {
        this.codigo = codigo;
        this.nome = nome;
        this.especialidade = especialidade;
        this.endereco = endereco;
        this.carros = carros;
    }

    public OficinaEntity(Integer codigo, String nome, String especialidade, String endereco) {
        this.codigo = codigo;
        this.nome = nome;
        this.especialidade = especialidade;
        this.endereco = endereco;
    }

    public OficinaEntity(Integer codigo) {
        this.codigo = codigo;
    }

    public OficinaEntity() {
    }

    @Override
    public String toString() {
        return "OficinaEntity{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", especialidade='" + especialidade + '\'' +
                ", endereco='" + endereco + '\'' +
                ", carros=" + carros +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OficinaEntity that)) return false;

        if (!getCodigo().equals(that.getCodigo())) return false;
        if (getNome() != null ? !getNome().equals(that.getNome()) : that.getNome() != null) return false;
        if (getEspecialidade() != null ? !getEspecialidade().equals(that.getEspecialidade()) : that.getEspecialidade() != null)
            return false;
        if (getEndereco() != null ? !getEndereco().equals(that.getEndereco()) : that.getEndereco() != null)
            return false;
        return getCarros() != null ? getCarros().equals(that.getCarros()) : that.getCarros() == null;
    }

    @Override
    public int hashCode() {
        int result = getCodigo().hashCode();
        result = 31 * result + (getNome() != null ? getNome().hashCode() : 0);
        result = 31 * result + (getEspecialidade() != null ? getEspecialidade().hashCode() : 0);
        result = 31 * result + (getEndereco() != null ? getEndereco().hashCode() : 0);
        result = 31 * result + (getCarros() != null ? getCarros().hashCode() : 0);
        return result;
    }
}
