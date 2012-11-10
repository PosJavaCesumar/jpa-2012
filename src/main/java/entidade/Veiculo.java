package entidade;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class Veiculo implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    
    @Version
    Integer version;
    
    @Column(length=60)
    private String modelo;
    
    @Column(length=8)
    private Placa placa;
    
    @ManyToOne
    @JoinColumn(name="fornecedor_fk")
    private Fornecedor fornecedor;
    
    @ManyToMany(mappedBy="veiculos")
    private List<Pessoa> pessoas = new LinkedList<Pessoa>();

    public Long getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Placa getPlaca() {
        return placa;
    }

    public void setPlaca(Placa placa) {
        this.placa = placa;
    }
    
    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }
    
}
