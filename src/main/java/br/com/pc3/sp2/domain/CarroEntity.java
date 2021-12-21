package br.com.pc3.sp2.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "carro")
@Table(name = "Carro", schema = "sp2")
public class CarroEntity implements Serializable {
    public static final long serialVersionUID = 7322453248345506341L;
    @Id
    @Length(message = "A placa deve ter exatamente 7 caracteres.", min = 7, max = 7)
    @NotNull(message = "A placa do carro é um campo obrigatório.")
    @Pattern(message = "Por favor, use o modelo Mercosul.", regexp = "[A-Z]{2,3}[0-9]{4}|[A-Z]{3,4}[0-9]{3}|[A-Z0-9]{7}")
    @Column(name = "placa", nullable = false, length = 7)
    private String placa;
    @Basic
    @Column(name = "cor", nullable = true, length = 45)
    private String cor;
    @Basic
    @Column(name = "ano", nullable = true)
    private Integer ano;
    @Basic
    @Column(name = "ano_modelo", nullable = true)
    private Integer anoModelo;
    @Basic
    @Column(name = "marca", nullable = true, length = 45)
    private String marca;
    @Basic
    @Column(name = "modelo", nullable = true, length = 45)
    private String modelo;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "oficina")
    private OficinaEntity oficina;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "cliente")
    private ClienteEntity cliente;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public OficinaEntity getOficina() {
        return oficina;
    }

    public void setOficina(OficinaEntity oficina) {
        this.oficina = oficina;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }
}
