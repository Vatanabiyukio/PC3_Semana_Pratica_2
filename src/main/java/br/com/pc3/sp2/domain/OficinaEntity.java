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
}
