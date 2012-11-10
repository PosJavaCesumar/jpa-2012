package entidade;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class Fornecedor implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    
    @Version
    Integer version;
    
    @Column(length=15)
    private String telefone;
    
    @OneToMany(mappedBy="fornecedor")
    private List<Veiculo> veiculos = new LinkedList<Veiculo>();

    public Long getId() {
        return id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }
}